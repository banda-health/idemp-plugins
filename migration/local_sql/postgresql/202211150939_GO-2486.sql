-- Update certain purchase orders to not be marked as expenses
UPDATE c_order
SET
	bh_isexpense = NULL
WHERE
	bh_isexpense = 'Y'
	AND issotrx = 'N'
	AND created > '2022-11-11'
	AND c_order_id NOT IN (
	SELECT c_order_id
	FROM c_orderline
	WHERE c_charge_id IS NOT NULL
);

SELECT
	register_migration_script('202211150939_GO-2486.sql')
FROM
	dual;
