-- Log out all sessions created before 14 Jan of 2025
UPDATE
	ad_session
SET
	processed = 'Y'
WHERE
	logindate < '2025-01-14'
	AND processed = 'N';

SELECT
	register_migration_script('202501161332_GO-3201.sql')
FROM
	dual;
