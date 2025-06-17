DROP FUNCTION IF EXISTS bh_dashboard_get_financial_visit_charges(numeric);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_visit_charges(_ad_client_id numeric)
	RETURNS table
	        (
		        bucket_value       timestamp,
		        patient_visits     numeric,
		        avg_charge_patient numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	DATE_TRUNC('month', v.bh_visitdate)            AS bucket_value,
	COUNT(*)                                       AS patient_visits,
	ROUND(COALESCE(AVG(o.grandtotal)::numeric, 0)) AS avg_charge_patient
FROM
	bh_visit v
		JOIN c_order o
		ON v.bh_visit_id = o.bh_visit_id AND o.docstatus IN ('CO', 'CL')
WHERE
	v.ad_client_id = _ad_client_id
	AND v.bh_visitdate BETWEEN DATE_TRUNC('month', NOW() - '5 months'::interval) AND NOW()
GROUP BY
	DATE_TRUNC('month', v.bh_visitdate);
$$;
