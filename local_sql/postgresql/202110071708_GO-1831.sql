-- Add a new parameter
INSERT INTO ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete) VALUES ((SELECT MAX(ad_process_para_id) + 1 FROM ad_process_para), 0, 0, 'Y', '2021-10-07 13:25:31.857000', 100, '2021-10-07 16:47:54.577000', 100, 'Coded Diagnosis', null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '7c29028a-8dd3-4025-a5af-87701748d81f'), 25, 19, null, null, 'BH_Coded_Diagnosis_UU', 'N', 36, 'N', 'N', null, null, null, null, null, (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'e5ee0169-7976-47a8-b844-9705b6d64a88'), 'U', null, null, '250d4efb-e958-4ef6-95cf-4d23b10f0972', 'N', null, null, null, 'N') ON CONFLICT DO NOTHING;

-- Rename the old parameter
UPDATE ad_process_para SET name = '' WHERE ad_process_para_uu = '3b9e7e1e-cb86-4835-89ae-0c14e6f1b1b7';

SELECT register_migration_script('202110071708_GO-1831.sql') FROM dual;
