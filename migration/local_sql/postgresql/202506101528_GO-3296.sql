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
	mpc.bh_product_category_type							AS type
FROM
	bh_get_visit_payments(_ad_client_id, _begin_date, _end_date) bgvp
JOIN c_order co
ON co.c_order_id = bgvp.c_order_id
JOIN c_orderline cl
ON cl.c_order_id = co.c_order_id
JOIN m_product m
ON m.m_product_id = cl.m_product_id
JOIN m_product_category mpc
ON mpc.m_product_category_id = m.m_product_category_id
GROUP BY mpc.name, mpc.bh_product_category_type
$$;

SELECT 
	register_migration_script('202506101528_GO-3296.sql')
FROM dual;