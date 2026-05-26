-- Rename patient type to visit type on bh_visit and related metadata
ALTER TABLE bh_visit
	RENAME COLUMN bh_patienttype TO bh_visittype;

UPDATE ad_element
SET
	columnname = 'BH_VisitType',
	name = 'Visit Type',
	printname = 'Visit Type'
WHERE
	ad_element_uu = '5e3e6279-0c10-46b0-b889-801586fe436c';

UPDATE ad_element_trl
SET
	name = 'Visit Type',
	printname = 'Visit Type'
WHERE
	ad_element_id = (
		SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '5e3e6279-0c10-46b0-b889-801586fe436c'
	);

UPDATE ad_column
SET
	columnname = 'BH_VisitType',
	name = 'Visit Type'
WHERE
	ad_column_uu = '1a52b028-4e6d-434d-a8f4-43d9c5755423';

UPDATE ad_reference
SET
	name = 'BH_VisitType'
WHERE
	ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7';

UPDATE ad_field
SET
	name = 'Visit Type'
WHERE
	ad_column_id = (
		SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '1a52b028-4e6d-434d-a8f4-43d9c5755423'
	);

UPDATE ad_process_para
SET
	name = 'Visit Type',
	columnname = 'Visit Type'
WHERE
	name = 'Patient Type'
	OR columnname = 'Patient Type';

DROP FUNCTION IF EXISTS bh_get_visit_details(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION bh_get_visit_details(_ad_client_id numeric,
                                     _begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                     _end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        bh_visit_id                  numeric,
		        bh_visitdate                 timestamptz,
		        c_order_id                   numeric,
		        c_order_uu                   character varying,
		        ad_org_id                    numeric,
		        receipt_number               numeric,
		        ad_user_id                   numeric,
		        cashier_name                 character varying,
		        createdby_user_uu            character varying,
		        c_bpartner_id                numeric,
		        patient_name                 character varying,
		        bh_visittype               character varying,
		        bh_visittype_name          character varying,
		        bh_patientid                 character varying,
		        bh_birthday                  timestamp WITHOUT TIME ZONE,
		        bh_gender                    character varying,
		        bh_phone                     character varying,
		        primary_coded                numeric,
		        secondary_coded              numeric,
		        bh_primaryuncodeddiagnosis   character varying,
		        bh_secondaryuncodeddiagnosis character varying,
		        docstatus                    character,
		        bh_clinician_user_id         numeric,
		        processing                   character,
		        saleslineitemtotals          numeric,
		        salestotals                  numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH visit_diagnoses AS (
	SELECT
		v.bh_visit_id,
		ev.bh_concept_id,
		ev.bh_uncoded_diagnosis,
		ROW_NUMBER() OVER (PARTITION BY v.bh_visit_id ORDER BY lineno) AS diagnosis_rank
	FROM
		bh_visit v
			JOIN bh_encounter e
			ON v.bh_visit_id = e.bh_visit_id
			LEFT JOIN bh_encounter_diagnosis ev
			ON e.bh_encounter_id = ev.bh_encounter_id
	WHERE
		v.ad_client_id = _ad_client_id
		AND v.bh_visitdate BETWEEN _begin_date AND _end_date
)
SELECT
	v.bh_visit_id,
	v.bh_visitdate                                   AS visit_date,
	o.c_order_id,
	o.c_order_uu,
	v.ad_org_id,
	o.c_order_id                                     AS receipt_number,
	createdby_user.ad_user_id                        AS cashier_id,
	createdby_user.name                              AS cashier_name,
	createdby_user.ad_user_uu                        AS createdby_user_uu,
	v.patient_id                                     AS patient_id,
	bp.name                                          AS patient_name,
	v.bh_visittype                                 AS visit_type,
	rl.name                                          AS bh_visittype_name,
	COALESCE(bp.bh_local_patientid, bp.bh_patientid) AS bh_patientid,
	bp.bh_birthday                                   AS patient_birthday,
	bp.bh_gender                                     AS patient_gender,
	bp.bh_phone                                      AS patient_phoneNumber,
	pd.bh_concept_id				   AS primary_coded,
	sd.bh_concept_id                         	   AS secondary_coded,
	pd.bh_uncoded_diagnosis                          AS primary_uncoded,
	sd.bh_uncoded_diagnosis                          AS secondary_uncoded,
	o.docstatus                                      AS docstatus,
	v.bh_clinician_user_id                           AS clinician_id,
	o.processing                                     AS processing,
	saleslineitemtotals,
	salestotals
FROM
	bh_visit v
		JOIN c_order o
		ON v.bh_visit_id = o.bh_visit_id
		JOIN c_bpartner bp
		ON v.patient_id = bp.c_bpartner_id
		JOIN ad_user createdby_user
		ON v.createdby = createdby_user.ad_user_id
		LEFT JOIN ad_ref_list rl
		ON rl.value = v.bh_visittype
		LEFT JOIN ad_reference r
		ON rl.ad_reference_id = r.ad_reference_id
		LEFT JOIN visit_diagnoses pd
		ON v.bh_visit_id = pd.bh_visit_id AND pd.diagnosis_rank = 1
		LEFT JOIN visit_diagnoses sd
		ON v.bh_visit_id = sd.bh_visit_id AND sd.diagnosis_rank = 2
		JOIN (
		SELECT
			o.c_order_id,
			COALESCE(SUM(ol.linenetamt) FILTER ( WHERE ol.c_charge_id IS NULL ), 0) AS saleslineitemtotals,
			COALESCE(SUM(ol.linenetamt), 0)                                         AS salestotals
		FROM
			c_order o
				JOIN c_orderline ol
				ON o.c_order_id = ol.c_order_id
				JOIN bh_visit v
				ON o.bh_visit_id = v.bh_visit_id
		WHERE
			o.ad_client_id = _ad_client_id
			AND v.bh_visitdate BETWEEN _begin_date AND _end_date
		GROUP BY o.c_order_id
	) sales_details
		ON o.c_order_id = sales_details.c_order_id
WHERE
	v.bh_visitdate BETWEEN _begin_date AND _end_date
	AND v.ad_client_id = _ad_client_id
	AND (r.ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7' OR r.ad_reference_uu IS NULL);
$$;

-- Commented Code below might be needed in the future

-- DO
-- $$
-- 	BEGIN
-- 		IF EXISTS(SELECT
-- 			          1
-- 		          FROM
-- 			          information_schema.routines
-- 		          WHERE
-- 			          ROUTINE_SCHEMA = CURRENT_SCHEMA()
-- 			          AND ROUTINE_NAME = 'bh_get_visit_details') THEN
-- 			DROP FUNCTION bh_get_visit_details;
-- 		END IF;
-- 	END;
-- $$ LANGUAGE plpgsql;

DROP FUNCTION IF EXISTS bh_get_visit_info(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION bh_get_visit_info(ad_client_id numeric,
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
		        visittype         character varying,
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
		u.ad_user_id             AS cashier_id,
		bp.name                  AS patientname,
		bp.bh_patientid          AS PatientNo,
		v.bh_visittype         AS VisitType,
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
		v.bh_visit_id, o.c_order_id, bp.c_bpartner_id, ol.c_charge_id, v.bh_visitdate, bp.name, u.name, bp.bh_patientid,
		u.ad_user_id
	ORDER BY 1
),
	patient_payments AS (
		SELECT
			bh_visit_id,
			SUM(payamt) FILTER ( WHERE tendertype = 'X' )                            AS cash,
			SUM(payamt) FILTER ( WHERE tendertype = 'M' )                            AS mobile,
			SUM(payamt) FILTER ( WHERE tendertype = 'C' )                            AS credit_debit,
			SUM(payamt) FILTER ( WHERE tendertype = 'D' )                            AS bank,
			SUM(payamt) FILTER ( WHERE tendertype = 'K' )                            AS checks,
			SUM(payamt) FILTER ( WHERE tendertype NOT IN ('I', 'D', 'W'))            AS TotalDirectPayments,
			SUM(payamt) FILTER ( WHERE tendertype NOT IN ('X', 'M', 'C', 'D', 'K') ) AS OtherNewPayments
		FROM
			bh_get_visit_payments($1, $2, $3)
		GROUP BY bh_visit_id
	),
	non_patient_payments AS (
		SELECT
			bh_visit_id,
			SUM(linenetamt) FILTER ( WHERE bh_subtype = 'I' ) * -1             AS insurance,
			SUM(linenetamt) FILTER ( WHERE bh_subtype = 'W' ) * -1             AS waiver,
			SUM(linenetamt) FILTER ( WHERE bh_subtype = 'D' ) * -1             AS donation,
			SUM(linenetamt) FILTER ( WHERE bh_subtype IN ('D', 'W', 'I')) * -1 AS TotalNonPayments,
			member_id,
			MemberName,
			ClaimNo,
			Relationship
		FROM
			bh_get_visit_non_patient_payments($1, $2, $3)
		GROUP BY bh_visit_id, member_id, membername, claimno, relationship
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
	OrderInfo.VisitType::varchar,
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

DROP FUNCTION IF EXISTS bh_dashboard_get_visit_history_stats(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_visit_history_stats(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        bucket_value         timestamp,
		        ad_ref_list_id       numeric,
		        alternate_visit_type varchar,
		        frequency            numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH completed_visits AS (
	SELECT
		v.bh_visit_id,
		bpg.name != 'Patients - DO NOT CHANGE' AS is_otc
	FROM
		bh_visit v
			JOIN c_bpartner bp
			ON v.patient_id = bp.c_bpartner_id
			JOIN c_bp_group bpg
			ON bp.c_bp_group_id = bpg.c_bp_group_id
			JOIN c_order o
			ON v.bh_visit_id = o.bh_visit_id AND o.docstatus IN ('CO', 'CL')
	WHERE
		v.ad_client_id = _ad_client_id
		AND v.bh_visitdate BETWEEN _begin_date AND _end_date
),
	buckets_cte AS (
		SELECT
			CASE WHEN cv.is_otc = TRUE THEN NULL ELSE rl.ad_ref_list_id END AS ad_ref_list_id,
			CASE
				WHEN cv.is_otc = TRUE THEN 'Over the Counter (OTC)'
				WHEN v.bh_visittype IS NULL THEN 'None'
				END                                                           AS alternate_visit_type,
			WIDTH_BUCKET(EXTRACT(EPOCH FROM bh_visitdate), EXTRACT(EPOCH FROM _begin_date),
			             EXTRACT(EPOCH FROM _end_date), 6)                  AS bucket_number
		FROM
			bh_visit v
				JOIN completed_visits cv
				ON cv.bh_visit_id = v.bh_visit_id
				LEFT JOIN ad_ref_list rl
				ON v.bh_visittype = rl.value
				LEFT JOIN ad_reference r
				ON rl.ad_reference_id = r.ad_reference_id
		WHERE
			r.ad_reference_id IS NULL
			OR r.ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
	),
	bucket_mapping (bucket_number, bucket_value) AS (
		VALUES
			(1, _begin_date),
			(2, _end_date - (_end_date - _begin_date) * 5 / 6),
			(3, _end_date - (_end_date - _begin_date) * 4 / 6),
			(4, _end_date - (_end_date - _begin_date) * 3 / 6),
			(5, _end_date - (_end_date - _begin_date) * 2 / 6),
			(6, _end_date - (_end_date - _begin_date) / 6)
	)
SELECT
	bm.bucket_value,
	ad_ref_list_id,
	alternate_visit_type,
	COUNT(*) AS frequency
FROM
	bucket_mapping bm
		LEFT JOIN buckets_cte bcte
		ON bcte.bucket_number = bm.bucket_number
GROUP BY
	bm.bucket_value, ad_ref_list_id, alternate_visit_type;
$$;

DROP FUNCTION IF EXISTS bh_dashboard_get_financial_charge_type(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_charge_type(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        name						character varying,
	        	frequency        			numeric,
	        	type						character varying
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	mpc.name												AS name,
	SUM(bgvp.tender_amt)									AS charge,
	'Service'												AS type
FROM
	bh_get_visit_payments(_ad_client_id, _begin_date, _end_date) bgvp
JOIN c_order co
ON co.c_order_id = bgvp.c_order_id
JOIN c_orderline cl
ON cl.c_order_id = co.c_order_id
JOIN m_product m
ON m.m_product_id = cl.m_product_id
JOIN m_product_category mpc
ON mpc.m_product_category_id = m.m_product_category_id AND mpc.bh_product_category_type = 'S'
GROUP BY mpc.name
UNION ALL
SELECT
	arl.name												AS name,
	SUM(bgvp.tender_amt)									AS charge,
	'Patient'												AS type
FROM
	bh_get_visit_payments(_ad_client_id, _begin_date, _end_date) bgvp
JOIN bh_visit v
ON v.bh_visit_id = bgvp.bh_visit_id
JOIN ad_ref_list arl
ON arl.value = v.bh_visittype
JOIN ad_reference ar
ON ar.ad_reference_id = arl.ad_reference_id AND ar.ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
GROUP BY arl.name
$$;

SELECT
	register_migration_script('202605251200_GO-3582.sql')
FROM
	dual;
