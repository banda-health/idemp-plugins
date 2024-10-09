-- Ensure the clinic user role can run reports
UPDATE ad_process_access
SET
	isreadwrite = 'Y'
WHERE
	ad_role_id = (
		SELECT ad_role_id
		FROM ad_role
		WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'
	);

SELECT
	register_migration_script('202410091306_GO-3103.sql')
FROM
	dual;
