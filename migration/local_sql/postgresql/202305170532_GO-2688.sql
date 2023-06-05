-- Insert parameters that might be missing for the Donor Fund report
INSERT INTO
	ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	                 description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	                 columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2,
	                 vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic,
	                 ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete)
VALUES
	((
		 SELECT MAX(ad_process_para_id) + 1
		 FROM ad_process_para
	 ), 0, 0, 'Y', '2019-05-16 15:35:51.362000', 100, '2019-05-16 15:35:51.362000', 100, 'Begin Date', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '3478d341-c6d9-4f52-a865-5bf0ba8a7607'
	 ), 10, 15, NULL, NULL, 'Begin Date', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '935825a6-edd6-4bd6-a0d2-792f7820631f', 'N', NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	                 description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	                 columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2,
	                 vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic,
	                 ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete)
VALUES
	((
		 SELECT MAX(ad_process_para_id) + 1
		 FROM ad_process_para
	 ), 0, 0, 'Y', '2019-05-16 15:36:42.506000', 100, '2019-05-16 15:36:42.506000', 100, 'End Date', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '3478d341-c6d9-4f52-a865-5bf0ba8a7607'
	 ), 20, 15, NULL, NULL, 'End Date', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '09d25fd2-a707-4431-b4b3-14ea2968ff12', 'N', NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;

SELECT
	register_migration_script('202305170532_GO-2688.sql')
FROM
	dual;
