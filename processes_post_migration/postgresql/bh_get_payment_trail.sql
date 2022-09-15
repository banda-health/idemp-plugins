DROP FUNCTION bh_get_payment_trail(character varying);
CREATE OR REPLACE FUNCTION bh_get_payment_trail(c_bpartner_uu character varying)
	RETURNS TABLE
	        (
		        patient_name          character varying,
		        payment_date          date,
		        item                  text,
		        visit_charges         numeric,
		        visit_payments        numeric,
		        open_balance_payments numeric,
		        patient_open_balance  numeric
	        )
	LANGUAGE sql
AS
$$
WITH payments AS (
	-- Get all payments made by a person, except those that were reversed
	SELECT
		p1.c_payment_id,
		p1.c_bpartner_id,
		p1.bh_c_order_id,
		DATE(p1.created) AS DATE,
		p1.tendertype,
		p1.payamt
	FROM
		c_payment p1
			INNER JOIN c_bpartner bp
				ON p1.c_bpartner_id = bp.c_bpartner_id
			LEFT JOIN c_payment p2
				ON p2.docstatus = 'RE'
			AND p2.reversal_id = p1.c_payment_id
			AND p1.c_bpartner_id = p2.c_bpartner_id
	WHERE
		bp.c_bpartner_uu = $1
		AND p1.payamt IS NOT NULL
		AND p2.c_payment_id IS NULL
		AND p1.docstatus != 'RE'
),
	transactions AS (
		-- This categorizes the payments
		SELECT
			NAME,
			DATE,
			items,
			charges,
			visit_payment,
			open_balance_payment,
			open_balance,
			ROW_NUMBER() OVER (ORDER BY sort, DATE) AS ROW
		FROM
			(
				SELECT
					NAME,
					DATE,
					CASE
						WHEN charges = 0 AND visit_payment = 0 THEN 'Open balance payment only'
						ELSE 'Visit Charges and payments' END                                             AS items,
					charges,
					visit_payment * -1                                                                  AS visit_payment,
					open_balance_payment * -1                                                           AS open_balance_payment,
							SUM(line_total) OVER (PARTITION BY NAME ORDER BY DATE ROWS UNBOUNDED PRECEDING) AS open_balance,
					2                                                                                   AS sort
				FROM
					(
						-- Sum all the payments and group them by date
						SELECT
							NAME,
							DATE,
							SUM(charges)                                                  AS charges,
							SUM(visit_payment)                                            AS visit_payment,
							SUM(open_balance_payment)                                     AS open_balance_payment,
							SUM(charges) + SUM(visit_payment) + SUM(open_balance_payment) AS line_total
						FROM
							(
								-- Here's where payments are categorized
								SELECT
									NAME,
									DATE,
									COALESCE(SUM(grandtotal) FILTER (WHERE TYPE = 'Visit'), 0) AS charges,
									COALESCE(SUM(grandtotal)
									         FILTER (WHERE TYPE = 'Bill Payment' OR TYPE = 'Insurance, Waivers, and Deductions'),
									         0)                                                AS visit_payment,
									COALESCE(SUM(grandtotal) FILTER (WHERE TYPE = 'Outstanding Balance Payment'),
									         0)                                                AS open_balance_payment
								FROM
									(
										-- Bills
										SELECT
											o.c_order_id,
											bp.name,
											o.c_bpartner_id,
											DATE(o.bh_visitdate) AS DATE,
											'Visit'              AS "type",
											SUM(ol.linenetamt)   AS grandtotal,
											NULL                 AS tendertype,
											10                   AS sort
										FROM
											c_order o
												JOIN c_orderline ol
													ON o.c_order_id = ol.c_order_id
												INNER JOIN c_bpartner bp
													ON o.c_bpartner_id = bp.c_bpartner_id
										WHERE
											o.issotrx = 'Y'
											AND o.docstatus = 'CO'
											AND ol.c_charge_id IS NULL
											AND o.c_bpartner_id IN (
											SELECT
												c_bpartner_id
											FROM
												payments
										)
										GROUP BY o.c_order_id, bp.name, o.c_bpartner_id, DATE(o.bh_visitdate)
										UNION
										-- Insurance, waivers, and deductions
										SELECT
											o.c_order_id,
											bp.name,
											o.c_bpartner_id,
											DATE(o.bh_visitdate)                 AS DATE,
											'Insurance, Waivers, and Deductions' AS "type",
											SUM(ol.linenetamt)                   AS grandtotal,
											NULL                                 AS tendertype,
											20                                   AS sort
										FROM
											c_order o
												JOIN c_orderline ol
													ON o.c_order_id = ol.c_order_id
												INNER JOIN c_bpartner bp
													ON o.c_bpartner_id = bp.c_bpartner_id
												JOIN c_charge C
													ON ol.c_charge_id = C.c_charge_id
										WHERE
											o.issotrx = 'Y'
											AND o.docstatus = 'CO'
											AND o.c_bpartner_id IN (
											SELECT
												c_bpartner_id
											FROM
												payments
										)
										GROUP BY o.c_order_id, bp.name, o.c_bpartner_id, DATE(o.bh_visitdate)
										UNION
										-- Bill Payments
										SELECT
											co.c_order_id,
											bp.name,
											cp.c_bpartner_id,
											cp.date,
											-- CASE
											-- 	WHEN cp.tendertype IN ('M','MT') THEN 'Bill Payment - Mobile'
											-- 	WHEN cp.tendertype IN ('X') THEN 'Bill Payment - Cash'
											-- 	ELSE 'Bill Payment'
											-- END as "type",
											'Bill Payment' AS "type",
											cp.totalpayamt * -1,
											cp.tendertype,
											30             AS sort
										FROM
											(
												SELECT
													c_payment_id,
													c_bpartner_id,
													bh_c_order_id,
													DATE,
													tendertype,
													SUM(payamt) AS totalpayamt
												FROM
													payments
												GROUP BY
													c_payment_id,
													c_bpartner_id,
													bh_c_order_id,
													DATE,
													tendertype
											) cp
												INNER JOIN c_bpartner bp
													ON cp.c_bpartner_id = bp.c_bpartner_id
												LEFT JOIN c_allocationline cal
													ON cal.c_payment_id = cp.c_payment_id
												LEFT JOIN c_invoice i
													ON i.c_invoice_id = cal.c_invoice_id
												INNER JOIN c_order co
													ON i.c_order_id = co.c_order_id
												OR co.c_order_id = cp.bh_c_order_id
										WHERE
											co.issotrx = 'Y'
											AND co.docstatus = 'CO'
											AND cp.bh_c_order_id IS NOT NULL
										UNION
										-- Outstanding Balance Payments
										SELECT
											cp.bh_c_order_id              AS c_order_id,
											bp.name,
											cp.c_bpartner_id,
											cp.date,
											'Outstanding Balance Payment' AS "type",
											cp.totalpayamt * -1,
											NULL                          AS tendertype,
											40                            AS sort
										FROM
											(
												SELECT
													c_payment_id,
													c_bpartner_id,
													bh_c_order_id,
													DATE,
													SUM(payamt) AS totalpayamt
												FROM
													payments
												GROUP BY
													c_payment_id,
													c_bpartner_id,
													bh_c_order_id,
													DATE
											) cp
												INNER JOIN c_bpartner bp
													ON cp.c_bpartner_id = bp.c_bpartner_id
										WHERE
											cp.bh_c_order_id IS NULL
									) AS transactions
								GROUP BY
									NAME,
									DATE,
									TYPE,
									grandtotal,
									sort,
									c_bpartner_id
							) AS transactions
						GROUP BY
							NAME,
							DATE
					) AS transactions
				UNION
				-- Add another row to show the starting balance of zero when the patient was created
				SELECT
					NAME,
					DATE(created) AS DATE,
					'Starting balance',
					0             AS charges,
					0             AS visit_payment,
					0             AS open_balance_payment,
					0             AS open_balance,
					1             AS sort
				FROM
					c_bpartner bp
						JOIN payments p
							ON p.c_bpartner_id = bp.c_bpartner_id
			) AS transactions
	)
SELECT
	NAME                 AS patient_name,
	DATE                 AS payment_date,
	items                AS item,
	charges              AS visit_charges,
	visit_payment        AS visit_payments,
	open_balance_payment AS open_balance_payments,
	open_balance         AS patient_open_balance
FROM
	transactions
ORDER BY
	ROW;
$$;