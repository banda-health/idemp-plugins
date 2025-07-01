-- Add the new stock transfers report
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
	 ), 0, 0, 'Y', '2025-06-13 15:55:32.374000', 100, '2025-06-13 15:55:32.374000', 100, '10000001', 'Stock Transfers',
	 NULL, NULL, '3', 'U', NULL, 'N', 'N', NULL, NULL, 0, 0, NULL, NULL, NULL, 'N', NULL, 'Y',
	 'Stock Transfer/Stock Transfer.jasper', NULL, 'N', '5a666f24-469a-43dc-865f-4053e0dd4fd6', NULL, NULL, 'P', NULL);

-- Add the begin & end date parameters
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
	 ), 0, 0, 'Y', '2025-06-13 15:56:08.714000', 100, '2025-06-13 15:56:08.714000', 100, 'Begin Date', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '5a666f24-469a-43dc-865f-4053e0dd4fd6'
	 ), 10, 16, NULL, NULL, 'Begin Date', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '9e1a0f9d-06a6-4e58-91e1-9fcedd5f905f', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');
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
	 ), 0, 0, 'Y', '2025-06-13 15:56:21.838000', 100, '2025-06-13 15:56:21.838000', 100, 'End Date', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '5a666f24-469a-43dc-865f-4053e0dd4fd6'
	 ), 20, 16, NULL, NULL, 'End Date', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '2ebc4789-9c71-4ed4-9486-1730c98a648a', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

-- Add the report to the menu
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
	 ), 0, 0, 'Y', '2025-06-13 16:00:45.486000', 100, '2025-06-13 16:00:45.486000', 'Stock Transfers', 100, NULL, 'N',
	 'Y', 'N', 'P', NULL, NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '5a666f24-469a-43dc-865f-4053e0dd4fd6'
	 ), NULL, NULL, 'U', 'Y', '41dbb52e-88a3-407f-99ab-326bbbac7388', NULL, NULL, NULL);

INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '41dbb52e-88a3-407f-99ab-326bbbac7388'
	), 0, 0, 'Y', '2025-06-13 16:00:45.507830', 100, '2025-06-13 16:01:07.330000', 100, (
		 SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '90d2983e-64b0-4b5f-86ee-4512c45bf893'
	 ), 7, '2bf4775b-650d-4116-a5c1-b7cdb1966379');

-- Add access for the clinic admin and pharmacy advanced
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
SELECT
	p.ad_process_id,
	ad_role_id,
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
	ad_process p
		JOIN ad_role r
		ON r.ad_role_uu IN ('461b31c5-cae2-449d-8a0c-7385b12f4685', 'ec17fee0-a53a-4dbb-b946-423ce14880eb')
WHERE
	ad_process_uu = '5a666f24-469a-43dc-865f-4053e0dd4fd6';

SELECT
	register_migration_script('202506131604_GO-3316.sql')
FROM
	dual;
