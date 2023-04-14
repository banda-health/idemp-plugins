-- Update Cashier/Registration Advanced value
UPDATE AD_Ref_List SET Value = 'D' WHERE ad_ref_list_uu = 'c2003ff1-682d-42a5-beda-d04fbf1a62a0'; 

-- Delete erroneous entries
DELETE FROM ad_role_included ri USING ad_role r WHERE ismasterrole = 'Y' AND ri.ad_role_id = r.ad_role_id;

-- Update Cashier/Registration Advanced db_usertype
UPDATE bh_defaultincludedrole SET db_usertype = 'D' WHERE included_role_id = (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='ee008abc-2c16-4230-b48c-b1f5577ea270');

-- Insert cashier/registration advanced role
INSERT INTO adempiere.bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id)+1 FROM bh_defaultincludedrole), 0, 0, 'e0ad5b0a-92a7-4a2e-ad8a-e8939fa0a0bd', '2021-11-17 19:32:54.687000', 100, null, 'Y', null, '2021-11-17 19:32:54.687000', 100, (SELECT AD_Role_ID FROM ad_role WHERE ad_role_uu = 'ee008abc-2c16-4230-b48c-b1f5577ea270'), 'D') ON CONFLICT DO NOTHING;

-- Insert Must haves
INSERT INTO adempiere.bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id)+1 FROM bh_defaultincludedrole), 0, 0, '86456b12-772e-47c0-b4e2-1e617521bc63', '2022-04-21 14:53:51.225000', 100, null, 'Y', null, '2022-04-21 14:53:51.225000', 100, (SELECT AD_Role_ID FROM ad_role WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'), 'D') ON CONFLICT DO NOTHING;

-- Update clinician/nurse name
UPDATE ad_ref_list SET Name = 'Clinician/Nurse Basic' WHERE Name = 'Clinician/Nurse';

-- Insert clinician/nurse advanced
INSERT INTO adempiere.ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT MAX(AD_Ref_List_ID)+1 FROM AD_Ref_List), 0, 0, 'Y', '2022-04-21 13:14:15.700000', 100, '2022-04-21 13:14:15.700000', 100, 'E', 'Clinician/Nurse Advanced', 'Clinician/Nurse Advanced', 1000031, null, null, 'U', '34c6accb-c624-4936-95a6-3a2ef648e360', 'N', 'N') ON CONFLICT DO NOTHING;

-- must haves included role
INSERT INTO adempiere.bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id)+1 FROM bh_defaultincludedrole), 0, 0, '2ecf2f32-98d1-42bc-8093-0c6a21f38722', '2022-04-21 14:06:22.309000', 100, null, 'Y', null, '2022-04-21 14:06:22.309000', 100, (SELECT AD_Role_ID FROM ad_role WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'), 'E') ON CONFLICT DO NOTHING;

-- clinician/nurse advanced included role
INSERT INTO adempiere.bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id)+1 FROM bh_defaultincludedrole), 0, 0, 'fb62aa20-87ae-46b1-811d-893774f8253a', '2022-04-21 14:06:32.941000', 100, null, 'Y', null, '2022-04-21 14:06:32.941000', 100, (SELECT AD_Role_ID FROM ad_role WHERE ad_role_uu = 'c54253cf-c86b-4aaa-b472-ed8880635c62'), 'E') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202204211444_GO-2289.sql') FROM dual;
