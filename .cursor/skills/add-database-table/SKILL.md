---
name: add-database-table
description: >-
  Adds a new iDempiere database table end-to-end: migration SQL (AD_Element,
  AD_Table, AD_Column, optional window/access), base plugin models (I_/X_/M_),
  BHModelFactory registration, GraphQL artifacts, and composer wiring. Use when
  adding a new table, BH_ table, database migration, model class, or GraphQL
  exposure for a table. Do not run the model or GraphQL generators — replicate
  their output using BH_Feature_Flag as the canonical reference.
---

# Add Database Table

Canonical reference pair:

- Migration: `migration/local_sql/postgresql/202605221123_GO-3580.sql`
- Base models: `base/src/org/bandahealth/idempiere/base/model/*BH_Feature_Flag*`
- GraphQL: search repo for `BH_Feature_Flag` / `MBHFeatureFlag` under `graphql/`

Human-readable details: `migration/README.md`

## Workflow

### 1. Migration SQL

Create `migration/local_sql/postgresql/YYYYMMDDHHMM_GO-####.sql`.

Sections (in order):

1. `CREATE TABLE` + FK constraints
2. `INSERT INTO ad_element` for custom columns (skip when element already exists — see below)
3. `INSERT INTO ad_table` + `ad_sequence`
4. `INSERT INTO ad_column` for every column (include standard audit columns)
5. Optional: `ad_window`, `ad_tab`, `ad_field`, `ad_menu`, `ad_treenodemm`
6. Optional: `ad_window_access`, `ad_process_access`, `bh_add_roles_to_clients(...)`
7. **Required** when adding GraphQL artifacts: update `bh_graphqlgeneratortemplate`
   (`BH_GraphQLGeneratorTemplate`; UUID `0b9c9d6a-6e59-4ba4-995a-6762c9effe03`)
8. End with: `SELECT register_migration_script('FILENAME.sql') FROM dual;`

Use new UUIDs for all `*_UU` columns. Use `MAX(id) + 1` subqueries for IDs.

#### AD_Element (reuse existing elements)

Do **not** insert an `ad_element` row when one already exists for the same
`columnname` at `ad_client_id = 0` (e.g. `QtyEntered`, `Description`,
`M_Product_ID`). Use `INSERT … SELECT … WHERE NOT EXISTS`:

```sql
INSERT INTO ad_element (...)
SELECT (SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', ..., 'BH_My_Column', ...
WHERE NOT EXISTS (
	SELECT 1 FROM ad_element WHERE columnname = 'BH_My_Column' AND ad_client_id = 0
);
```

In `ad_column` inserts, resolve `ad_element_id` by **column name**, not UUID:

```sql
(SELECT ad_element_id FROM ad_element WHERE columnname = 'BH_My_Column' AND ad_client_id = 0 LIMIT 1)
```

#### AD_Client / AD_Org defaults (required)

Every new table's `AD_Client_ID` and `AD_Org_ID` columns **must** use session
defaults so GraphQL `*Input` PO saves get the correct tenant without Java
workarounds:

| Column | `defaultvalue` | `fkconstrainttype` |
|--------|----------------|--------------------|
| `AD_Client_ID` | `@#AD_Client_ID@` | `D` |
| `AD_Org_ID` | `@#AD_Org_ID@` | `D` |

Copy the Tenant/Organization `ad_column` rows from `202605221123_GO-3580.sql`.
Use unique `fkconstraintname` values per table (not generic `ADClient_`).

If a migration script was already applied before these defaults were added, run the
idempotent `UPDATE ad_column SET defaultvalue = …` block manually against the
database (same statements at the end of the migration file).

#### GraphQL generator template (required)

Append each new table to `bh_graphqlgeneratortemplate.tablename` in the same
migration script. Use an idempotent `REGEXP_REPLACE` anchored on a neighbouring
table that is already in the list:

```sql
UPDATE bh_graphqlgeneratortemplate
SET
	tablename = REGEXP_REPLACE(
		tablename,
		'''BH_Encounter_Type_Window''',
		'''BH_Encounter_Type_Window'',''BH_My_Table''',
		'i'
	)
WHERE
	bh_graphqlgeneratortemplate_uu = '0b9c9d6a-6e59-4ba4-995a-6762c9effe03'
	AND tablename NOT ILIKE '%BH_My_Table%';
```

For multiple tables, append all names in one replace (see
`202605221123_GO-3580.sql`). Do not skip this step — the generator template
drives which tables are included in GraphQL codegen.

### 2. Base plugin models

Per table `BH_My_Table`, create in `base/src/org/bandahealth/idempiere/base/model/`:

| File | Role |
|------|------|
| `I_BH_My_Table.java` | Interface with column constants |
| `X_BH_My_Table.java` | Generated PO (`/** Generated Model - DO NOT CHANGE */`) |
| `MBHMyTable.java` | Thin subclass of `X_*`; business logic goes here |

Copy structure from `I_BH_Feature_Flag`, `X_BH_Feature_Flag`, `MBHFeatureFlag`.

#### Register in BHModelFactory (required)

Edit `base/src/org/bandahealth/idempiere/base/factory/BHModelFactory.java`:

1. Add import at top with other `MBH*` imports
2. Add an `else if` branch in **all four methods**, at the **same position** in each chain:
   - `getClass(String tableName)`
   - `getPO(String tableName, int Record_ID, String trxName)`
   - `getPO(String tableName, ResultSet rs, String trxName)`
   - `getPO(String tableName, String Record_UU, String trxName)`

Example (`getClass`):

```java
} else if (tableName.equalsIgnoreCase(MBHMyTable.Table_Name)) {
    return MBHMyTable.class;
```

Mirror in each `getPO` overload with the matching constructor. Place new entries
in the same relative order in all four methods (see `MBHFeatureFlag` after
`MBHEncounterDiagnostic`).

Without this, `Query` loads `X_*` instead of `M*` and custom logic is skipped.

### 3. GraphQL plugin artifacts

Replicate generator output; copy from `BH_Feature_Flag` / `MBHFeatureFlag`.

Per table, create:

| Artifact | Path |
|----------|------|
| Schema | `graphql/WEB-INF/resources/X_BH_My_Table.graphqls` |
| M-schema stub | `graphql/WEB-INF/resources/MBHMyTable.graphqls` |
| Input interface | `graphql/.../model/input/I_BH_My_TableInput.java` |
| Input class | `graphql/.../model/input/X_BH_My_TableInput.java` |
| M-input stub | `graphql/.../model/input/MBHMyTableInput.java` |
| Query | `graphql/.../resolver/query/X_BH_My_TableQuery.java` |
| M-query stub | `graphql/.../resolver/query/MBHMyTableQuery.java` |
| Mutation | `graphql/.../resolver/mutation/X_BH_My_TableMutation.java` |
| M-mutation stub | `graphql/.../resolver/mutation/MBHMyTableMutation.java` |
| Model resolver | `graphql/.../resolver/model/X_BH_My_TableResolver.java` |
| M-resolver stub | `graphql/.../resolver/model/MBHMyTableResolver.java` |
| DataLoader | `graphql/.../dataloader/impl/X_BH_My_TableDataLoader.java` |
| M-DataLoader stub | `graphql/.../dataloader/impl/MBHMyTableDataLoader.java` |

`M*` stubs typically extend the matching `X_*` class with minimal or no extra code.

#### Register in GraphQL composers (required)

Add entries in alphabetical/MBH order to match siblings:

| File | Register |
|------|----------|
| `graphql/.../BandaSchemaFileComposer.java` | `"WEB-INF/resources/MBHMyTable.graphqls"` |
| `graphql/.../resolver/query/BandaQueryComposer.java` | `new MBHMyTableQuery()` |
| `graphql/.../resolver/mutation/BandaMutationComposer.java` | `new MBHMyTableMutation()` |
| `graphql/.../resolver/model/BandaResolverComposer.java` | `new MBHMyTableResolver()` |
| `graphql/.../dataloader/BandaDataLoaderComposer.java` | `new MBHMyTableDataLoader()` |
| `graphql/.../model/BandaObjectMapper.java` | `addMapping(I_BH_My_TableInput.class, MBHMyTableInput.class)` |

### 4. Build, migrate, verify

From repo root (dev container must be running):

```bash
./build.sh
./migrate.sh
```

Restart the iDempiere server in the dev container if needed.

## Checklist

- [ ] Migration SQL with correct filename and `register_migration_script`
- [ ] `ad_element` inserts use `WHERE NOT EXISTS`; `ad_column` references elements by `columnname`
- [ ] `AD_Client_ID` / `AD_Org_ID` columns have `@#AD_Client_ID@` / `@#AD_Org_ID@` defaults
- [ ] `I_*`, `X_*`, `M*` in base plugin
- [ ] `BHModelFactory` — import + 4 method branches
- [ ] GraphQL `X_*` artifacts + `M*` stubs
- [ ] 6 GraphQL composer / mapper registrations
- [ ] `bh_graphqlgeneratortemplate` updated (required for GraphQL tables)
- [ ] `./build.sh` && `./migrate.sh`

## Notes

- Skip model/GraphQL generator GUI — hand-write artifacts from reference files.
- Window, menu, and role access are optional; model factory and GraphQL
  registration are mandatory for custom tables used in code.
- For column-only changes (no new table), migration SQL may suffice without
  new model/GraphQL files unless columns need API exposure.
