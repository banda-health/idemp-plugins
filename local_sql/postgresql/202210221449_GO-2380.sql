BEGIN;
DROP FUNCTION IF EXISTS bh_get_debt_payments(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE OR REPLACE FUNCTION bh_get_debt_payments(ad_client_id numeric, begin_date timestamp WITHOUT TIME ZONE,
                                                end_date timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        c_payment_id        numeric,
		        cashier_id          numeric,
		        cashier_uu          character varying,
		        cashier             character varying,
		        payment_date        timestamp,
		        patient_id          numeric,
		        patient_uu          character varying,
		        patient_name        character varying,
		        payment_mode_letter character varying,
		        payment_mode_name   character varying,
		        totalopenbalance    numeric,
		        payment_amount      numeric,
		        docstatus           character varying,
		        processing          character varying
	        )
	LANGUAGE sql
AS
$$
SELECT
	p.c_payment_id,
	cashier.ad_user_id    AS cashier_id,
	cashier.ad_user_uu    AS cashier_uu,
	cashier.name          AS cashier,
	p.datetrx             AS payment_date,
	bp.c_bpartner_id      AS patient_id,
	bp.c_bpartner_uu      AS patient_uu,
	bp.name               AS patient_name,
	p.tendertype::varchar AS payment_mode_letter,
	rl.name               AS payment_mode_name,
	bp.totalopenbalance   AS totalopenbalance,
	p.payamt              AS payment_amount,
	p.docstatus::varchar,
	p.processing::varchar
FROM
	c_payment p
		JOIN c_bpartner bp
			ON p.c_bpartner_id = bp.c_bpartner_id
		JOIN ad_ref_list rl
			ON p.tendertype = rl.value AND AD_Reference_ID = 214
		JOIN ad_user cashier
			ON p.createdby = cashier.ad_user_id
		LEFT JOIN c_allocationline al
			ON p.c_payment_id = al.c_payment_id
		LEFT JOIN c_allocationhdr ah
			ON al.c_allocationhdr_id = ah.c_allocationhdr_id
		LEFT JOIN c_invoice i
			ON al.c_invoice_id = i.c_invoice_id
		LEFT JOIN c_payment p2
			ON p.c_payment_id = p2.reversal_id
WHERE
	p.ad_client_id = $1
	AND (p.bh_c_order_id = 0 OR p.bh_c_order_id IS NULL)
	AND date(p.datetrx) BETWEEN date($2) AND date($3)
	AND (i.docstatus IS NULL OR i.docstatus NOT IN ('RE', 'RA', 'VO'))
	AND (ah.docstatus IS NULL OR ah.docstatus NOT IN ('RE', 'RA', 'VO'))
	AND p.reversal_id IS NULL
	AND p.docstatus NOT IN ('RE', 'VO')
	AND p2.c_payment_id IS NULL;
$$;

DROP FUNCTION IF EXISTS bh_get_visit_payments(NUMERIC, TIMESTAMP WITHOUT TIME ZONE, TIMESTAMP WITHOUT TIME ZONE);
CREATE OR REPLACE FUNCTION bh_get_visit_payments(ad_client_id numeric, begin_date timestamp WITHOUT TIME ZONE,
                                                 end_date timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        c_order_id        numeric,
		        bh_c_order_id     numeric,
		        ad_org_id         numeric,
		        c_payment_id      numeric,
		        payamt            numeric,
		        tendertype        character,
		        payment_mode_name character varying,
		        datetrx           timestamp WITHOUT TIME ZONE,
		        patient_id        numeric,
		        patient_name      character varying,
		        isallocated       character,
		        invoice_id        numeric,
		        cashier_id        numeric,
		        cashier           character varying,
		        cashier_uu        character varying,
		        docstatus         character,
		        processing        character,
		        linenetamt        numeric
	        )
	LANGUAGE sql
AS
$$
SELECT
	c.c_order_id,
	p.bh_c_order_id,
	c.ad_org_id,
	p.c_payment_id,
	p.payamt           AS payment_amount,
	p.tendertype       AS payment_mode_letter,
	r.name             AS payment_mode_name,
	p.datetrx          AS payment_date,
	p.c_bpartner_id    AS patient_id,
	cb.name            AS patient_name,
	p.isallocated,
	p.c_invoice_id     AS invoice_id,
	c.createdby        AS cashier_id,
	ad.name            AS cashier,
	ad.ad_user_uu      AS cashier_uu,
	c.docstatus        AS docstatus,
	c.processing       AS processing,
	SUM(ol.linenetamt) AS lineitemtotals
FROM
	c_payment p
		LEFT JOIN c_allocationline al
			ON p.c_payment_id = al.c_payment_id
		LEFT JOIN c_invoice i
			ON al.c_invoice_id = i.c_invoice_id
		JOIN c_order c
			ON i.c_order_id = c.c_order_id OR p.bh_c_order_id = c.c_order_id
		JOIN c_orderline ol
			ON c.c_order_id = ol.c_order_id
		JOIN c_bpartner cb
			ON c.c_bpartner_id = cb.c_bpartner_id
		JOIN ad_user ad
			ON c.createdby = ad.ad_user_id
		JOIN ad_ref_list r
			ON r.value = p.tendertype
		JOIN ad_reference a
			ON r.ad_reference_id = a.ad_reference_id
WHERE
	p.ad_client_id = $1
	AND ad_reference_uu = '7eca6283-86b9-4dff-9c40-786162a8be7a'
	AND ol.c_charge_id IS NULL
	AND c.issotrx = 'Y'
	AND c.bh_visitdate BETWEEN begin_date AND end_date
	AND (i.docstatus IS NULL OR i.docstatus NOT IN ('RE', 'RA', 'VO'))
	AND p.bh_c_order_id IS NOT NULL
	AND p.bh_c_order_id != 0
	AND p.docstatus NOT IN ('RE', 'VO')
	AND p.c_payment_id NOT IN (
	SELECT
		reversal_id
	FROM
		c_payment
	WHERE
		a.ad_client_id = $1
)
GROUP BY
	c.c_order_id, c.ad_org_id, p.payamt, p.tendertype, r.name, p.datetrx, cb.name, p.isallocated,
	p.c_invoice_id, c.createdby, ad.name, ad.ad_user_uu, c.docstatus, c.processing, p.bh_c_order_id, p.c_payment_id;
$$;

DROP FUNCTION IF EXISTS bh_get_payment_trail(character varying);
CREATE OR REPLACE FUNCTION bh_get_payment_trail(c_bpartner_uu character varying)
	RETURNS TABLE
	        (
		        c_bpartner_id         numeric,
		        patient_name          character varying,
		        payment_date          timestamp,
		        item                  text,
		        visit_charges         numeric,
		        visit_payments        numeric,
		        open_balance_payments numeric,
		        patient_open_balance  numeric
	        )
	LANGUAGE sql
AS
$$
WITH transactions AS (
	-- This categorizes the payments
	SELECT
		c_bpartner_id,
		date,
		items,
		charges,
		visit_payment,
		open_balance_payment,
		open_balance,
		ROW_NUMBER() OVER (ORDER BY sort, date) AS row
	FROM
		(
			SELECT
				c_bpartner_id,
				date,
				CASE
					WHEN charges = 0 AND visit_payment = 0 THEN 'Open balance payment only'
					ELSE 'Visit Charges and payments' END                                                      AS items,
				charges,
				visit_payment * -1                                                                           AS visit_payment,
				open_balance_payment * -1                                                                    AS open_balance_payment,
						SUM(line_total) OVER (PARTITION BY c_bpartner_id ORDER BY date ROWS UNBOUNDED PRECEDING) AS open_balance,
				2                                                                                            AS sort
			FROM
				(
					-- Sum all the payments and group them by date
					SELECT
						c_bpartner_id,
						date,
						SUM(charges)                                                  AS charges,
						SUM(visit_payment)                                            AS visit_payment,
						SUM(open_balance_payment)                                     AS open_balance_payment,
						SUM(charges) + SUM(visit_payment) + SUM(open_balance_payment) AS line_total
					FROM
						(
							-- Here's where payments are categorized
							SELECT
								c_bpartner_id,
								date,
								COALESCE(SUM(grandtotal) FILTER (WHERE type = 'Visit'), 0) AS charges,
								COALESCE(SUM(grandtotal)
								         FILTER (WHERE type = 'Bill Payment' OR type = 'Insurance, Waivers, and Deductions'),
								         0)                                                AS visit_payment,
								COALESCE(SUM(grandtotal) FILTER (WHERE type = 'Outstanding Balance Payment'),
								         0)                                                AS open_balance_payment
							FROM
								(
									-- Bills
									SELECT
										o.c_order_id,
										o.c_bpartner_id,
										date(o.bh_visitdate) AS date,
										'Visit'              AS "type",
										SUM(ol.linenetamt)   AS grandtotal,
										NULL                 AS tendertype,
										10                   AS sort
									FROM
										c_order o
											JOIN c_orderline ol
												ON o.c_order_id = ol.c_order_id
											JOIN c_bpartner bp
												ON o.c_bpartner_id = bp.c_bpartner_id
									WHERE
										o.issotrx = 'Y'
										AND o.docstatus = 'CO'
										AND ol.c_charge_id IS NULL
										AND bp.c_bpartner_uu = $1
									GROUP BY o.c_order_id, o.c_bpartner_id, date
									UNION ALL
									-- Insurance, waivers, and deductions
									SELECT
										o.c_order_id,
										o.c_bpartner_id,
										date(o.bh_visitdate)                 AS date,
										'Insurance, Waivers, and Deductions' AS "type",
										SUM(ol.linenetamt)                   AS grandtotal,
										NULL                                 AS tendertype,
										20                                   AS sort
									FROM
										c_order o
											JOIN c_orderline ol
												ON o.c_order_id = ol.c_order_id
											JOIN c_bpartner bp
												ON o.c_bpartner_id = bp.c_bpartner_id
											JOIN c_charge c
												ON ol.c_charge_id = c.c_charge_id
									WHERE
										o.issotrx = 'Y'
										AND o.docstatus = 'CO'
										AND bp.c_bpartner_uu = $1
									GROUP BY o.c_order_id, o.c_bpartner_id, date(o.bh_visitdate)
									UNION ALL
									-- Bill Payments
									SELECT
										p.bh_c_order_id AS c_order_id,
										p.c_bpartner_id,
										p.visit_date,
										-- CASE
										-- 	WHEN cp.tendertype IN ('M','MT') THEN 'Bill Payment - Mobile'
										-- 	WHEN cp.tendertype IN ('X') THEN 'Bill Payment - Cash'
										-- 	ELSE 'Bill Payment'
										-- END as "type",
										'Bill Payment'  AS "type",
										p.totalpayamt * -1,
										p.tendertype,
										30              AS sort
									FROM
										(
											SELECT
												gvp.c_payment_id,
												bp.c_bpartner_id,
												gvp.bh_c_order_id,
												date(o.bh_visitdate) AS visit_date,
												tendertype,
												SUM(gvp.payamt)      AS totalpayamt
											FROM
												c_bpartner bp
													JOIN bh_get_visit_payments(bp.ad_client_id, '-infinity'::timestamp, 'infinity'::timestamp) gvp
														ON gvp.patient_id = bp.c_bpartner_id
													JOIN c_order o
														ON gvp.bh_c_order_id = o.c_order_id
											WHERE
												bp.c_bpartner_uu = $1
											GROUP BY
												gvp.c_payment_id,
												bp.c_bpartner_id,
												bh_c_order_id,
												visit_date,
												tendertype
										) p
									UNION ALL
									-- Outstanding Balance Payments
									SELECT
										p.bh_c_order_id               AS c_order_id,
										p.c_bpartner_id,
										p.date,
										'Outstanding Balance Payment' AS "type",
										p.totalpayamt * -1,
										NULL                          AS tendertype,
										40                            AS sort
									FROM
										(
											SELECT
												c_payment_id,
												c_bpartner_id,
												NULL::numeric       AS bh_c_order_id,
												payment_date        AS date,
												SUM(payment_amount) AS totalpayamt
											FROM
												c_bpartner bp
													JOIN bh_get_debt_payments(bp.ad_client_id, '-infinity'::timestamp, 'infinity'::timestamp) gdp
														ON gdp.patient_id = bp.c_bpartner_id
											WHERE
												bp.c_bpartner_uu = $1
											GROUP BY
												c_payment_id,
												c_bpartner_id,
												bh_c_order_id,
												date
										) p
								) AS transactions
							GROUP BY
								c_bpartner_id,
								Date,
								type,
								grandtotal,
								sort
						) AS transactions
					GROUP BY
						c_bpartner_id,
						date
				) AS transactions
			UNION ALL
			-- Add another row to show the starting balance of zero when the patient was created
			SELECT
				c_bpartner_id,
				date(created) AS date,
				'Starting balance',
				0             AS charges,
				0             AS visit_payment,
				0             AS open_balance_payment,
				0             AS open_balance,
				1             AS sort
			FROM
				c_bpartner bp
			WHERE
				bp.c_bpartner_uu = $1
		) AS transactions
)
SELECT
	bp.c_bpartner_id,
	bp.name              AS patient_name,
	date                 AS payment_date,
	items                AS item,
	charges              AS visit_charges,
	visit_payment        AS visit_payments,
	open_balance_payment AS open_balance_payments,
	open_balance         AS patient_open_balance
FROM
	transactions
		JOIN c_bpartner bp
			ON transactions.c_bpartner_id = bp.c_bpartner_id
ORDER BY
	row;
$$;
COMMIT;

SELECT
	register_migration_script('202210221449_GO-2380.sql')
FROM
	dual;
