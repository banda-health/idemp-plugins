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
		        bh_patienttype               character varying,
		        bh_patienttype_name          character varying,
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
		ev.bh_coded_diagnosis_id,
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
	v.bh_patienttype                                 AS patient_type,
	rl.name                                          AS bh_patienttype_name,
	COALESCE(bp.bh_local_patientid, bp.bh_patientid) AS bh_patientid,
	bp.bh_birthday                                   AS patient_birthday,
	bp.bh_gender                                     AS patient_gender,
	bp.bh_phone                                      AS patient_phoneNumber,
	pd.bh_coded_diagnosis_id                         AS primary_coded,
	sd.bh_coded_diagnosis_id                         AS secondary_coded,
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
		ON rl.value = v.bh_patienttype
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
