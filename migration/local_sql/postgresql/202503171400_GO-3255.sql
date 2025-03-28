-- Update the icon for FA 5
UPDATE ad_treenodemm
SET
	parent_id = (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'b451e0dd-d11b-49f9-8e00-ba1c36872966'
	),
	seqno     = 6
WHERE
	node_id = (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '8da6c2ab-7020-4cac-8f81-5e4aac53e457'
	);

-- Wrap up and be done
SELECT
	register_migration_script('202503171400_GO-3255.sql')
FROM
	dual;
