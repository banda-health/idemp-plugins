-- Insert patients report parameter
INSERT INTO
	ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	                 description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	                 columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2,
	                 vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic,
	                 ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete,
	                 ad_fieldgroup_id, query, daterangeoption, isshownegatebutton)
VALUES
	((
		 SELECT MAX(ad_process_para_id) + 1
		 FROM ad_process_para
	 ), 0, 0, 'Y', '2025-05-19 17:13:30.429000', 100, '2025-05-19 17:13:30.429000', 100, 'Tags', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'feaa97fb-b424-4dce-8790-035ba80ca023'
	 ), 10, 200162, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '5b45bfe6-70e4-4327-843f-1ce7bc2bb646'
	 ), NULL, 'BH_Tag_UU', 'N', 36, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '11fd71c2-400f-4f09-978d-2deeae6cdb28', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

-- Insert services charged report parameter
INSERT INTO
	ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	                 description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	                 columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2,
	                 vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic,
	                 ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete,
	                 ad_fieldgroup_id, query, daterangeoption, isshownegatebutton)
VALUES
	((
		 SELECT MAX(ad_process_para_id) + 1
		 FROM ad_process_para
	 ), 0, 0, 'Y', '2025-05-19 17:28:51.877000', 100, '2025-05-19 17:28:51.877000', 100, 'Tags', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2'
	 ), 30, 200162, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '5b45bfe6-70e4-4327-843f-1ce7bc2bb646'
	 ), NULL, 'BH_Tag_UU', 'N', 36, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '0774a443-616b-4a13-ad0a-ca65dff3ddef', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

SELECT
	register_migration_script('202505221621_GO-3295.sql')
FROM
	dual;
