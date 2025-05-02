-- Change inventory group's description
UPDATE ad_menu
SET
	description = 'Track stock, purchases, and resources'
WHERE
	ad_menu_uu = '90d2983e-64b0-4b5f-86ee-4512c45bf893';

-- Delete from the menu treenode where node IDs aren't mapped anymore
DELETE
FROM
	ad_treenodemm
WHERE
	node_id NOT IN (
		SELECT ad_menu_id
		FROM ad_menu
	);

SELECT
	register_migration_script('202504241434_GO-3279.sql')
FROM
	dual;
