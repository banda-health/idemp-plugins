UPDATE ad_process
SET
	name         = 'Income/Expense Overview',
	jasperreport = 'Income Expense Overview/IncomeStatement.jasper'
WHERE
	ad_process_uu = 'f777f042-3907-4293-94c4-49fe6eb58780';

SELECT
	register_migration_script('202505201621_GO-3299.sql')
FROM
	dual;
