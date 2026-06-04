-- GO-3598: Speed up Patient Transactions report (and related financial reports)
--
-- Problem:
--   Patient Transactions calls bh_get_visit_details() several times per run (main list,
--   CashierCollections subreport, etc.). The prior implementation re-scanned bh_visit on
--   bh_visitdate only, then filtered ad_client_id in memory (~90k rows per month across
--   all tenants). Order line totals were aggregated in a subquery that Postgres often
--   executed once per visit (nested loop), which timed out on production (~5 min) on
--   CashierCollections.
--
-- Changes:
--   1. Composite index so visit lookups filter by client and date in the index.
--   2. Rewrite bh_get_visit_details to scan the date range once and hash-join totals.

-- Existing index bh_visit_bh_visitdate_index (bh_visitdate only) remains for other queries.
CREATE INDEX IF NOT EXISTS bh_visit_ad_client_bh_visitdate_idx
	ON bh_visit (ad_client_id, bh_visitdate);

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
	rl.name                                          AS bh_visittype_name,
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
		LEFT JOIN ad_ref_list rl
		ON rl.value = v.bh_visittype
		LEFT JOIN ad_reference r
		ON rl.ad_reference_id = r.ad_reference_id
		LEFT JOIN visit_diagnoses pd
		ON v.bh_visit_id = pd.bh_visit_id AND pd.diagnosis_rank = 1
		LEFT JOIN visit_diagnoses sd
		ON v.bh_visit_id = sd.bh_visit_id AND sd.diagnosis_rank = 2
WHERE
	-- BH_VisitType reference list (same filter as before rewrite).
	r.ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
	OR r.ad_reference_uu IS NULL;
$$;

SELECT
	register_migration_script('202606031200_GO-3598.sql')
FROM
	dual;
