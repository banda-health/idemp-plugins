/**********************************************************************************************************/
-- Grant CashierRegistrationBasicPlus read/write access to Services & Prices window: fd93da00-871d-4996-a3f7-4528bed8b758'
/**********************************************************************************************************/
UPDATE ad_window_access
SET
	isreadwrite      = 'Y',
	bh_candeactivate = 'Y'
WHERE
	ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'fd93da00-871d-4996-a3f7-4528bed8b758'
	)
	AND ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a'
	);

/**********************************************************************************************************/
-- Remove CashierRegistrationBasicPlus read/write access to Supplier window: 565af89e-8f10-4469-84f5-6cca8d7fae27
/**********************************************************************************************************/
DELETE
FROM
	ad_window_access
WHERE
	ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '565af89e-8f10-4469-84f5-6cca8d7fae27'
	)
	AND ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a'
	);

SELECT
	register_migration_script('202603181624_GO-3526.sql')
FROM
	dual;
