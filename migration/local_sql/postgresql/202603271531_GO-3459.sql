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
	 ) + 1, 0, 0, 'Y', '2026-03-27 14:59:14.552000', 100, '2026-03-27 14:59:14.552000', 100, '10000000',
	 'Patient Summary Report', 'Report for patient summary', NULL, '3', 'U', NULL, 'N', 'N', NULL, NULL, 0, 0, NULL, NULL,
	 NULL, 'N', NULL, 'Y', NULL, NULL, 'N', 'c0e1adfc-f743-49e4-9346-4da29f1e9f6c', NULL, NULL, 'P', NULL);

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

---- TODO add process access
INSERT INTO
	ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby,
	         description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id,
	         ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu,
	         ad_infowindow_id, iconclassname, predefinedcontextvariables)
VALUES
	((
		 SELECT
			 MAX(ad_menu_id)
		 FROM
			 ad_menu
	 ) + 1, 0, 0, 'Y', '2026-03-27 15:06:44.325000', 100, '2026-03-27 15:06:44.325000', 'Patients Summary Report', 100,
	 'Patient Summary', 'N', 'Y', 'N', 'P', NULL, NULL, NULL, 1000079, NULL, NULL, 'U', 'Y',
	 '84e85424-8401-4341-a0d8-b1331443f3e7', NULL, NULL, NULL);



INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	               updatedby, parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '84e85424-8401-4341-a0d8-b1331443f3e7'
	), 0, 0, 'Y', '2026-03-27 15:06:44.339308', 100, '2026-03-27 15:08:37.820000', 100, (
		 SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'bcf31f7a-9532-42d2-9bd6-35ebc79f973e'
	 ), 8,
	 'c4004e66-a62e-42f9-9b26-ec1a12e16b06');

SELECT
	register_migration_script('202603271531_GO-3459.sql')
FROM
	dual; 
