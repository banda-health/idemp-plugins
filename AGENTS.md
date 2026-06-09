# Agent Instructions

## Adding a new database table

When adding a table, altering dictionary metadata for a new table, or exposing a
table via GraphQL, follow the full workflow in:

**[`.cursor/skills/add-database-table/SKILL.md`](.cursor/skills/add-database-table/SKILL.md)**

Do **not** run the iDempiere model generator or GraphQL generator GUIs. Replicate
their output by copying the `BH_Feature_Flag` reference implementation.

### Quick reference

| Step | What |
|------|------|
| Migration | `migration/local_sql/postgresql/YYYYMMDDHHMM_GO-####.sql` |
| Base models | `I_*`, `X_*`, `M*` in `base/src/.../model/` |
| Model factory | Register in `BHModelFactory` (all 4 methods) |
| GraphQL | `X_*` artifacts + `M*` stubs; register in 6 composer/mapper files |
| Apply | `./build.sh` then `./migrate.sh` |

Canonical example: `migration/local_sql/postgresql/202605221123_GO-3580.sql`

More detail: [`migration/README.md`](migration/README.md)

## Docker development

- `./eclipse.sh` — start dev container
- `./build.sh` — build plugins (`mvn verify`)
- `./migrate.sh` — apply pending migrations

See [`README.md`](README.md) for full setup.
