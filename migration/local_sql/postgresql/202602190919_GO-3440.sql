-- Apparently we weren't supposed to deploy this feature, so reverting it
UPDATE ad_sysconfig
SET
	value = '0'
WHERE
	name = 'USER_LOCKING_MAX_LOGIN_ATTEMPT'
	AND ad_client_id = 0;

UPDATE ad_sysconfig
SET
	value = '0'
WHERE
	name = 'USER_LOCKING_MAX_INACTIVE_PERIOD_DAY'
	AND ad_client_id = 0;

UPDATE ad_user
SET
	islocked = 'N'
WHERE
	islocked = 'Y';

SELECT
	register_migration_script('202602190919_GO-3440.sql')
FROM
	dual;
