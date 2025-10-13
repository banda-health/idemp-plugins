-- Delete erroneously created order lines from reactivations
SELECT
	ol2.c_orderline_id,
	ol2.c_order_id
INTO TEMP TABLE
	tmp_c_order_stuff_to_delete
FROM
	c_orderline ol1
		JOIN c_orderline ol2
			ON ol1.c_orderline_id < ol2.c_orderline_id AND ol1.c_order_id = ol2.c_order_id AND
			   ol1.m_product_id = ol2.m_product_id
		JOIN c_order o
			ON ol1.c_order_id = o.c_order_id AND o.docstatus = 'IP' AND o.issotrx = 'Y'
		LEFT JOIN m_inoutline iol
			ON ol1.c_orderline_id = iol.c_orderline_id
		LEFT JOIN m_transaction t
			ON iol.m_inoutline_id = t.m_inoutline_id
WHERE
	t.m_transaction_id IS NULL;

SELECT DISTINCT
	il.c_invoice_id
INTO
	tmp_c_invoice_stuff_to_delete
FROM
	c_invoiceline il
		JOIN tmp_c_order_stuff_to_delete ostd
			ON ostd.c_orderline_id = il.c_orderline_id;

SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_invoiceline
WHERE
	c_orderline_id IN (
		SELECT
			c_orderline_id
		FROM
			tmp_c_order_stuff_to_delete
	);$$, 'c_invoiceline_id');
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	m_inoutline
WHERE
	c_orderline_id IN (
		SELECT
			c_orderline_id
		FROM
			tmp_c_order_stuff_to_delete
	);$$, 'm_inoutline_id');
DELETE
FROM
	c_orderline
WHERE
	c_orderline_id IN (
		SELECT
			c_orderline_id
		FROM
			tmp_c_order_stuff_to_delete
	);

-- Update the totals for these
UPDATE c_invoice i
SET
	grandtotal = i_c.total
FROM
	(
		SELECT
			il.c_invoice_id,
			SUM(linenetamt) AS total
		FROM
			c_invoiceline il
				JOIN tmp_c_invoice_stuff_to_delete istd
					ON istd.c_invoice_id = il.c_invoice_id
		GROUP BY il.c_invoice_id
	) i_c
WHERE
	i.c_invoice_id = i_c.c_invoice_id;
UPDATE c_order o
SET
	grandtotal = o_c.total
FROM
	(
		SELECT
			ol.c_order_id,
			SUM(linenetamt) AS total
		FROM
			c_orderline ol
				JOIN tmp_c_order_stuff_to_delete ostd
					ON ostd.c_order_id = ol.c_order_id
		GROUP BY ol.c_order_id
	) o_c
WHERE
	o.c_order_id = o_c.c_order_id;

SELECT
	register_migration_script('202510131402_GO-3434.sql')
FROM
	dual;
