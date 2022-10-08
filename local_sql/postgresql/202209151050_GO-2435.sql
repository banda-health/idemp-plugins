-- Add Manage Users menu
INSERT INTO adempiere.ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id)+1 FROM AD_Menu), 0, 0, 'Y', '2022-09-15 10:56:45.490000', 100, '2022-09-15 10:56:45.490000', 'Manage Users', 100, 'Manage Users', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='6b934ec2-7f45-4104-ba10-08e3ce54de7e'), null, null, null, null, null, 'U', 'Y', '2bdda8ff-6aa1-44b6-816f-3060717c1cc3', null, 'fas fa-users') ON CONFLICT DO NOTHING;

-- Add as a sub-menu to Back-End menu
INSERT INTO adempiere.ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '2bdda8ff-6aa1-44b6-816f-3060717c1cc3'), 0, 0, 'Y', '2022-09-15 10:56:45.490000', 100, '2022-09-15 10:56:45.490000', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '58e80a91-030d-4679-9c9a-356cffd30a40'), 3, '8200623d-e8b2-46c3-be78-0e5cbc538dac') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202209151050_GO-2435.sql') FROM dual;
