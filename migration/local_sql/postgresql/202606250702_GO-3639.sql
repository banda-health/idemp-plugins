-- GO-3639: Speed up monthly ad_changelog archiving
--
-- Problem:
--   Monthly archiving deletes old ad_changelog rows by created date. Without an index on
--   created, those deletes scan the full table (~25M rows in production).
--
-- Changes:
--   B-tree index on created for range scans and deletes during archive jobs.

CREATE INDEX IF NOT EXISTS ad_changelog_created_idx
	ON ad_changelog (created);

SELECT
	register_migration_script('202606250702_GO-3639.sql')
FROM
	dual;
