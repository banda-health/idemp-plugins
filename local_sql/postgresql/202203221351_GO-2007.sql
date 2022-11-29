UPDATE ad_process SET name = 'Changes to Inventory' WHERE ad_process_uu = '58ae2bdf-0e80-46f2-860f-2ae070fc82d2';

SELECT register_migration_script('202203221351_GO-2007.sql') FROM dual;
