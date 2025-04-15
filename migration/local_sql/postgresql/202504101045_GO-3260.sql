--Update the role name column to be longer
update ad_column set fieldlength = 400 where ad_column_id = 532;

SELECT
	register_migration_script('202504101045_GO-3260.sql')
FROM
	dual;
