-- Add new parameters to the expenses report
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
	 ), 0, 0, 'Y', '2025-05-23 14:28:03.062000', 100, '2025-05-23 14:28:03.062000', 100, 'Payment Method', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'bbffd5e1-973a-4d17-9ddf-9ca78a4e140d'
	 ), 50, 17, 195, NULL, 'Payment Mode', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 'b1b7a46a-9e07-4050-8bd1-23780ae0c797', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');
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
	 ), 0, 0, 'Y', '2025-05-23 14:28:57.773000', 100, '2025-05-23 14:28:57.773000', 100, 'Created By', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'bbffd5e1-973a-4d17-9ddf-9ca78a4e140d'
	 ), 60, 19, NULL, NULL, 'AD_User_UU', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '653e7298-7291-4b18-8c92-5e185d76cec8', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

SELECT
	register_migration_script('202505231712_GO-3290.sql')
FROM
	dual;
