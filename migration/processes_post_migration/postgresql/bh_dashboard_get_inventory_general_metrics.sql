DROP FUNCTION IF EXISTS bh_dashboard_get_inventory_general_metrics(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_inventory_general_metrics(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        inventory_turnover_rate        	numeric,
		        days_on_hand       				numeric,
		        sales_to_stock_ratio 			numeric,
		        gross_margin    				numeric,
		        return_on_investment      		numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	ROUND(inventory.costofgoodssold / inventory.averagestock, 0)													AS inventory_turnover_rate,
	ROUND((inventory.averagestock / inventory.costofgoodssold) * EXTRACT(DAY FROM _end_date - _begin_date),0)		AS days_on_hand,
	ROUND(inventory.averagestock / payments.revenuesales, 0)														AS sales_to_stock_ratio,
    ROUND(inventory.grossprofit / payments.revenuesales * 100, 0)													AS gross_margin,
    0																												AS return_on_investment
FROM
	(
	SELECT
		COALESCE(SUM(payamt), 0)      											AS revenuesales
	FROM
		bh_get_visit_payments(_ad_client_id, _begin_date, _end_date)
	) as payments
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
	    ROUND(((SUM(opening_stock) + SUM(ending_stock)) / 2), 0)                        AS averagestock,
	    COALESCE(SUM(cost_of_goods_sold), 0)           									AS costofgoodssold,
        COALESCE(SUM(gross_profit), 0)              									AS grossprofit
	FROM
		get_inventory_changes(_ad_client_id, _begin_date, _end_date)
	WHERE
		opening_stock >= 0
	) AS inventory
$$;