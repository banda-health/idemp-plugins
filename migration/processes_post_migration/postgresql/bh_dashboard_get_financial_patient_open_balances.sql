DROP FUNCTION IF EXISTS bh_dashboard_get_financial_patient_open_balances(_ad_client_id numeric);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_patient_open_balances(_ad_client_id numeric)
	RETURNS table
	        (
		        name						character varying,
	        	totalopenbalance        	numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	bp.name 					AS name,
	bp.totalopenbalance			AS totalopenbalance
FROM c_bpartner bp
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
	bp.name, bp.c_bpartner_id, bp.bh_patientid, bp.totalopenbalance
$$;