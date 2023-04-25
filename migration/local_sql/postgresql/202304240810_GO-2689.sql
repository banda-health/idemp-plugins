-- Since this fix only has a process_post_migration fix, creating an empty migration script to trigger it
-- (would like a better long-term solution)
SELECT
	register_migration_script('202304240810_GO-2689.sql')
FROM
	dual;
