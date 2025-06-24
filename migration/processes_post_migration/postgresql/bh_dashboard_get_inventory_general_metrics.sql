DROP FUNCTION IF EXISTS bh_dashboard_get_inventory_general_metrics(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_inventory_general_metrics(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        inventory_turnover_rate numeric,
		        days_on_hand            numeric,
		        sales_to_stock_ratio    numeric,
		        gross_margin            numeric,
		        return_on_investment    numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH data AS (
	SELECT
		SUM((opening_stock + ending_stock) / 2)                      AS averagestock,
		SUM((opening_stock + ending_stock) / 2 * purchase_price)     AS stock_value,
		SUM(sold_stock * sell_price) FILTER ( WHERE sold_stock > 0 ) AS sales_value,
		COALESCE(SUM(cost_of_goods_sold), 0)                         AS costofgoodssold,
		COALESCE(SUM(gross_profit), 0)                               AS grossprofit,
		SUM((opening_stock + ending_stock) / 2 * purchase_price) /
		SUM(sold_stock * sell_price) FILTER ( WHERE sold_stock > 0 ) AS stock_to_sales_ratio
	FROM
		get_inventory_changes(_ad_client_id, _begin_date, _end_date)
	WHERE
		opening_stock > 0
		OR ending_stock > 0
)
SELECT
	costofgoodssold / averagestock                                               AS inventory_turnover_rate,
	(averagestock / costofgoodssold) * EXTRACT(DAY FROM _end_date - _begin_date) AS days_on_hand,
	stock_to_sales_ratio                                                         AS sales_to_stock_ratio,
	grossprofit / sales_value * 100                                              AS gross_margin,
	(grossprofit / stock_value) * 100                                            AS return_on_investment
FROM
	data
$$;
