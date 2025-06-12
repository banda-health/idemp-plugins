-- Ensure the correct people have access to assign tags to BPs
UPDATE ad_table
SET
	ad_window_id = 123,
	accesslevel  = '3'
WHERE
	tablename ILIKE 'bh_bpartner_tags';

SELECT
	register_migration_script('202505231110_GO-3295.sql')
FROM
	dual;
