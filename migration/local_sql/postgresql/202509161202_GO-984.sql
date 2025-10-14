-- Adding this script out of order for Galmi because we need to fix data before 202509161302_GO-984.sql runs
UPDATE c_orderline ol
SET
	m_attributesetinstance_id = 0
FROM
	c_order o
WHERE
	o.c_order_id = ol.c_order_id
	AND o.docstatus IN ('CO', 'CL')
	AND o.issotrx = 'N'
	AND ol.m_attributesetinstance_id IS NULL;

SELECT
	register_migration_script('202509161202_GO-984.sql')
FROM
	dual;
