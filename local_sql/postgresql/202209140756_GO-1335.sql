-- Deactivate the Income Category Menu
UPDATE ad_menu
SET isactive = 'N'
WHERE ad_menu_uu = '4844b8ee-8387-40d8-80c8-5e73479b8b61';

-- Deactivate the Track Income menu
UPDATE ad_menu
SET isactive = 'N'
WHERE ad_menu_uu = '88d5359a-4130-4863-830e-63a507a41cab';

SELECT register_migration_script('202209140756_GO-1335.sql') FROM dual;
