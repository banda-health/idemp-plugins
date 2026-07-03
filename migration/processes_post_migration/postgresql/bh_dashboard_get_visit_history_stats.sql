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
	otc_ref_list AS (
		SELECT
			rl.ad_ref_list_id
		FROM
			ad_ref_list rl
				JOIN ad_reference r
				ON rl.ad_reference_id = r.ad_reference_id
		WHERE
			r.ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
			AND rl.value = 'ot'
	),
	buckets_cte AS (
		SELECT
			date_trunc('day', v.bh_visitdate)::timestamp AS bucket_value,
			CASE WHEN cv.is_otc = TRUE THEN otc.ad_ref_list_id ELSE rl.ad_ref_list_id END AS ad_ref_list_id,
			CASE
				WHEN cv.is_otc = TRUE THEN NULL
				WHEN v.bh_visittype IS NULL THEN 'None'
				END                                          AS alternate_visit_type
		FROM
			bh_visit v
				JOIN completed_visits cv
				ON cv.bh_visit_id = v.bh_visit_id
				CROSS JOIN otc_ref_list otc
				LEFT JOIN ad_ref_list rl
				ON v.bh_visittype = rl.value
				LEFT JOIN ad_reference r
				ON rl.ad_reference_id = r.ad_reference_id
		WHERE
			r.ad_reference_id IS NULL
			OR r.ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
	)
SELECT
	bucket_value,
	ad_ref_list_id,
	alternate_visit_type,
	COUNT(*) AS frequency
FROM
	buckets_cte
GROUP BY
	bucket_value, ad_ref_list_id, alternate_visit_type;
$$;
