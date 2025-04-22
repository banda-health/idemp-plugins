-- Add the new report
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
	 ), 0, 0, 'Y', '2025-04-09 15:27:31.043000', 100, '2025-04-09 15:27:54.220000', 100, '10000002',
	 'Expenses', 'A list of all OTC sales and totals', NULL, '3', 'U', NULL, 'N', 'N', NULL, NULL, 0,
	 0, NULL, NULL, NULL, 'N', NULL, 'Y', 'expenses/Expenses.jasper', NULL, 'N', 'bbffd5e1-973a-4d17-9ddf-9ca78a4e140d',
	 NULL, NULL, 'P', NULL);

-- Add the parameters
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
	 ), 0, 0, 'Y', '2025-04-09 11:47:21.035000', 100, '2025-04-09 11:47:21.035000', 100, 'End Date', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'bbffd5e1-973a-4d17-9ddf-9ca78a4e140d'
	 ), 20, 16, NULL, NULL, 'End Date', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 'ec7a4dbb-6636-48cb-bb9b-203ec5fee08b', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');
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
	 ), 0, 0, 'Y', '2025-04-06 11:46:52.581000', 100, '2025-04-09 11:46:52.581000', 100, 'Begin Date', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'bbffd5e1-973a-4d17-9ddf-9ca78a4e140d'
	 ), 10, 16, NULL, NULL, 'Begin Date', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 'f368689d-65df-4b87-b9bc-5a5c3072b487', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

-- Update the report dropdown menu
INSERT INTO
	ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description,
	         issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id,
	         ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname,
	         predefinedcontextvariables)
VALUES
	((
		 SELECT
			 MAX(ad_menu_id) + 1
		 FROM
			 ad_menu
	 ), 0, 0, 'Y', '2025-04-09 15:32:29.583000', 100, '2025-04-09 15:32:29.583000', 'Expenses', 100,
	 NULL, 'N', 'Y', 'N', 'P', NULL, NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'bbffd5e1-973a-4d17-9ddf-9ca78a4e140d'
	 ), NULL, NULL, 'U', 'Y', '6468aaa2-11e4-4afa-97f0-293e45656c1a', NULL, NULL, NULL);

INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '6468aaa2-11e4-4afa-97f0-293e45656c1a'
	), 0, 0, 'Y', '2025-04-09 15:32:29.623104', 100, '2025-04-09 15:32:54.123000', 100, (
		 SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
	 ), 24, '47c0ae27-6543-4d83-bb81-084afee3e16a');

-- Add correct access
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
SELECT
	p.ad_process_id,
	r.ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	'Y',
	uuid_generate_v4()
FROM
	ad_role r
		JOIN ad_process p
		ON p.ad_process_uu = 'bbffd5e1-973a-4d17-9ddf-9ca78a4e140d'
WHERE
	r.ad_role_uu IN ('93365778-a2d9-433b-b962-87fb150db4fa', '461b31c5-cae2-449d-8a0c-7385b12f4685',
	                 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e', '09eb7fc8-9cc5-44b0-9d14-15258a066038',
	                 'ee008abc-2c16-4230-b48c-b1f5577ea270', 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a');

-- Register the script
SELECT
	register_migration_script('202504091613_GO-2840.sql')
FROM
	dual;
