/**********************************************************************************************************/
-- Reset failed login attempts and configure account security settings
/**********************************************************************************************************/
-- After implementer discussion, we're reducing the maximum login attempts from 10 to 5
UPDATE ad_sysconfig 
SET value = '5'
WHERE name = 'USER_LOCKING_MAX_LOGIN_ATTEMPT'
  AND ad_client_id = 0;

SELECT
	register_migration_script('202602110957_GO-3440.sql')
FROM
	dual;
