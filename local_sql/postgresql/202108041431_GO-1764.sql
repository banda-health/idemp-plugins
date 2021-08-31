-- Add Bill Insurance Report
INSERT INTO ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, help, accesslevel, entitytype, procedurename, isreport, isdirectprint, ad_reportview_id, classname, statistic_count, statistic_seconds, ad_printformat_id, workflowvalue, ad_workflow_id, isbetafunctionality, isserverprocess, showhelp, jasperreport, ad_form_id, copyfromprocess, ad_process_uu, ad_ctxhelp_id, executiontype, allowmultipleexecution) VALUES ((SELECT MAX(ad_process_id) + 1 FROM ad_process), 0, 0, 'Y', '2021-08-04 14:28:06.546000', 100, '2021-08-04 14:28:06.546000', 100, 'BH Bill Invoice', 'BH Bill Invoice', 'Invoice Receipt Report', null, '3', 'U', null, 'Y', 'Y', null, 'org.adempiere.report.jasper.ReportStarter', 0, 0, null, null, null, 'N', 'N', 'Y', 'A5_Insurance.jasper', null, 'N', '477cdda4-82ff-4bac-834f-08de384df412', null, null, 'P') ON CONFLICT DO NOTHING;

-- Add Bill Insurance Report parameter
INSERT INTO ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete) VALUES ((SELECT MAX(ad_process_para_id) + 1 FROM ad_process_para), 0, 0, 'Y', '2021-08-04 14:32:39.800000', 100, '2021-08-04 14:32:39.800000', 100, 'C_Order_UU', null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412'), 10, 10, null, null, 'C_Order_UU', 'Y', 36, 'N', 'N', null, null, null, null, null, 54809, 'U', null, null, '989edccc-2afd-4096-ad58-bf076ab4b698', 'N', null, null, null, 'N') ON CONFLICT DO NOTHING;

-- Add the Bill Insurance report to all the roles
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '93365778-a2d9-433b-b962-87fb150db4fa'), 0, 0, 'Y', '2021-08-04 14:39:54.940000', 100, '2021-08-04 14:39:54.940000', 100, 'Y', '6ecc99ec-6944-47e8-960d-9260471a3a34') ON CONFLICT DO NOTHING;
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'), 0, 0, 'Y', '2021-08-04 14:40:24.984000', 100, '2021-08-04 14:40:24.984000', 100, 'Y', 'a37395ae-0f22-4edd-a505-87e98447f3fa') ON CONFLICT DO NOTHING;
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'), 0, 0, 'Y', '2021-08-04 14:40:36.102000', 100, '2021-08-04 14:40:36.102000', 100, 'Y', '285078e1-6931-405a-af1e-a02ea4c4ebd0') ON CONFLICT DO NOTHING;
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-08-04 14:40:56.347000', 100, '2021-08-04 14:40:56.347000', 100, 'Y', '02c1035d-72a0-4b75-bf81-876b586556e5') ON CONFLICT DO NOTHING;
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'), 0, 0, 'Y', '2021-08-04 14:41:12.836000', 100, '2021-08-04 14:41:12.836000', 100, 'Y', '5fc85f12-7c3f-4044-96ba-f2dc299617e0') ON CONFLICT DO NOTHING;
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'), 0, 0, 'Y', '2021-08-04 14:41:24.907000', 100, '2021-08-04 14:41:24.907000', 100, 'Y', '47891b63-f27b-425b-8451-e235da4e7751') ON CONFLICT DO NOTHING;
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'), 0, 0, 'Y', '2021-08-04 14:41:35.497000', 100, '2021-08-04 14:41:35.497000', 100, 'Y', 'dd578e44-5f88-4d9c-85b4-b7e973a16458') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202108041431_GO-1764.sql') FROM dual;
