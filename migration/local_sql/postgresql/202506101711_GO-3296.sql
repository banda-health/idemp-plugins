DROP FUNCTION IF EXISTS bh_dashboard_get_financial_charge_type(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_charge_type(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        name						character varying,
	        	frequency        			numeric,
	        	type						character varying
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	mpc.name												AS name,
	SUM(bgvp.tender_amt)									AS charge,
	'Service'												AS type
FROM
	bh_get_visit_payments(_ad_client_id, _begin_date, _end_date) bgvp
JOIN c_order co
ON co.c_order_id = bgvp.c_order_id
JOIN c_orderline cl
ON cl.c_order_id = co.c_order_id
JOIN m_product m
ON m.m_product_id = cl.m_product_id
JOIN m_product_category mpc
ON mpc.m_product_category_id = m.m_product_category_id AND mpc.bh_product_category_type = 'S'
GROUP BY mpc.name
UNION ALL
SELECT
	arl.name												AS name,
	SUM(bgvp.tender_amt)									AS charge,
	'Patient'												AS type
FROM
	bh_get_visit_payments(_ad_client_id, _begin_date, _end_date) bgvp
JOIN bh_visit v
ON v.bh_visit_id = bgvp.bh_visit_id
JOIN ad_ref_list arl
ON arl.value = v.bh_patienttype
JOIN ad_reference ar
ON ar.ad_reference_id = arl.ad_reference_id AND ar.ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
GROUP BY arl.name
$$;

SELECT 
	register_migration_script('202506101711_GO-3296.sql')
FROM dual;