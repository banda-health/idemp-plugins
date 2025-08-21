DROP FUNCTION IF EXISTS bh_get_vendor_payment_trail(_ad_client_id numeric);
CREATE OR REPLACE FUNCTION bh_get_vendor_payment_trail(_ad_client_id numeric)
	RETURNS table
	        (
		        ad_client_id  numeric,
		        c_invoice_id  numeric,
		        c_bpartner_id numeric,
		        c_payment_id  numeric,
		        date          timestamp,
		        created       timestamp,
		        updated       timestamp,
		        createdby     numeric,
		        c_order_id    numeric,
		        charged       numeric,
		        paid          numeric,
		        open_balance  numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	ad_client_id,
	c_invoice_id,
	c_bpartner_id,
	c_payment_id,
	date,
	created,
	updated,
	createdby,
	c_order_id,
	b.charged,
	paid,
			SUM(net) OVER (PARTITION BY c_bpartner_id ORDER BY date, created ROWS UNBOUNDED PRECEDING) AS open_balance
FROM
	(
		-- Receive products
		SELECT
			o.ad_client_id,
			i.c_invoice_id,
			o.c_bpartner_id,
			p.c_payment_id,
			-- Add time so the starting balance can be first
			o.dateordered::date + '1 microsecond'::interval AS date,
			o.created,
			o.updated,
			o.createdby,
			o.c_order_id,
			o.grandtotal                                    AS charged,
			COALESCE(p.payamt, 0)                           AS paid,
			o.grandtotal - COALESCE(p.payamt, 0)            AS net
		FROM
			c_order o
				JOIN c_invoice i
					ON i.c_order_id = o.c_order_id AND i.docstatus IN ('CO', 'CL')
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.c_invoice_id AND p.docstatus IN ('CO', 'CL')
		WHERE
			o.ad_client_id = _ad_client_id
			AND o.issotrx = 'N'
			AND o.bh_visit_id IS NULL
		UNION ALL
		-- Expenses
		SELECT
			i.ad_client_id,
			i.c_invoice_id,
			i.c_bpartner_id,
			p.c_payment_id,
			-- Add time so the starting balance can be first
			i.dateinvoiced::date + '1 microsecond'::interval,
			i.created,
			i.updated,
			i.createdby,
			NULL,
			i.grandtotal,
			COALESCE(p.payamt, 0),
			i.grandtotal - COALESCE(p.payamt, 0) AS net
		FROM
			c_invoice i
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.c_invoice_id AND p.docstatus IN ('CO', 'CL')
		WHERE
			i.ad_client_id = _ad_client_id
			AND i.issotrx = 'N'
			AND i.docstatus IN ('CO', 'CL')
			AND i.bh_visit_id IS NULL
			AND i.c_order_id IS NULL
		UNION ALL
		-- Outstanding Open Balances
		SELECT
			ad_client_id,
			NULL,
			c_bpartner_id,
			c_payment_id,
			-- Add time so the starting balance can be first
			datetrx::date + '1 microsecond'::interval,
			created,
			updated,
			createdby,
			NULL,
			0,
			payamt,
			payamt * -1
		FROM
			c_payment
		WHERE
			ad_client_id = _ad_client_id
			AND isreceipt = 'N'
			AND docstatus IN ('CO', 'CL')
			AND c_invoice_id IS NULL
			AND bh_visit_id IS NULL
		UNION ALL
		-- Get a starting balance
		SELECT
			_ad_client_id,
			NULL,
			bp.c_bpartner_id,
			NULL,
			MIN(LEAST(bp.created, o.dateordered, i.dateinvoiced, p.datetrx)),
			MIN(LEAST(bp.created, o.dateordered, i.dateinvoiced, p.datetrx)),
			MIN(LEAST(bp.created, o.dateordered, i.dateinvoiced, p.datetrx)),
			bp.createdby,
			NULL,
			0,
			0,
			0
		FROM
			c_bpartner bp
				LEFT JOIN c_order o
					ON o.c_bpartner_id = bp.c_bpartner_id AND o.docstatus IN ('CO', 'CL') AND o.issotrx = 'N' AND
					   o.bh_visit_id IS NULL
				LEFT JOIN c_invoice i
					ON bp.c_bpartner_id = i.c_bpartner_id AND i.docstatus IN ('CO', 'CL') AND i.issotrx = 'N' AND
					   i.bh_visit_id IS NULL
				LEFT JOIN c_payment p
					ON bp.c_bpartner_id = p.c_bpartner_id AND p.docstatus IN ('CO', 'CL') AND p.isreceipt = 'N' AND
					   p.bh_visit_id IS NULL
		WHERE
			bp.ad_client_id = _ad_client_id
		GROUP BY bp.c_bpartner_id, bp.createdby
	) b
$$;
