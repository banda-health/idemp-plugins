-- Disable the dashboard window until we get our new dashboard
UPDATE ad_menu
SET
	isactive = 'N'
WHERE
	ad_menu_uu = 'cc0d5ed0-b0c9-4038-93b3-b7c7343bdde6';

SELECT
	register_migration_script('202412091321-GO-3178.sql')
FROM
	dual;
