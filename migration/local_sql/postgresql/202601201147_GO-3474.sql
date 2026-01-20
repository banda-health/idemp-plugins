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
	 ), 0, 0, 'Y', '2026-01-20 08:26:39.096000', 100, '2026-01-20 08:26:39.096000', 100, 'Referral', NULL, NULL,
	 (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '7c29028a-8dd3-4025-a5af-87701748d81f'
	 ), 60, 17, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '090f3a94-25a4-4f65-a270-96732df35407'
	 ), NULL, 'Referral', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '03774df0-bdc8-455f-9e55-cc29d8132aa4', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');
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
	 ), 0, 0, 'Y', '2026-01-20 08:23:36.481000', 100, '2026-01-20 08:23:36.481000', 100, 'Patient Type', NULL, NULL,
	 (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '7c29028a-8dd3-4025-a5af-87701748d81f'
	 ), 50, 17, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
	 ), NULL, 'Patient Type', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL,
	 NULL, '508b7dbc-e486-46ca-ac6d-fd6582619ebc', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

SELECT
	register_migration_script('202601201147_GO-3474.sql')
FROM
	dual;
