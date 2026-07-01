-- GO-3644: Speed up Non Patient Payment Report
--
-- Problem:
--   The report was timing out (~24 min actual, 300s nginx limit). Three bottlenecks:
--
--   1. bh_get_visit_non_patient_payments: the ClaimNo and Relationship LEFT JOINs on
--      bh_bp_specific_payer_info (662K rows) ran as nested loops — one full seq scan
--      per invoice line (1,137 lines × 662K rows = 750M rows processed, ~580s).
--
--   2. Report WHERE subquery had an unused LEFT JOIN c_bpartner that forced
--      1.58M index lookups with 717M heap fetches (~544s). Fixed in the .jrxml.
--
--   3. bh_get_visit_details: LEFT JOIN ad_ref_list (1,626 rows) × all visits then
--      probed ad_reference per combination (125M pkey lookups, ~237s). Fixed below.

-- Fix 1: index so bh_bp_specific_payer_info joins use index scan inside the loop.
CREATE INDEX IF NOT EXISTS bh_bp_specific_payer_info_c_invoiceline_id_idx
	ON bh_bp_specific_payer_info (c_invoiceline_id);

-- Fix 3: rewrite bh_get_visit_details to pre-filter ad_ref_list to the visit-type
-- reference UUID before joining to visits, eliminating the 125M ad_reference lookups.
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
		        bh_visittype                 character varying,
		        bh_visittype_name            character varying,
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
WITH
	-- Single pass over visits for this client and report date range.
	visits_in_range AS (
	SELECT
		v.bh_visit_id,
		v.bh_visitdate,
		v.ad_org_id,
		v.patient_id,
		v.bh_visittype,
		v.bh_clinician_user_id,
		v.createdby
	FROM
		bh_visit v
	WHERE
		v.ad_client_id = _ad_client_id
		AND v.bh_visitdate BETWEEN _begin_date AND _end_date
),
	-- Diagnoses limited to visits in range (avoids a separate full bh_visit scan).
	visit_diagnoses AS (
	SELECT
		v.bh_visit_id,
		ev.bh_concept_id,
		ev.bh_uncoded_diagnosis,
		ROW_NUMBER() OVER (PARTITION BY v.bh_visit_id ORDER BY ev.lineno) AS diagnosis_rank
	FROM
		visits_in_range v
			JOIN bh_encounter e
			ON v.bh_visit_id = e.bh_visit_id
			LEFT JOIN bh_encounter_diagnosis ev
			ON e.bh_encounter_id = ev.bh_encounter_id
),
	-- Order line totals aggregated once per c_order_id, then joined (not per output row).
	sales_details AS (
	SELECT
		o.c_order_id,
		COALESCE(SUM(ol.linenetamt) FILTER ( WHERE ol.c_charge_id IS NULL ), 0) AS saleslineitemtotals,
		COALESCE(SUM(ol.linenetamt), 0)                                         AS salestotals
	FROM
		c_order o
			JOIN c_orderline ol
			ON o.c_order_id = ol.c_order_id
			JOIN visits_in_range v
			ON o.bh_visit_id = v.bh_visit_id
	WHERE
		o.ad_client_id = _ad_client_id
	GROUP BY
		o.c_order_id
),
	-- Pre-filter ref_list to only visit-type entries, evaluated once instead of per visit.
	visit_type_names AS (
	SELECT
		rl.value,
		rl.name
	FROM
		ad_ref_list rl
			JOIN ad_reference r
			ON rl.ad_reference_id = r.ad_reference_id
	WHERE
		r.ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
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
	v.bh_visittype                                   AS visit_type,
	vtn.name                                         AS bh_visittype_name,
	COALESCE(bp.bh_local_patientid, bp.bh_patientid) AS bh_patientid,
	bp.bh_birthday                                   AS patient_birthday,
	bp.bh_gender                                     AS patient_gender,
	bp.bh_phone                                      AS patient_phoneNumber,
	pd.bh_concept_id                                 AS primary_coded,
	sd.bh_concept_id                                 AS secondary_coded,
	pd.bh_uncoded_diagnosis                          AS primary_uncoded,
	sd.bh_uncoded_diagnosis                          AS secondary_uncoded,
	o.docstatus                                      AS docstatus,
	v.bh_clinician_user_id                           AS clinician_id,
	o.processing                                     AS processing,
	sales_details.saleslineitemtotals,
	sales_details.salestotals
FROM
	visits_in_range v
		JOIN c_order o
		ON v.bh_visit_id = o.bh_visit_id
		JOIN sales_details
		ON o.c_order_id = sales_details.c_order_id
		JOIN c_bpartner bp
		ON v.patient_id = bp.c_bpartner_id
		JOIN ad_user createdby_user
		ON v.createdby = createdby_user.ad_user_id
		LEFT JOIN visit_type_names vtn
		ON vtn.value = v.bh_visittype
		LEFT JOIN visit_diagnoses pd
		ON v.bh_visit_id = pd.bh_visit_id AND pd.diagnosis_rank = 1
		LEFT JOIN visit_diagnoses sd
		ON v.bh_visit_id = sd.bh_visit_id AND sd.diagnosis_rank = 2;
$$;

SELECT
	register_migration_script('202607011653_GO-3644.sql')
FROM
	dual;
