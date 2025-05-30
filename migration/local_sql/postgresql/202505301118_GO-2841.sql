UPDATE ad_process
SET
	jasperreport = 'Income Statement/IncomeStatementProfitAndLoss.jasper'
WHERE
	ad_process_uu = '8ea6c947-4450-48dd-8bd0-76b0f307dcb0';

SELECT
	register_migration_script('202505301118_GO-2841.sql')
FROM
	dual;
