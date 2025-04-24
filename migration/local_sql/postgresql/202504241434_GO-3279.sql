-- Change inventory group's description
UPDATE ad_menu
SET
	description = 'Track stock, purchases, and resources'
WHERE
	ad_menu_uu = '90d2983e-64b0-4b5f-86ee-4512c45bf893';

SELECT
	register_migration_script('202504241434_GO-3279.sql')
FROM
	dual;
