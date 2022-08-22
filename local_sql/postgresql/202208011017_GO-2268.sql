-- Update some functions
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
		date(p1.created) AS date,
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
			name,
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
					name,
					date,
					CASE
						WHEN charges = 0 AND visit_payment = 0 THEN 'Open balance payment only'
						ELSE 'Visit Charges and payments' END                                             AS items,
					charges,
					visit_payment * -1                                                                  AS visit_payment,
					open_balance_payment * -1                                                           AS open_balance_payment,
							SUM(line_total) OVER (PARTITION BY name ORDER BY date ROWS UNBOUNDED PRECEDING) AS open_balance,
					2                                                                                   AS sort
				FROM
					(
						-- Sum all the payments and group them by date
						SELECT
							name,
							date,
							SUM(charges)                                                  AS charges,
							SUM(visit_payment)                                            AS visit_payment,
							SUM(open_balance_payment)                                     AS open_balance_payment,
							SUM(charges) + SUM(visit_payment) + SUM(open_balance_payment) AS line_total
						FROM
							(
								-- Here's where payments are categorized
								SELECT
									Name,
									Date,
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
											bp.name,
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
										GROUP BY o.c_order_id, bp.name, o.c_bpartner_id, date(o.bh_visitdate)
										UNION
										-- Insurance, waivers, and deductions
										SELECT
											o.c_order_id,
											bp.name,
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
												INNER JOIN c_bpartner bp
													ON o.c_bpartner_id = bp.c_bpartner_id
												JOIN c_charge c
													ON ol.c_charge_id = c.c_charge_id
										WHERE
											o.issotrx = 'Y'
											AND o.docstatus = 'CO'
											AND o.c_bpartner_id IN (
											SELECT
												c_bpartner_id
											FROM
												payments
										)
										GROUP BY o.c_order_id, bp.name, o.c_bpartner_id, date(o.bh_visitdate)
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
													date,
													tendertype,
													SUM(payamt) AS totalpayamt
												FROM
													payments
												GROUP BY
													c_payment_id,
													c_bpartner_id,
													bh_c_order_id,
													date,
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
										UNION
										-- Outstanding Balance Payments
										SELECT
											co.c_order_id,
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
													date,
													SUM(payamt) AS totalpayamt
												FROM
													payments
												GROUP BY
													c_payment_id,
													c_bpartner_id,
													bh_c_order_id,
													date
											) cp
												INNER JOIN c_bpartner bp
													ON cp.c_bpartner_id = bp.c_bpartner_id
												LEFT JOIN c_allocationline cal
													ON cal.c_payment_id = cp.c_payment_id
												LEFT JOIN c_invoice i
													ON i.c_invoice_id = cal.c_invoice_id
												LEFT JOIN c_order co
													ON i.c_order_id = co.c_order_id
												OR co.c_order_id = cp.bh_c_order_id
										WHERE
											co.issotrx IS NULL
											AND co.docstatus IS NULL
									) AS transactions
								GROUP BY
									Name,
									Date,
									type,
									grandtotal,
									sort,
									c_bpartner_id
							) AS transactions
						GROUP BY
							name,
							date
					) AS transactions
				UNION
				-- Add another row to show the starting balance of zero when the patient was created
				SELECT
					name,
					date(created) AS date,
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
	name                 AS patient_name,
	date                 AS payment_date,
	items                AS item,
	charges              AS visit_charges,
	visit_payment        AS visit_payments,
	open_balance_payment AS open_balance_payments,
	open_balance         AS patient_open_balance
FROM
	transactions
ORDER BY
	row;
$$;

CREATE OR REPLACE FUNCTION get_visit_info(ad_client_id numeric,
                                          begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                          end_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        c_order_id          numeric,
		        c_bpartner_id       numeric,
		        bill_date           timestamp WITHOUT TIME ZONE,
		        cashier             character varying,
		        patientname         character varying,
		        patientno           character varying,
		        patienttype         character varying,
		        member_id           character varying,
		        membername          character varying,
		        relationship        character varying,
		        claimno             character varying,
		        lineitemtotals      numeric,
		        product_list        text,
		        cash                numeric,
		        mobile              numeric,
		        credit_debit        numeric,
		        bank                numeric,
		        checks              numeric,
		        totaldirectpayments numeric,
		        othernewpayments    numeric,
		        insurance           numeric,
		        waiver              numeric,
		        donation            numeric,
		        totalnonpayments    numeric
	        )
	LANGUAGE sql
AS
$$
	-- Order Info
WITH OrderInfo AS (
	SELECT
		co.c_order_id,
		cb.c_bpartner_id,
--        ol.c_charge_id,
		co.bh_visitdate           AS bill_date,
		ad.name                   AS Cashier,
		cb.name                   AS patientname,
		cb.bh_patientid           AS PatientNo,
		co.bh_patienttype         AS PatientType,
		SUM(ol.linenetamt)        AS lineitemtotals,
		STRING_AGG(mp.name, ', ') AS product_list
	FROM
		c_order co
			INNER JOIN c_bpartner cb
				ON co.c_bpartner_id = cb.c_bpartner_id
			INNER JOIN ad_user ad
				ON co.createdby = ad.ad_user_id
			JOIN c_orderline ol
				ON co.c_order_id = ol.c_order_id
			LEFT JOIN m_product mp
				ON ol.m_product_id = mp.m_product_id
	WHERE
		(
				(co.ad_client_id = $1)
				AND (date(co.bh_visitdate) BETWEEN $2 AND $3)
				AND (co.docstatus <> 'VO' AND co.docstatus <> 'DR')
				AND issotrx = 'Y'
			)
		AND ol.c_charge_id IS NULL
	GROUP BY co.c_order_id, cb.c_bpartner_id, ol.c_charge_id, co.bh_visitdate, cb.name, ad.name
	ORDER BY 1
),
	patient_payments AS (
		SELECT
			p.bh_c_order_id                                                                AS c_order_id,
			SUM(p.payamt) FILTER ( WHERE tendertype = 'X' )                                AS cash,
			SUM(p.payamt) FILTER ( WHERE tendertype = 'M' )                                AS mobile,
			SUM(p.payamt) FILTER ( WHERE tendertype = 'C' )                                AS credit_debit,
			SUM(p.payamt) FILTER ( WHERE tendertype = 'D' )                                AS bank,
			SUM(p.payamt) FILTER ( WHERE tendertype = 'K' )                                AS checks,
			SUM(p.payamt) FILTER ( WHERE tendertype NOT IN ('I', 'D', 'W'))                AS TotalDirectPayments,
					SUM(p.payamt) FILTER ( WHERE tendertype NOT IN ('X', 'M', 'C', 'D', 'K') ) AS OtherNewPayments
		FROM
			c_payment p
		WHERE
			p.ad_client_id = $1
		GROUP BY p.bh_c_order_id
	),
	non_patient_payments AS (
		SELECT
			ol.c_order_id,
			SUM(ol.linenetamt) FILTER ( WHERE c.bh_subtype = 'I' ) * -1                   AS insurance,
			SUM(ol.linenetamt) FILTER ( WHERE c.bh_subtype = 'W' ) * -1                   AS waiver,
			SUM(ol.linenetamt) FILTER ( WHERE c.bh_subtype = 'D' ) * -1                   AS donation,
						SUM(ol.linenetamt) FILTER ( WHERE c.bh_subtype IN ('D', 'W', 'I')) * -1 AS TotalNonPayments,
			olci.name                                                                     AS member_id,
			bol.name                                                                      AS MemberName,
			olc.name                                                                      AS ClaimNo,
			bci.name                                                                      AS Relationship
		FROM
			c_orderline ol
				JOIN c_order o
					ON ol.c_order_id = o.c_order_id
				JOIN c_charge c
					ON ol.c_charge_id = c.c_charge_id
				LEFT JOIN (
				SELECT
					olci.c_orderline_id,
					olci.name
				FROM
					bh_orderline_charge_info olci
						JOIN bh_charge_info ci
							ON olci.bh_charge_info_id = ci.bh_charge_info_id
				WHERE
					(ci.name IN ('Member ID', 'NHIF Number') OR ci.name IS NULL)
			) AS olci
					ON olci.c_orderline_id = ol.c_orderline_id
				LEFT JOIN (
				SELECT
					bol.c_orderline_id,
					bol.name
				FROM
					bh_orderline_charge_info bol
						JOIN bh_charge_info ci
							ON bol.bh_charge_info_id = ci.bh_charge_info_id
				WHERE
					(ci.name IN ('Patient Name', 'Member Name') OR ci.name IS NULL)
			) bol
					ON bol.c_orderline_id = ol.c_orderline_id
				LEFT JOIN (
				SELECT
					olc.c_orderline_id,
					olc.name
				FROM
					bh_orderline_charge_info olc
						JOIN bh_charge_info ci
							ON olc.bh_charge_info_id = ci.bh_charge_info_id
				WHERE
					(ci.name IN ('Claim Number') OR ci.name IS NULL)
					AND (ci.bh_chargeinfodatatype = 'T' AND ci.bh_fillfrompatient = 'N')
			) olc
					ON olc.c_orderline_id = ol.c_orderline_id
				LEFT JOIN (
				SELECT
					bci.c_orderline_id,
					bci.name
				FROM
					bh_orderline_charge_info bci
						JOIN bh_charge_info ci
							ON bci.bh_charge_info_id = ci.bh_charge_info_id
				WHERE
					(ci.name IN ('Relationship') OR ci.name IS NULL)
					AND (ci.bh_chargeinfodatatype = 'L' AND ci.bh_fillfrompatient = 'Y')
			) bci
					ON bci.c_orderline_id = ol.c_orderline_id
		WHERE
			o.ad_client_id = $1
			AND (date(o.bh_visitdate) BETWEEN $2 AND $3)
		GROUP BY ol.c_order_id, olci.name, bci.name, olc.name, bol.name
	)
SELECT
	OrderInfo.c_order_id,
	OrderInfo.c_bpartner_id,
	OrderInfo.bill_date,
	OrderInfo.Cashier,
	OrderInfo.patientname,
	OrderInfo.PatientNo,
	OrderInfo.PatientType::varchar,
	non_patient_payments.member_id,
	non_patient_payments.MemberName,
	non_patient_payments.Relationship,
	non_patient_payments.ClaimNo,
	OrderInfo.lineitemtotals,
	OrderInfo.product_list,
	COALESCE(patient_payments.cash, 0)                 AS cash,
	COALESCE(patient_payments.mobile, 0)               AS mobile,
	COALESCE(patient_payments.credit_debit, 0)         AS credit_debit,
	COALESCE(patient_payments.bank, 0)                 AS bank,
	COALESCE(patient_payments.checks, 0)               AS checks,
	COALESCE(patient_payments.TotalDirectPayments, 0)  AS TotalDirectPayments,
	COALESCE(patient_payments.OtherNewPayments, 0)     AS OtherNewPayments,
	COALESCE(non_patient_payments.insurance, 0)        AS insurance,
	COALESCE(non_patient_payments.waiver, 0)           AS waiver,
	COALESCE(non_patient_payments.donation, 0)         AS donation,
	COALESCE(non_patient_payments.TotalNonPayments, 0) AS TotalNonPayments
FROM
	OrderInfo
		LEFT JOIN patient_payments
			ON OrderInfo.c_order_id = patient_payments.c_order_id
		LEFT JOIN non_patient_payments
			ON OrderInfo.c_order_id = non_patient_payments.c_order_id
ORDER BY
	date(OrderInfo.bill_date), OrderInfo.patientname;
$$;

CREATE OR REPLACE FUNCTION bh_get_visit_details(ad_client_id numeric,
                                                begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                                end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        bh_visitdate                  timestamp WITHOUT TIME ZONE,
		        c_order_id                    numeric,
		        c_order_uu                    character varying,
		        ad_org_id                     numeric,
		        receipt_number                numeric,
		        ad_user_id                    numeric,
		        cashier_name                  character varying,
		        c_bpartner_id                 numeric,
		        patient_name                  character varying,
		        bh_patienttype                character varying,
		        bh_patienttype_name           character varying,
		        bh_patientid                  character varying,
		        bh_birthday                   timestamp WITHOUT TIME ZONE,
		        bh_gender                     character varying,
		        bh_phone                      character varying,
		        bh_primarycodeddiagnosis_id   numeric,
		        bh_secondarycodeddiagnosis_id numeric,
		        bh_primaryuncodeddiagnosis    character varying,
		        bh_secondaryuncodeddiagnosis  character varying,
		        docstatus                     character,
		        bh_clinician_user_id          numeric,
		        processing                    character
	        )
	LANGUAGE sql
AS
$$
SELECT
	c.bh_visitdate                  AS visit_date,
	c.c_order_id,
	c.c_order_uu,
	c.ad_org_id,
	c.c_order_id                    AS receipt_number,
	ad.ad_user_id                   AS cashier_id,
	ad.name                         AS cashier_name,
	cb.c_bpartner_id                AS patient_id,
	cb.name                         AS patient_name,
	c.bh_patienttype::varchar       AS patient_type,
	r.name                          AS bh_patienttype_name,
	cb.bh_patientid                 AS patient_no,
	cb.bh_birthday                  AS patient_birthday,
	cb.bh_gender                    AS patient_gender,
	cb.bh_phone                     AS patient_phoneNumber,
	c.bh_primarycodeddiagnosis_id   AS primary_coded,
	c.bh_secondarycodeddiagnosis_id AS secondary_coded,
	c.bh_primaryuncodeddiagnosis    AS primary_uncoded,
	c.bh_secondaryuncodeddiagnosis  AS secondary_uncoded,
	c.docstatus                     AS docstatus,
	c.bh_clinician_user_id          AS clinician_id,
	c.processing                    AS processing
FROM
	c_order c
		JOIN c_bpartner cb
			ON c.c_bpartner_id = cb.c_bpartner_id
		JOIN ad_user ad
			ON c.createdby = ad.ad_user_id
		JOIN ad_ref_list r
			ON r.value = c.bh_patienttype
		JOIN ad_reference a
			ON r.ad_reference_id = a.ad_reference_id
WHERE
	c.bh_visitdate BETWEEN $2 AND $3
	AND c.ad_client_id = $1
	AND ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
	AND c.issotrx = 'Y';
$$;

SELECT register_migration_script('202208011017_GO-2268.sql') FROM dual;
