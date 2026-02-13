/**********************************************************************************************************/
-- Reset failed login attempts and configure account security settings
/**********************************************************************************************************/
-- Per implementer request, we're increasing the maximum login attempts from 3 to 10
UPDATE ad_sysconfig 
SET value = '10'
WHERE name = 'USER_LOCKING_MAX_LOGIN_ATTEMPT'
  AND ad_client_id = 0;

SELECT
	register_migration_script('202602101625_GO-3440.sql')
FROM
	dual;
