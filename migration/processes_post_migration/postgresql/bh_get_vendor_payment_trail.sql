DROP FUNCTION IF EXISTS bh_get_vendor_payment_trail(_ad_client_id numeric);
CREATE OR REPLACE FUNCTION bh_get_vendor_payment_trail(_ad_client_id numeric)
	RETURNS table
	        (
		        ad_client_id               numeric,
		        c_invoice_id               numeric,
		        c_bpartner_id              numeric,
		        c_payment_id               numeric,
		        date                       timestamp,
		        created                    timestamp,
		        updated                    timestamp,
		        ordering_date              timestamp,
		        createdby                  numeric,
		        c_order_id                 numeric,
		        charged                    numeric,
		        paid                       numeric,
		        open_balance               numeric,
		        base_reversal_c_invoice_id numeric,
		        base_reversal_c_payment_id numeric
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
	DATE,
	created,
	updated,
	ordering_date,
	createdby,
	c_order_id,
	charged,
	paid,
			SUM(net) FILTER ( WHERE docstatus NOT IN ('DR', 'IP') )
		OVER ( PARTITION BY c_bpartner_id ORDER BY CASE
			                                           WHEN docstatus IN ('DR', 'IP')
				                                           THEN '-infinity'::TIMESTAMP
			                                           ELSE ordering_date END, date ROWS UNBOUNDED PRECEDING) AS open_balance,
	base_reversal_c_invoice_id,
	base_reversal_c_payment_id
FROM
	(
		-- Receive products
		SELECT
			o.ad_client_id,
			i.c_invoice_id,
			o.c_bpartner_id,
			NULL::NUMERIC                                                           AS c_payment_id,
			-- Add time so the starting balance can be first
			o.dateordered::DATE + '1 microsecond'::INTERVAL                         AS date,
			i.created,
			i.updated,
			CASE
				WHEN i.docstatus IN ('CO', 'CL') THEN i.updated
				ELSE i.created END                                                    AS ordering_date,
			i.createdby,
			o.c_order_id,
			i.grandtotal                                                            AS charged,
			COALESCE(SUM(p.payamt), 0)                                              AS paid,
			i.docstatus,
			i.grandtotal - COALESCE(SUM(p.payamt), 0)                               AS net,
			CASE WHEN i.docstatus = 'RE' THEN i.c_invoice_id ELSE NULL::NUMERIC END AS base_reversal_c_invoice_id,
			NULL::NUMERIC                                                           AS base_reversal_c_payment_id
		FROM
			c_order o
				JOIN c_invoice i
					ON i.c_order_id = o.c_order_id AND (i.reversal_id IS NULL OR i.reversal_id > i.c_invoice_id)
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.bh_original_c_invoice_id AND (p.reversal_id IS NULL OR p.reversal_id > p.c_payment_id)
		WHERE
			o.ad_client_id = _ad_client_id
			AND o.issotrx = 'N'
			AND o.bh_visit_id IS NULL
		GROUP BY
			o.ad_client_id, i.c_invoice_id, o.c_bpartner_id, o.dateordered::DATE + '1 microsecond'::INTERVAL, i.created,
			i.updated, i.createdby, o.c_order_id, i.grandtotal, i.docstatus
		UNION ALL
		-- Receive products reversions
		SELECT
			o.ad_client_id,
			i_r.c_invoice_id,
			o.c_bpartner_id,
			NULL,
			-- Add time so the starting balance can be first
			o.dateordered::DATE + '1 microsecond'::INTERVAL AS DATE,
			i_r.created,
			i_r.updated,
			i_r.created,
			i_r.createdby,
			o.c_order_id,
			i_r.grandtotal                                  AS charged,
			COALESCE(SUM(p_r.payamt), 0)                    AS paid,
			i_r.docstatus,
			i_r.grandtotal - COALESCE(SUM(p_r.payamt), 0)   AS net,
			i.c_invoice_id,
			NULL
		FROM
			c_order o
				JOIN c_invoice i
					ON i.c_order_id = o.c_order_id AND i.reversal_id > i.c_invoice_id
				JOIN c_invoice i_r
					ON i.reversal_id = i_r.c_invoice_id
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.bh_original_c_invoice_id
				LEFT JOIN c_payment p_r
					ON p.reversal_id = p_r.c_payment_id AND p.reversal_id > p.c_payment_id
		WHERE
			o.ad_client_id = _ad_client_id
			AND i.docstatus = 'RE'
			AND o.issotrx = 'N'
			AND o.bh_visit_id IS NULL
		GROUP BY
			o.ad_client_id, i_r.c_invoice_id, o.c_bpartner_id, o.dateordered, i_r.created, i_r.updated, i_r.createdby,
			o.c_order_id, i_r.grandtotal, i_r.docstatus, i.c_invoice_id
		UNION ALL
		-- Expenses
		SELECT
			i.ad_client_id,
			i.c_invoice_id,
			i.c_bpartner_id,
			NULL,
			-- Add time so the starting balance can be first
			i.dateinvoiced::DATE + '1 microsecond'::INTERVAL,
			i.created,
			i.updated,
			CASE
				WHEN i.docstatus IN ('CO', 'CL') THEN i.updated
				ELSE i.created END                      AS ordering_date,
			i.createdby,
			NULL,
			i.grandtotal,
			COALESCE(SUM(p.payamt), 0),
			i.docstatus,
			i.grandtotal - COALESCE(SUM(p.payamt), 0) AS net,
			CASE WHEN i.docstatus = 'RE' THEN i.c_invoice_id END,
			NULL
		FROM
			c_invoice i
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.bh_original_c_invoice_id AND (p.reversal_id IS NULL OR p.reversal_id > p.c_payment_id)
		WHERE
			i.ad_client_id = _ad_client_id
			AND (i.reversal_id IS NULL OR i.reversal_id > i.c_invoice_id)
			AND i.issotrx = 'N'
			AND i.bh_visit_id IS NULL
			AND i.c_order_id IS NULL
		GROUP BY
			i.ad_client_id, i.c_invoice_id, i.c_bpartner_id, i.dateinvoiced, i.created, i.updated, i.createdby, i.grandtotal,
			i.docstatus
		UNION ALL
		-- Expense reversals
		SELECT
			i_r.ad_client_id,
			i_r.c_invoice_id,
			i_r.c_bpartner_id,
			NULL,
			-- Add time so the starting balance can be first
			i_r.dateinvoiced::DATE + '1 microsecond'::INTERVAL,
			i_r.created,
			i_r.updated,
			i_r.created,
			i_r.createdby,
			NULL,
			i_r.grandtotal,
			COALESCE(SUM(p_r.payamt), 0),
			i_r.docstatus,
			i_r.grandtotal - COALESCE(SUM(p_r.payamt), 0) AS net,
			i.c_invoice_id,
			NULL
		FROM
			c_invoice i
				JOIN c_invoice i_r
					ON i.reversal_id = i_r.c_invoice_id AND i.reversal_id > i.c_invoice_id
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.bh_original_c_invoice_id
				LEFT JOIN c_payment p_r
					ON p.reversal_id = p_r.c_payment_id AND p.reversal_id > p.c_payment_id
		WHERE
			i.ad_client_id = _ad_client_id
			AND i.reversal_id IS NOT NULL
			AND i.reversal_id < i.c_invoice_id
			AND i.issotrx = 'N'
			AND i.bh_visit_id IS NULL
			AND i.c_order_id IS NULL
		GROUP BY
			i_r.ad_client_id, i_r.c_invoice_id, i_r.c_bpartner_id, i_r.dateinvoiced, i_r.created, i_r.updated, i_r.createdby,
			i_r.grandtotal, i_r.docstatus, i_r.grandtotal, i.c_invoice_id
		UNION ALL
		-- Outstanding Open Balances
		SELECT
			ad_client_id,
			NULL,
			c_bpartner_id,
			c_payment_id,
			-- Add time so the starting balance can be first
			datetrx::DATE + '1 microsecond'::INTERVAL,
			created,
			updated,
			CASE
				WHEN docstatus IN ('CO', 'CL') THEN updated
				ELSE created END,
			createdby,
			NULL,
			0,
			payamt,
			docstatus,
			payamt * -1,
			NULL,
			CASE WHEN docstatus = 'RE' THEN c_payment_id ELSE NULL END
		FROM
			c_payment
		WHERE
			ad_client_id = _ad_client_id
			AND (reversal_id IS NULL OR reversal_id > c_payment_id)
			AND isreceipt = 'N'
			AND c_invoice_id IS NULL
			AND bh_visit_id IS NULL
			AND bh_original_c_invoice_id IS NULL
		UNION ALL
		-- Outstanding Open Balance payment reversals
		SELECT
			p_r.ad_client_id,
			NULL,
			p_r.c_bpartner_id,
			p_r.c_payment_id,
			-- Add time so the starting balance can be first
			p_r.datetrx::DATE + '1 microsecond'::INTERVAL,
			p_r.created,
			p_r.updated,
			p_r.created,
			p_r.createdby,
			NULL,
			0,
			p_r.payamt,
			p_r.docstatus,
			p_r.payamt * -1,
			NULL,
			p.c_payment_id
		FROM
			c_payment p
				JOIN c_payment p_r
					ON p_r.c_payment_id = p.reversal_id AND p.reversal_id > p.c_payment_id
		WHERE
			p.ad_client_id = _ad_client_id
			AND p.isreceipt = 'N'
			AND p.c_invoice_id IS NULL
			AND p.bh_visit_id IS NULL
			AND p.bh_original_c_invoice_id IS NULL
		UNION ALL
		-- Get a starting balance
		SELECT
			_ad_client_id,
			NULL,
			c_bpartner_id,
			NULL,
			'-infinity'::timestamp,
			'-infinity'::timestamp,
			'-infinity'::timestamp,
			'-infinity'::timestamp,
			createdby,
			NULL,
			0,
			0,
			NULL,
			0,
			NULL,
			NULL
		FROM
			c_bpartner
		WHERE
			ad_client_id = _ad_client_id
	) b
$$;
