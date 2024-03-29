-- Add Non-Patient Payment Report Process
INSERT INTO ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, help, accesslevel, entitytype, procedurename, isreport, isdirectprint, ad_reportview_id, classname, statistic_count, statistic_seconds, ad_printformat_id, workflowvalue, ad_workflow_id, isbetafunctionality, isserverprocess, showhelp, jasperreport, ad_form_id, copyfromprocess, ad_process_uu, ad_ctxhelp_id, executiontype, allowmultipleexecution) VALUES ((SELECT MAX(ad_process_id)+ 1 FROM ad_process), 0, 0, 'Y', '2023-05-11 09:12:44.912000', 100, '2023-05-11 09:12:44.912000', 100,'Non Patient Payment Report', 'Non Patient Payment Report', 'Insurance payments report', null, '3', 'U', null, 'Y', 'N', null, null, 0, 0, null, null, null, 'N', 'N', 'Y', 'cashier/Non-Patient Reports/Non-Patient-Payments.jasper', null, 'N', '19464274-e2bc-4dbe-ad69-ae48b9f7778c', null, null, 'P') ON CONFLICT DO NOTHING;

-- Add Non-Patient Payment Parameters
INSERT INTO ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete) VALUES ((SELECT MAX(ad_process_para_id) + 1 FROM ad_process_para), 0, 0, 'Y', '2023-05-11 09:15:47.322000', 100, '2023-05-11 09:15:47.322000', 100, 'Begin Date', null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '19464274-e2bc-4dbe-ad69-ae48b9f7778c'), 10, 16, null, null, 'Begin Date', 'N', 0, 'N', 'N', null, null, null, null, null, null, 'U', null, null, 'fc8f2ba6-61ff-42cb-ac47-c767d03f4489', 'N', null, null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete) VALUES ((SELECT MAX(ad_process_para_id) + 1 FROM ad_process_para), 0, 0, 'Y', '2023-05-11 09:16:04.738000', 100, '2023-05-11 09:16:04.738000', 100, 'End Date', null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '19464274-e2bc-4dbe-ad69-ae48b9f7778c'), 20, 16, null, null, 'End Date', 'N', 0, 'N', 'N', null, null, null, null, null, null, 'U', null, null, 'e8d37e63-9f12-4df1-b4b5-4d565b9db6af', 'N', null, null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete) VALUES ((SELECT MAX(ad_process_para_id) + 1 FROM ad_process_para), 0, 0, 'Y', '2023-05-11 09:17:26.122000', 100, '2023-05-11 10:40:38.921000', 100, 'Mode', null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '19464274-e2bc-4dbe-ad69-ae48b9f7778c'), 30, 17, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b313a870-0826-4c1d-a9af-f9ec990b4375'), null, 'Mode', 'N', 0, 'N', 'N', null, null, null, null, null, null, 'U', null, null, 'b9fbce26-77a6-4975-bc21-df14d24ee9c3', 'N', null, null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete) VALUES ((SELECT MAX(ad_process_para_id) + 1 FROM ad_process_para), 0, 0, 'Y', '2023-05-11 10:11:12.955000', 100, '2023-05-11 10:11:12.955000', 100, 'Insurance Type', null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '19464274-e2bc-4dbe-ad69-ae48b9f7778c'), 40, 17, null, null, 'Insurance Type', 'N', 0, 'N', 'N', null, null, null, null, null, null, 'U', null, null, '59d8caf6-425d-48fc-a54e-26d40f572882', 'N', null, null, null, 'N') ON CONFLICT DO NOTHING;

-- Add Clinic admin Role Access
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '19464274-e2bc-4dbe-ad69-ae48b9f7778c'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'), 0, 0, 'Y', '2021-04-08 06:56:57.013000', 100, '2021-04-08 06:56:57.013000', 100, 'Y', 'b6923494-075f-4346-aa15-1eed7c769062') ON CONFLICT DO NOTHING;

-- Add Accounting Role Access
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '19464274-e2bc-4dbe-ad69-ae48b9f7778c'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '93365778-a2d9-433b-b962-87fb150db4fa'), 0, 0, 'Y', '2023-05-11 11:12:38.954000', 100, '2023-05-11 11:12:38.954000', 100, 'Y', 'd1cc575d-cab5-4bd0-a8da-a40c95e4f00f') ON CONFLICT DO NOTHING;

-- Add Non Patient Payment Menu
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id)+1 FROM ad_menu), 0, 0, 'Y', '2023-05-11 10:13:36.648000', 100, '2023-05-11 10:13:36.648000', 'Non Patient Payment Report', 100, null, 'N', 'Y', 'N', 'R', null, null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '19464274-e2bc-4dbe-ad69-ae48b9f7778c'), null, null, 'U', 'Y', 'ab7ea722-5915-484f-94ea-75c08ef48796', null, null) ON CONFLICT DO NOTHING;

-- Add to Greenlight -> Reports
INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'ab7ea722-5915-484f-94ea-75c08ef48796'), 0, 0, 'Y', '2023-05-11 10:13:36.706599', 100, '2023-05-11 11:48:46.610154', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 17, 'db135b29-35b8-4d98-9ea1-1366c6c8e801') ON CONFLICT DO NOTHING;

-- Add the process to the correct existing roles
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby)
SELECT
	p.ad_process_id,
	r.ad_role_id,
	r.ad_client_id,
	0,
	100,
	100
FROM
	ad_process p JOIN ad_role r ON r.ismanual = 'N' AND r.ismasterrole = 'N'
WHERE p.ad_process_uu = '19464274-e2bc-4dbe-ad69-ae48b9f7778c' ON CONFLICT DO NOTHING;

SELECT
	update_sequences();

SELECT
	register_migration_script('202305111013_GO-2355.sql')
FROM
	dual;
