-- Update again these parameters in case go-2688 had to add them
UPDATE ad_process_para
SET
	ad_reference_id = 16
WHERE
		ad_process_para_uu IN ('935825a6-edd6-4bd6-a0d2-792f7820631f', '09d25fd2-a707-4431-b4b3-14ea2968ff12');

-- Remove a parameter that exists in some DBs, but shouldn't
DELETE
FROM
	ad_process_para
WHERE
		ad_process_para_uu = '4cc6e38c-33f1-4699-ae5e-005560710a96';

-- Add I&E report parameters for DBs that don't have them
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
	 ), 0, 0, 'Y', '2020-08-06 12:21:54.901000', 100, '2020-08-11 07:58:02.312000', 100, 'End Date', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'f777f042-3907-4293-94c4-49fe6eb58780'
	 ), 20, 16, NULL, NULL, 'End Date', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 'cb31eb7a-c1ef-4afd-8443-86c657060000', 'N', NULL, NULL, NULL, 'N')
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
	 ), 0, 0, 'Y', '2020-08-06 12:21:20.237000', 100, '2020-08-11 07:57:41.173000', 100, 'Begin Date', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'f777f042-3907-4293-94c4-49fe6eb58780'
	 ), 10, 16, NULL, NULL, 'Begin Date', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '23fcb57c-e97e-4339-8228-65f2ad473d2a', 'N', NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;

SELECT
	register_migration_script('202305170606_GO-2627.sql')
FROM
	dual;
