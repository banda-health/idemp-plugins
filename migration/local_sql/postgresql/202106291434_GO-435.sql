-- Insert the open balance report
INSERT INTO ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, help, accesslevel, entitytype, procedurename, isreport, isdirectprint, ad_reportview_id, classname, statistic_count, statistic_seconds, ad_printformat_id, workflowvalue, ad_workflow_id, isbetafunctionality, isserverprocess, showhelp, jasperreport, ad_form_id, copyfromprocess, ad_process_uu, ad_ctxhelp_id, executiontype, allowmultipleexecution) VALUES ((SELECT MAX(ad_process_id) + 1 FROM ad_process), 0, 0, 'Y', '2021-06-29 14:10:25.789000', 100, '2021-06-29 14:10:25.789000', 100, 'BH Open Balance List', 'Open Balance List', null, null, '3', 'U', null, 'Y', 'N', null, null, 0, 0, null, null, null, 'N', 'N', 'Y', 'OpeningBalanceReport.jasper', null, 'N', 'b4f11e14-b9d8-4f6c-aa46-adfd77c4f773', null, null, 'P') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202106291434_GO-435.sql') FROM dual;