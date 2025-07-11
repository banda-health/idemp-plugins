-- Add start and end date parameters
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
	 ), 0, 0, 'Y', '2025-07-11 16:59:00.673244', 100, '2025-07-11 16:59:00.673244', 100, 'Begin Date', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '592179c8-1974-4205-aeca-005233fdacd0'
	 ), 10, 16, NULL, NULL, 'Begin Date', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 'd48fe228-cdf2-4619-9ed4-6b6a3e0ab85d', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');
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
	 ), 0, 0, 'Y', '2025-07-11 16:59:00.673244', 100, '2025-07-11 16:59:00.673244', 100, 'End Date', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '592179c8-1974-4205-aeca-005233fdacd0'
	 ), 20, 16, NULL, NULL, 'End Date', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '58711583-23e7-47d9-9aa1-4a30281713c6', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

SELECT
	register_migration_script('202507112114_GO-3340.sql')
FROM
	dual;
