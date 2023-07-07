ALTER TABLE bh_visit
	ALTER bh_chiefcomplaint TYPE text;
UPDATE ad_column
SET
	ad_reference_id = 36,
	fieldlength= 0
WHERE
	ad_column_uu = '58e4d45d-bf24-4225-bf33-8f63d3a00f9b';

SELECT
	register_migration_script('202306091432_GO-2743.sql')
FROM
	dual;
