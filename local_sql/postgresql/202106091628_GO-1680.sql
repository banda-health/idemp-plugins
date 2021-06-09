-- Deactivate one of the Stock to be Ordered Reports
UPDATE ad_process SET isactive = 'N' WHERE ad_process_uu = 'd42deea6-c650-42b4-a21c-90b3ef0fa99f';

SELECT register_migration_script('202106091628_GO-1680.sql') FROM dual;
