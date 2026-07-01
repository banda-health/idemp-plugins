#!/usr/bin/env python3
"""
sync-role-access (reports-first)

Deterministically turn the public "standard role matrix" sheet into an idempotent
AD_Process_Access migration. Source of truth = the Google Sheet; this script only
transforms it. It fails loudly rather than guessing.

Scope: report rows only (col 'System Components' starting with 'R:' / 'R;').
Mapping (sheet legend): 0=No access, 1=Read Only, 2=Create/Edit, 3=Deactivate, 4=Delete/Void.
For a report/process, access is binary: any value >= 1 -> one ad_process_access row
(isreadwrite='Y'); 0 -> no row.

Usage:
  python3 generate.py --offline                 # use committed snapshot, print SQL to stdout
  python3 generate.py                           # fetch live sheet, diff vs snapshot, print SQL
  python3 generate.py --update-snapshot         # fetch + refresh the committed snapshot
  python3 generate.py --offline --write --ticket GO-1234   # write migration file
  python3 generate.py --offline --check         # CI: validate only, no SQL, non-zero on any problem

Hard-fails (non-zero exit, no SQL emitted) on: an 'R:' row that is neither resolved
nor explicitly ignored; an unknown role column header; a cell that is blank/'TBD'/'?'
on a managed report row; a value outside 0-4; or access granted in a column with no
mapped role.
"""
import argparse
import csv
import datetime
import io
import json
import os
import re
import sys
import urllib.request

SKILL_DIR = os.path.dirname(os.path.abspath(__file__))
BLANKISH = {"", "tbd", "?", "-", "n/a", "na"}


def norm(s):
    return re.sub(r"\s+", " ", (s or "").strip()).lower()


def norm_report_label(s):
    return re.sub(r"^r\s*[:;]\s*", "", norm(s))


def load_json(name):
    with open(os.path.join(SKILL_DIR, name), encoding="utf-8") as f:
        return json.load(f)


def fetch_csv(cfg):
    url = (
        "https://docs.google.com/spreadsheets/d/%s/export?format=csv&gid=%s"
        % (cfg["spreadsheet_id"], cfg["gid"])
    )
    with urllib.request.urlopen(url, timeout=30) as resp:  # noqa: S310 (trusted, public sheet)
        return resp.read().decode("utf-8")


def locate_header(rows, marker):
    nmarker = norm(marker)
    for i, row in enumerate(rows):
        for j, cell in enumerate(row):
            if norm(cell) == nmarker:
                return i, j
    sys.exit("ERROR: could not find header row (cell %r) in the sheet." % marker)


def main():
    ap = argparse.ArgumentParser(description="Generate AD_Process_Access migration from the role matrix.")
    ap.add_argument("--offline", action="store_true", help="use the committed snapshot instead of fetching")
    ap.add_argument("--csv", help="read the matrix from this CSV file (overrides fetch/snapshot)")
    ap.add_argument("--update-snapshot", action="store_true", help="overwrite the committed snapshot with the fetched sheet")
    ap.add_argument("--write", action="store_true", help="write the migration into the repo migration dir")
    ap.add_argument("--check", action="store_true", help="validate only; emit no SQL; non-zero exit on any problem")
    ap.add_argument("--report", help="emit ONLY this report's ad_process_access block (snippet to paste into the report's own feature migration); match by 'System Components' label")
    ap.add_argument("--ticket", default="GO-XXXX", help="ticket id for the standalone re-sync migration filename")
    ap.add_argument("--repo-root", default=os.path.abspath(os.path.join(SKILL_DIR, "..", "..", "..")))
    args = ap.parse_args()

    cfg = load_json("config.json")
    role_map = {k: v for k, v in load_json("role-columns.json").items() if not k.startswith("_")}
    resolution = load_json("report-resolution.json")
    reports_map = {norm_report_label(k): v for k, v in resolution.get("reports", {}).items()}
    ignore_set = {norm_report_label(x) for x in resolution.get("ignore", [])}
    ignore_cols = {norm(x) for x in cfg.get("ignore_columns", [])}
    snapshot_path = os.path.join(SKILL_DIR, cfg["snapshot"])

    # ---- obtain CSV text -------------------------------------------------
    if args.csv:
        text = open(args.csv, encoding="utf-8").read()
    elif args.offline:
        text = open(snapshot_path, encoding="utf-8").read()
    else:
        text = fetch_csv(cfg)
        if os.path.exists(snapshot_path):
            old = open(snapshot_path, encoding="utf-8").read()
            if old != text:
                sys.stderr.write("NOTE: live sheet differs from committed snapshot.\n")
                if args.update_snapshot:
                    open(snapshot_path, "w", encoding="utf-8").write(text)
                    sys.stderr.write("  -> snapshot updated; review `git diff` on %s\n" % cfg["snapshot"])
                else:
                    sys.stderr.write("  -> re-run with --update-snapshot to refresh it (review the diff).\n")

    rows = list(csv.reader(io.StringIO(text)))

    # ---- locate header + role columns -----------------------------------
    hi, label_col = locate_header(rows, cfg["header_marker"])
    header = rows[hi]
    name_col = label_col + 1
    errors = []

    role_cols = []  # (col_index, header_text, uuid_or_None)
    for j in range(name_col + 1, len(header)):
        htext = header[j]
        nh = norm(htext)
        if not nh or nh in ignore_cols:
            continue
        if nh not in role_map:
            errors.append("unknown role column %r (col %d) - add it to role-columns.json" % (htext, j + 1))
            continue
        role_cols.append((j, htext.strip(), role_map[nh]))

    # ---- walk report rows ------------------------------------------------
    # grants: process_uu -> list of (role_uuid, role_header)
    target = norm_report_label(args.report) if args.report else None
    if target is not None and target not in reports_map:
        errors.append("report %r is not onboarded - add it to report-resolution.json 'reports' with its ad_process_uu" % args.report)

    grants = {}
    label_by_uu = {v: k for k, v in reports_map.items()}
    managed = 0
    ignored = 0
    seen_target = False
    for ri in range(hi + 1, len(rows)):
        row = rows[ri]
        label = row[label_col] if len(row) > label_col else ""
        if not re.match(r"^\s*r\s*[:;]", label, flags=re.I):
            continue  # not a report row (reports-first scope)
        key = norm_report_label(label)
        if target is not None:
            if key != target:
                continue  # single-report snippet mode: only validate/emit the requested report
            seen_target = True
        else:
            if key in ignore_set:
                ignored += 1
                continue
            if key not in reports_map:
                errors.append("unmapped report row %r (row %d) - add it to report-resolution.json 'reports' or 'ignore'" % (label.strip(), ri + 1))
                continue
        process_uu = reports_map[key]
        managed += 1
        for j, htext, uuid in role_cols:
            raw = row[j] if len(row) > j else ""
            v = norm(raw)
            if v in BLANKISH:
                errors.append("blank/unknown cell for report %r x role %r (row %d, col %d) = %r" % (label.strip(), htext, ri + 1, j + 1, raw))
                continue
            if v not in {"0", "1", "2", "3", "4"}:
                errors.append("bad cell value %r for report %r x role %r (row %d, col %d)" % (raw, label.strip(), htext, ri + 1, j + 1))
                continue
            if int(v) >= 1:
                if uuid is None:
                    errors.append("report %r grants access to column %r which has no mapped role (role-columns.json = null)" % (label.strip(), htext))
                    continue
                if int(v) > 1:
                    sys.stderr.write("WARN: report %r x %r = %s (>1); reports are read-only, granting access anyway.\n" % (label.strip(), htext, v))
                grants.setdefault(process_uu, []).append((uuid, htext))

    if target is not None and target in reports_map and not seen_target:
        errors.append("report %r not found in the sheet" % args.report)

    if errors:
        sys.stderr.write("ERROR: %d problem(s) found; no SQL emitted:\n" % len(errors))
        for e in errors:
            sys.stderr.write("  - %s\n" % e)
        sys.exit(1)

    scope = ("report %r" % args.report) if target is not None else ("%d managed report(s), %d ignored" % (managed, ignored))
    sys.stderr.write("OK: %s, %d role column(s).\n" % (scope, len(role_cols)))

    if args.check:
        sys.exit(0)

    if not grants:
        sys.stderr.write("Nothing to grant (no access cell >= 1).\n")
        sys.exit(0)

    # ---- emit SQL --------------------------------------------------------
    def access_block(process_uu):
        pairs = sorted(set(grants[process_uu]), key=lambda p: p[1].lower())
        b = ["-- Report role access for: %s  (from standard role matrix; regenerate via .cursor/skills/sync-role-access)" % label_by_uu.get(process_uu, process_uu)]
        b.append("INSERT INTO")
        b.append("\tad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,")
        b.append("\t                   updated, updatedby, isreadwrite, ad_process_access_uu)")
        b.append("SELECT")
        b.append("\tp.ad_process_id, r.ad_role_id, 0, 0, 'Y', NOW(), 100, NOW(), 100, 'Y', uuid_generate_v4()")
        b.append("FROM")
        b.append("\tad_process p")
        b.append("\t\tJOIN ad_role r ON r.ad_role_uu IN (")
        for idx, (uuid, htext) in enumerate(pairs):
            comma = "," if idx < len(pairs) - 1 else ""
            b.append("\t\t\t'%s'%s -- %s" % (uuid, comma, htext))
        b.append("\t\t)")
        b.append("WHERE")
        b.append("\tp.ad_process_uu = '%s'" % process_uu)
        b.append("\tAND NOT EXISTS (")
        b.append("\t\tSELECT 1 FROM ad_process_access x WHERE x.ad_process_id = p.ad_process_id AND x.ad_role_id = r.ad_role_id")
        b.append("\t);")
        return "\n".join(b)

    ordered = sorted(grants, key=lambda u: label_by_uu.get(u, u))

    # Snippet mode: just the access block(s), to paste INTO the report's own feature migration.
    if target is not None:
        sys.stdout.write("\n\n".join(access_block(u) for u in ordered) + "\n")
        return

    # Standalone re-sync migration: for matrix changes to ALREADY-shipped reports
    # (append-only migrations mean later changes can't edit the original feature migration).
    ts = datetime.datetime.now().strftime("%Y%m%d%H%M")
    fname = "%s_%s.sql" % (ts, args.ticket)
    out = [
        "-- Generated by .cursor/skills/sync-role-access from the standard role matrix",
        "-- https://docs.google.com/spreadsheets/d/%s (gid=%s)" % (cfg["spreadsheet_id"], cfg["gid"]),
        "-- Re-sync of report access for already-shipped reports. New reports should instead embed",
        "-- their access block (--report) in their own feature migration. Save as: %s/%s" % (cfg["migration_dir"], fname),
        "",
    ]
    for u in ordered:
        out.append(access_block(u))
        out.append("")
    out.append("SELECT register_migration_script('%s') FROM dual;" % fname)
    out.append("")
    sql = "\n".join(out)
    if args.write:
        dest = os.path.join(args.repo_root, cfg["migration_dir"], fname)
        with open(dest, "w", encoding="utf-8") as f:
            f.write(sql)
        sys.stderr.write("Wrote %s\n" % dest)
    else:
        sys.stdout.write(sql)


if __name__ == "__main__":
    main()
