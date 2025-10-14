-- Remove erroneously created invoices and shipments for POs that had a product with no price
DELETE
FROM
	c_invoiceline
WHERE
	c_invoice_id IN (
		SELECT
			i.c_invoice_id
		FROM
			c_invoice i
				JOIN c_order o
					ON i.c_order_id = o.c_order_id AND o.docstatus = 'CO' AND i.docstatus IN ('DR', 'IN', 'IP') AND
					   o.issotrx = 'N'
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.c_invoice_id
				LEFT JOIN c_allocationline al
					ON i.c_invoice_id = al.c_invoice_id
		WHERE
			p.c_payment_id IS NULL
			AND al.c_allocationline_id IS NULL
	);
DELETE
FROM
	c_invoice
WHERE
	c_invoice_id IN (
		SELECT
			i.c_invoice_id
		FROM
			c_invoice i
				JOIN c_order o
					ON i.c_order_id = o.c_order_id AND o.docstatus = 'CO' AND i.docstatus IN ('DR', 'IN', 'IP') AND
					   o.issotrx = 'N'
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.c_invoice_id
				LEFT JOIN c_allocationline al
					ON i.c_invoice_id = al.c_invoice_id
		WHERE
			p.c_payment_id IS NULL
			AND al.c_allocationline_id IS NULL
	);
DELETE
FROM
	m_inoutline
WHERE
	m_inout_id IN (
		SELECT
			io.m_inout_id
		FROM
			m_inout io
				JOIN c_order o
					ON io.c_order_id = o.c_order_id AND o.docstatus = 'CO' AND io.docstatus IN ('DR', 'IN', 'IP') AND
					   o.issotrx = 'N'
	)
	AND m_inoutline_id NOT IN (
		SELECT
			m_inoutline_id
		FROM
			c_invoiceline
		WHERE
			m_inoutline_id IS NOT NULL
	);
DELETE
FROM
	m_inout
WHERE
	m_inout_id IN (
		SELECT
			io.m_inout_id
		FROM
			m_inout io
				JOIN c_order o
					ON io.c_order_id = o.c_order_id AND o.docstatus = 'CO' AND io.docstatus IN ('DR', 'IN', 'IP') AND
					   o.issotrx = 'N'
	)
	AND m_inout_id NOT IN (
		SELECT
			iol.m_inout_id
		FROM
			m_inoutline iol
				JOIN c_invoiceline il
					ON iol.m_inoutline_id = il.m_inoutline_id
	);

SELECT
	register_migration_script('202510091513_GO-3428.sql')
FROM
	dual;
