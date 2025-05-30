DROP FUNCTION IF EXISTS bh_dashboard_get_financial_open_balances(_ad_client_id numeric,  _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_open_balances(_ad_client_id numeric,  _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        name						character varying,
	        	totalopenbalance        	numeric,
	        	type						character varying
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	bp.name 					AS name,
	bp.totalopenbalance			AS totalopenbalance,
	'Patient'					AS type
FROM 
	c_bpartner bp
LEFT JOIN c_payment p
ON bp.c_bpartner_id = p.c_bpartner_id
JOIN c_bp_group bpg
ON bp.c_bp_group_id = bpg.c_bp_group_id
WHERE
	iscustomer = 'Y'
	AND bp.ad_client_id = _ad_client_id
	AND bp.totalopenbalance > 0
	AND bpg.name = 'Patients - DO NOT CHANGE'
GROUP BY
	bp.name, bp.totalopenbalance
	
UNION ALL

SELECT
	bp.name					AS name,
	bp.totalopenbalance		AS totalopenbalance,
	'Provider'				AS type
FROM
	bh_get_visit_non_patient_payments(_ad_client_id, _begin_date, _end_date) npp
JOIN c_invoice i ON npp.c_invoice_id = i.c_invoice_id
JOIN c_bpartner bp ON i.c_bpartner_id = bp.c_bpartner_id
WHERE bp.totalopenbalance > 0
$$;