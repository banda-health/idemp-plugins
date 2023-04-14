-- Rename the changes to inventory report
UPDATE ad_process SET jasperreport = 'Stock Reconciliation.jasper' WHERE ad_process_uu = '58ae2bdf-0e80-46f2-860f-2ae070fc82d2';

SELECT register_migration_script('202207192147_GO-2383.sql') FROM dual;
