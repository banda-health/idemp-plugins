-- Temporarily remove supplier payment window access
DELETE
FROM
	ad_window_access
WHERE
	ad_window_id IN (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'be24b4d5-987f-4aa5-ae14-38375b0d6bf2'
	)
	AND ad_role_id IN (
		SELECT ad_role_id
		FROM ad_role
		WHERE ismasterrole = 'Y'
	);

-- Register the script
SELECT
	register_migration_script('202508200857_GO-984.sql')
FROM
	dual;
