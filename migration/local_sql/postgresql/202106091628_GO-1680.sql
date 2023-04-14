-- Deactivate one of the Stock to be Ordered Reports
UPDATE ad_process SET isactive = 'N' WHERE ad_process_uu = 'd42deea6-c650-42b4-a21c-90b3ef0fa99f';

-- Remove an AD_CLIENT_ID process parameter (since iDempiere adds by default)
DELETE FROM ad_process_para WHERE ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '03ba009a-68bb-4b12-a5bc-e58a9bce1545');

-- Update some process parameter names
UPDATE ad_process_para SET name = 'Begin Date' WHERE ad_process_para_uu = '7587c79d-436d-4f19-b4ed-63785c0a8bdc';
UPDATE ad_process_para SET name = 'End Date' WHERE ad_process_para_uu = 'ac2b0a7a-c97c-4a1f-af1e-3587490eed7f';
UPDATE ad_process_para SET name = 'Begin Date' WHERE ad_process_para_uu = '5a1d1717-68a9-4eb7-9d36-993328c0bb83';
UPDATE ad_process_para SET name = 'End Date' WHERE ad_process_para_uu = '2d68af75-b38b-435f-8b1d-08080a727dd0';
UPDATE ad_process_para SET name = 'Begin Date' WHERE ad_process_para_uu = '8195a390-6c9c-4c39-8669-13c57a4907d2';
UPDATE ad_process_para SET name = 'End Date' WHERE ad_process_para_uu = 'b43bf00b-37b5-416d-b196-263286ebd09b';

SELECT register_migration_script('202106091628_GO-1680.sql') FROM dual;
