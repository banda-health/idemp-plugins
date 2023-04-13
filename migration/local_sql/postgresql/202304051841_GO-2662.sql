-- Since this fix only has a process_post_migration fix, creating an empty migration script to trigger it
-- Fix was made to get_visit_info() function in the process_post_migration folder
SELECT
	register_migration_script('202304051841_GO-2662.sql')
FROM
	dual;