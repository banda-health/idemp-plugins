UPDATE ad_user
SET
	supervisor_id = NULL
WHERE
	ad_user_id = supervisor_id;

SELECT
	register_migration_script('202407101702_GO-3025.sql')
FROM
	dual;
