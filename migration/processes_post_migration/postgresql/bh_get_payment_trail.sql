DROP FUNCTION IF EXISTS bh_get_payment_trail(character varying);
CREATE FUNCTION bh_get_payment_trail(_c_bpartner_uu character varying)
	RETURNS TABLE
	        (
		        c_bpartner_id        numeric,
		        patient_name         character varying,
		        transaction_date     timestamp WITHOUT TIME ZONE,
		        created              timestamp WITHOUT TIME ZONE,
		        updated              timestamp WITHOUT TIME ZONE,
		        item                 text,
		        debits               numeric,
		        credits              numeric,
		        patient_open_balance numeric,
		        bh_visit_id          numeric,
		        c_invoice_id         numeric,
		        c_payment_id         numeric,
		        createdby            numeric
	        )
	STABLE
	LANGUAGE sql
AS
$$
WITH visit_payments AS (
	SELECT
		c_order_id,
		SUM(payamt) AS payamt
	FROM
		c_bpartner bp
			JOIN bh_get_visit_payments(bp.ad_client_id, '-infinity'::timestamp, 'infinity'::timestamp) gvp
				ON gvp.patient_id = bp.c_bpartner_id
	WHERE
		bp.c_bpartner_uu = _c_bpartner_uu
	GROUP BY c_order_id
),
	transactions AS (
		-- Sum all the payments and group them by date
		SELECT
			bh_visit_id,
			c_invoice_id,
			c_payment_id,
			c_payment_docstatus,
			createdby,
			c_bpartner_id,
			date,
			created,
			updated,
			"type"                                               AS item,
			COALESCE(SUM(debits), 0)                             AS debits,
			COALESCE(SUM(credits), 0)                            AS credits,
			COALESCE(SUM(debits), 0) - COALESCE(SUM(credits), 0) AS net
		FROM
			(
				-- Bills
				SELECT
					v.bh_visit_id,
					NULL::numeric                                        AS c_invoice_id,
					NULL::numeric                                        AS c_payment_id,
					NULL                                                 AS c_payment_docstatus,
					v.createdby,
					o.c_bpartner_id,
					v.bh_visitdate::date                                 AS date,
					v.created,
					v.updated,
					CASE
						WHEN COALESCE(SUM(vp.payamt), 0) - COALESCE(i.charges, 0) = 0 THEN 'Visit'
						ELSE 'Visit charges and payments' END              AS "type",
					i.non_charges                                        AS debits,
					COALESCE(SUM(vp.payamt), 0) - COALESCE(i.charges, 0) AS credits
				FROM
					bh_visit v
						JOIN c_order o
							ON v.bh_visit_id = o.bh_visit_id
						JOIN c_bpartner bp
							ON v.patient_id = bp.c_bpartner_id
						LEFT JOIN visit_payments vp
							ON o.c_order_id = vp.c_order_id
						JOIN (
						SELECT
							i.c_order_id,
							SUM(il.linenetamt) FILTER ( WHERE il.c_charge_id IS NULL )     AS non_charges,
							SUM(il.linenetamt) FILTER ( WHERE il.c_charge_id IS NOT NULL ) AS charges
						FROM
							c_invoice i
								JOIN c_invoiceline il
									ON i.c_invoice_id = il.c_invoice_id
								JOIN c_bpartner bp
									ON i.c_bpartner_id = bp.c_bpartner_id
						WHERE
							bp.c_bpartner_uu = _c_bpartner_uu
							AND i.docstatus = 'CO'
						GROUP BY i.c_order_id
					) i
							ON i.c_order_id = o.c_order_id
				WHERE
					o.docstatus = 'CO'
					AND bp.c_bpartner_uu = _c_bpartner_uu
				GROUP BY
					o.c_order_id, o.c_bpartner_id, date, non_charges, charges, v.bh_visit_id, v.createdby, v.created, v.updated
				UNION ALL
				-- Outstanding Balance Payments
				SELECT
					NULL                                     AS bh_visit_id,
					NULL                                     AS c_invoice_id,
					gdp.c_payment_id                         AS c_payment_id,
					p.docstatus                              AS c_payment_docstatus,
					p.createdby,
					bp.c_bpartner_id,
					gdp.payment_date                         AS date,
					p.created,
					p.updated,
					CASE
						WHEN p.scheduled = 'Y' AND p.docstatus NOT IN ('CO', 'CL') THEN 'Scheduled Payment'
						ELSE 'Outstanding Balance Payment' END AS "type",
					NULL                                     AS debits,
					SUM(payment_amount)                      AS credits
				FROM
					c_bpartner bp
						JOIN bh_get_debt_payments(bp.ad_client_id, '-infinity'::timestamp, 'infinity'::timestamp) gdp
							ON gdp.patient_id = bp.c_bpartner_id
						JOIN c_payment p
							ON p.c_payment_id = gdp.c_payment_id
				WHERE
					bp.c_bpartner_uu = _c_bpartner_uu
				GROUP BY
					bp.c_bpartner_id, date, gdp.c_payment_id, p.createdby, p.scheduled, p.docstatus, p.created, p.updated
				UNION ALL
				-- Waived open balance
				SELECT
					NULL                    AS bh_visit_id,
					i.c_invoice_id,
					NULL                    AS c_payment_id,
					NULL                    AS c_payment_docstatus,
					i.createdby,
					i.c_bpartner_id,
					i.dateinvoiced          AS date,
					i.created,
					i.updated,
					'Waived Open Balance'   AS "type",
					NULL                    AS debits,
					SUM(il.linenetamt) * -1 AS credits
				FROM
					c_invoice i
						JOIN c_bpartner bp
							ON i.c_bpartner_id = bp.c_bpartner_id
						JOIN c_invoiceline il
							ON i.c_invoice_id = il.c_invoice_id
						JOIN c_charge c
							ON il.c_charge_id = c.c_charge_id
						JOIN c_chargetype ct
							ON c.c_chargetype_id = ct.c_chargetype_id
				WHERE
					bp.c_bpartner_uu = _c_bpartner_uu
					AND c.name = 'Bad debt write-off - DO NOT CHANGE'
					AND ct.name = 'One-offs - DO NOT CHANGE'
				GROUP BY
					i.c_invoice_id, bp.c_bpartner_id, i.dateinvoiced::date, i.createdby, i.created, i.updated
			) AS transactions
		GROUP BY
			bh_visit_id, c_payment_id, createdby, c_bpartner_id, date, "type", created, updated, c_invoice_id,
			c_payment_docstatus
	),
	orderings AS (
-- This categorizes the payments
		SELECT
			orderings.*,
			ROW_NUMBER() OVER (ORDER BY secondary_sort, date, updated) AS row
		FROM
			(
				SELECT
					bh_visit_id,
					c_invoice_id,
					c_payment_id,
					createdby,
					c_bpartner_id,
					date,
					created,
					updated,
					item,
					debits,
					credits,
					net,
							SUM(net) FILTER ( WHERE c_payment_docstatus IS NULL OR c_payment_docstatus IN ('CO', 'CL') )
						OVER (PARTITION BY c_bpartner_id ORDER BY CASE
							                                          WHEN c_payment_docstatus NOT IN ('CO', 'CL') THEN '-infinity'::timestamp
							                                          ELSE date END, updated ROWS UNBOUNDED PRECEDING) AS open_balance,
					2                                                                                              AS secondary_sort
				FROM
					transactions
				UNION ALL
				-- Add another row to show the starting balance of zero when the patient was created
				SELECT
					NULL,
					NULL,
					NULL,
					bp.createdby,
					bp.c_bpartner_id,
					CASE WHEN MIN(t.date) < bp.created THEN MIN(t.date) ELSE bp.created END,
					CASE WHEN MIN(t.date) < bp.created THEN MIN(t.date) ELSE bp.created END,
					CASE WHEN MIN(t.date) < bp.created THEN MIN(t.date) ELSE bp.created END,
					'Starting balance',
					0,
					0,
					0,
					0,
					1 AS sort
				FROM
					c_bpartner bp
						LEFT JOIN transactions t
							ON t.c_bpartner_id = bp.c_bpartner_id
				WHERE
					bp.c_bpartner_uu = _c_bpartner_uu
				GROUP BY bp.c_bpartner_id
			) AS orderings
	)
SELECT
	bp.c_bpartner_id,
	bp.name      AS patient_name,
	date         AS transaction_date,
	o.created,
	o.updated,
	item         AS item,
	debits,
	credits,
	open_balance AS patient_open_balance,
	bh_visit_id,
	c_invoice_id,
	c_payment_id,
	o.createdby
FROM
	orderings o
		JOIN c_bpartner bp
			ON o.c_bpartner_id = bp.c_bpartner_id
ORDER BY
	row;
$$;
