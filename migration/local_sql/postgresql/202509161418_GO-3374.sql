-- Update the parameter name
UPDATE ad_process_para
SET
	name    = 'Insurer/Donor',
	updated = NOW()
WHERE
	ad_process_para_uu = '59d8caf6-425d-48fc-a54e-26d40f572882';

SELECT
	register_migration_script('202509161418_GO-3374.sql')
FROM
	dual;
