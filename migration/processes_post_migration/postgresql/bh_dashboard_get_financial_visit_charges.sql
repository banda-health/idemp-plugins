DROP FUNCTION IF EXISTS bh_dashboard_get_financial_visit_charges(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_visit_charges(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        bucket_value         	 timestamp,
		        patient_visits         	 numeric,
		        avg_charge_patient		 numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH visits AS (
	SELECT
		COUNT(*)										AS patient_visits,
		ROUND(COALESCE(AVG(o.grandtotal)::numeric, 0))	AS avg_charge_patient,
		date(v.bh_visitdate)                      		AS date
	FROM
		bh_visit v
			JOIN c_order o
			ON v.bh_visit_id = o.bh_visit_id AND o.docstatus IN ('CO', 'CL')
	WHERE
		v.ad_client_id = _ad_client_id
		AND v.bh_visitdate BETWEEN _begin_date AND _end_date
	GROUP BY date(v.bh_visitdate)
),
buckets_cte AS (
	SELECT
		patient_visits,
		avg_charge_patient,
		WIDTH_BUCKET(EXTRACT(EPOCH FROM date), EXTRACT(EPOCH FROM _begin_date),
		             EXTRACT(EPOCH FROM _end_date), 6)                  						AS bucket_number
	FROM
		visits
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
	COALESCE(SUM(patient_visits), 0)			AS patient_visits,
	COALESCE(SUM(avg_charge_patient), 0)		AS avg_charge_patient
FROM
	bucket_mapping bm
LEFT JOIN buckets_cte bcte
ON bcte.bucket_number = bm.bucket_number
GROUP BY
	bm.bucket_value;
$$;