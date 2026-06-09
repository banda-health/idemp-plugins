# Database Migrations

SQL migrations for the BandaGo iDempiere installation. Maven copies this directory
to the iDempiere home during `mvn verify`; in Docker dev use `./build.sh` then
`./migrate.sh`.

## Directory layout

| Path | Purpose |
|------|---------|
| `local_sql/postgresql/` | Versioned migration scripts (main location for new work) |
| `processes_post_migration/postgresql/` | DB functions and post-migration SQL |
| `zip_2pack/` | 2-pack archives |

## Migration file naming

```
migration/local_sql/postgresql/YYYYMMDDHHMM_GO-####.sql
```

- `YYYYMMDDHHMM` — creation timestamp
- `GO-####` — issue/ticket number

Example: `202605221123_GO-3580.sql`

Every script must end with:

```sql
SELECT register_migration_script('202605221123_GO-3580.sql') FROM dual;
```

## Adding a new table (full workflow)

For AI-assisted or manual work, see **`.cursor/skills/add-database-table/SKILL.md`**
and **`AGENTS.md`** at the repo root.

### 1. Migration SQL

Canonical example: **`local_sql/postgresql/202605221123_GO-3580.sql`**

That script demonstrates:

- `CREATE TABLE` with FK constraints
- `ad_element`, `ad_table`, `ad_sequence`, `ad_column` dictionary entries
- `ad_window`, `ad_tab`, `ad_field`, `ad_menu` (UI)
- `bh_graphqlgeneratortemplate` table list update (GraphQL exposure)

Smaller examples (column additions only): `202412051125_GO-2976.sql`

### 2. Base plugin

Per table `BH_My_Table`:

| File | Location |
|------|----------|
| `I_BH_My_Table.java` | `base/src/org/bandahealth/idempiere/base/model/` |
| `X_BH_My_Table.java` | same (generated PO — do not add business logic) |
| `MBHMyTable.java` | same (subclass of `X_*` — business logic here) |

Reference: `I_BH_Feature_Flag`, `X_BH_Feature_Flag`, `MBHFeatureFlag`

**Register in `BHModelFactory`** (`base/src/.../factory/BHModelFactory.java`):

- Add import
- Add matching `else if` in all four methods: `getClass`, and three `getPO` overloads
- Keep the same insertion order in each method chain

### 3. GraphQL plugin

Hand-write artifacts (do not run the GraphQL generator GUI). Copy from
`BH_Feature_Flag` / `MBHFeatureFlag` under `graphql/`.

Register in:

- `BandaSchemaFileComposer.java`
- `BandaQueryComposer.java`
- `BandaMutationComposer.java`
- `BandaResolverComposer.java`
- `BandaDataLoaderComposer.java`
- `BandaObjectMapper.java`

### 4. Build and apply

```bash
./build.sh    # mvn verify in dev container
./migrate.sh  # RUN_SyncDBDev.sh
```

## GraphQL template table list

Tables exposed via the API must appear in `bh_graphqlgeneratortemplate.tablename`.
Append new table names in the migration script:

```sql
UPDATE bh_graphqlgeneratortemplate
SET tablename = REGEXP_REPLACE(tablename, '''Existing_Table''', '''Existing_Table'',''BH_New_Table''', 'i')
WHERE bh_graphqlgeneratortemplate_uu = '0b9c9d6a-6e59-4ba4-995a-6762c9effe03'
  AND tablename NOT ILIKE '%BH_New_Table%';
```

See `202605221123_GO-3580.sql` for a working example.

## Role and access (optional)

When a new window needs role access, see `202605211616_GO-3549.sql` for patterns
using `ad_window_access`, `ad_process_access`, and `bh_add_roles_to_clients()`.
