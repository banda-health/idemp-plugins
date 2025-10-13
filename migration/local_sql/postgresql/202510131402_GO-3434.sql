-- Delete erroneously created order lines from reactivations
DELETE
FROM
	c_orderline
WHERE
	c_orderline_id IN (
		SELECT
			ol2.c_orderline_id
		FROM
			c_orderline ol1
				JOIN c_orderline ol2
					ON ol1.c_orderline_id < ol2.c_orderline_id AND ol1.c_order_id = ol2.c_order_id AND
					   ol1.m_product_id = ol2.m_product_id
				JOIN c_order o
					ON ol1.c_order_id = o.c_order_id AND o.docstatus = 'IP' AND o.issotrx = 'Y'
				LEFT JOIN c_invoiceline il
					ON ol2.c_orderline_id = il.c_orderline_id
		WHERE
			il.m_inoutline_id IS NULL
	);

SELECT
	register_migration_script('202510131402_GO-3434.sql')
FROM
	dual;
