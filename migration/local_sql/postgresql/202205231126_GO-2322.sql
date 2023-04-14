-- Update Clinician/nurse advanced report access
UPDATE AD_Process_Access SET isreadwrite = 'Y' WHERE ad_role_id = (SELECT AD_Role_ID FROM AD_Role WHERE AD_Role_UU = 'c54253cf-c86b-4aaa-b472-ed8880635c62');

-- Update Cashier/Registration advanced report access
UPDATE AD_Process_Access SET isreadwrite = 'Y' WHERE ad_role_id = (SELECT AD_Role_ID FROM AD_Role WHERE AD_Role_UU = 'ee008abc-2c16-4230-b48c-b1f5577ea270');

SELECT register_migration_script('202205231126_GO-2322.sql') FROM dual;
