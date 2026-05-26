-- Rename patient type to visit type on bh_visit and related metadata
ALTER TABLE bh_visit
	RENAME COLUMN bh_patienttype TO bh_visittype;

UPDATE ad_element
SET
	columnname = 'BH_VisitType',
	name = 'Visit Type',
	printname = 'Visit Type'
WHERE
	ad_element_uu = '5e3e6279-0c10-46b0-b889-801586fe436c';

UPDATE ad_element_trl
SET
	name = 'Visit Type',
	printname = 'Visit Type'
WHERE
	ad_element_id = (
		SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '5e3e6279-0c10-46b0-b889-801586fe436c'
	);

UPDATE ad_column
SET
	columnname = 'BH_VisitType',
	name = 'Visit Type'
WHERE
	ad_column_uu = '1a52b028-4e6d-434d-a8f4-43d9c5755423';

UPDATE ad_reference
SET
	name = 'BH_VisitType'
WHERE
	ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7';

UPDATE ad_field
SET
	name = 'Visit Type'
WHERE
	ad_column_id = (
		SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '1a52b028-4e6d-434d-a8f4-43d9c5755423'
	);

UPDATE ad_process_para
SET
	name = 'Visit Type',
	columnname = 'Visit Type'
WHERE
	name = 'Patient Type'
	OR columnname = 'Patient Type';

SELECT
	register_migration_script('202605251200_GO-3582.sql')
FROM
	dual;
