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
| GraphQL template | Update `bh_graphqlgeneratortemplate` in migration (required for GraphQL tables) |
| Base models | `I_*`, `X_*`, `M*` in `base/src/.../model/` |
| Model factory | Register in `BHModelFactory` (all 4 methods) |
| GraphQL | `X_*` artifacts + `M*` stubs; register in 6 composer/mapper files |
| Apply | `./dev.sh build` then `./dev.sh migrate` |

Canonical example: `migration/local_sql/postgresql/202605221123_GO-3580.sql`

More detail: [`migration/README.md`](migration/README.md)

## OCL concept uploads

Open Concept Lab is the source of truth for clinical concepts synced into BandaGo via `ConceptSyncProcess`.

| Source | Purpose | Detailed rules |
|--------|---------|----------------|
| **BHLabs** | Lab tests and panels | `.cursor/rules/ocl-bhlabs.mdc` |
| **BHGO** | Coded diagnoses | `.cursor/rules/ocl-bhgo.mdc` |

OCL org/source base: `bandahealth` → `https://api.openconceptlab.org/orgs/bandahealth/sources/{source}/`

### Shared conventions (all sources)

- Use the **OCL REST API** with `OCL_API_TOKEN` from `.env` — not browser login or UI automation.
- Auth header: `Authorization: Token <OCL_API_TOKEN>`
- **Always verify** external concept IDs before creating SAME-AS mappings:
  `GET /orgs/CIEL/sources/CIEL/concepts/{id}/` (or LOINC equivalent) and confirm `display_name` matches.
- Search before creating to avoid duplicates: `GET .../concepts/?q={name}`
- Retire wrong mappings (`retired: true`); do not leave duplicate active SAME-AS mappings.
- All concept/mapping **extra keys are lowercase** in OCL (e.g. `index_terms`, `local_name`, `moh-705a-lessthan5`, `low_normal`) — must match Jasper reports and `bh_concept_extra.bh_key` after Concept Sync.
- After bulk uploads, run **Concept Sync** in iDempiere for the affected source (`BHGO` or `BHLabs`).
- Local examples: `external-mocks/files/ocl/BHGO-concepts.json`, `external-mocks/files/ocl/BHLabs-concepts.json`

### Downstream sync

`ConceptSyncProcess` (`base/.../ConceptSyncProcess.java`) pulls concepts from OCL into `BH_Concept`. Process parameters:

- `source` — `BHGO` (default) or `BHLabs`
- `sourceIDFilter` — optional comma-separated OCL concept IDs for partial sync

## Docker development

Use [`dev.sh`](dev.sh). **Freezing a new dev image** (Eclipse target platform, plugin import, install) is manual — see [`dev-docker/IMAGE-SETUP.md`](dev-docker/IMAGE-SETUP.md). Required again when Eclipse, iDempiere, or Jaspersoft Studio versions change in the Dockerfile.

See [`README.md`](README.md) and [`.cursor/skills/run-idempiere-dev/SKILL.md`](.cursor/skills/run-idempiere-dev/SKILL.md).
