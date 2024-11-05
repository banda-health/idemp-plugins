-- Fix a column having the wrong reference value
UPDATE ad_column
SET
	ad_reference_value_id = 200175
WHERE
	ad_column_uu IN ('625ce37a-2250-45f1-bf0a-7568a1d5609b', '02325e94-bace-437b-90f5-8c77cad30375');

-- Make casing correct on this column for code-generation purposes
UPDATE ad_column
SET
	columnname = 'BH_Voided_Reason_UU'
WHERE
	ad_column_uu = '376e96e5-0b52-4daa-87f9-4d3a4dcd86d4';
UPDATE ad_element
SET
	columnname = 'BH_Voided_Reason_UU'
WHERE
	ad_element_uu = '17226899-35c3-41d9-8b3a-79a78f3c4dbb';

-- Update the empty sales reps since they will throw errors
UPDATE c_order
SET
	salesrep_id = createdby
WHERE
	salesrep_id IS NULL
	AND ad_client_id > 999999;

SELECT
	register_migration_script('202410241311_GO-3134.sql')
FROM
	dual;
