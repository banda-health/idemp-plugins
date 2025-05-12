-- Update window and menu names
UPDATE ad_window
SET
	name = 'Patient Tags'
WHERE
	ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83';
UPDATE ad_menu
SET
	name = 'Patient Tags'
WHERE
	ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'
	);

SELECT
	register_migration_script('202505091448_GO-3295.sql')
FROM
	dual;
