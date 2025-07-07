-- Rename the product & service catalogue menu
UPDATE ad_window
SET
	name = 'Product & Service Catalogue - BETA'
WHERE
	ad_window_uu = 'd4d1767a-1a6f-45ef-8b72-48ff004f1b4e';
UPDATE ad_menu
SET
	name = 'Product & Service Catalogue - BETA'
WHERE
	ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'd4d1767a-1a6f-45ef-8b72-48ff004f1b4e'
	);

SELECT
	register_migration_script('202507071318_GO-3305.sql')
FROM
	dual;
