-- Add some new parameters to the expense report
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
	 ), 0, 0, 'Y', '2025-05-02 13:40:05.418000', 100, '2025-05-02 13:40:05.418000', 100, 'Expense Category', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'bbffd5e1-973a-4d17-9ddf-9ca78a4e140d'
	 ), 30, 19, NULL, NULL, 'C_Charge_UU', 'N', 36, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 'd31c0b9e-a479-427f-8813-0c953f294387', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');
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
	 ), 0, 0, 'Y', '2025-05-02 13:40:24.064000', 100, '2025-05-02 13:40:24.064000', 100, 'Supplier', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'bbffd5e1-973a-4d17-9ddf-9ca78a4e140d'
	 ), 40, 19, NULL, NULL, 'C_BPartner_UU', 'N', 36, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 'ee5e8174-4381-4e6a-9158-72f489a221a4', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

SELECT
	register_migration_script('202505021404_GO-3286.sql')
FROM
	dual;
