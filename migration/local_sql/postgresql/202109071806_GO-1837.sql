UPDATE ad_process SET jasperreport = '705A Main Report.jasper', updatedby = 100, updated = now() WHERE ad_process_uu = 'c9f91d23-48ea-4990-af5d-f3e7f0db77de';
UPDATE ad_process SET jasperreport = '705B Main Report.jasper', updatedby = 100, updated = now() WHERE ad_process_uu = '432eeb61-1a87-4880-bded-91927139341c';
UPDATE ad_process SET name = 'Patient Visits and Referrals', value = 'BH Patient Visits and Referrals', updatedby = 100, updated = now() WHERE ad_process_uu = '061ed4a0-5670-4764-909e-fb4592f51aaa';

SELECT register_migration_script('202109071806_GO-1837.sql') FROM dual;
