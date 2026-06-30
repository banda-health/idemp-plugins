# sync-role-access (reports-first)

Generate an idempotent `AD_Process_Access` migration from the **standard role matrix**
sheet (the source of truth for who can see what). Scope today: **reports only** —
rows in the sheet whose `System Components` label starts with `R:` / `R;`.

Use this whenever you add a report, or when the matrix changes which roles may run a
report. Do **not** hand-curate role UUID lists in a report's feature migration — derive
them here so the sheet stays authoritative and changes are reviewable.

## Source of truth

- Sheet: https://docs.google.com/spreadsheets/d/1ZBJGcV3vZUlxdqh_6qJBE9MxDB82i5yk3VPGgeJhcTI (gid 0)
- Legend: `0=No access · 1=Read Only · 2=Create/Edit · 3=Deactivate · 4=Delete/Void`
- For a **report/process** access is binary: any value `>= 1` → one `ad_process_access`
  row (`isreadwrite='Y'`); `0` → no row.
- `role-matrix.snapshot.csv` is the committed copy. The build reads the snapshot; the live
  fetch is only for refreshing it (so every change to access is a reviewable git diff).

## Two modes (because a report = one feature migration)

A report isn't an independent file — it's a `.jrxml` plus dictionary rows
(`ad_process` + params + menu + access) delivered in **one feature migration**. So access
should live **with** the report, not in a separate file:

- **Snippet (primary, for a new report):** emit just that report's `ad_process_access`
  block and paste it into the report's **own** feature migration (next to its `ad_process`).
  No standalone file, no `register_migration_script`.
  ```bash
  python3 generate.py --offline --report "Purchased Stocks"
  ```
- **Standalone re-sync (for an already-shipped report whose matrix row changed):** append-only
  migrations can't edit the original, so emit a small delta migration.
  ```bash
  python3 generate.py --offline --write --ticket GO-1234   # writes migration/local_sql/postgresql/<ts>_GO-1234.sql
  ```

Other commands:
```bash
python3 generate.py --offline --check     # validate every R: row/cell/column; non-zero on any problem (CI)
python3 generate.py --update-snapshot     # fetch live sheet + refresh the committed snapshot (review the diff)
```
All emitted SQL uses `JOIN ad_role … NOT EXISTS`, so it is safe to re-apply.

## Config (committed, hand-maintained)

| File | What |
|------|------|
| `config.json` | sheet id/gid, snapshot name, migration dir, columns to ignore |
| `role-columns.json` | normalized matrix header → master `ad_role_uu` (`null` = no role) |
| `report-resolution.json` | report label → `ad_process_uu` (`reports`), plus an explicit `ignore` list |
| `role-matrix.snapshot.csv` | committed snapshot of the sheet |

Why maps instead of name-matching: the sheet's `iDempiere Name` column is unreliable
(blank, `TBD`, `?`, or composites like `Stock Discrepancy Report_BH …`), and role names
differ from the DB (sheet `Clinic Admin` = DB `Clinical Admin`; inconsistent spacing).

## It fails loudly (exit 1, no SQL) when

- an `R:` row is neither in `report-resolution.json` `reports` nor `ignore`
- a role column header isn't in `role-columns.json`
- a managed report has a blank / `TBD` / `?` cell
- a cell value is outside `0–4`
- a managed report grants access in a column whose role is `null`

## Onboard a new report

1. Add the report's row to the sheet (set the role cells), then
   `python3 generate.py --update-snapshot` (review the diff).
2. Move its label from `ignore` to `reports` in `report-resolution.json` with the
   `ad_process_uu`.
3. `python3 generate.py --offline --report "<label>"` and paste the block into the
   report's **own** feature migration (after its `ad_process`/params/menu inserts, before
   `register_migration_script`). See `migration/local_sql/postgresql/202606301208_GO-3561.sql`
   for the worked example.
4. Apply via the normal migration flow (`./dev.sh build` / `docker compose up --build`).

Later, if the matrix changes a role for that already-shipped report, use the standalone
re-sync mode (`--write --ticket GO-####`) to emit a delta migration instead.

## Not in scope yet

Windows (`ad_window_access`, `IsReadWrite` + `BH_CanDeactivate`) and forms
(`ad_form_access`). The matrix legend values `2–4` only apply there; this skill treats
reports as binary. Extend with a kind-aware emitter when needed.
