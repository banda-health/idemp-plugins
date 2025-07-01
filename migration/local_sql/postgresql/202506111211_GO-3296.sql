DROP FUNCTION IF EXISTS bh_dashboard_get_financial_types(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_types(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
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
WITH nonpatientpayments AS (
	SELECT
		'Insurance'								AS name,
		COUNT(*)								AS frequency
	FROM
		bh_get_visit_non_patient_payments(_ad_client_id, _begin_date, _end_date) npp
),
patientpayments AS (
	SELECT 
		payment_mode_name		AS name,
		COUNT(*)				AS frequency
	FROM
		bh_get_visit_payments(_ad_client_id, _begin_date, _end_date)
	GROUP BY payment_mode_name
),
expenses AS (
	SELECT
		c.Name					AS name,
		COUNT(*)				AS frequency
    FROM
        c_invoice i
    JOIN c_invoiceline cil
    ON cil.c_invoice_id = i.c_invoice_id
    JOIN c_charge c
    ON c.c_charge_id = cil.c_charge_id
    WHERE
		i.ad_client_id = _ad_client_id
		AND i.docstatus = 'CO'
	    AND i.issotrx = 'N'
	    AND i.bh_visit_id IS NULL
	    AND i.dateinvoiced BETWEEN _begin_date AND _end_date
    GROUP BY c.Name    
)

SELECT 
	name,
	frequency,
	'Income' 							AS type
FROM nonpatientpayments npp
UNION ALL
SELECT 
	name,
	frequency,
	'Income'							AS type
FROM patientpayments
UNION ALL
SELECT
	name,
	frequency,
	'Expense'
FROM expenses
$$;

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
	name,
	totalopenbalance,
	type
FROM
(
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
	ORDER BY bp.totalopenbalance desc
	LIMIT 10	
) AS summary1

UNION ALL

SELECT
	name,		
	SUM(totalopenbalance) 			AS totalopenbalance,
	type
FROM
(
	SELECT
		'Other' 					AS name,
		SUM(bp.totalopenbalance)	AS totalopenbalance,
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
	GROUP BY bp.totalopenbalance 
	ORDER BY bp.totalopenbalance desc
	OFFSET 10
) AS summary2
GROUP BY name, type

UNION ALL

SELECT
	name,
	totalopenbalance,
	type
FROM
(
	SELECT
		bp.name							AS name,
		bp.totalopenbalance				AS totalopenbalance,
		'Provider'						AS type
	FROM
		bh_get_visit_non_patient_payments(_ad_client_id, _begin_date, _end_date) npp
	JOIN c_invoice i ON npp.c_invoice_id = i.c_invoice_id
	JOIN c_bpartner bp ON i.c_bpartner_id = bp.c_bpartner_id
	WHERE 
		bp.totalopenbalance > 0
	AND
		bp.ad_client_id = _ad_client_id
	GROUP BY
		bp.name, bp.totalopenbalance
	ORDER BY bp.totalopenbalance desc
	LIMIT 10	
) AS summary3

UNION ALL

SELECT
	name,		
	SUM(totalopenbalance) 			AS totalopenbalance,
	type
FROM
(
	SELECT
		'Other' 					AS name,
		SUM(bp.totalopenbalance)	AS totalopenbalance,
		'Provider'					AS type
	FROM
		bh_get_visit_non_patient_payments(_ad_client_id, _begin_date, _end_date) npp
	JOIN c_invoice i ON npp.c_invoice_id = i.c_invoice_id
	JOIN c_bpartner bp ON i.c_bpartner_id = bp.c_bpartner_id
	WHERE 
		bp.totalopenbalance > 0
	AND
		bp.ad_client_id = _ad_client_id
	GROUP BY
		bp.name, bp.totalopenbalance
	ORDER BY bp.totalopenbalance desc
	OFFSET 10
) AS summary2
GROUP BY name, type
$$;

SELECT 
	register_migration_script('202506111211_GO-3296.sql')
FROM dual;