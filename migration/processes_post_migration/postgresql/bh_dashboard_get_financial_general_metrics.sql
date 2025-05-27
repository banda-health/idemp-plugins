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
SELECT
	COALESCE(SUM(payments.payamt), 0)      												AS revenuesales,
	COALESCE(SUM(expenses.totalexpenses), 0)										    AS totalexpenses,
	COALESCE(SUM(payments.payamt) - SUM(expenses.totalexpenses), 0)						AS netprofit,
	COALESCE(SUM(billdetails.saleslineitemtotals) - SUM(payments.payamt), 0) 			AS totalowed,
	COALESCE(SUM(inventory.inventoryvalue), 0)     										AS inventoryvalue,
	COALESCE(SUM(charges.totalcharges), 0)         										AS totalcharges,
    COALESCE(SUM(inventory.costofgoodssold), 0)           								AS costofgoodssold,
    COALESCE(SUM(inventory.grossprofit), 0)              								AS grossprofit,
    COALESCE(ROUND(SUM(inventory.grossprofit) / SUM(payments.payamt) * 100), 0)			AS grossprofitmargin
FROM
	bh_get_visit_payments(_ad_client_id, _begin_date, _end_date) payments
    CROSS JOIN (
    SELECT
		COALESCE(SUM(i.grandtotal), 0) AS totalexpenses
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
		saleslineitemtotals AS saleslineitemtotals,
		salestotals        AS salestotals
	FROM
		bh_get_visit_details(_ad_client_id, _begin_date, _end_date)
	WHERE
		docstatus NOT IN ('VO', 'DR')
    ) billdetails
    CROSS JOIN (
	SELECT
	    COALESCE(balanced_stock * purchase_price, 0)                                AS inventoryvalue,
	    COALESCE(SUM(cost_of_goods_sold), 0)           								AS costofgoodssold,
        COALESCE(SUM(gross_profit), 0)              								AS grossprofit
	FROM
		get_inventory_changes(_ad_client_id, _begin_date, _end_date)
	WHERE
		opening_stock >= 0
	GROUP BY purchase_price, balanced_stock
	) AS inventory
    CROSS JOIN (
    SELECT
		COALESCE(SUM(i.grandtotal), 0) AS totalcharges
    FROM
        c_invoice i
    WHERE
    	i.ad_client_id = _ad_client_id
        AND i.docstatus = 'CO'
        AND i.issotrx = 'Y'
        AND i.bh_visit_id IS NULL
        AND i.dateinvoiced BETWEEN _begin_date AND _end_date
    ) AS charges
$$;