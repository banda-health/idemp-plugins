INSERT INTO
	ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	            description, help, accesslevel, entitytype, procedurename, isreport, isdirectprint, ad_reportview_id,
	            classname, statistic_count, statistic_seconds, ad_printformat_id, workflowvalue, ad_workflow_id,
	            isbetafunctionality, isserverprocess, showhelp, jasperreport, ad_form_id, copyfromprocess, ad_process_uu,
	            ad_ctxhelp_id, executiontype, allowmultipleexecution)
VALUES
	((
		 SELECT
				 MAX(ad_process_id) + 1
		 FROM
			 ad_process
	 ), 0, 0, 'Y', '2023-05-16 09:27:02.051000', 100, '2023-05-16 09:27:02.051000', 100, 'BH Open Balance Invoice',
	 'Open Balance Invoice', 'Track how open balance changed since the last time it was 0', NULL, '3', 'U', NULL, 'Y',
	 'N', NULL, NULL, 0, 0, NULL, NULL, NULL, 'N', 'N', 'Y',
	 'cashier/Total Open Balance Invoice/OpenBalanceInvoice.jasper', NULL, 'N', '199f56a6-8e1f-47b4-8f22-e2bdb8da7505',
	 NULL, NULL, 'P')
ON CONFLICT DO NOTHING;

INSERT INTO
	ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	                 description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	                 columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2,
	                 vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic,
	                 ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete)
VALUES
	((
		 SELECT
				 MAX(ad_process_para_id) + 1
		 FROM
			 ad_process_para
	 ), 0, 0, 'Y', '2020-10-30 05:28:49.930000', 100, '2020-10-30 05:28:49.930000', 100, 'c_bpartner_uu', 'Patient UUID',
	 NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505'
	 ), 10, 10, NULL, NULL, 'c_bpartner_uu', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '72dac62a-0432-4f58-8e65-cab7cdacde30', 'N', NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;

INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'
	 ), 0, 0, 'Y', '2023-05-16 10:05:25.517000', 100, '2023-05-16 10:05:25.517000', 100, 'Y',
	 '754e0a91-6c19-46db-990d-50d9ed2f5e35')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '93365778-a2d9-433b-b962-87fb150db4fa'
	 ), 0, 0, 'Y', '2023-05-16 10:05:21.258000', 100, '2023-05-16 10:05:21.258000', 100, 'Y',
	 '76d6a47a-d76e-4303-92b6-a08abe068279')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'
	 ), 0, 0, 'Y', '2023-05-16 10:05:17.664000', 100, '2023-05-16 10:05:17.664000', 100, 'Y',
	 '08e02bee-808b-4ad7-8851-1c05380c5f86')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c54253cf-c86b-4aaa-b472-ed8880635c62'
	 ), 0, 0, 'Y', '2023-05-16 10:05:02.904000', 100, '2023-05-16 10:05:02.904000', 100, 'Y',
	 '703bbc9c-2783-43f6-b482-477eef371183')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	 ), 0, 0, 'Y', '2023-05-16 10:04:58.399000', 100, '2023-05-16 10:04:58.399000', 100, 'Y',
	 'ca358548-3620-491d-911f-c080eeb8022e')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'
	 ), 0, 0, 'Y', '2023-05-16 10:04:50.178000', 100, '2023-05-16 10:04:50.178000', 100, 'Y',
	 '764d66de-aff2-43af-8b96-17a6a9ebb82a')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ee008abc-2c16-4230-b48c-b1f5577ea270'
	 ), 0, 0, 'Y', '2023-05-16 10:04:44.040000', 100, '2023-05-16 10:04:44.040000', 100, 'Y',
	 '41e15aaf-47a9-46db-beef-8be2f049a3be')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	 ), 0, 0, 'Y', '2023-05-16 10:04:38.996000', 100, '2023-05-16 10:04:38.996000', 100, 'Y',
	 'bede4ca5-3eb4-459e-8ea2-2d18234b7110')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
	 ), 0, 0, 'Y', '2023-05-16 10:04:29.108000', 100, '2023-05-16 10:04:29.108000', 100, 'Y',
	 'cf4c5e99-d042-4a3e-8f85-8698beb515cc')
ON CONFLICT DO NOTHING;

-- Add the process to the correct existing roles
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby)
SELECT
	p.ad_process_id,
	r.ad_role_id,
	r.ad_client_id,
	0,
	100,
	100
FROM
	ad_process p
		JOIN ad_role r
			ON r.ismanual = 'N' AND r.ismasterrole = 'N'
WHERE
		p.ad_process_uu = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505'
ON CONFLICT DO NOTHING;

SELECT
	register_migration_script('202305161031_GO-2432.sql')
FROM
	dual;
