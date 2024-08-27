-- Some included roles have no UU - fix it
UPDATE ad_role_included
SET
	ad_role_included_uu = uuid_generate_v4()
WHERE
	ad_role_included_uu IS NULL;

SELECT
	register_migration_script('202407181302_GraphQL-4.sql')
FROM
	dual;
