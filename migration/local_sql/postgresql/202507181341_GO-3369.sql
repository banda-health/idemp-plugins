UPDATE ad_user
SET
	bh_hasacceptedtermsofuse = 'N'
WHERE
	ad_client_id != 0
	AND ad_client_id NOT IN (
		SELECT ad_client_id
		FROM ad_client
		WHERE name ILIKE 'galmi%'
	);

SELECT
	register_migration_script('202507181341_GO-3369.sql')
FROM
	dual;
