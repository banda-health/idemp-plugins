-- create extra columns
ALTER TABLE AD_Menu ADD IF NOT EXISTS IconClassName VARCHAR(100) DEFAULT NULL;
INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT MAX(AD_Element_ID)+1 FROM AD_Element), 0, 0, 'Y', '2018-06-12 11:06:45.752000', 100, '2018-06-12 11:06:45.752000', 100, 'IconClassName', 'U', 'Icon Class Name', 'Icon Class Name', 'The class(es) to display the correct Font Awesome icon', null, null, null, null, null, 'b51079e4-a2c4-4611-b95c-79d92ae35a69', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM ad_column), 0, 0, 'Y', '2022-03-11 17:04:41.632000', '2022-03-11 17:04:41.632000', 100, 100, 'Icon Class Name', 'The class(es) to display the correct Font Awesome icon', null, 0, 'U', 'IconClassName', 116, 10, null, null, 100, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'Y', (SELECT AD_ELEMENT_ID FROM AD_Element WHERE AD_Element_UU='b51079e4-a2c4-4611-b95c-79d92ae35a69'), null, 'N', 'N', null, null, null, 'N', 'Y', null, 'baea99da-9f6a-46d9-89fe-562180868341', 'Y', 10, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;
INSERT INTO ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic, displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype, obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id, ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines, columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton, isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform) VALUES ((SELECT MAX(ad_field_id) + 1 FROM ad_field), 0, 0, 'Y', '2022-06-01 08:46:34.448000', 100, '2022-06-01 08:47:14.363000', 100, 'Icon Class Name', 'The class(es) to display the correct Font Awesome icon', null, 'Y', 110, (SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'baea99da-9f6a-46d9-89fe-562180868341'), null, 'Y', null, 100, 'N', 50, null, 'N', 'N', 'N', 'N', 'U', null, null, null, null, null, null, null, null, '86d35add-53c8-4aa4-9ff8-cf7ae3429de0', null, 190, 'Y', 1, 1, 5, 'N', null, null, null, null, null, 'N', 'N', null, null, null, null, 'N') ON CONFLICT DO NOTHING;

-- Add new Greenlight Reports window
INSERT INTO ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic) VALUES ((SELECT MAX(ad_window_id) + 1 FROM ad_window), 0, 0, 'Y', '2022-04-18 08:20:32.443000', 100, '2022-04-18 08:23:22.821000', 100, 'Reports', 'Reports', null, 'M', 'Y', 'U', 'N', null, null, 'N', 0, 0, 'N', '584a4f57-33c6-460e-9916-9ad0347cac5b', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_tab (ad_tab_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_table_id, ad_window_id, seqno, tablevel, issinglerow, isinfotab, istranslationtab, isreadonly, ad_column_id, hastree, whereclause, orderbyclause, commitwarning, ad_process_id, processing, ad_image_id, importfields, ad_columnsortorder_id, ad_columnsortyesno_id, issorttab, entitytype, included_tab_id, readonlylogic, displaylogic, isinsertrecord, isadvancedtab, parent_column_id, ad_tab_uu, ad_ctxhelp_id, treedisplayedon, maxqueryrecords) VALUES ((SELECT MAX(ad_tab_id) + 1 FROM ad_tab), 0, 0, 'Y', '2022-04-18 08:22:11.853000', 100, '2022-04-18 08:23:33.474000', 100, 'Greenlight Reports', 'Greenlight Reports', null, 284, (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '584a4f57-33c6-460e-9916-9ad0347cac5b'), 10, 0, 'Y', 'N', 'N', 'N', null, 'N', null, null, null, null, 'N', null, 'N', null, null, 'N', 'U', null, null, null, 'Y', 'N', null, 'dda55636-d97e-49f3-83c3-4eb3f23b7666', null, 'B', 0) ON CONFLICT DO NOTHING;

-- Update the window names to be what they should be on the menu (since they'll be synced)
UPDATE ad_window SET name = 'Suppliers', description = 'Maintain Suppliers' WHERE ad_window_uu = '565af89e-8f10-4469-84f5-6cca8d7fae27';
UPDATE ad_window SET name = 'Products & Prices', description = 'Maintain Products' WHERE ad_window_uu = 'c63b9972-1b23-4140-8bbb-0ea2b0b81024';
UPDATE ad_window SET name = 'Services & Prices', description = 'Management of services offered to patients' WHERE ad_window_uu = 'fd93da00-871d-4996-a3f7-4528bed8b758';
UPDATE ad_window SET name = 'Manage Inventory', description = '' WHERE ad_window_uu = '8f744d1c-427a-4b85-ab98-38e50258e86d';
UPDATE ad_window SET name = 'Visits/Bills', description = '' WHERE ad_window_uu = 'a1f3e45c-4a6f-4c05-af26-517b8e9cbb77';
UPDATE ad_window SET name = 'Debt Payments', description = 'Service an outstanding debt as reflected on the Total Open Balance' WHERE ad_window_uu = '4497b5f7-758d-4e82-8e2b-01c4364ce609';
UPDATE ad_window SET name = 'Diagnoses', description = 'Coded Diagnosis' WHERE ad_window_uu = '1f29f7ab-bc9a-427c-b35b-87589e4612b5';

-- Update the window translations
UPDATE ad_window_trl SET name = 'Fournisseurs' WHERE ad_window_id = (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '565af89e-8f10-4469-84f5-6cca8d7fae27');
UPDATE ad_window_trl SET name = 'Produits' WHERE ad_window_id = (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'c63b9972-1b23-4140-8bbb-0ea2b0b81024');
UPDATE ad_window_trl SET name = 'Gérer l''inventaire' WHERE ad_window_id = (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '8f744d1c-427a-4b85-ab98-38e50258e86d');
UPDATE ad_window_trl SET name = 'Consultations/Factures' WHERE ad_window_id = (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'a1f3e45c-4a6f-4c05-af26-517b8e9cbb77');
UPDATE ad_window_trl SET name = 'Solde d''ouverture à payer' WHERE ad_window_id = (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '4497b5f7-758d-4e82-8e2b-01c4364ce609');
UPDATE ad_window_trl SET name = 'Diagnostics' WHERE ad_window_id = (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '1f29f7ab-bc9a-427c-b35b-87589e4612b5');
UPDATE ad_window_trl SET name = 'Rapports' WHERE ad_window_id = (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '584a4f57-33c6-460e-9916-9ad0347cac5b');
UPDATE ad_window_trl SET name = 'Suivre les dépenses' WHERE ad_window_id = (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '37df7931-7d07-4812-b9d4-dec7a53bb70f');
UPDATE ad_window_trl SET name = 'Réception des produits' WHERE ad_window_id = (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '78dd6f39-84f9-4e19-b08e-7a3441af15e5');
UPDATE ad_window_trl SET name = 'Transférer l''inventaire' WHERE ad_window_id = (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'd3c84cad-7306-464d-85da-7e629846f8c0');
UPDATE ad_window_trl SET name = 'Catégories de dépenses' WHERE ad_window_id = (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '5731bc45-3b78-475a-a347-4ca899f19e32');

-- Create Menu entries for the main menu
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-04-18 08:15:27.151000', 100, '2022-04-18 08:15:27.151000', 'Greenlight Report Dropdown', 100, 'This holds the reports that should show in the GL dropdown for ordering purposes', 'Y', 'Y', 'N', null, null, null, null, null, null, null, 'U', 'Y', '35ce7d6a-cf7d-4962-a748-75e27d0121bf', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-11 18:45:36.992000', 100, '2022-04-18 07:47:38.397000', 'Products & Prices', 100, 'Maintain Products', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'c63b9972-1b23-4140-8bbb-0ea2b0b81024'), null, null, null, null, null, 'U', 'Y', '1a56d0fb-b751-489c-8206-285c8831d302', null, 'fa fa-pills') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-11 18:46:26.642000', 100, '2022-04-18 07:47:55.867000', 'Services & Prices', 100, 'Mangement of services offered to patients', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'fd93da00-871d-4996-a3f7-4528bed8b758'), null, null, null, null, null, 'U', 'Y', '05f10658-1593-43d8-8188-0fb9150022fe', null, 'fas fa-briefcase-medical') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-11 18:41:29.285000', 100, '2022-03-11 18:41:29.285000', 'Patients', 100, 'Maintain Patients', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ba697729-5ec8-44f7-b534-446310bb5782'), null, null, null, null, null, 'U', 'Y', '917351d6-e6d9-4103-b580-77ea14556a0c', null, 'fas fa-users') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-11 18:43:13.655000', 100, '2022-03-11 18:43:13.655000', 'Back-End', 100, null, 'Y', 'Y', 'N', null, null, null, null, null, null, null, 'U', 'Y', '58e80a91-030d-4679-9c9a-356cffd30a40', null, 'fas fa-server') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-11 18:42:43.678000', 100, '2022-03-11 18:42:43.678000', 'Accounting', 100, null, 'Y', 'Y', 'N', null, null, null, null, null, null, null, 'U', 'Y', 'eba1cdd4-5475-4529-beed-0e63d9a88357', null, 'fas fa-balance-scale') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-11 16:42:03.555000', 100, '2022-03-29 10:37:36.384000', 'Dashboard', 100, null, 'N', 'Y', 'N', null, null, null, null, null, null, null, 'U', 'Y', 'cc0d5ed0-b0c9-4038-93b3-b7c7343bdde6', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-11 18:42:02.942000', 100, '2022-03-29 10:41:50.481000', 'Inventory', 100, null, 'Y', 'Y', 'N', null, null, null, null, null, null, null, 'U', 'Y', 'b451e0dd-d11b-49f9-8e00-ba1c36872966', null, 'fas fa-clipboard-list') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'N', '2022-03-11 18:40:10.017000', 100, '2022-03-29 10:42:07.978000', 'Pharmacy Sales (OTC)', 100, null, 'N', 'Y', 'N', null, null, null, null, null, null, null, 'U', 'Y', 'd89d5558-2af5-4922-843d-dfc0e8588b54', null, 'fas fa-shopping-cart') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-10 12:01:44.812000', 100, '2022-03-11 18:38:11.114000', 'Greenlight Client Menu', 100, null, 'Y', 'Y', 'N', null, null, null, null, null, null, null, 'U', 'Y', 'bb0670c5-0dc1-468a-8b85-a91b15407368', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-11 18:43:41.293000', 100, '2022-04-18 08:23:22.850000', 'Reports', 100, 'Reports', 'N', 'N', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '584a4f57-33c6-460e-9916-9ad0347cac5b'), null, null, null, null, null, 'U', 'Y', '34e39aff-03e6-48e7-99a8-5028000618b9', null, 'fas fa-notes-medical') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-11 18:47:37.326000', 100, '2022-04-18 07:48:15.543000', 'Manage Inventory', 100, null, 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '8f744d1c-427a-4b85-ab98-38e50258e86d'), null, null, null, null, null, 'U', 'Y', 'ff40264f-58f9-4cc3-b9b5-49b6975898a4', null, 'fas fa-people-carry') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-11 16:24:01.848000', 100, '2022-03-29 10:40:10.702000', 'Visits/Bills', 100, null, 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'a1f3e45c-4a6f-4c05-af26-517b8e9cbb77'), null, null, null, null, null, 'U', 'Y', 'eee2f1f6-00c0-4480-a05d-a42800061a40', null, 'far fa-money-bill-alt') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-11 18:46:59.195000', 100, '2022-03-11 18:46:59.195000', 'Receive Products', 100, 'Receive Products', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '78dd6f39-84f9-4e19-b08e-7a3441af15e5'), null, null, null, null, null, 'U', 'Y', 'c5230218-218d-46c2-92ce-fa3c2c38badf', null, 'fas fa-truck-moving') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-11 18:49:07.822000', 100, '2022-04-18 07:48:31.763000', 'Suppliers', 100, 'Maintain Vendors', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '565af89e-8f10-4469-84f5-6cca8d7fae27'), null, null, null, null, null, 'U', 'Y', '0427931b-7a2c-47b7-82f6-fc04cb35ca73', null, 'fas fa-handshake') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 09:53:03.736000', 100, '2022-04-18 07:48:50.888000', 'Debt Payments', 100, 'Service an outstanding debt as reflected on the Total Open Balance', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '4497b5f7-758d-4e82-8e2b-01c4364ce609'), null, null, null, null, null, 'U', 'Y', 'f87dbeb1-8584-44ae-a91c-f80449090a78', null, 'far fa-money-bill-alt') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-11 18:48:14.289000', 100, '2022-03-11 18:48:14.289000', 'Transfer Inventory', 100, null, 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'd3c84cad-7306-464d-85da-7e629846f8c0'), null, null, null, null, null, 'U', 'Y', 'b7abd866-5dea-4d7e-86e5-aa4a38dd51de', null, 'fas fa-exchange-alt') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 09:57:52.670000', 100, '2022-04-18 07:47:03.913000', 'Suppliers', 100, 'Maintain Vendors', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '565af89e-8f10-4469-84f5-6cca8d7fae27'), null, null, null, null, null, 'U', 'Y', '007ddf92-64fd-443a-bf11-482379589d9f', null, 'fas fa-handshake') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 09:56:19.782000', 100, '2022-04-18 07:49:08.573000', 'Suppliers', 100, 'Maintain Vendors', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '565af89e-8f10-4469-84f5-6cca8d7fae27'), null, null, null, null, null, 'U', 'Y', '7994fad1-0928-4408-822e-bd50a01bc1ef', null, 'fas fa-handshake') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 09:57:03.715000', 100, '2022-03-14 09:57:03.715000', 'Diagnoses', 100, 'Coded Diagnosis', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '1f29f7ab-bc9a-427c-b35b-87589e4612b5'), null, null, null, null, null, 'U', 'Y', 'e0960760-2b33-4a6c-8609-476581df5877', null, 'fas fa-stethoscope') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 09:55:39.318000', 100, '2022-03-14 09:55:39.318000', 'Expense Categories', 100, 'Maintain Expense Categories', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '5731bc45-3b78-475a-a347-4ca899f19e32'), null, null, null, null, null, 'U', 'Y', '53dfc02e-80f9-446a-b318-49ebe6d6bfc6', null, 'fab fa-etsy') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 09:53:56.718000', 100, '2022-03-14 09:53:56.718000', 'Track Expenses', 100, 'Track Expenses', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '37df7931-7d07-4812-b9d4-dec7a53bb70f'), null, null, null, null, null, 'U', 'Y', 'b68f3d07-5743-4f21-b3d6-819f773af826', null, 'fa fa-tags') ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 09:54:54.932000', 100, '2022-03-14 09:54:54.932000', 'Non-Patient Payments', 100, 'This records has no associated tabs or tables as all that will be handled in GL. It''s only here for access assingnment and it''s UUID.', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ab23d5c5-19ce-4c46-a17a-5ae2c37dd89d'), null, null, null, null, null, 'U', 'Y', 'e9aa30ce-8925-44bb-af68-9b616c8756a2', null, 'fas fa-piggy-bank') ON CONFLICT DO NOTHING;

INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:59:58.158000', 100, '2022-03-14 10:59:58.158000', 'Cashier Patient Transactions', 100, 'Generate list of Patient Transactions with the Cashier on it', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='b09d9a23-ad0f-4eff-a7c6-4c1e2309c3d1'), null, null, 'U', 'Y', 'c5a87aaa-4649-44df-b6c7-f1afa080779e', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 11:02:29.051000', 100, '2022-03-14 11:02:29.051000', 'Inventory Quantity Report', 100, 'Non-financial opening and closing stock report', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='93d7c1bc-2885-43f4-985f-90f57a414e5f'), null, null, 'U', 'Y', 'a0908c25-9b75-408a-9882-24ae08ffed83', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 11:01:34.713000', 100, '2022-03-14 11:01:34.713000', 'Voided Transactions List', 100, 'Get a list of voided visit transactions for a definted period', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='20a623fb-e127-4c26-98d5-3604a6d100b2'), null, null, 'U', 'Y', '30549397-f696-42eb-bd4f-b0230bcbb83a', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 11:00:43.717000', 100, '2022-03-14 11:00:43.717000', 'Open Balance List', 100, null, 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='b4f11e14-b9d8-4f6c-aa46-adfd77c4f773'), null, null, 'U', 'Y', '16bf3013-ce9b-4d06-8014-b3ca21c74c97', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:58:32.558000', 100, '2022-03-14 10:58:32.558000', 'Cashier Transaction Differences', 100, 'Generate list of Transactions by Cashier with differences displayed', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='226cdf47-9cde-43e8-b7ef-87b28d7ef2e2'), null, null, 'U', 'Y', '5ba81e87-ea7c-4fa8-b99a-f1074efa6759', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:57:39.218000', 100, '2022-03-14 10:57:39.218000', 'Stock to be Ordered', 100, 'Generate List of stock that need to be ordered', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='03ba009a-68bb-4b12-a5bc-e58a9bce1545'), null, null, 'U', 'Y', 'd05c1647-82f4-42c9-8f24-bcdcee1567c6', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:57:05.445000', 100, '2022-03-14 10:57:05.445000', 'Services Charged Report', 100, 'Get a list of services that were charged in a period', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2'), null, null, 'U', 'Y', '09dcc9a2-20d4-4e9e-8393-a1f57cca5908', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:52:47.088000', 100, '2022-03-14 10:52:47.088000', 'Donor Fund Report', 100, 'Generate list of transactions settled by donor fund', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='3478d341-c6d9-4f52-a865-5bf0ba8a7607'), null, null, 'U', 'Y', 'efd4896a-e676-4c8e-bf5b-656c152b5d75', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:51:48.018000', 100, '2022-03-14 10:51:48.018000', 'Changes to Inventory', 100, 'Generate List of inventory changed using the balance my stock levels window', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='58ae2bdf-0e80-46f2-860f-2ae070fc82d2'), null, null, 'U', 'Y', 'eb183f95-ea6d-4aeb-93bf-8d14f6a8634c', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:50:45.421000', 100, '2022-03-14 10:50:45.421000', 'Inventory Sold Report', 100, 'Get a list of inventory that was sold in a period', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='1211e173-6f12-4e2f-bfcc-d43d48af51c3'), null, null, 'U', 'Y', 'b04a6ecc-587e-4364-95c5-1c4e2dbfdb47', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:50:00.764000', 100, '2022-03-14 10:50:00.764000', 'MoH705B Out Patient Over 5yr Summary', 100, 'Generate outpatient over 5yr summary', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='432eeb61-1a87-4880-bded-91927139341c'), null, null, 'U', 'Y', 'ff08aba3-feb9-4eee-a971-f09e88ba3e66', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:49:10.801000', 100, '2022-03-14 10:49:10.801000', 'MoH717 New and Revisit Patient Count', 100, 'Generate count of new patients and revisit', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='742f515a-81c7-4690-8d35-2c6f1252ad5b'), null, null, 'U', 'Y', '7d3bd0e5-df44-46f6-863d-21ae75d31ba6', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:47:05.890000', 100, '2022-03-14 10:47:05.890000', 'MoH705A Out Patient Under 5yr Summary', 100, 'Generate outpatient under 5yr summary', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='c9f91d23-48ea-4990-af5d-f3e7f0db77de'), null, null, 'U', 'Y', '7ad6a2d1-a209-4cea-8fe8-3372b28ad184', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:46:31.516000', 100, '2022-03-14 10:46:31.516000', 'Patient Visits and Referrals', 100, 'Generate count of patients with their visit type and referrals', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='061ed4a0-5670-4764-909e-fb4592f51aaa'), null, null, 'U', 'Y', '8c73cc35-045a-4d35-9574-224004c9683b', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:43:50.671000', 100, '2022-03-14 10:43:50.671000', 'Value of Opening and Closing Stock', 100, 'Cash value of incoming and outgoing stock for a given period of time', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='630fc1ab-0b64-459b-b10f-68549d21f507'), null, null, 'U', 'Y', '43efb6b7-0751-4566-a77f-136c30569b7e', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:43:11.302000', 100, '2022-03-14 10:43:11.302000', 'Products and Prices', 100, 'Your Products and their Prices', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='3edf67b9-ee3d-4b73-a02e-deb1c1811db5'), null, null, 'U', 'Y', '4c2ded2e-1eb9-4bad-acb1-f96ec2cf321c', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:23:06.842000', 100, '2022-03-14 10:23:06.842000', 'Patient Transactions', 100, 'Generate list of Patient Transactions', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='4cf22d3f-1fc8-4bdd-83e1-fc5d79537269'), null, null, 'U', 'Y', '2dbbc039-42ca-43e4-b4cc-2be94acad606', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2022-03-14 10:09:06.318000', 100, '2022-03-14 10:09:06.318000', 'Income & Expenses', 100, 'Summary report on income and expenses for a specified period', 'N', 'Y', 'N', 'P', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu='f777f042-3907-4293-94c4-49fe6eb58780'), null, null, 'U', 'Y', '9a7b27a9-e09e-48a6-bba1-81b3a1f4fe29', null, null) ON CONFLICT DO NOTHING;

-- Create treenodemm entries
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '007ddf92-64fd-443a-bf11-482379589d9f'), 0, 0, 'Y', '2022-03-14 09:57:52.732263', 100, '2022-03-14 09:58:06.521834', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '58e80a91-030d-4679-9c9a-356cffd30a40'), 1, 'b3d1c386-6105-45c7-ac3e-533faf977d64') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'e0960760-2b33-4a6c-8609-476581df5877'), 0, 0, 'Y', '2022-03-14 09:57:03.763861', 100, '2022-03-14 09:58:06.519787', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '58e80a91-030d-4679-9c9a-356cffd30a40'), 0, '3db59ef3-b0eb-4b54-828b-844b379d2185') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '7994fad1-0928-4408-822e-bd50a01bc1ef'), 0, 0, 'Y', '2022-03-14 09:56:19.827787', 100, '2022-03-14 09:56:37.319318', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'eba1cdd4-5475-4529-beed-0e63d9a88357'), 4, '94e3c199-65b7-459c-a50d-ba09ce1fa18d') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '53dfc02e-80f9-446a-b318-49ebe6d6bfc6'), 0, 0, 'Y', '2022-03-14 09:55:39.421135', 100, '2022-03-14 09:56:37.314114', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'eba1cdd4-5475-4529-beed-0e63d9a88357'), 3, 'b3f0abf1-311b-45ee-a0d4-c5740a3ea9d8') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'e9aa30ce-8925-44bb-af68-9b616c8756a2'), 0, 0, 'Y', '2022-03-14 09:54:54.988376', 100, '2022-03-14 09:56:37.311223', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'eba1cdd4-5475-4529-beed-0e63d9a88357'), 2, '514fcbff-06ff-4128-847e-322042a46f03') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'b68f3d07-5743-4f21-b3d6-819f773af826'), 0, 0, 'Y', '2022-03-14 09:53:56.768584', 100, '2022-03-14 09:56:37.308259', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'eba1cdd4-5475-4529-beed-0e63d9a88357'), 1, 'ab812142-c77d-4efe-bcd7-cbda18066178') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'f87dbeb1-8584-44ae-a91c-f80449090a78'), 0, 0, 'Y', '2022-03-14 09:53:03.790018', 100, '2022-03-14 09:56:37.305257', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'eba1cdd4-5475-4529-beed-0e63d9a88357'), 0, '8d0d5bfd-7f0d-43f5-8672-65b3409eb74a') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '0427931b-7a2c-47b7-82f6-fc04cb35ca73'), 0, 0, 'Y', '2022-03-11 18:49:07.898659', 100, '2022-03-11 18:49:19.052343', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'b451e0dd-d11b-49f9-8e00-ba1c36872966'), 5, 'c0104385-01ee-434e-ad6c-3e5349f46f5b') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'b7abd866-5dea-4d7e-86e5-aa4a38dd51de'), 0, 0, 'Y', '2022-03-11 18:48:14.368054', 100, '2022-03-11 18:49:19.051044', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'b451e0dd-d11b-49f9-8e00-ba1c36872966'), 4, '603658d7-f6fb-45f2-95b7-de83c2584528') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'ff40264f-58f9-4cc3-b9b5-49b6975898a4'), 0, 0, 'Y', '2022-03-11 18:47:37.368874', 100, '2022-03-11 18:49:19.049856', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'b451e0dd-d11b-49f9-8e00-ba1c36872966'), 3, '397c6ec9-c902-4814-9695-d6e8c7379f47') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'c5230218-218d-46c2-92ce-fa3c2c38badf'), 0, 0, 'Y', '2022-03-11 18:46:59.232764', 100, '2022-03-11 18:49:19.048393', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'b451e0dd-d11b-49f9-8e00-ba1c36872966'), 2, 'cbeca90b-6a68-45cc-938e-ed9b3ac0b88e') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '05f10658-1593-43d8-8188-0fb9150022fe'), 0, 0, 'Y', '2022-03-11 18:46:26.708439', 100, '2022-03-11 18:49:19.046707', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'b451e0dd-d11b-49f9-8e00-ba1c36872966'), 1, '18680f46-c756-43ab-843d-f2ce0aab996f') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '1a56d0fb-b751-489c-8206-285c8831d302'), 0, 0, 'Y', '2022-03-11 18:45:37.038896', 100, '2022-03-11 18:49:19.045381', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'b451e0dd-d11b-49f9-8e00-ba1c36872966'), 0, '56574148-77af-4108-93d7-1003eb05f587') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'a0908c25-9b75-408a-9882-24ae08ffed83'), 0, 0, 'Y', '2022-03-14 11:02:29.155455', 100, '2022-03-14 11:02:54.344142', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 18, '045b45bb-9dbb-41ee-8c3c-3540a2727689') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '30549397-f696-42eb-bd4f-b0230bcbb83a'), 0, 0, 'Y', '2022-03-14 11:01:34.754228', 100, '2022-03-14 11:02:54.341299', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 17, '2d005126-89de-4659-90e3-8a6ae9a7ae50') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '16bf3013-ce9b-4d06-8014-b3ca21c74c97'), 0, 0, 'Y', '2022-03-14 11:00:43.815810', 100, '2022-03-14 11:02:54.338846', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 16, 'f3c6b07a-a43f-44f7-b399-ea34d2aa9347') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '5ba81e87-ea7c-4fa8-b99a-f1074efa6759'), 0, 0, 'Y', '2022-03-14 10:58:32.626076', 100, '2022-03-14 11:02:54.335927', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 14, 'ac16e0dd-09b6-49a4-9c71-3ff74ff4d83b') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'd05c1647-82f4-42c9-8f24-bcdcee1567c6'), 0, 0, 'Y', '2022-03-14 10:57:39.265031', 100, '2022-03-14 11:02:54.333950', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 13, '0f35daab-6a78-4708-9c99-ee04ad4b0df7') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '09dcc9a2-20d4-4e9e-8393-a1f57cca5908'), 0, 0, 'Y', '2022-03-14 10:57:05.502264', 100, '2022-03-14 11:02:54.331200', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 12, 'abcfd0b2-d4b8-461e-8fc7-095f38e1224d') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'efd4896a-e676-4c8e-bf5b-656c152b5d75'), 0, 0, 'Y', '2022-03-14 10:52:47.185209', 100, '2022-03-14 11:02:54.329667', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 11, 'ba015d88-99ed-4950-bf45-2a62df3f5c1a') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'eb183f95-ea6d-4aeb-93bf-8d14f6a8634c'), 0, 0, 'Y', '2022-03-14 10:51:48.094515', 100, '2022-03-14 11:02:54.328052', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 10, '41f020a0-a4a5-4e1b-97b9-1242ea38b196') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'bb0670c5-0dc1-468a-8b85-a91b15407368'), 0, 0, 'Y', '2022-03-29 15:33:44.892002', 100, '2022-04-18 08:16:03.869523', 100, 0, 1, '1a27b52c-0ee2-440f-ab1f-0e1033a107af') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'b04a6ecc-587e-4364-95c5-1c4e2dbfdb47'), 0, 0, 'Y', '2022-03-14 10:50:45.507890', 100, '2022-03-14 11:02:54.326063', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 9, '52affba1-7a2f-4b16-9e4c-ebf20c225fc4') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'ff08aba3-feb9-4eee-a971-f09e88ba3e66'), 0, 0, 'Y', '2022-03-14 10:50:00.839457', 100, '2022-03-14 11:02:54.323484', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 8, '09f54b46-81bb-4473-9673-9d0167d48abc') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'cc0d5ed0-b0c9-4038-93b3-b7c7343bdde6'), 0, 0, 'Y', '2022-03-11 16:42:03.608474', 100, '2022-03-29 10:41:37.153838', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'bb0670c5-0dc1-468a-8b85-a91b15407368'), 1, 'c0d83bfa-0a5c-406e-a473-8b7f0cda2e02') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'eee2f1f6-00c0-4480-a05d-a42800061a40'), 0, 0, 'Y', '2022-03-11 16:24:01.902738', 100, '2022-03-29 10:41:37.154545', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'bb0670c5-0dc1-468a-8b85-a91b15407368'), 2, '77192175-d011-42a1-80ab-cdaebbd6ecc0') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'd89d5558-2af5-4922-843d-dfc0e8588b54'), 0, 0, 'Y', '2022-03-11 18:40:10.065290', 100, '2022-03-29 10:41:37.155232', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'bb0670c5-0dc1-468a-8b85-a91b15407368'), 3, '780abd1f-a088-46ab-bcd3-b2fcbb86b4f5') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '917351d6-e6d9-4103-b580-77ea14556a0c'), 0, 0, 'Y', '2022-03-11 18:41:29.336430', 100, '2022-03-29 10:41:37.155757', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'bb0670c5-0dc1-468a-8b85-a91b15407368'), 4, 'bcfc8e67-e5b9-4164-9300-87904f9b402e') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'b451e0dd-d11b-49f9-8e00-ba1c36872966'), 0, 0, 'Y', '2022-03-11 18:42:03.008343', 100, '2022-03-29 10:41:37.156086', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'bb0670c5-0dc1-468a-8b85-a91b15407368'), 5, '5f8ace46-35c3-4aa9-83af-7cca3e8128cc') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'eba1cdd4-5475-4529-beed-0e63d9a88357'), 0, 0, 'Y', '2022-03-11 18:42:43.725105', 100, '2022-03-29 10:41:37.156410', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'bb0670c5-0dc1-468a-8b85-a91b15407368'), 6, '954861d3-b8e5-496c-96dc-f283c5e297a3') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '58e80a91-030d-4679-9c9a-356cffd30a40'), 0, 0, 'Y', '2022-03-11 18:43:13.697900', 100, '2022-03-29 10:41:37.156739', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'bb0670c5-0dc1-468a-8b85-a91b15407368'), 7, 'db02972c-a3c4-47cb-8a54-f917082ae983') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '34e39aff-03e6-48e7-99a8-5028000618b9'), 0, 0, 'Y', '2022-03-11 18:43:41.370565', 100, '2022-03-29 10:41:37.157052', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'bb0670c5-0dc1-468a-8b85-a91b15407368'), 8, 'f4ebf3f7-a390-42a5-8434-2d910e09d119') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 0, 0, 'Y', '2022-04-18 08:15:27.214092', 100, '2022-04-18 08:16:03.870882', 100, 0, 2, 'c761cfb8-5785-4adc-9f7b-b4993f027ac0') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '7d3bd0e5-df44-46f6-863d-21ae75d31ba6'), 0, 0, 'Y', '2022-03-14 10:49:10.904601', 100, '2022-03-14 11:02:54.320853', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 7, '7fb76494-d732-497d-9fa9-f1b9ee1305e3') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '7ad6a2d1-a209-4cea-8fe8-3372b28ad184'), 0, 0, 'Y', '2022-03-14 10:47:05.943299', 100, '2022-03-14 11:02:54.316534', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 6, '15c9fb1a-1422-40c0-86f1-5adf4fa14403') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '8c73cc35-045a-4d35-9574-224004c9683b'), 0, 0, 'Y', '2022-03-14 10:46:31.567553', 100, '2022-03-14 11:02:54.314251', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 5, 'f81f7dfc-84ef-4168-ad1d-50627da7b976') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '43efb6b7-0751-4566-a77f-136c30569b7e'), 0, 0, 'Y', '2022-03-14 10:43:50.756896', 100, '2022-03-14 11:02:54.311889', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 4, '620f1402-0d56-445f-84c9-88f1f31977fb') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '4c2ded2e-1eb9-4bad-acb1-f96ec2cf321c'), 0, 0, 'Y', '2022-03-14 10:43:11.350451', 100, '2022-03-14 11:02:54.310036', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 3, '8327e4a3-5315-434d-8627-b6dcae15d6de') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '2dbbc039-42ca-43e4-b4cc-2be94acad606'), 0, 0, 'Y', '2022-03-14 10:23:06.968314', 100, '2022-03-14 11:02:54.305199', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 1, 'fa901f7d-72a4-498b-a9e7-faaa04600b3a') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '9a7b27a9-e09e-48a6-bba1-81b3a1f4fe29'), 0, 0, 'Y', '2022-03-14 10:09:06.440603', 100, '2022-03-14 11:02:54.302935', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 0, '3541b5c6-4762-4300-b702-919b3a4d8389') ON CONFLICT DO NOTHING;
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'c5a87aaa-4649-44df-b6c7-f1afa080779e'), 0, 0, 'Y', '2022-03-14 10:59:58.201813', 100, '2022-03-14 11:02:54.337411', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 15, '37122bcd-1b78-4718-a2a9-446c33e8ad00') ON CONFLICT DO NOTHING;

-- Give all user's access to the Reports window, both the master roles and those that are automatic (i.e. aren't manual)
INSERT INTO
	ad_window_access (ad_window_id,
	                  ad_role_id,
	                  ad_client_id,
	                  ad_org_id,
	                  isactive,
	                  created,
	                  createdby,
	                  updated,
	                  updatedby,
	                  isreadwrite,
	                  ad_window_access_uu,
	                  bh_candeactivate)
SELECT
	w.ad_window_id,
	r.ad_role_id,
	r.ad_client_id,
	r.ad_org_id,
	'Y',                --isactive
	NOW(),              --created
	100,                --createdby
	NOW(),              --updated
	100,                --updatedby
	'Y',                --isreadwrite
	uuid_generate_v4(), --ad_window_access_uu
	'Y'                 --bh_candeactivate
FROM
	ad_window w
		CROSS JOIN ad_role r
WHERE
	w.ad_window_uu = '584a4f57-33c6-460e-9916-9ad0347cac5b'
	AND (r.ismanual = 'N' OR r.ismasterrole = 'Y')
	AND ad_role_id > 0
ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- 1. Delete package export information
/**********************************************************************************************************/
-- Delete package export details having to do with Dashboard Buttons
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_package_exp_detail_uu IN ('d01edf6b-9160-4230-ba88-ccab9f7bb06c', '6da4b23b-a302-4d99-a9cd-abfcce840c1e',
		                             'b3c08f38-03b8-4bc6-b8c5-cc5f52a4042b', 'd6758848-a7f9-47a6-92d0-3c0ab3e27f50',
		                             '4b54d315-d476-42ee-aa29-0cdae8c2e2cb', '88852754-e29e-4fbc-a284-0aaccecd3c07',
		                             '0c092218-7a97-4135-8632-cf4c3433223f', 'c9e00a5d-5753-4619-995c-d303609205cf',
		                             'c9e00a5d-5753-4619-995c-d303609205cf', '5891e92c-d958-4375-b3c5-13d6d497ee67');

-- Delete package export details where we're removing the entire package export
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_package_exp_id IN (
		SELECT
			ad_package_exp_id
		FROM
			ad_package_exp
		WHERE
				name IN ('BH_DashboardButtonsData', 'BH_DashboardButtons', 'bh_buttongroup', 'bh_homescreenbutton',
				         'BH Home Screen Button Translations')
	);

DELETE
FROM
	ad_package_exp
WHERE
		name IN ('BH_DashboardButtonsData', 'BH_DashboardButtons', 'bh_buttongroup', 'bh_homescreenbutton',
		         'BH Home Screen Button Translations');

-- Remove some exports that deal with the tables we'll be deleting
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
				ad_table_uu IN ('ae04c83f-2010-4037-bd42-e6f15a857823',
				                'bdfcbd0c-4810-4d63-a5b6-3c6ca2119b11',
				                '341b5918-206b-4c7d-98f7-31c09d74bb66',
				                'bfc62de5-8dd4-4aea-a3c4-24307b97b97c')
	);

/**********************************************************************************************************/
-- 2. Remove details on some imports
/**********************************************************************************************************/
DELETE
FROM
	ad_package_imp_detail
WHERE
		ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
				ad_table_uu IN ('ae04c83f-2010-4037-bd42-e6f15a857823',
				                'bdfcbd0c-4810-4d63-a5b6-3c6ca2119b11',
				                '341b5918-206b-4c7d-98f7-31c09d74bb66',
				                'bfc62de5-8dd4-4aea-a3c4-24307b97b97c')
	);

/**********************************************************************************************************/
-- 3. Remove the menus pointing to the Dashboard Button window
/**********************************************************************************************************/
DELETE
FROM
	ad_menu_trl
WHERE
		ad_menu_id IN (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '784f3e62-74e5-4d87-917e-5ab2b4461218'
	);

DELETE
FROM
	ad_menu
WHERE
	ad_menu_uu = '784f3e62-74e5-4d87-917e-5ab2b4461218';

/**********************************************************************************************************/
-- 4. Clean up some preferences in the system
/**********************************************************************************************************/
DELETE
FROM
	ad_preference
WHERE
		ad_window_id IN (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '09127102-04c5-47bf-a2b6-fb637b8466a9'
	);

/**********************************************************************************************************/
-- 5. Delete the fields (and their translations), tabs, and windows for the dashboard buttons
/**********************************************************************************************************/
-- Delete field translations
DELETE
FROM
	ad_field_trl
WHERE
		ad_field_id IN (
		SELECT
			ad_field_id
		FROM
			ad_field
		WHERE
				ad_tab_id IN (
				SELECT
					ad_tab_id
				FROM
					ad_tab
				WHERE
						ad_window_id IN (
						SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '09127102-04c5-47bf-a2b6-fb637b8466a9'
					)
			)
	);

-- Delete the fields
DELETE
FROM
	ad_field
WHERE
		ad_tab_id IN (
		SELECT
			ad_tab_id
		FROM
			ad_tab
		WHERE
				ad_window_id IN (
				SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '09127102-04c5-47bf-a2b6-fb637b8466a9'
			)
	);

-- Delete the tabs
DELETE
FROM
	ad_tab
WHERE
		ad_window_id IN (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '09127102-04c5-47bf-a2b6-fb637b8466a9'
	);

DELETE
FROM
	ad_ref_table
WHERE
		ad_window_id IN (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '09127102-04c5-47bf-a2b6-fb637b8466a9'
	);

-- Delete the window
DELETE
FROM
	ad_window
WHERE
	ad_window_uu = '09127102-04c5-47bf-a2b6-fb637b8466a9';

/**********************************************************************************************************/
-- 6. Clean up DB metadata for the dashboard buttons
/**********************************************************************************************************/
-- Remove the sequences
DELETE
FROM
	ad_sequence
WHERE
		ad_sequence_uu IN ('46f5d119-7dbc-458e-9899-09d2f115b2fc',
		                   '955ed774-aa59-46f5-95ae-69cb9a039a0c',
		                   'de74978e-0085-4f29-bd55-359902ce1e45',
		                   '4b2f8649-6786-455c-aee4-31a27b8166b3');

-- Insert the potentially removable element ids into a temp table
DROP TABLE IF EXISTS tmp_ad_element_id;

SELECT
	ad_element_id
INTO TEMP TABLE
	tmp_ad_element_id
FROM
	ad_element
WHERE
		ad_element_id IN (
		SELECT
			ad_element_id
		FROM
			ad_column
		WHERE
				ad_table_id IN (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
						ad_table_uu IN ('ae04c83f-2010-4037-bd42-e6f15a857823',
						                'bdfcbd0c-4810-4d63-a5b6-3c6ca2119b11',
						                '341b5918-206b-4c7d-98f7-31c09d74bb66',
						                'bfc62de5-8dd4-4aea-a3c4-24307b97b97c')
			)
	)
	AND ad_element_id NOT IN (
	SELECT
		ad_element_id
	FROM
		ad_column
	WHERE
			ad_table_id IN (
			SELECT
				ad_table_id
			FROM
				ad_table
			WHERE
					ad_table_uu NOT IN ('ae04c83f-2010-4037-bd42-e6f15a857823',
					                    'bdfcbd0c-4810-4d63-a5b6-3c6ca2119b11',
					                    '341b5918-206b-4c7d-98f7-31c09d74bb66',
					                    'bfc62de5-8dd4-4aea-a3c4-24307b97b97c')
		)
);

-- Remove the columns just used on those tables
DELETE
FROM
	ad_column
WHERE
		ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
				ad_table_uu IN ('ae04c83f-2010-4037-bd42-e6f15a857823',
				                'bdfcbd0c-4810-4d63-a5b6-3c6ca2119b11',
				                '341b5918-206b-4c7d-98f7-31c09d74bb66',
				                'bfc62de5-8dd4-4aea-a3c4-24307b97b97c')

	);

-- Remove the element translations for elements that now no longer have any tables
DELETE
FROM
	ad_element_trl
WHERE
		ad_element_id IN (
		SELECT
			ad_element_id
		FROM
			tmp_ad_element_id
	);

-- Remove the elements just used on those tables
DELETE
FROM
	ad_element
WHERE
		ad_element_id IN (
		SELECT
			ad_element_id
		FROM
			tmp_ad_element_id
	);

-- Remove the tables
DELETE
FROM
	ad_table
WHERE
		ad_table_uu IN ('ae04c83f-2010-4037-bd42-e6f15a857823',
		                'bdfcbd0c-4810-4d63-a5b6-3c6ca2119b11',
		                '341b5918-206b-4c7d-98f7-31c09d74bb66',
		                'bfc62de5-8dd4-4aea-a3c4-24307b97b97c');

/**********************************************************************************************************/
-- 7. Drop the dashboard preference ZUL file
/**********************************************************************************************************/
DELETE
FROM
	pa_dashboardpreference
WHERE
		pa_dashboardcontent_id IN (
		SELECT
			pa_dashboardcontent_id
		FROM
			pa_dashboardcontent
		WHERE
			pa_dashboardcontent_uu = 'cd30ab20-6515-47d1-9b3e-e5faed8f8662'
	);

DELETE
FROM
	pa_dashboardcontent_trl
WHERE
		pa_dashboardcontent_id IN (
		SELECT
			pa_dashboardcontent_id
		FROM
			pa_dashboardcontent
		WHERE
			pa_dashboardcontent_uu = 'cd30ab20-6515-47d1-9b3e-e5faed8f8662'
	);

DELETE
FROM
	pa_dashboardcontent
WHERE
	pa_dashboardcontent_uu = 'cd30ab20-6515-47d1-9b3e-e5faed8f8662';

/**********************************************************************************************************/
-- 8. Drop the actual tables
/**********************************************************************************************************/
DROP TABLE bh_dbrdbtngrp_btn_trl;
DROP TABLE bh_dbrdbtngrp_btn;
DROP TABLE bh_dbrdbtngrp_trl;
DROP TABLE bh_dbrdbtngrp;

SELECT register_migration_script('202203141303_GO-2184.sql') FROM dual;
