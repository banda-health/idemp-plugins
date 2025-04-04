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
