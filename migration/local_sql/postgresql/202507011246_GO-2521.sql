INSERT INTO ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value,
                        name, description, help, accesslevel, entitytype, procedurename, isreport, isdirectprint,
                        ad_reportview_id, classname, statistic_count, statistic_seconds, ad_printformat_id,
                        workflowvalue, ad_workflow_id, isbetafunctionality, isserverprocess, showhelp, jasperreport,
                        ad_form_id, copyfromprocess, ad_process_uu, ad_ctxhelp_id, executiontype,
                        allowmultipleexecution, filenamepattern)
VALUES ((select max(ad_client_id) + 1 from ad_process), 0, 0, 'Y', '2025-07-01 12:28:53.022000', 100,
        '2025-07-01 12:28:53.022000', 100, '10000000',
        'MoH747A Facility Contraceptives Consumption Data Report', 'MoH Report for contraceptives consumption', null,
        '3', 'U', null, 'Y', 'N', null, null, 0, 0, null, null, null, 'N', null, 'Y', 'moh-747/moh747A.jasper', null,
        'N', 'd5d7582e-8364-429c-a7e8-a11f2fcd3401', null, null, 'P', null);

INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created,
                               createdby, updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES ((select ad_process_id from ad_process where ad_process_uu = 'd5d7582e-8364-429c-a7e8-a11f2fcd3401'), 0, 0, 0,
        'Y', '2025-07-01 12:28:53.132000', 100, '2025-07-01 12:28:53.132000', 100, 'Y',
        'c3271ec3-6516-44f0-b171-ffbba9c8f917');

INSERT INTO ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby,
                             updated, updatedby, name, description, help, ad_process_id, seqno,
                             ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname,
                             iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue,
                             defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype,
                             readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic,
                             placeholder, placeholder2, isautocomplete, ad_fieldgroup_id, query,
                             daterangeoption, isshownegatebutton)
VALUES ((select max(ad_process_para_id) + 1 from ad_process_para), 0, 0, 'Y', '2025-07-01 12:31:43.323000', 100,
        '2025-07-01 12:31:43.323000', 100, 'End Date', null,
        null, (select ad_process_id from ad_process where ad_process_uu = 'd5d7582e-8364-429c-a7e8-a11f2fcd3401'), 20,
        15, null, null, 'End Date', 'N', 0, 'N', 'N', null, null, null, null, null, null, 'U', null,
        null, 'f8f2c113-ea21-4ab4-be77-6b3dc0b4c0b3', 'N', null, null, null, 'N', null, null, 'D', 'N');
INSERT INTO ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby,
                             updated, updatedby, name, description, help, ad_process_id, seqno,
                             ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname,
                             iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue,
                             defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype,
                             readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic,
                             placeholder, placeholder2, isautocomplete, ad_fieldgroup_id, query,
                             daterangeoption, isshownegatebutton)
VALUES ((select max(ad_process_para_id) + 1 from ad_process_para), 0, 0, 'Y', '2025-07-01 12:31:09.355000', 100,
        '2025-07-01 12:31:09.355000', 100, 'Begin Date', null,
        null, (select ad_process_id from ad_process where ad_process_uu = 'd5d7582e-8364-429c-a7e8-a11f2fcd3401'), 10,
        15, null, null, 'Begin Date', 'N', 0, 'N', 'N', null, null, null, null, null, null, 'U',
        null, null, 'fc985b45-3c53-4a62-ac4f-f68cc7c8b8d4', 'N', null, null, null, 'N', null, null, 'D', 'N');

INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name,
                     updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id,
                     ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype,
                     iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname,
                     predefinedcontextvariables)
VALUES ((select max(ad_menu_id) + 1 from ad_menu), 0, 0, 'Y', '2025-07-01 12:42:23.299000', 100,
        '2025-07-01 12:42:23.299000',
        'MoH747A Facility Contraceptives Consumption Data Report', 100, 'MoH Report for contraceptives consumption',
        'N', 'Y', 'N', 'R', null, null, null,
        (select ad_process_id from ad_process where ad_process_uu = 'd5d7582e-8364-429c-a7e8-a11f2fcd3401'), null, null,
        'U', 'Y', 'f24a9401-fc48-4c7e-8822-da5a70966e70',
        null, null, null);

INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby,
                           updated, updatedby, parent_id, seqno, ad_treenodemm_uu)
VALUES (10, (select ad_menu_id from ad_menu where ad_menu_uu = 'f24a9401-fc48-4c7e-8822-da5a70966e70'), 0, 0, 'Y',
        '2025-07-01 12:42:23.340498', 100, '2025-07-01 18:09:42.611000', 100,
        (select ad_menu_id from ad_menu where ad_menu_uu = '90d2983e-64b0-4b5f-86ee-4512c45bf893'), 8,
        '8103a889-7a65-4690-9c33-b8403b74faff');

SELECT update_sequences();        

SELECT register_migration_script('202507011246_GO-2521.sql')
FROM dual;
