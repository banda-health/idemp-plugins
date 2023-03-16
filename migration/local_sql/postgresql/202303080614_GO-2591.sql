-- Since this fix only has a process_post_migration fix, creating an empty migration script to trigger it
-- (would like a better long-term solution)
SELECT
	register_migration_script('202303080614_GO-2591.sql')
FROM
	dual;
