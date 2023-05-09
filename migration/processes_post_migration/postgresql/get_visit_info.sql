DROP FUNCTION IF EXISTS get_visit_info(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION get_visit_info(ad_client_id numeric,
                               begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                               end_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        bh_visit_id         numeric,
		        c_order_id          numeric,
		        c_bpartner_id       numeric,
		        bill_date           timestamptz,
		        cashier             character varying,
		        cashier_id          numeric,
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
	STABLE
	LANGUAGE sql
AS
$$
	-- Order Info
WITH OrderInfo AS (
	SELECT
		v.bh_visit_id,
		o.c_order_id,
		bp.c_bpartner_id,
		v.bh_visitdate           AS bill_date,
		u.name                   AS Cashier,
		u.ad_user_id            AS cashier_id,
		bp.name                  AS patientname,
		bp.bh_patientid          AS PatientNo,
		v.bh_patienttype         AS PatientType,
		SUM(ol.linenetamt)       AS lineitemtotals,
		STRING_AGG(p.name, ', ') AS product_list
	FROM
		bh_visit v
			INNER JOIN c_bpartner bp
				ON v.patient_id = bp.c_bpartner_id
			INNER JOIN ad_user u
				ON v.createdby = u.ad_user_id
			JOIN c_order o
				ON v.bh_visit_id = o.bh_visit_id
			JOIN c_orderline ol
				ON o.c_order_id = ol.c_order_id
			LEFT JOIN m_product p
				ON ol.m_product_id = p.m_product_id
	WHERE
		(
				(v.ad_client_id = $1)
				AND v.bh_visitdate BETWEEN $2 AND $3
				AND (o.docstatus <> 'VO' AND o.docstatus <> 'DR')
			)
		AND ol.c_charge_id IS NULL
	GROUP BY
		v.bh_visit_id, o.c_order_id, bp.c_bpartner_id, ol.c_charge_id, v.bh_visitdate, bp.name, u.name, bp.bh_patientid, u.ad_user_id
	ORDER BY 1
),
	patient_payments AS (
		SELECT
			p.bh_visit_id,
			SUM(p.payamt) FILTER ( WHERE tendertype = 'X' )                                AS cash,
			SUM(p.payamt) FILTER ( WHERE tendertype = 'M' )                                AS mobile,
			SUM(p.payamt) FILTER ( WHERE tendertype = 'C' )                                AS credit_debit,
			SUM(p.payamt) FILTER ( WHERE tendertype = 'D' )                                AS bank,
			SUM(p.payamt) FILTER ( WHERE tendertype = 'K' )                                AS checks,
			SUM(p.payamt) FILTER ( WHERE tendertype NOT IN ('I', 'D', 'W'))                AS TotalDirectPayments,
					SUM(p.payamt) FILTER ( WHERE tendertype NOT IN ('X', 'M', 'C', 'D', 'K') ) AS OtherNewPayments
		FROM
			bh_get_visit_payments($1, $2, $3) p
		GROUP BY p.bh_visit_id
	),
	non_patient_payments AS (
		SELECT
			ol.bh_visit_id,
			SUM(ol.linenetamt) FILTER ( WHERE ol.bh_subtype = 'I' ) * -1                   AS insurance,
			SUM(ol.linenetamt) FILTER ( WHERE ol.bh_subtype = 'W' ) * -1                   AS waiver,
			SUM(ol.linenetamt) FILTER ( WHERE ol.bh_subtype = 'D' ) * -1                   AS donation,
						SUM(ol.linenetamt) FILTER ( WHERE ol.bh_subtype IN ('D', 'W', 'I')) * -1 AS TotalNonPayments,
			member_id,
			MemberName,
			ClaimNo,
			Relationship
		FROM
			bh_get_visit_non_patient_payments($1, $2, $3) ol
		GROUP BY ol.bh_visit_id, olci.name, bci.name, olc.name, bol.name
	)
SELECT
	OrderInfo.bh_visit_id,
	OrderInfo.c_order_id,
	OrderInfo.c_bpartner_id,
	OrderInfo.bill_date,
	OrderInfo.Cashier,
	OrderInfo.cashier_id,
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
			ON OrderInfo.bh_visit_id = patient_payments.bh_visit_id
		LEFT JOIN non_patient_payments
			ON OrderInfo.bh_visit_id = non_patient_payments.bh_visit_id
ORDER BY
	date(OrderInfo.bill_date), OrderInfo.patientname;
$$;
