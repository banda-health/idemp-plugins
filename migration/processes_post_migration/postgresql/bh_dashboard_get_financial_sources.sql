DROP FUNCTION IF EXISTS bh_dashboard_get_financial_sources(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_sources(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        source						character varying,
	        	frequency        			numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH nonpatientpayments AS (
	SELECT
		npp.charge_subtype_name					AS source,
		COUNT(*)								AS frequency
	FROM
		bh_get_visit_non_patient_payments(_ad_client_id, _begin_date, _end_date) npp
	GROUP BY charge_subtype_name
),
patientpayments AS (
	SELECT 
		'Patient Direct'		AS source,
		COUNT(*)				AS frequency
	FROM
		bh_get_visit_payments(_ad_client_id, _begin_date, _end_date)
)

SELECT 
	source,
	frequency
FROM nonpatientpayments npp
UNION ALL
SELECT 
	source,
	frequency
FROM patientpayments
$$;