DROP FUNCTION IF EXISTS bh_get_payment_trail(character varying);
CREATE FUNCTION bh_get_payment_trail(_c_bpartner_uu character varying)
	RETURNS TABLE
	        (
		        c_bpartner_id        numeric,
		        patient_name         character varying,
		        transaction_date     timestamp WITHOUT TIME ZONE,
		        item                 text,
		        debits               numeric,
		        credits              numeric,
		        patient_open_balance numeric
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
			transactions.c_bpartner_id,
			transactions.date,
			transactions."type"                                                              AS item,
			COALESCE(SUM(transactions.debits), 0)                                            AS debits,
			COALESCE(SUM(transactions.credits), 0)                                           AS credits,
				COALESCE(SUM(transactions.debits), 0) - COALESCE(SUM(transactions.credits), 0) AS net,
			transactions.sort
		FROM
			(
				-- Bills
				SELECT
					o.c_bpartner_id,
					date(o.bh_visitdate)                                 AS date,
					CASE
						WHEN COALESCE(SUM(vp.payamt), 0) - COALESCE(i.charges, 0) = 0 THEN 'Visit'
						ELSE 'Visit charges and payments' END              AS "type",
					i.non_charges                                        AS debits,
						COALESCE(SUM(vp.payamt), 0) - COALESCE(i.charges, 0) AS credits,
					10                                                   AS sort
				FROM
					c_order o
						JOIN c_bpartner bp
							ON o.c_bpartner_id = bp.c_bpartner_id
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
						o.issotrx = 'Y'
					AND o.docstatus = 'CO'
					AND bp.c_bpartner_uu = _c_bpartner_uu
				GROUP BY o.c_order_id, o.c_bpartner_id, date, non_charges, charges
				UNION ALL
				-- Outstanding Balance Payments
				SELECT
					bp.c_bpartner_id,
					date(gdp.payment_date)        AS date,
					'Outstanding Balance Payment' AS "type",
					NULL                          AS debits,
					SUM(payment_amount)           AS credits,
					20                            AS sort
				FROM
					c_bpartner bp
						JOIN bh_get_debt_payments(bp.ad_client_id, '-infinity'::timestamp, 'infinity'::timestamp) gdp
							ON gdp.patient_id = bp.c_bpartner_id
				WHERE
						bp.c_bpartner_uu = _c_bpartner_uu
				GROUP BY
					bp.c_bpartner_id,
					date
				UNION ALL
				-- Waived open balance
				SELECT
					i.c_bpartner_id,
					date(i.dateinvoiced)    AS date,
					'Waived Open Balance'   AS "type",
					NULL                    AS debits,
						SUM(il.linenetamt) * -1 AS credits,
					30                      AS sort
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
					i.c_invoice_id,
					bp.c_bpartner_id, dateinvoiced
			) AS transactions
		GROUP BY
			transactions.c_bpartner_id,
			transactions.date,
			transactions."type",
			transactions.sort
	),
	orderings AS (
-- This categorizes the payments
		SELECT
			orderings.*,
					ROW_NUMBER() OVER (ORDER BY secondary_sort, date, sort) AS row
		FROM
			(
				SELECT
					transactions.c_bpartner_id,
					transactions.date,
					transactions.item,
					transactions.debits,
					transactions.credits,
					transactions.net,
							SUM(transactions.net)
							OVER (PARTITION BY transactions.c_bpartner_id ORDER BY transactions.date, transactions.sort ROWS UNBOUNDED PRECEDING) AS open_balance,
					transactions.sort,
					2                                                                                                                         AS secondary_sort
				FROM
					transactions
				UNION ALL
				-- Add another row to show the starting balance of zero when the patient was created
				SELECT
					bp.c_bpartner_id,
					CASE WHEN MIN(t.date) < bp.created THEN MIN(t.date) ELSE bp.created END,
					'Starting balance',
					0,
					0,
					0,
					0,
					0,
					1 AS sort
				FROM
					c_bpartner bp
						JOIN transactions t
							ON t.c_bpartner_id = bp.c_bpartner_id
				GROUP BY bp.c_bpartner_id
			) AS orderings
	)
SELECT
	bp.c_bpartner_id,
	bp.name      AS patient_name,
	date         AS transaction_date,
	item         AS item,
	debits,
	credits,
	open_balance AS patient_open_balance
FROM
	orderings o
		JOIN c_bpartner bp
			ON o.c_bpartner_id = bp.c_bpartner_id
ORDER BY
	row;
$$;
