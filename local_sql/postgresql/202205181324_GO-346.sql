-- Insert the Expired Products List Report
INSERT INTO ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, help, accesslevel, entitytype, procedurename, isreport, isdirectprint, ad_reportview_id, classname, statistic_count, statistic_seconds, ad_printformat_id, workflowvalue, ad_workflow_id, isbetafunctionality, isserverprocess, showhelp, jasperreport, ad_form_id, copyfromprocess, ad_process_uu, ad_ctxhelp_id, executiontype, allowmultipleexecution) VALUES ((SELECT MAX(ad_process_id) + 1 FROM ad_process), 0, 0, 'Y', '2022-05-18 12:39:36.484000', 100, '2022-05-18 12:39:36.484000', 100, 'BH Expired Products List', 'Expired Products List', 'List of Expired Products', null, '3', 'U', null, 'Y', 'N', null, null, 0, 0, null, null, null, 'N', 'N', 'Y', 'Expired Products List.jasper', null, 'N', '808a1aaa-f38a-4a90-87dc-5ab2ebe2f7e6', null, null, 'P') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202205181324_GO-346.sql') FROM dual;