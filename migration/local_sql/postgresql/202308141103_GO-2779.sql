UPDATE bh_coded_diagnosis
SET
	ad_client_id = 0
WHERE
	ad_client_id != 0;
UPDATE bh_coded_diagnosis_mapping
SET
	ad_client_id = 0
WHERE
	ad_client_id != 0;

SELECT
	register_migration_script('202308141103_GO-2779.sql')
FROM
	dual;
