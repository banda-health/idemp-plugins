-- Update the Patient Visits and Referrals report to be inactive
UPDATE ad_process
SET
	isactive = 'N'
WHERE
	ad_process_uu = '061ed4a0-5670-4764-909e-fb4592f51aaa';

UPDATE ad_menu
SET
	isactive = 'N'
WHERE
		ad_process_id = (
		SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '061ed4a0-5670-4764-909e-fb4592f51aaa'
	);

SELECT register_migration_script('202207280527_GO-2390.sql') FROM dual;

