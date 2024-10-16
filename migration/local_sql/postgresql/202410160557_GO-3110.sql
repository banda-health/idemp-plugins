-- Update the orders to make the sales rep whoever created them where there is no sales rep
UPDATE c_order
SET
	salesrep_id = createdby
WHERE
	issotrx = 'Y'
	AND bh_visit_id IS NOT NULL
	AND salesrep_id IS NULL;

SELECT
	register_migration_script('202410160557_GO-3110.sql')
FROM
	dual;
