INSERT INTO ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                       updatedby, name, description, help, windowtype, issotrx, entitytype, processing,
                       ad_image_id, ad_color_id, isdefault, winheight, winwidth, isbetafunctionality,
                       ad_window_uu, titlelogic, predefinedcontextvariables)
VALUES ((SELECT max(ad_window_id) + 1 from ad_window), 0, 0, 'Y', '2025-06-18 11:54:37.206000', 100,
        '2025-06-18 11:54:37.206000', 100,
        'Product & Service Catalog ', null, null, 'M', 'Y', 'U', 'N', null, null, 'N', 0, 0, 'N',
        'd4d1767a-1a6f-45ef-8b72-48ff004f1b4e', null, null);

INSERT INTO ad_tab (ad_tab_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                    name, description, help, ad_table_id, ad_window_id, seqno, tablevel, issinglerow,
                    isinfotab, istranslationtab, isreadonly, ad_column_id, hastree, whereclause,
                    orderbyclause, commitwarning, ad_process_id, processing, ad_image_id, importfields,
                    ad_columnsortorder_id, ad_columnsortyesno_id, issorttab, entitytype, included_tab_id,
                    readonlylogic, displaylogic, isinsertrecord, isadvancedtab, parent_column_id, ad_tab_uu,
                    ad_ctxhelp_id, treedisplayedon, maxqueryrecords, islookuponlyselection,
                    isallowadvancedlookup, ad_tabtype, ishighvolume, deleteconfirmationlogic)
VALUES ((SELECT max(ad_tab_id) + 1 from ad_tab), 0, 0, 'Y', '2025-06-18 12:01:21.767000', 100,
        '2025-06-18 12:01:21.767000', 100,
        'Product & Service Catalog', null, null,
        (select ad_table_id from ad_table where ad_table_uu = '2dcec3ca-58e7-4f5e-86b9-90465b99a581'),
        (select ad_window_id from ad_window where ad_window_uu = 'd4d1767a-1a6f-45ef-8b72-48ff004f1b4e'), 10, 0, 'Y',
        'N', 'N', 'N', null, 'N', null, null,
        null, null, 'N', null, 'N', null, null, 'N', 'U', null, null, null, 'Y', 'N', null,
        '76ca253e-500f-4d31-b14d-c02230a9d5b3', null, 'B', 0, 'N', 'Y', null, null, null);

INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
                              updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id from ad_window where ad_window_uu = 'd4d1767a-1a6f-45ef-8b72-48ff004f1b4e'), 0, 0, 0, 'Y',
        '2025-06-18 11:54:37.228000', 100, '2025-06-18 11:54:37.228000', 100, 'Y',
        '1572b593-1729-4bfd-9bcd-98199fe88552', 'Y');

INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name,
                     updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id,
                     ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype,
                     iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname,
                     predefinedcontextvariables)
VALUES ((SELECT max(ad_menu_id) + 1 from ad_menu), 0, 0, 'Y', '2025-06-18 12:09:00.237000', 100,
        '2025-06-18 12:12:14.137000',
        'Product & Service Catalog - BETA', 100, 'Maintain products and services', 'N', 'Y', 'N', 'W',
        (SELECT ad_window_id from ad_window where ad_window_uu = 'd4d1767a-1a6f-45ef-8b72-48ff004f1b4e'), null,
        null, null, null, null, 'U', 'Y', 'ab100eab-d2ed-4708-a8cc-aa952ab78529', null, 'fa fa-book', null);
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name,
                     updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id,
                     ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype,
                     iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname,
                     predefinedcontextvariables)
VALUES ((SELECT max(ad_menu_id) + 1 from ad_menu), 0, 0, 'Y', '2025-06-18 12:03:15.753000', 100,
        '2025-06-18 12:13:19.674000',
        'Product & Service Catalog - BETA', 100, null, 'N', 'Y', 'N', 'W',
        (SELECT ad_window_id from ad_window where ad_window_uu = 'd4d1767a-1a6f-45ef-8b72-48ff004f1b4e'), null, null,
        null, null, null, 'U',
        'Y', '6744541c-801d-4009-bc2a-96cfd3454b0d', null, 'fa fa-book', null);

INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby,
                           updated, updatedby, parent_id, seqno, ad_treenodemm_uu)
VALUES (10, (select ad_menu_id from ad_menu where ad_menu_uu = 'ab100eab-d2ed-4708-a8cc-aa952ab78529'), 0, 0, 'Y',
        '2025-06-18 12:09:00.253297', 100, '2025-06-18 12:11:43.833000', 100,
        (select ad_menu_id from ad_menu where ad_menu_uu = 'b451e0dd-d11b-49f9-8e00-ba1c36872966'), 7,
        '3268f14c-1011-4e6a-830d-e9d08f0641eb');
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby,
                           updated, updatedby, parent_id, seqno, ad_treenodemm_uu)
VALUES (10, (select ad_menu_id from ad_menu where ad_menu_uu = '6744541c-801d-4009-bc2a-96cfd3454b0d'), 0, 0, 'Y',
        '2025-06-18 12:03:15.767983', 100, '2025-06-18 12:06:50.045000', 100,
        (select ad_menu_id from ad_menu where ad_menu_uu = '58e80a91-030d-4679-9c9a-356cffd30a40'), 7,
        '18bc5956-1e9e-4ad4-8b40-eb13ddd4d7bf');

SELECT register_migration_script('202506181214_GO-3305.sql')
FROM dual;
