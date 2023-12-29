UPDATE ad_column
SET
	columnname = 'BH_Voided_Reason_UU'
WHERE
	ad_column_uu = '376e96e5-0b52-4daa-87f9-4d3a4dcd86d4';

SELECT
	register_migration_script('202401010000_GrapqQL.sql')
FROM
	dual;
