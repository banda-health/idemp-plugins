INSERT INTO ad_process (ad_process_id,
                        ad_client_id,
                        ad_org_id,
                        isactive,
                        created,
                        createdby,
                        updated,
                        updatedby,
                        value,
                        name,
                        description,
                        help,
                        accesslevel,
                        entitytype,
                        procedurename,
                        isreport,
                        isdirectprint,
                        ad_reportview_id,
                        classname,
                        statistic_count,
                        statistic_seconds,
                        ad_printformat_id,
                        workflowvalue,
                        ad_workflow_id,
                        isbetafunctionality,
                        isserverprocess,
                        showhelp,
                        jasperreport,
                        ad_form_id,
                        copyfromprocess,
                        ad_process_uu,
                        ad_ctxhelp_id,
                        executiontype,
                        allowmultipleexecution,
                        filenamepattern)
VALUES ((SELECT MAX(ad_process_id) + 1
         FROM ad_process),
        0,
        0,
        'Y',
        '2025-04-08 14:00:25.005153',
        100,
        '2025-04-08 14:00:25.005153',
        100,
        '10000000',
        'Patients Report',
        null,
        null,
        '3',
        'U',
        null,
        'Y',
        'N',
        null,
        null,
        0,
        0,
        null,
        null,
        null,
        'N',
        null,
        'Y',
        'patient/PatientReport.jasper',
        null,
        'N',
        'feaa97fb-b424-4dce-8790-035ba80ca023',
        null,
        null,
        'P',
        null);
        
-- Insert access for clinic admin
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'feaa97fb-b424-4dce-8790-035ba80ca023'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'), 0, 0, 'Y', '2025-04-08 14:00:25.005153', 100, '2025-04-08 14:00:25.005153', 100, 'Y', null) ON CONFLICT DO NOTHING;

-- Add the report to the GL menu
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
	 ), 0, 0, 'Y', '2025-04-08 14:00:25.005153', 100, '2025-04-08 14:00:25.005153', 'Patients Report', 100,
	 'Report of all patients in a clinic', 'N', 'Y', 'N', 'P', NULL, NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'feaa97fb-b424-4dce-8790-035ba80ca023'
	 ), NULL, NULL, 'U', 'Y', '5790943b-ba97-49e9-ab24-df1f4c64186c', NULL, NULL, NULL);
INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '5790943b-ba97-49e9-ab24-df1f4c64186c'
	), 0, 0, 'Y', '2025-04-08 14:00:25.005153', 100, '2025-04-08 14:00:25.005153', 100, (
		 SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
	 ), 22, 'fe3cdf50-9529-4914-9938-9d40168d4576');


-- Register the script
SELECT register_migration_script('202504081700_GO-3257.sql')
FROM dual;