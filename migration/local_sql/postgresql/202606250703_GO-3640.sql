-- GO-3640: Speed up monthly fact_acct archiving
--
-- Problem:
--   Monthly archiving deletes old fact_acct rows by created date. A full B-tree on created
--   would add noticeable insert overhead on a heavily written table (~30k rows/day in production).
--
-- Changes:
--   BRIN index on created for low insert cost while still supporting archive range scans.

CREATE INDEX IF NOT EXISTS fact_acct_created_brin
	ON fact_acct USING brin (created) WITH (pages_per_range = 64);

SELECT
	register_migration_script('202606250703_GO-3640.sql')
FROM
	dual;
