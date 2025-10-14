-- For payments with invoice IDs, just set them
UPDATE c_payment
SET
	bh_original_c_invoice_id = c_invoice_id
WHERE
	c_invoice_id IS NOT NULL
	AND bh_original_c_invoice_id IS NULL;

-- Update completed payments
UPDATE c_payment p
SET
	bh_original_c_invoice_id = al.c_invoice_id
FROM
	c_allocationline al
WHERE
	p.c_payment_id = al.c_payment_id
	AND p.docstatus IN ('CO', 'CL')
	AND p.reversal_id IS NULL
	AND p.c_invoice_id IS NULL
	AND p.bh_original_c_invoice_id IS NULL
	AND al.c_invoice_id IS NOT NULL
	AND p.bh_visit_id IS NOT NULL;

-- Update all payments to included original invoice IDs
UPDATE c_payment p
SET
	bh_original_c_invoice_id = al.c_invoice_id
FROM
	c_allocationline al
WHERE
	p.c_payment_id = al.c_payment_id
	AND p.c_payment_id < p.reversal_id
	AND al.amount >= 0
	AND al.c_invoice_id IS NOT NULL
	AND p.bh_original_c_invoice_id IS NULL;

-- For all reversal payments, set their original invoice IDs to match the reversal
UPDATE c_payment p_r
SET
	bh_original_c_invoice_id = p_o.bh_original_c_invoice_id
FROM
	c_payment p_o
WHERE
	p_o.reversal_id = p_r.c_payment_id
	AND p_o.c_payment_id < p_o.reversal_id
	AND p_r.bh_original_c_invoice_id IS NULL
	AND p_o.bh_original_c_invoice_id IS NOT NULL;

-- Now for remaining visit things, let's assign it to the first completed invoices
UPDATE c_payment p
SET
	bh_original_c_invoice_id = i.c_invoice_id
FROM
	bh_visit v
		JOIN c_invoice i
			ON v.bh_visit_id = i.bh_visit_id AND v.patient_id = i.c_bpartner_id AND i.docstatus IN ('CO', 'CL')
WHERE
	p.bh_visit_id = v.bh_visit_id
	AND p.bh_original_c_invoice_id IS NULL
	AND p.docstatus IN ('CO', 'CL');

-- For remaining visit payments, try to connect them based on totals
UPDATE c_payment p
SET
	bh_original_c_invoice_id = i.c_invoice_id
FROM
	bh_visit v
		JOIN c_invoice i
			ON v.bh_visit_id = i.bh_visit_id AND v.patient_id = i.c_bpartner_id
WHERE
	p.bh_visit_id = v.bh_visit_id
	AND (p.reversal_id IS NULL OR p.c_payment_id < p.reversal_id)
	AND p.bh_original_c_invoice_id IS NULL
	AND p.payamt = i.grandtotal;

-- For all reversal payments, set their original invoice IDs to match the reversal
UPDATE c_payment p_r
SET
	bh_original_c_invoice_id = p_o.bh_original_c_invoice_id
FROM
	c_payment p_o
WHERE
	p_o.reversal_id = p_r.c_payment_id
	AND p_o.c_payment_id < p_o.reversal_id
	AND p_r.bh_original_c_invoice_id IS NULL
	AND p_o.bh_original_c_invoice_id IS NOT NULL;

DROP FUNCTION IF EXISTS bh_get_payment_trail(_ad_client_id numeric);
CREATE OR REPLACE FUNCTION bh_get_payment_trail(_ad_client_id numeric)
	RETURNS table
	        (
		        ad_client_id               numeric,
		        bh_visit_id                numeric,
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
	bh_visit_id,
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
		-- Visits
		SELECT
			v.bh_visit_id,
			o.ad_client_id,
			i.c_invoice_id,
			o.c_bpartner_id,
			NULL::NUMERIC                                                           AS c_payment_id,
			-- Add time so the starting balance can be first
			v.bh_visitdate + '1 microsecond'::INTERVAL                              AS date,
			i.created,
			i.updated,
			i.created                                                               AS ordering_date,
			i.createdby,
			o.c_order_id,
			il.charged                                                              AS charged,
			COALESCE(SUM(p.payamt), 0) + il.insurance                               AS paid,
			i.docstatus,
			il.charged - COALESCE(SUM(p.payamt), 0) - il.insurance                  AS net,
			CASE WHEN i.docstatus = 'RE' THEN i.c_invoice_id ELSE NULL::NUMERIC END AS base_reversal_c_invoice_id,
			NULL::NUMERIC                                                           AS base_reversal_c_payment_id
		FROM
			bh_visit v
				JOIN c_order o
					ON v.bh_visit_id = o.bh_visit_id
				JOIN c_invoice i
					ON i.c_order_id = o.c_order_id AND (i.reversal_id IS NULL OR i.reversal_id > i.c_invoice_id)
				JOIN LATERAL (SELECT
					              i.c_invoice_id,
					              COALESCE(SUM(linenetamt) FILTER ( WHERE c_charge_id IS NULL ), 0)          AS charged,
					              COALESCE(SUM(linenetamt) FILTER ( WHERE c_charge_id IS NOT NULL ), 0) * -1 AS insurance
				              FROM
					              c_invoiceline
				              WHERE
					              c_invoice_id = i.c_invoice_id) il
					ON i.c_invoice_id = il.c_invoice_id
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.bh_original_c_invoice_id AND (p.reversal_id IS NULL OR p.reversal_id > p.c_payment_id)
		WHERE
			o.ad_client_id = _ad_client_id
		GROUP BY
			v.bh_visit_id, o.ad_client_id, i.c_invoice_id, o.c_bpartner_id, v.bh_visitdate + '1 microsecond'::INTERVAL,
			i.created, i.updated, i.createdby, o.c_order_id, il.charged, il.insurance, i.docstatus
		UNION ALL
		-- Visit reversions
		SELECT
			v.bh_visit_id,
			o.ad_client_id,
			i_r.c_invoice_id,
			o.c_bpartner_id,
			NULL,
			-- Add time so the starting balance can be first
			v.bh_visitdate + '1 microsecond'::INTERVAL,
			i_r.created,
			i_r.updated,
			i_r.created,
			i_r.createdby,
			o.c_order_id,
			il.charged                                               AS charged,
			COALESCE(SUM(p_r.payamt), 0) + il.insurance              AS paid,
			i_r.docstatus,
			il.charged - COALESCE(SUM(p_r.payamt), 0) - il.insurance AS net,
			i.c_invoice_id,
			NULL
		FROM
			bh_visit v
				JOIN c_order o
					ON v.bh_visit_id = o.bh_visit_id
				JOIN c_invoice i
					ON i.c_order_id = o.c_order_id AND i.reversal_id > i.c_invoice_id
				JOIN c_invoice i_r
					ON i.reversal_id = i_r.c_invoice_id
				JOIN LATERAL (SELECT
					              i_r.c_invoice_id,
					              COALESCE(SUM(linenetamt) FILTER ( WHERE c_charge_id IS NULL ), 0)          AS charged,
					              COALESCE(SUM(linenetamt) FILTER ( WHERE c_charge_id IS NOT NULL ), 0) * -1 AS insurance
				              FROM
					              c_invoiceline
				              WHERE
					              c_invoice_id = i_r.c_invoice_id) il
					ON i_r.c_invoice_id = il.c_invoice_id
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.bh_original_c_invoice_id
				LEFT JOIN c_payment p_r
					ON p.reversal_id = p_r.c_payment_id AND p.reversal_id > p.c_payment_id
		WHERE
			o.ad_client_id = _ad_client_id
			AND i.docstatus = 'RE'
		GROUP BY
			v.bh_visit_id, o.ad_client_id, i_r.c_invoice_id, o.c_bpartner_id, v.bh_visitdate, i_r.created, i_r.updated,
			i_r.createdby, o.c_order_id, il.charged, il.insurance, i_r.docstatus, i.c_invoice_id
		UNION ALL
		-- Waived Open Balances
		SELECT
			NULL,
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
				ELSE i.created END AS ordering_date,
			i.createdby,
			NULL,
			0,
			i.grandtotal,
			i.docstatus,
			i.grandtotal * -1    AS net,
			CASE WHEN i.docstatus = 'RE' THEN i.c_invoice_id END,
			NULL
		FROM
			c_invoice i
				JOIN c_invoiceline il
					ON i.c_invoice_id = il.c_invoice_id
				JOIN c_charge c
					ON il.c_charge_id = c.c_charge_id
				JOIN c_chargetype ct
					ON c.c_chargetype_id = ct.c_chargetype_id
		WHERE
			i.ad_client_id = _ad_client_id
			AND (i.reversal_id IS NULL OR i.reversal_id > i.c_invoice_id)
			AND i.issotrx = 'Y'
			AND i.bh_visit_id IS NULL
			AND i.c_order_id IS NULL
			AND c.name = 'Bad debt write-off - DO NOT CHANGE'
			AND ct.name = 'One-offs - DO NOT CHANGE'
		GROUP BY
			i.ad_client_id, i.c_invoice_id, i.c_bpartner_id, i.dateinvoiced, i.created, i.updated, i.createdby, i.grandtotal,
			i.docstatus
		UNION ALL
		-- Open Debt Payment reversals
		SELECT
			NULL,
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
			0,
			i_r.grandtotal,
			i_r.docstatus,
			i_r.grandtotal * -1 AS net,
			i.c_invoice_id,
			NULL
		FROM
			c_invoice i
				JOIN c_invoice i_r
					ON i.reversal_id = i_r.c_invoice_id AND i.reversal_id > i.c_invoice_id
				JOIN c_invoiceline il
					ON i_r.c_invoice_id = il.c_invoice_id
				JOIN c_charge c
					ON il.c_charge_id = c.c_charge_id
				JOIN c_chargetype ct
					ON c.c_chargetype_id = ct.c_chargetype_id
		WHERE
			i.ad_client_id = _ad_client_id
			AND i.reversal_id IS NOT NULL
			AND i.reversal_id < i.c_invoice_id
			AND i.issotrx = 'Y'
			AND i.bh_visit_id IS NULL
			AND i.c_order_id IS NULL
			AND c.name = 'Bad debt write-off - DO NOT CHANGE'
			AND ct.name = 'One-offs - DO NOT CHANGE'
		GROUP BY
			i_r.ad_client_id, i_r.c_invoice_id, i_r.c_bpartner_id, i_r.dateinvoiced, i_r.created, i_r.updated, i_r.createdby,
			i_r.grandtotal, i_r.docstatus, i_r.grandtotal, i.c_invoice_id
		UNION ALL
		-- Outstanding Open Balances
		SELECT
			NULL,
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
			AND isreceipt = 'Y'
			AND c_invoice_id IS NULL
			AND bh_visit_id IS NULL
			AND bh_original_c_invoice_id IS NULL
		UNION ALL
		-- Outstanding Open Balance payment reversals
		SELECT
			NULL,
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
			AND p.isreceipt = 'Y'
			AND p.c_invoice_id IS NULL
			AND p.bh_visit_id IS NULL
			AND p.bh_original_c_invoice_id IS NULL
		UNION ALL
		-- Get a starting balance
		SELECT
			NULL,
			_ad_client_id,
			NULL,
			bp.c_bpartner_id,
			NULL,
			MIN(LEAST(bp.created, v.bh_visitdate, o.dateordered, i.dateinvoiced, p.datetrx)),
			MIN(LEAST(bp.created, v.bh_visitdate, o.dateordered, i.dateinvoiced, p.datetrx)),
			MIN(LEAST(bp.created, v.bh_visitdate, o.dateordered, i.dateinvoiced, p.datetrx)),
			MIN(LEAST(bp.created, v.bh_visitdate, o.dateordered, i.dateinvoiced, p.datetrx)),
			bp.createdby,
			NULL,
			0,
			0,
			NULL,
			0,
			NULL,
			NULL
		FROM
			c_bpartner bp
				LEFT JOIN bh_visit v
					ON bp.c_bpartner_id = v.patient_id
				LEFT JOIN c_order o
					ON v.bh_visit_id = o.bh_visit_id
				LEFT JOIN c_invoice i
					ON bp.c_bpartner_id = i.c_bpartner_id AND i.issotrx = 'N' AND
					   i.bh_visit_id IS NULL
				LEFT JOIN c_payment p
					ON bp.c_bpartner_id = p.c_bpartner_id AND p.isreceipt = 'N' AND
					   p.bh_visit_id IS NULL
		WHERE
			bp.ad_client_id = _ad_client_id
		GROUP BY bp.c_bpartner_id, bp.createdby
	) b
$$;

SELECT
	register_migration_script('202510131543_GO-3404.sql')
FROM
	dual;
