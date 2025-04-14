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
