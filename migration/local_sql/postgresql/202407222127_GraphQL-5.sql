-- Ensure the encounter diagnostic concept and diagnostic status are updateable
UPDATE ad_column
SET
	isupdateable       = 'Y',
	isalwaysupdateable = 'Y'
WHERE
	ad_column_uu IN ('8a25e6da-7705-4868-809b-8573f08eda46', '1e64d8e2-67e5-4c01-8469-f67a3c10a93a');

SELECT
	register_migration_script('202407222127_GraphQL-5.sql')
FROM
	dual;
