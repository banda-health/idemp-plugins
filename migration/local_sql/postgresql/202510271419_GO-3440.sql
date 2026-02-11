/**********************************************************************************************************/
-- Reset failed login attempts and configure account security settings
/**********************************************************************************************************/

-- Step 1: Reset all users' failed login attempts to 0
UPDATE ad_user 
SET failedlogincount = 0
WHERE failedlogincount > 0;

-- Step 2: Set maximum allowable login attempts to 3
UPDATE ad_sysconfig 
SET value = '3'
WHERE name = 'USER_LOCKING_MAX_LOGIN_ATTEMPT'
  AND ad_client_id = 0;


-- Step 3: Set maximum account expiry to 30 days before deactivation
UPDATE ad_sysconfig 
SET value = '30'
WHERE name = 'USER_LOCKING_MAX_INACTIVE_PERIOD_DAY'
  AND ad_client_id = 0;

SELECT
	register_migration_script('202510271419_GO-3440.sql')
FROM
	dual;
