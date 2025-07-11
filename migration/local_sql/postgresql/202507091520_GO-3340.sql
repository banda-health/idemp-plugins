INSERT INTO ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                        updatedby, value, name, description, help, accesslevel, entitytype, procedurename,
                        isreport, isdirectprint, ad_reportview_id, classname, statistic_count,
                        statistic_seconds, ad_printformat_id, workflowvalue, ad_workflow_id,
                        isbetafunctionality, isserverprocess, showhelp, jasperreport, ad_form_id,
                        copyfromprocess, ad_process_uu, ad_ctxhelp_id, executiontype, allowmultipleexecution,
                        filenamepattern)
VALUES ((select max(ad_process_id) + 1 from ad_process), 0, 0, 'Y', '2025-07-09 15:23:56.534000', 100,
        '2025-07-09 15:23:56.534000', 100, '10000000',
        'Deleted Drafted Bills Report', null, null, '3', 'U', null, 'Y', 'N', null, null, 0, 0, null, null, null, 'N',
        null, 'Y', 'Deleted Drafted Bills/Deleted Drafted Bills Report.jasper', null, 'N',
        '592179c8-1974-4205-aeca-005233fdacd0', null, null, 'P', null);

INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
                               updated,
                               updatedby, isreadwrite, ad_process_access_uu)
SELECT p.ad_process_id,
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
FROM ad_process p
         JOIN ad_role r
              ON r.ad_role_uu IN ('461b31c5-cae2-449d-8a0c-7385b12f4685')
WHERE ad_process_uu = '592179c8-1974-4205-aeca-005233fdacd0';

INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name,
                     updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id,
                     ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype,
                     iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname,
                     predefinedcontextvariables)
VALUES ((select max(ad_menu_id) + 1 from ad_menu), 0, 0, 'Y', '2025-07-09 15:27:03.176000', 100,
        '2025-07-09 15:27:03.176000', 'Deleted Drafted Bills',
        100, null, 'N', 'N', 'N', 'R', null, null, null,
        (select ad_process_id from ad_process where ad_process_uu = '592179c8-1974-4205-aeca-005233fdacd0'), null, null,
        'U', 'Y',
        '909065b1-ee54-4ac7-9bd4-276e58252c4f', null, null, null);

INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby,
                           updated, updatedby, parent_id, seqno, ad_treenodemm_uu)
VALUES (10, (select ad_menu_id from ad_menu where ad_menu_uu = '909065b1-ee54-4ac7-9bd4-276e58252c4f'), 0, 0, 'Y',
        '2025-07-09 15:27:03.213273', 100, '2025-07-09 15:29:27.403000', 100,
        (select ad_menu_id from ad_menu where ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'), 14,
        '3b7b5e70-911c-47b6-a63e-f01d4ef7c601');

SELECT
	register_migration_script('202507091520_GO-3340.sql')
FROM
	dual;