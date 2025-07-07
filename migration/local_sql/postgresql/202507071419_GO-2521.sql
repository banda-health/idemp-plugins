-- Update the menu positioning for the MOH 747
UPDATE ad_treenodemm
SET
	parent_id = (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'bcf31f7a-9532-42d2-9bd6-35ebc79f973e'
	),
	seqno = 6
WHERE
	node_id = (
		SELECT ad_menu_id
		FROM ad_menu
		WHERE ad_menu_uu = 'f24a9401-fc48-4c7e-8822-da5a70966e70'
	);

SELECT
	register_migration_script('202507071419_GO-2521.sql')
FROM
	dual;
