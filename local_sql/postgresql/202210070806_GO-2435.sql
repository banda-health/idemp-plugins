-- Fix an issue where the menu name gets changed to match the window since it's centrally maintained
UPDATE ad_menu
SET
	iscentrallymaintained = 'N',
	name                  = 'Manage Users'
WHERE
	ad_menu_uu = '2bdda8ff-6aa1-44b6-816f-3060717c1cc3';

SELECT register_migration_script('202210070806_GO-2435.sql') FROM dual;
