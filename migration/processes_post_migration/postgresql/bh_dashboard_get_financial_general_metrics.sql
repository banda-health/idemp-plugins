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