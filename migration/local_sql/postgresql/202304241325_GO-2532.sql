-- Fix CIEL IDs so that we don't have problems with model generation
ALTER TABLE bh_coded_diagnosis
	RENAME COLUMN bh_ciel_id TO bh_cielid;
UPDATE ad_element
SET
	columnname = 'BH_CielID',
	name='BH_CielID',
	printname='BH_CielID'
WHERE
	ad_element_uu = 'b3d486a4-9e79-4052-a44b-fa5eeb863c3d';
UPDATE ad_column c
SET
	columnname      = e.columnname,
	name            = e.name,
	ad_reference_id = 11
FROM
	ad_element e
WHERE
	e.ad_element_id = c.ad_element_id
	AND e.ad_element_uu = 'b3d486a4-9e79-4052-a44b-fa5eeb863c3d';

-- Fix the BH Voided Reason stuff
UPDATE ad_element
SET
	columnname = 'BH_Voided_Reason_ID',
	name='BH_Voided_Reason_ID',
	printname='BH_Voided_Reason_ID'
WHERE
	ad_element_uu = '9f1bb1b0-353c-4f5c-a034-e5faea969b35';
UPDATE ad_column c
SET
	columnname      = e.columnname,
	name            = e.name
FROM
	ad_element e
WHERE
	e.ad_element_id = c.ad_element_id
	AND e.ad_element_uu = '9f1bb1b0-353c-4f5c-a034-e5faea969b35';

SELECT
	update_sequences();

SELECT
	register_migration_script('202304241108_GO-2532.sql')
FROM
	dual;
