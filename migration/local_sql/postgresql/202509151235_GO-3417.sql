INSERT INTO
	ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	            description, help, accesslevel, entitytype, procedurename, isreport, isdirectprint, ad_reportview_id,
	            classname, statistic_count, statistic_seconds, ad_printformat_id, workflowvalue, ad_workflow_id,
	            isbetafunctionality, isserverprocess, showhelp, jasperreport, ad_form_id, copyfromprocess, ad_process_uu,
	            ad_ctxhelp_id, executiontype, allowmultipleexecution, filenamepattern)
VALUES
	((
		 SELECT
			 MAX(ad_process_id) + 1
		 FROM
			 ad_process
	 ), 0, 0, 'Y', '2025-09-15 13:15:27.412000', 100, '2025-09-15 13:15:27.412000', 100, '10000000',
	 'In-Patient Report', 'Report for in-patient data', NULL, '3', 'U', NULL, 'N', 'N', NULL, NULL, 0, 0, NULL, NULL,
	 NULL, 'N', NULL, 'Y', 'In-Patient Report/InPatientReport.jasper', NULL, 'N',
	 'a1b2c3d4-e5f6-7890-abcd-ef1234567890', NULL, NULL, 'P', NULL);

INSERT INTO
	ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	                 description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	                 columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2,
	                 vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic,
	                 ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete,
	                 ad_fieldgroup_id, query, daterangeoption, isshownegatebutton)
VALUES
	((
		 SELECT
			 MAX(ad_process_para_id) + 1
		 FROM
			 ad_process_para
	 ), 0, 0, 'Y', '2025-09-15 13:17:17.645000', 100, '2025-09-15 13:17:17.645000', 100, 'Begin Date',
	 'Start date for the report', NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'
	 ), 10, 16, NULL, NULL, 'Begin Date', 'N', 0, 'Y', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '3fcf7a7a-157f-479a-b8ac-62350ad1bb06', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');
INSERT INTO
	ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	                 description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	                 columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2,
	                 vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic,
	                 ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete,
	                 ad_fieldgroup_id, query, daterangeoption, isshownegatebutton)
VALUES
	((
		 SELECT
			 MAX(ad_process_para_id) + 1
		 FROM
			 ad_process_para
	 ), 0, 0, 'Y', '2025-09-15 13:17:41.287000', 100, '2025-09-15 13:17:41.287000', 100, 'End Date',
	 'End date for the report', NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'
	 ), 20, 16, NULL, NULL, 'End Date', 'N', 0, 'Y', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '0668b3bc-590e-4191-9923-b02eee47ce2d', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

-- Add access for Clinic Admin role & Cashier/Registration Advanced role
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT
			 ad_process_id
		 FROM
			 ad_process
		 WHERE
			 ad_process_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'
	 ), (
		 SELECT
			 ad_role_id
		 FROM
			 ad_role
		 WHERE
			 ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
	 ), 0, 0, 'Y', NOW(), 100, NOW(), 100, 'Y', uuid_generate_v4());
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT
			 ad_process_id
		 FROM
			 ad_process
		 WHERE
			 ad_process_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'
	 ), (
		 SELECT
			 ad_role_id
		 FROM
			 ad_role
		 WHERE
			 ad_role_uu = 'ee008abc-2c16-4230-b48c-b1f5577ea270'
	 ), 0, 0, 'Y', NOW(), 100, NOW(), 100, 'Y', uuid_generate_v4());

-- Add the report to the menu
INSERT INTO
	ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description,
	         issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id,
	         ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname,
	         predefinedcontextvariables)
VALUES
	((
		 SELECT MAX(ad_menu_id) + 1
		 FROM ad_menu
	 ), 0, 0, 'Y', '2025-09-15 13:23:00.642000', 100, '2025-09-15 13:23:00.642000', 'In-Patient Report', 100, NULL, 'N',
	 'Y', 'N', 'R', NULL, NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'
	 ), NULL, NULL, 'U', 'Y', 'b7f1dcc0-85c2-4565-a18c-fb5beb2f36aa', NULL, NULL, NULL);

INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'b7f1dcc0-85c2-4565-a18c-fb5beb2f36aa'
	), 0, 0, 'Y', '2025-09-15 13:23:00.665676', 100, '2025-09-15 13:23:36.405000', 100, (
		 SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'bcf31f7a-9532-42d2-9bd6-35ebc79f973e'
	 ), 7, '88f87ed3-b896-4437-b903-97bf7cea262a');

-- Register the script
SELECT
	register_migration_script('202509151235_GO-3417.sql')
FROM
	dual;
