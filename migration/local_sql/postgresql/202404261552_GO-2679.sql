INSERT INTO ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete) VALUES ((SELECT MAX(ad_process_para_id)+1 FROM ad_process_para), 0, 0, 'Y', '2024-03-08 12:05:14.777000', 100, '2024-03-08 12:05:14.777000', 100, 'Source', null, null, (SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='97542544-da63-4e5f-85e0-ad35da81318c'), 20, 10, null, null, 'Source', 'N', 0, 'N', 'N', 'BHGO', null, null, null, null, null, 'U', null, null, '6287b949-1088-4e93-a9dc-644be8657918', 'N', null, null, null, 'N') ON CONFLICT DO NOTHING;

SELECT
	register_migration_script('202404261552_GO-2679.sql')
FROM
	dual;
