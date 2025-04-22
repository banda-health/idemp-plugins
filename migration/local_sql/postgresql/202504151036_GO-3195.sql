-- Update the selected panel ID column so model generation works correctly
UPDATE ad_column
SET
	ad_reference_id       = 18,
	ad_reference_value_id = (
		SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '9f81c0d2-3af8-4a2e-b6d4-7b15852a3bbc'
	)
WHERE
	ad_column_uu = '0b00b3aa-3bab-40f4-b9a7-bfbaf6ea0977';

SELECT
	register_migration_script('202504151036_GO-3195.sql')
FROM
	dual;
