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
		LEFT JOIN buckets_cte bcte
		ON bcte.bucket_number = bm.bucket_number
GROUP BY
	bm.bucket_value, ad_ref_list_id, alternate_visit_type;
$$;

-- Wrap up and be done
SELECT
	register_migration_script('202504071356_GO-3262.sql')
FROM
	dual;
