DROP FUNCTION IF EXISTS bh_dashboard_get_financial_general_metrics(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_general_metrics(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        revenue_sales        	numeric,
		        total_expenses       	numeric,
		        net_profit 				numeric,
		        total_owed    			numeric,
		        inventory_value      	numeric,
		        total_charges        	numeric,
		        cost_of_goods_sold      numeric,
		        gross_profit            numeric,
		        gross_profit_margin     numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH payments AS (
	SELECT
		COALESCE(SUM(payamt), 0)      											AS revenuesales
	FROM
		bh_get_visit_payments(_ad_client_id, _begin_date, _end_date)
)

SELECT
	payments.revenuesales      														AS revenuesales,
	expenses.totalexpenses										    				AS totalexpenses,
	payments.revenuesales - expenses.totalexpenses									AS netprofit,
	billdetails.saleslineitemtotals - payments.revenuesales 						AS totalowed,
	inventory.inventoryvalue     													AS inventoryvalue,
	charges.totalcharges         													AS totalcharges,
    inventory.costofgoodssold           											AS costofgoodssold,
    inventory.grossprofit              												AS grossprofit,
    COALESCE(ROUND(inventory.grossprofit / payments.revenuesales * 100), 0)			AS grossprofitmargin
FROM
	payments
    CROSS JOIN (
    SELECT
		COALESCE(SUM(i.grandtotal), 0) 												AS totalexpenses
    FROM
        c_invoice i
    WHERE
    	i.ad_client_id = _ad_client_id
    	AND i.docstatus = 'CO'
        AND i.issotrx = 'N'
        AND i.bh_visit_id IS NULL
        AND i.dateinvoiced BETWEEN _begin_date AND _end_date
    ) AS expenses
    CROSS JOIN (
    SELECT
		COALESCE(SUM(saleslineitemtotals),0) AS saleslineitemtotals,
		COALESCE(SUM(salestotals),0)        AS salestotals
	FROM
		bh_get_visit_details(_ad_client_id, _begin_date, _end_date)
	WHERE
		docstatus NOT IN ('VO', 'DR')
    ) billdetails
    CROSS JOIN (
	SELECT
	    COALESCE(SUM(balanced_stock * purchase_price),0)                                AS inventoryvalue,
	    COALESCE(SUM(cost_of_goods_sold), 0)           									AS costofgoodssold,
        COALESCE(SUM(gross_profit), 0)              									AS grossprofit
	FROM
		get_inventory_changes(_ad_client_id, _begin_date, _end_date)
	WHERE
		opening_stock >= 0
	) AS inventory
    CROSS JOIN (
    SELECT
		COALESCE(SUM(o.grandtotal),0)													AS totalcharges
	FROM
		bh_visit v
			JOIN c_order o
			ON v.bh_visit_id = o.bh_visit_id AND o.docstatus IN ('CO', 'CL')
	WHERE
		v.ad_client_id = _ad_client_id
		AND v.bh_visitdate BETWEEN _begin_date AND _end_date
    ) AS charges
$$;

DROP FUNCTION IF EXISTS bh_dashboard_get_financial_historical(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_historical(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        bucket_value         timestamp,
		        total_income         numeric,
		        total_expenses		 numeric,
		        net_profit           numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH expenses AS (
SELECT
    COALESCE(SUM(i.grandtotal), 0)      AS total_expenses,
    date(i.dateinvoiced)                AS date
FROM
    c_invoice i
WHERE
    i.ad_client_id = _ad_client_id
    AND i.docstatus = 'CO'
    AND i.issotrx = 'N'
    AND i.bh_visit_id IS NULL
    AND i.dateinvoiced BETWEEN _begin_date AND _end_date
    GROUP BY date(i.dateinvoiced)
),
payments AS (
	SELECT
		COALESCE(SUM(p.payamt), 0)                  AS total_income,
		date(p.datetrx)                             AS date
	FROM
		bh_get_visit_payments(_ad_client_id, _begin_date, _end_date) p
	GROUP BY date(p.datetrx)
),
payments_expenses AS (
	SELECT
		COALESCE(p.date, e.date)                        AS date,
		p.total_income				                    AS total_income,
		e.total_expenses                   				AS total_expenses,
		p.total_income - e.total_expenses  				AS net_profit
	FROM
		payments p
	FULL OUTER JOIN expenses e ON p.date = e.date
),
buckets_cte AS (
	SELECT
		total_income,
		total_expenses,
		net_profit,
		WIDTH_BUCKET(EXTRACT(EPOCH FROM date), EXTRACT(EPOCH FROM _begin_date),
		             EXTRACT(EPOCH FROM _end_date), 6)                  						AS bucket_number
	FROM
		payments_expenses
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
	COALESCE(SUM(total_income), 0) 				AS total_income,
	COALESCE(SUM(total_expenses), 0)			AS total_expenses,
	COALESCE(SUM(net_profit), 0)				AS net_profit
FROM
	bucket_mapping bm
LEFT JOIN buckets_cte bcte
ON bcte.bucket_number = bm.bucket_number
GROUP BY
	bm.bucket_value;
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
	GROUP BY charge_subtype_name
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

SELECT 
	register_migration_script('202505301244_GO-3296.sql')
FROM dual;
