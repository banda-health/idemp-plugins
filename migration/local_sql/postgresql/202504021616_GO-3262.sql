-- Create some indexes that will be helpful for our dashboard queries
CREATE INDEX bhvisit_adclient ON bh_visit (ad_client_id);
CREATE INDEX mtransaction_movementdate ON m_transaction (movementdate);
CREATE INDEX mtransaction_productattr ON m_transaction (m_product_id, m_attributesetinstance_id);

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
			AVG(ct) AS avg
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
			AVG(o.grandtotal) AS avg
		FROM
			bh_visit v
				JOIN completed_visits cv
				ON v.bh_visit_id = cv.bh_visit_id
				JOIN c_order o
				ON v.bh_visit_id = o.bh_visit_id
	) avg_chg
		CROSS JOIN (
		SELECT
			EXTRACT(DAY FROM AVG(t.movementdate - t_r.movementdate)) AS avg
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
			(COUNT(v_v.*) FILTER ( WHERE v_v.bh_visit_id IS NOT NULL ))::numeric / COUNT(v.*)::numeric AS ct_v,
			(COUNT(v_d.*) FILTER ( WHERE v_d.bh_visit_id IS NOT NULL ))::numeric / COUNT(v.*)::numeric AS ct_d,
			(COUNT(v_n.*) FILTER ( WHERE v_n.bh_visit_id IS NOT NULL ))::numeric / COUNT(v.*)::numeric AS ct_n
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
			(COUNT(ed.*)
			 FILTER ( WHERE ed.bh_diagnostic_note IS NOT NULL OR (ed.bh_value IS NOT NULL AND ed.bh_value != '') ))::numeric /
			COUNT(ed.*)::numeric AS ct
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
			(COUNT(cv.*) FILTER ( WHERE cv.bh_visit_id IS NOT NULL ))::numeric / COUNT(v.*)::numeric AS ct
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

DROP FUNCTION IF EXISTS bh_dashboard_get_diagnosis_usage(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_diagnosis_usage(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        m_product_id  numeric,
		        name          varchar,
		        current       numeric,
		        previous      numeric,
		        current_total numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH current_period_primary_diagnoses AS (
	SELECT
		c.bh_concept_id,
		ed.bh_uncoded_diagnosis,
		COUNT(ed.*) AS ct
	FROM
		bh_encounter_diagnosis ed
			JOIN bh_encounter e
			ON e.bh_encounter_id = ed.bh_encounter_id
			JOIN bh_visit v
			ON e.bh_visit_id = v.bh_visit_id AND v.bh_visitdate BETWEEN _begin_date AND _end_date AND
			   v.ad_client_id = _ad_client_id
			LEFT JOIN bh_concept c
			ON ed.bh_concept_id = c.bh_concept_id
	WHERE
		ed.lineno = 0
	GROUP BY c.bh_concept_id, ed.bh_uncoded_diagnosis
),
	current_period_diagnoses AS (
		SELECT
			c.bh_concept_id,
			ed.bh_uncoded_diagnosis,
			COUNT(ed.*) AS ct
		FROM
			bh_encounter_diagnosis ed
				JOIN bh_encounter e
				ON e.bh_encounter_id = ed.bh_encounter_id
				JOIN bh_visit v
				ON e.bh_visit_id = v.bh_visit_id AND v.bh_visitdate BETWEEN _begin_date AND _end_date AND
				   v.ad_client_id = _ad_client_id
				LEFT JOIN bh_concept c
				ON ed.bh_concept_id = c.bh_concept_id
		GROUP BY c.bh_concept_id, ed.bh_uncoded_diagnosis
	),
	previous_period_diagnoses AS (
		SELECT
			c.bh_concept_id,
			ed.bh_uncoded_diagnosis,
			COUNT(ed.*) AS ct
		FROM
			bh_encounter_diagnosis ed
				JOIN bh_encounter e
				ON e.bh_encounter_id = ed.bh_encounter_id
				JOIN bh_visit v
				ON e.bh_visit_id = v.bh_visit_id AND
				   v.bh_visitdate BETWEEN (_begin_date - (_end_date - _begin_date)) AND _begin_date AND
				   v.ad_client_id = _ad_client_id
				LEFT JOIN bh_concept c
				ON ed.bh_concept_id = c.bh_concept_id
		GROUP BY c.bh_concept_id, ed.bh_uncoded_diagnosis
	)
SELECT
	cppd.bh_concept_id,
	cppd.bh_uncoded_diagnosis,
	cppd.ct             AS current,
	COALESCE(ppd.ct, 0) AS previous,
	COALESCE(cpd.ct, 0) AS current_total
FROM
	(
		SELECT *
		FROM
			current_period_primary_diagnoses
		ORDER BY ct DESC
		LIMIT 10
	) cppd
		LEFT JOIN previous_period_diagnoses ppd
		ON cppd.bh_concept_id = ppd.bh_concept_id OR cppd.bh_uncoded_diagnosis = ppd.bh_uncoded_diagnosis
		LEFT JOIN current_period_diagnoses cpd
		ON cppd.bh_concept_id = cpd.bh_concept_id OR cppd.bh_uncoded_diagnosis = cpd.bh_uncoded_diagnosis
UNION ALL
SELECT
	NULL,
	'Other',
	COALESCE(SUM(ct), 0),
	NULL,
	NULL
FROM
	current_period_primary_diagnoses
WHERE
	bh_concept_id || COALESCE(bh_uncoded_diagnosis, '') NOT IN (
		SELECT
			bh_concept_id || COALESCE(bh_uncoded_diagnosis, '')
		FROM
			current_period_primary_diagnoses
		ORDER BY ct DESC
		LIMIT 10
	);
$$;

DROP FUNCTION IF EXISTS bh_dashboard_get_product_usage(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_product_usage(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        m_product_id numeric,
		        name         varchar,
		        current      numeric,
		        previous     numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH current_period_product AS (
	SELECT
		p.m_product_id,
		COUNT(p.*) AS ct
	FROM
		m_product p
			JOIN c_orderline ol
			ON p.m_product_id = ol.m_product_id
			JOIN c_order o
			ON ol.c_order_id = o.c_order_id AND o.docstatus IN ('CO', 'CL')
			JOIN bh_visit v
			ON o.bh_visit_id = v.bh_visit_id AND v.bh_visitdate BETWEEN _begin_date AND _end_date AND
			   v.ad_client_id = _ad_client_id
			JOIN m_product_category pc
			ON p.m_product_category_id = pc.m_product_category_id AND pc.name = 'Pharmacy'
	WHERE
		p.producttype = 'I'
	GROUP BY p.m_product_id
),
	previous_period_product AS (
		SELECT
			p.m_product_id,
			COUNT(p.*) AS ct
		FROM
			m_product p
				JOIN c_orderline ol
				ON p.m_product_id = ol.m_product_id
				JOIN c_order o
				ON ol.c_order_id = o.c_order_id AND o.docstatus IN ('CO', 'CL')
				JOIN bh_visit v
				ON o.bh_visit_id = v.bh_visit_id AND
				   v.bh_visitdate BETWEEN (_begin_date - (_end_date - _begin_date)) AND _begin_date AND
				   v.ad_client_id = _ad_client_id
				JOIN m_product_category pc
				ON p.m_product_category_id = pc.m_product_category_id AND pc.name = 'Pharmacy'
		WHERE
			p.producttype = 'I'
		GROUP BY p.m_product_id
	)
SELECT
	cpp.m_product_id,
	p.name,
	cpp.ct              AS current,
	COALESCE(ppp.ct, 0) AS previous
FROM
	(
		SELECT *
		FROM
			current_period_product
		ORDER BY ct DESC
		LIMIT 10
	) cpp
		LEFT JOIN previous_period_product ppp
		ON cpp.m_product_id = ppp.m_product_id
		JOIN m_product p
		ON cpp.m_product_id = p.m_product_id
UNION ALL
SELECT
	NULL,
	'Other',
	COALESCE(SUM(ct), 0),
	NULL
FROM
	current_period_product
WHERE
	m_product_id NOT IN (
		SELECT
			m_product_id
		FROM
			current_period_product
		ORDER BY ct DESC
		LIMIT 10
	);
$$;

DROP FUNCTION IF EXISTS bh_dashboard_get_lab_usage(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_lab_usage(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        bh_concept_id numeric,
		        name          varchar,
		        current       numeric,
		        previous      numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH current_period_lab AS (
	SELECT
		bh_concept_id,
		COUNT(*) AS ct
	FROM
		(
			SELECT DISTINCT
				v.bh_visit_id,
				COALESCE(ed.selected_panel_id, ed.bh_concept_id) AS bh_concept_id
			FROM
				bh_encounter_diagnostic ed
					JOIN bh_encounter e
					ON e.bh_encounter_id = ed.bh_encounter_id
					JOIN bh_visit v
					ON e.bh_visit_id = v.bh_visit_id AND v.bh_visitdate BETWEEN _begin_date AND _end_date AND
					   v.ad_client_id = _ad_client_id
		) l
	GROUP BY bh_concept_id
),
	previous_period_lab AS (
		SELECT
			bh_concept_id,
			COUNT(*) AS ct
		FROM
			(
				SELECT DISTINCT
					v.bh_visit_id,
					COALESCE(ed.selected_panel_id, ed.bh_concept_id) AS bh_concept_id
				FROM
					bh_encounter_diagnostic ed
						JOIN bh_encounter e
						ON e.bh_encounter_id = ed.bh_encounter_id
						JOIN bh_visit v
						ON e.bh_visit_id = v.bh_visit_id AND
						   v.bh_visitdate BETWEEN (_begin_date - (_end_date - _begin_date)) AND _begin_date AND
						   v.ad_client_id = _ad_client_id
			) l
		GROUP BY bh_concept_id
	)
SELECT
	cpl.bh_concept_id,
	c.bh_display_name   AS name,
	cpl.ct              AS current,
	COALESCE(ppl.ct, 0) AS previous
FROM
	(
		SELECT *
		FROM
			current_period_lab
		ORDER BY ct DESC
		LIMIT 10
	) cpl
		LEFT JOIN previous_period_lab ppl
		ON cpl.bh_concept_id = ppl.bh_concept_id
		LEFT JOIN bh_concept c
		ON cpl.bh_concept_id = c.bh_concept_id
UNION ALL
SELECT
	NULL,
	'Other',
	COALESCE(SUM(ct), 0),
	NULL
FROM
	current_period_lab
WHERE
	bh_concept_id NOT IN (
		SELECT
			bh_concept_id
		FROM
			current_period_lab
		ORDER BY ct DESC
		LIMIT 10
	);
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
				WHEN v.bh_patienttype IS NULL THEN 'None'
				END                                                           AS alternate_visit_type,
			WIDTH_BUCKET(EXTRACT(EPOCH FROM bh_visitdate), EXTRACT(EPOCH FROM _begin_date),
			             EXTRACT(EPOCH FROM _end_date), 6)                  AS bucket_number
		FROM
			bh_visit v
				JOIN completed_visits cv
				ON cv.bh_visit_id = v.bh_visit_id
				LEFT JOIN ad_ref_list rl
				ON v.bh_patienttype = rl.value
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
		JOIN buckets_cte bcte
		ON bcte.bucket_number = bm.bucket_number
GROUP BY
	bm.bucket_value, ad_ref_list_id, alternate_visit_type;
$$;

-- Wrap up and be done
SELECT
	register_migration_script('202504021616_GO-3262.sql')
FROM
	dual;
