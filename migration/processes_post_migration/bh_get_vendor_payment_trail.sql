DROP FUNCTION IF EXISTS bh_get_vendor_payment_trail(_ad_client_id numeric);
CREATE OR REPLACE FUNCTION bh_get_vendor_payment_trail(_ad_client_id numeric)
	RETURNS table
	        (
		        ad_client_id  numeric,
		        c_invoice_id  numeric,
		        c_bpartner_id numeric,
		        c_payment_id  numeric,
		        bh_visit_id   numeric,
		        date          timestamp,
		        created       timestamp,
		        updated       timestamp,
		        createdby     numeric,
		        docstatus     char(2),
		        c_order_id    numeric,
		        item          text,
		        debits        numeric,
		        credits       numeric,
		        net           numeric,
		        open_balance  numeric

	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT *,
			SUM(net) FILTER ( WHERE docstatus IS NULL OR docstatus IN ('CO', 'CL') )
		OVER (PARTITION BY c_bpartner_id ORDER BY CASE
			                                          WHEN docstatus NOT IN ('CO', 'CL') THEN '-infinity'::timestamp
			                                          ELSE date END, updated ROWS UNBOUNDED PRECEDING) AS open_balance
FROM
	(
		-- Expenses and Receive products
		SELECT
			i.ad_client_id,
			i.c_invoice_id,
			i.c_bpartner_id,
			p.c_payment_id                                                             AS c_payment_id,
			i.bh_visit_id,
			i.dateinvoiced::date                                                       AS date,
			i.created,
			i.updated,
			i.createdby,
			i.docstatus,
			o.c_order_id,
			CASE WHEN o.c_order_id IS NULL THEN 'Expenses' ELSE 'Receive Products' END AS item,
			i.grandtotal                                                               AS debits,
			COALESCE(SUM(p.payamt), 0)                                                 AS credits,
			COALESCE(SUM(p.payamt), 0) - i.grandtotal                                  AS net
		FROM
			c_invoice i
				LEFT JOIN c_order o
					ON i.c_order_id = o.c_order_id
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.c_invoice_id
		WHERE
			i.ad_client_id = _ad_client_id
			AND i.docstatus IN ('CO', 'CL', 'VO', 'RE', 'RA')
		GROUP BY
			i.ad_client_id, i.c_invoice_id, i.c_bpartner_id, i.bh_visit_id, i.dateinvoiced::date, i.created,
			i.updated, i.createdby, i.docstatus, o.c_order_id,
			o.c_order_id, i.grandtotal, p.c_payment_id
		-- Outstanding Open Balances
		UNION ALL
		SELECT
			ad_client_id,
			NULL,
			c_bpartner_id,
			c_payment_id,
			bh_visit_id,
			datetrx::date,
			created,
			updated,
			createdby,
			docstatus,
			NULL,
			'Outstanding Balance Payment' AS item,
			0                             AS debits,
			payamt                        AS credits,
			payamt                        AS net
		FROM
			c_payment
		WHERE
			ad_client_id = _ad_client_id
			AND docstatus IN ('CO', 'CL', 'VO', 'RE', 'RA')
			AND c_invoice_id IS NULL
	) b
$$;
