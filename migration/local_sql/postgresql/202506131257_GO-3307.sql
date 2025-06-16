-- Add the new services list report
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
	 ), 0, 0, 'Y', '2025-06-13 11:28:11.096000', 100, '2025-06-13 11:28:11.096000', 100, '10000000', 'Services List',
	 NULL, NULL, '3', 'U', NULL, 'N', 'N', NULL, NULL, 0, 0, NULL, NULL, NULL, 'N', NULL, 'Y',
	 'Service List/Service List.jasper', NULL, 'N', 'fd5b6538-760c-4c8f-b943-115c1f3d2287', NULL, NULL, 'P', NULL);

-- Add the new services list report menu item
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
	 ), 0, 0, 'Y', '2025-06-13 11:31:09.731000', 100, '2025-06-13 11:31:09.731000', 'Services List', 100, NULL, 'N', 'Y',
	 'N', 'P', NULL, NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'fd5b6538-760c-4c8f-b943-115c1f3d2287'
	 ), NULL, NULL, 'U', 'Y', 'e708bcc8-f134-418a-8642-cc9b7103b9ea', NULL, NULL, NULL);

-- Add the menu into the correct tree for UI grouping
INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'e708bcc8-f134-418a-8642-cc9b7103b9ea'
	), 0, 0, 'Y', '2025-06-13 11:31:09.750125', 100, '2025-06-13 11:31:49.271000', 100, (
		 SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'
	 ), 13, '349a930c-90ce-4922-a834-eaadd42d7184');

-- Give the clinic admin access
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
		ON r.ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
WHERE
	ad_process_uu = 'fd5b6538-760c-4c8f-b943-115c1f3d2287';

SELECT
	register_migration_script('202506131257_GO-3307.sql')
FROM
	dual;
