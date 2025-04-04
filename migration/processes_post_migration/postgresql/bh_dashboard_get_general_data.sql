DROP FUNCTION IF EXISTS bh_dashboard_get_general_data(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_general_data(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        total_patients_service        numeric,
		        new_patients_registered       numeric,
		        avg_num_of_products_delivered numeric,
		        average_charge_per_patient    numeric,
		        average_product_turnover      numeric,
		        percent_vitals_tracked        numeric,
		        percent_diagnoses_coded       numeric,
		        percent_notes                 numeric,
		        percent_completed_labs        numeric,
		        percent_visit_completed       numeric
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
)
SELECT
	tot_p.ct         AS total_patients_service,
	new_p.ct         AS new_patients_registered,
	avg_pr.avg       AS avg_num_of_products_delivered,
	avg_chg.avg      AS average_charge_per_patient,
	prd_turn.avg     AS average_product_turnover,
	doc_quality.ct_v AS percent_vitals_tracked,
	doc_quality.ct_d AS percent_diagnoses_coded,
	doc_quality.ct_n AS percent_notes,
	labs.ct          AS percent_completed_labs,
	v_per.ct         AS percent_visit_completed
FROM
	(
		SELECT
			COUNT(v.*) AS ct
		FROM
			bh_visit v
				JOIN completed_visits cv
				ON v.bh_visit_id = cv.bh_visit_id AND is_otc = FALSE
	) tot_p
		CROSS JOIN (
		SELECT
			COUNT(*) AS ct
		FROM
			c_bpartner bp
				JOIN c_bp_group bpg
				ON bp.c_bp_group_id = bpg.c_bp_group_id AND bpg.name = 'Patients - DO NOT CHANGE'
		WHERE
			bp.ad_client_id = _ad_client_id
			AND bp.created BETWEEN _begin_date AND _end_date
	) new_p
		CROSS JOIN (
		SELECT
			COALESCE(AVG(ct), 0) AS avg
		FROM
			(
				SELECT
					v.bh_visit_id,
					COUNT(*) AS ct
				FROM
					bh_visit v
						JOIN completed_visits cv
						ON v.bh_visit_id = cv.bh_visit_id
						JOIN c_order o
						ON v.bh_visit_id = o.bh_visit_id
						JOIN c_orderline ol
						ON o.c_order_id = ol.c_order_id
				GROUP BY v.bh_visit_id
			) v_ct
	) avg_pr
		CROSS JOIN (
		SELECT
			COALESCE(AVG(o.grandtotal), 0) AS avg
		FROM
			bh_visit v
				JOIN completed_visits cv
				ON v.bh_visit_id = cv.bh_visit_id
				JOIN c_order o
				ON v.bh_visit_id = o.bh_visit_id
	) avg_chg
		CROSS JOIN (
		SELECT
			COALESCE(EXTRACT(DAY FROM AVG(t.movementdate - t_r.movementdate)), 0) AS avg
		FROM
			m_transaction t
				JOIN m_transaction t_r
				ON t.m_product_id = t_r.m_product_id AND t.m_attributesetinstance_id = t_r.m_attributesetinstance_id AND
				   t_r.movementtype = 'V+' AND t_r.movementqty > 0
		WHERE
			t.ad_client_id = _ad_client_id
			AND t.movementdate BETWEEN _begin_date AND _end_date
			AND t.movementtype = 'C-'
	) prd_turn
		CROSS JOIN (
		SELECT
			COALESCE((COUNT(v_v.*) FILTER ( WHERE v_v.bh_visit_id IS NOT NULL ))::numeric / NULLIF(COUNT(v.*)::numeric, 0),
			         0) AS ct_v,
			COALESCE((COUNT(v_d.*) FILTER ( WHERE v_d.bh_visit_id IS NOT NULL ))::numeric / NULLIF(COUNT(v.*)::numeric, 0),
			         0) AS ct_d,
			COALESCE((COUNT(v_n.*) FILTER ( WHERE v_n.bh_visit_id IS NOT NULL ))::numeric / NULLIF(COUNT(v.*)::numeric, 0),
			         0) AS ct_n
		FROM
			bh_visit v
				JOIN completed_visits cv
				ON v.bh_visit_id = cv.bh_visit_id AND is_otc = FALSE
				LEFT JOIN (
				SELECT DISTINCT
					v.bh_visit_id
				FROM
					bh_visit v
						JOIN completed_visits cv
						ON v.bh_visit_id = cv.bh_visit_id AND is_otc = FALSE
						JOIN bh_encounter e
						ON e.bh_visit_id = v.bh_visit_id AND e.bh_encounter_type = 'V'
						JOIN bh_observation o
						ON e.bh_encounter_id = o.bh_encounter_id AND o.bh_value != ''
			) v_v
				ON v.bh_visit_id = v_v.bh_visit_id
				LEFT JOIN (
				SELECT DISTINCT
					v.bh_visit_id
				FROM
					bh_visit v
						JOIN completed_visits cv
						ON v.bh_visit_id = cv.bh_visit_id AND is_otc = FALSE
						JOIN bh_encounter e
						ON e.bh_visit_id = v.bh_visit_id AND e.bh_encounter_type = 'D'
						JOIN bh_encounter_diagnosis ed
						ON e.bh_encounter_id = ed.bh_encounter_id AND ed.bh_concept_id IS NOT NULL
			) v_d
				ON v.bh_visit_id = v_d.bh_visit_id
				LEFT JOIN (
				SELECT DISTINCT
					v.bh_visit_id
				FROM
					bh_visit v
						JOIN completed_visits cv
						ON v.bh_visit_id = cv.bh_visit_id AND is_otc = FALSE
						JOIN bh_encounter e
						ON e.bh_visit_id = v.bh_visit_id AND e.bh_encounter_type = 'C'
						JOIN bh_observation o
						ON e.bh_encounter_id = o.bh_encounter_id AND o.bh_value != ''
			) v_n
				ON v.bh_visit_id = v_n.bh_visit_id
	) doc_quality
		CROSS JOIN (
		SELECT
			COALESCE((COUNT(ed.*)
			          FILTER ( WHERE ed.bh_diagnostic_note IS NOT NULL OR
			                         (ed.bh_value IS NOT NULL AND ed.bh_value != '') ))::numeric /
			         NULLIF(COUNT(ed.*)::numeric, 0), 0) AS ct
		FROM
			bh_visit v
				JOIN completed_visits cv
				ON v.bh_visit_id = cv.bh_visit_id AND is_otc = FALSE
				JOIN bh_encounter e
				ON e.bh_visit_id = v.bh_visit_id
				JOIN bh_encounter_diagnostic ed
				ON e.bh_encounter_id = ed.bh_encounter_id AND ed.bh_concept_id IS NOT NULL
	) labs
		CROSS JOIN (
		SELECT
			COALESCE((COUNT(cv.*) FILTER ( WHERE cv.bh_visit_id IS NOT NULL ))::numeric / NULLIF(COUNT(v.*)::numeric, 0),
			         0) AS ct
		FROM
			bh_visit v
				JOIN c_bpartner bp
				ON v.patient_id = bp.c_bpartner_id
				JOIN c_bp_group bpg
				ON bp.c_bp_group_id = bpg.c_bp_group_id AND bpg.name = 'Patients - DO NOT CHANGE'
				JOIN c_order o
				ON v.bh_visit_id = o.bh_visit_id AND o.docstatus NOT IN ('VO')
				LEFT JOIN completed_visits cv
				ON v.bh_visit_id = cv.bh_visit_id AND is_otc = FALSE
		WHERE
			v.ad_client_id = _ad_client_id
			AND v.bh_visitdate BETWEEN _begin_date AND _end_date
	) v_per;
$$;
