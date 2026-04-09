/**********************************************************************************************************/
-- Enable Add Services permission for CashierRegistrationBasic and CashierRegistrationBasicPlus roles
/**********************************************************************************************************/
UPDATE ad_window_access
SET
	isreadwrite = 'Y'
WHERE
	ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'fd93da00-871d-4996-a3f7-4528bed8b758'
	)
	AND ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			ad_role
		WHERE
			ad_role_uu IN ('09eb7fc8-9cc5-44b0-9d14-15258a066038', 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a')
	);

/**********************************************************************************************************/
-- Enable Products & Services Catalogue write access for CashierRegistrationBasic and CashierRegistrationBasicPlus
/**********************************************************************************************************/
UPDATE ad_window_access
SET
	isreadwrite = 'Y'
WHERE
	ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'd4d1767a-1a6f-45ef-8b72-48ff004f1b4e'
	)
	AND ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			ad_role
		WHERE
			ad_role_uu IN ('09eb7fc8-9cc5-44b0-9d14-15258a066038', 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a')
	);

SELECT
	register_migration_script('202604091137_GO-3506.sql')
FROM
	dual;
