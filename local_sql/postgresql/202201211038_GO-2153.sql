INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU = '03ba009a-68bb-4b12-a5bc-e58a9bce1545'), (SELECT AD_Role_ID FROM AD_Role WHERE AD_Role_UU='ec17fee0-a53a-4dbb-b946-423ce14880eb'), 0, 0, 'Y', '2022-01-21 10:37:09.183000', 100, '2022-01-21 10:37:09.183000', 100, 'Y', '21cd1331-5036-4f45-b393-d162d7ac4894') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202201211038_GO-2153.sql') FROM dual;
