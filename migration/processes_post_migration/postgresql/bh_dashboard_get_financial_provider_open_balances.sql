DROP FUNCTION IF EXISTS bh_dashboard_get_financial_provider_open_balances(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_provider_open_balances(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
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
	bp.name					AS name,
	bp.totalopenbalance		AS totalopenbalance
FROM
	bh_get_visit_non_patient_payments(_ad_client_id, _begin_date, _end_date) npp
JOIN c_invoice i ON npp.c_invoice_id = i.c_invoice_id
JOIN c_bpartner bp ON i.c_bpartner_id = bp.c_bpartner_id
$$;