-- Add more visit types to our patient type dropdown
INSERT INTO adempiere.ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT max(ad_ref_list_id) + 1 from adempiere.ad_ref_list), 0, 0, 'Y', '2021-11-17 12:54:55.174000', 100, '2021-11-17 12:54:55.174000', 100, 'A', 'Antenatal (ANC)', null, (SELECT ad_reference_id from ad_reference where ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'), null, null, 'U', '3ce6d10d-8c9c-4e4d-b7ff-67abe9da58a1', null, null) ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT max(ad_ref_list_id) + 1 from adempiere.ad_ref_list), 0, 0, 'Y', '2021-11-17 12:55:57.601000', 100, '2021-11-17 12:55:57.601000', 100, 'Im', 'Immunizations', null, (SELECT ad_reference_id from ad_reference where ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'), null, null, 'U', '3cbeb14f-10db-4e32-9b85-e3463eb620b8', null, null) ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT max(ad_ref_list_id) + 1 from adempiere.ad_ref_list), 0, 0, 'Y', '2021-11-17 12:56:31.352000', 100, '2021-11-17 12:56:31.352000', 100, 'M', 'Maternity', null, (SELECT ad_reference_id from ad_reference where ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'), null, null, 'U', '4fa370d8-d02f-4506-91b9-9f06c2e00baf', null, null) ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT max(ad_ref_list_id) + 1 from adempiere.ad_ref_list), 0, 0, 'Y', '2021-11-17 12:56:54.323000', 100, '2021-11-17 12:56:54.323000', 100, 'D', 'Dental', null, (SELECT ad_reference_id from ad_reference where ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'), null, null, 'U', '1841d957-db04-4640-af15-811a12deb7e4', null, null) ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT max(ad_ref_list_id) + 1 from adempiere.ad_ref_list), 0, 0, 'Y', '2021-11-17 12:57:15.610000', 100, '2021-11-17 12:57:15.610000', 100, 'E', 'Eye Clinic', null, (SELECT ad_reference_id from ad_reference where ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'), null, null, 'U', '1e8a9ec6-0f1e-4fac-8085-593ebeec9d44', null, null) ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT max(ad_ref_list_id) + 1 from adempiere.ad_ref_list), 0, 0, 'Y', '2021-11-17 12:57:31.555000', 100, '2021-11-17 12:57:31.555000', 100, 'S', 'Surgery', null, (SELECT ad_reference_id from ad_reference where ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'), null, null, 'U', '74d58aed-2017-47bc-94f0-9a20c7b208a2', null, null) ON CONFLICT DO NOTHING;

SELECT register_migration_script('202111181532_GO-1876.sql') FROM dual;