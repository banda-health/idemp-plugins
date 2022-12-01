DROP FUNCTION IF EXISTS get_visit_info(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
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
				AND co.bh_visitdate BETWEEN $2 AND $3
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
			AND o.bh_visitdate BETWEEN $2 AND $3
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