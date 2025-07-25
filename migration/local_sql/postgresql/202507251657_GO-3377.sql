UPDATE ad_user
SET
	bh_hasacceptedtermsofuse = 'N'
WHERE
	EXISTS (
		SELECT
			ad_client_id
		FROM
			ad_client
		WHERE
			NAME ILIKE 'galmi%'
	);

SELECT
	register_migration_script('202507251657_GO-3377.sql')
FROM
	dual;
