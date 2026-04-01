-- GO-3459: Patient Summary Report (Jasper). Process UU c0e1adfc-f743-49e4-9346-4da29f1e9f6c.
-- Register the report process and grant the same roles that can run Diagnosis Report, including
-- Clinician/Nurse Advanced (see 202207250836_GO-2399.sql for Diagnosis on that role).

INSERT INTO
	ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value,
	            name, description, help, accesslevel, entitytype, procedurename, isreport, isdirectprint,
	            ad_reportview_id, classname, statistic_count, statistic_seconds, ad_printformat_id,
	            workflowvalue, ad_workflow_id, isbetafunctionality, isserverprocess, showhelp, jasperreport,
	            ad_form_id, copyfromprocess, ad_process_uu, ad_ctxhelp_id, executiontype,
	            allowmultipleexecution, filenamepattern)
VALUES
	((
		 SELECT
			 MAX(ad_process_id)
		 FROM
			 ad_process
	 ) + 1, 0, 0, 'Y', '2026-03-27 14:59:14.552000', 100, '2026-03-27 14:59:14.552000', 100, 'BH Patient Summary Report',
	 'Patient Summary Report', 'Report for patient summary', NULL, '3', 'U', NULL, 'Y', 'N', NULL, NULL, 0, 0, NULL, NULL,
	 NULL, 'N', NULL, 'Y', 'Patients Report/PatientSummary.jasper', NULL, 'N', 'c0e1adfc-f743-49e4-9346-4da29f1e9f6c', NULL,
	 NULL, 'P', NULL);

-- Parameter: current visit (BH_Visit_UU) passed into the report.
INSERT INTO
	ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                 updatedby, name, description, help, ad_process_id, seqno, ad_reference_id,
	                 ad_reference_value_id, ad_val_rule_id, columnname, iscentrallymaintained, fieldlength,
	                 ismandatory, isrange, defaultvalue, defaultvalue2, vformat, valuemin, valuemax,
	                 ad_element_id, entitytype, readonlylogic, displaylogic, ad_process_para_uu, isencrypted,
	                 mandatorylogic, placeholder, placeholder2, isautocomplete, ad_fieldgroup_id, query,
	                 daterangeoption, isshownegatebutton)
VALUES
	((
		 SELECT
			 MAX(ad_process_para_id)
		 FROM
			 ad_process_para
	 ) + 1, 0, 0, 'Y', '2026-03-27 15:03:37.766000', 100, '2026-03-27 15:03:37.766000', 100, 'BH_Visit_UU', NULL, NULL,
	 (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'c0e1adfc-f743-49e4-9346-4da29f1e9f6c'
	 ), 10, 10, NULL, NULL, 'BH_Visit_UU', 'Y', 36, 'N', 'N', NULL, NULL, NULL, NULL, NULL, 1000276, 'U', NULL,
	 NULL, 'd147cad4-2aef-4abd-a929-d6bea83c5495', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

-- ad_process_access: who may run this report (matches Diagnosis Report coverage).
--   461b31c5… Clinic Admin          (GO-1569)
--   98617c31… Clinician/Nurse Basic (GO-1569)
--   e1a9a87d… Clinic User          (GO-1703)
--   c54253cf… Clinician/Nurse Advanced (GO-2399, Diagnosis Report)

-- Role: Clinic Admin (461b31c5-cae2-449d-8a0c-7385b12f4685)
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'c0e1adfc-f743-49e4-9346-4da29f1e9f6c'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
	 ), 0, 0, 'Y', NOW(), 100, NOW(), 100, 'Y', 'f10eaecf-6417-4b1c-b238-30be74fcd640')
ON CONFLICT DO NOTHING;

-- Role: Clinician/Nurse Basic (98617c31-55ff-48f9-bd44-253ef323d960)
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'c0e1adfc-f743-49e4-9346-4da29f1e9f6c'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	 ), 0, 0, 'Y', NOW(), 100, NOW(), 100, 'Y', '5e2e6349-361f-41bc-a95e-4badf708e72e')
ON CONFLICT DO NOTHING;

-- Role: Clinic User (e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e)
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'c0e1adfc-f743-49e4-9346-4da29f1e9f6c'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'
	 ), 0, 0, 'Y', NOW(), 100, NOW(), 100, 'Y', '2fea89ec-fecf-4fef-a9fd-cb22f0665994')
ON CONFLICT DO NOTHING;

-- Role: Clinician/Nurse Advanced (c54253cf-c86b-4aaa-b472-ed8880635c62)
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'c0e1adfc-f743-49e4-9346-4da29f1e9f6c'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c54253cf-c86b-4aaa-b472-ed8880635c62'
	 ), 0, 0, 'Y', NOW(), 100, NOW(), 100, 'Y', '9a8b7c6d-5e4f-4a3b-9c2d-1e0f8a7b6c5d')
ON CONFLICT DO NOTHING;

SELECT
	register_migration_script('202603271531_GO-3459.sql')
FROM
	dual; 
