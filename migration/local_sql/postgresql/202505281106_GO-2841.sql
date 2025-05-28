-- Create Income statement report
INSERT INTO ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                        updatedby, value, name, description, help, accesslevel, entitytype, procedurename,
                        isreport, isdirectprint, ad_reportview_id, classname, statistic_count,
                        statistic_seconds, ad_printformat_id, workflowvalue, ad_workflow_id,
                        isbetafunctionality, isserverprocess, showhelp, jasperreport, ad_form_id,
                        copyfromprocess, ad_process_uu, ad_ctxhelp_id, executiontype, allowmultipleexecution,
                        filenamepattern)
VALUES ((SELECT MAX(ad_process_id) + 1
         FROM ad_process), 0, 0, 'Y', '2025-05-28 11:26:57.510000', 100, '2025-05-28 11:26:57.510000', 100, '10000000',
        'Income Statement (Profit & Loss)', 'Summary report on income for a specific period', null, '3', 'U', null, 'Y',
        'N', null, null, 0, 0, null, null, null, 'N', null, 'Y',
        'Income and Expenses/IncomeStatementProfitAndLoss.jasper', null, 'N', '8ea6c947-4450-48dd-8bd0-76b0f307dcb0',
        null, null, 'P', null);
--- Create process parameters
INSERT INTO ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby,
                             updated, updatedby, name, description, help, ad_process_id, seqno,
                             ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname,
                             iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue,
                             defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype,
                             readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic,
                             placeholder, placeholder2, isautocomplete, ad_fieldgroup_id, query,
                             daterangeoption, isshownegatebutton)
VALUES ((SELECT MAX(ad_process_para_id) + 1
         FROM ad_process_para), 0, 0, 'Y', '2025-05-28 11:30:33.052000', 100, '2025-05-28 11:30:33.052000', 100, 'End Date', null,
        null, (select ad_process_id from ad_process where ad_process_uu = '8ea6c947-4450-48dd-8bd0-76b0f307dcb0'), 20, 16, null, null, 'End Date', 'N', 0, 'N', 'N', null, null, null, null, null, null, 'U', null,
        null, 'ba1d6e50-67c0-44fd-831f-50e05ce08fca', 'N', null, null, null, 'N', null, null, 'D', 'N');
INSERT INTO ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby,
                             updated, updatedby, name, description, help, ad_process_id, seqno,
                             ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname,
                             iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue,
                             defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype,
                             readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic,
                             placeholder, placeholder2, isautocomplete, ad_fieldgroup_id, query,
                             daterangeoption, isshownegatebutton)
VALUES ((SELECT MAX(ad_process_para_id) + 1
         FROM ad_process_para), 0, 0, 'Y', '2025-05-28 11:28:51.845000', 100, '2025-05-28 11:28:51.845000', 100, 'Begin Date', null,
        null, (select ad_process_id from ad_process where ad_process_uu = '8ea6c947-4450-48dd-8bd0-76b0f307dcb0'), 10, 16, null, null, 'Begin Date', 'N', 0, 'N', 'N', null, null, null, null, null, null, 'U',
        null, null, 'f4ddeff4-0856-45f7-bd58-bedc163b49d4', 'N', null, null, null, 'N', null, null, 'D', 'N');
--- Update process access
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created,
                               createdby, updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES ((select ad_process_id from ad_process where ad_process_uu = '8ea6c947-4450-48dd-8bd0-76b0f307dcb0'),
        (select ad_role_id from ad_role where ad_role_uu = '93365778-a2d9-433b-b962-87fb150db4fa'), 0, 0, 'Y',
        '2025-05-28 11:47:17.115000', 100, '2025-05-28 11:47:17.115000', 100, 'Y',
        '78de239e-0348-47a6-911f-28855bb426e4');
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created,
                               createdby, updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES ((select ad_process_id from ad_process where ad_process_uu = '8ea6c947-4450-48dd-8bd0-76b0f307dcb0'),
        (select ad_role_id from ad_role where ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'), 0, 0, 'Y',
        '2025-05-28 11:46:54.903000', 100, '2025-05-28 11:46:54.903000', 100, 'Y',
        'aca787f5-fbdf-45f8-9a69-46d5dc5fbcab');
--- Update menus
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name,
                     updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id,
                     ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype,
                     iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname,
                     predefinedcontextvariables)
VALUES ((SELECT MAX(ad_menu_id) + 1
         FROM ad_menu), 0, 0, 'Y', '2025-05-28 11:35:12.731000', 100, '2025-05-28 11:35:12.731000',
        'Income Statement (Profit & Loss)', 100, 'Summary report on income for a specified period', 'N', 'Y', 'N', 'P',
        null, null, null, (select ad_process_id from ad_process where ad_process_uu = '8ea6c947-4450-48dd-8bd0-76b0f307dcb0'), null, null, 'U', 'Y', '6c023605-750c-4885-88db-033f35461556', null, null, null);
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby,
                           updated, updatedby, parent_id, seqno, ad_treenodemm_uu)
VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '6c023605-750c-4885-88db-033f35461556'), 0, 0, 'Y', '2025-05-28 11:35:12.767834', 100, '2025-05-28 11:44:54.065000', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'), 11,
        '183bb5ad-4d4f-4964-9812-20864fc7dede');

--- Update other roles
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby)
SELECT p.ad_process_id,
       r.ad_role_id,
       r.ad_client_id,
       0,
       100,
       100
FROM ad_process p
         JOIN ad_role r ON r.ismanual = 'N' AND r.ismasterrole = 'N'
WHERE p.ad_process_uu = '8ea6c947-4450-48dd-8bd0-76b0f307dcb0'
    ON CONFLICT DO NOTHING;

SELECT update_sequences();

SELECT register_migration_script('202505281106_GO-2841.sql')
FROM dual;
