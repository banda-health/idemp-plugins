-- Rename "Back-End" to "System Settings"
UPDATE ad_menu
SET
	name = 'System Settings'
WHERE
	ad_menu_uu = '58e80a91-030d-4679-9c9a-356cffd30a40';

UPDATE ad_menu_trl
SET
	name = 'System Settings'
WHERE
	ad_menu_id = (
		SELECT
			ad_menu_id
		FROM
			ad_menu
		WHERE
			ad_menu_uu = '58e80a91-030d-4679-9c9a-356cffd30a40'
	);

SELECT
	register_migration_script('202506301250_GO-3351.sql')
FROM
	dual;
