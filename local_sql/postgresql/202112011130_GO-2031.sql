-- update begin date/time. 
UPDATE AD_Process_Para SET AD_Reference_ID = 16, ismandatory = 'Y' WHERE AD_Process_Para_UU='ceebf220-95a7-492b-b3dd-2d4bb77ed863';

-- update end date/time
UPDATE AD_Process_Para SET AD_Reference_ID = 16, ismandatory = 'Y' WHERE AD_Process_Para_UU='169c8d64-66cb-4bba-adf2-fdd17b7fe561';

-- create user parameter
INSERT INTO adempiere.ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete) VALUES ((SELECT MAX(ad_process_para_id) + 1 FROM ad_process_para), 0, 0, 'Y', '2021-12-01 11:49:46.945000', 100, '2021-12-09 16:45:38.989000', 100, 'Completed By', null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu ='4cf22d3f-1fc8-4bdd-83e1-fc5d79537269'), 50, 19, null, null, 'AD_User_UU', 'N', 0, 'N', 'N', null, null, null, null, null, null, 'U', null, null, '2eb49e7a-04f3-468b-9c70-bf9ad98b9437', 'N', null, null, null, 'N') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202112011130_GO-2031.sql') FROM dual;
