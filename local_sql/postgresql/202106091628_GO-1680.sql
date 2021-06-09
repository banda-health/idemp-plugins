-- Deactivate one of the Stock to be Ordered Reports
UPDATE ad_process SET isactive = 'N' WHERE ad_process_uu = 'd42deea6-c650-42b4-a21c-90b3ef0fa99f';

-- Remove an AD_CLIENT_ID process parameter (since iDempiere adds by default)
DELETE FROM ad_process_para WHERE ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '03ba009a-68bb-4b12-a5bc-e58a9bce1545');

SELECT register_migration_script('202106091628_GO-1680.sql') FROM dual;
