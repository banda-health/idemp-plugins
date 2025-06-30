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
		COALESCE(SUM(cost_of_goods_sold), 0)                         AS costofgoodssold,
		SUM((opening_stock + ending_stock) / 2 * purchase_price) /
		SUM(sold_stock * sell_price) FILTER ( WHERE sold_stock > 0 ) AS stock_to_sales_ratio
	FROM
		get_inventory_changes(_ad_client_id, _begin_date, _end_date)
),
	revenue AS (
		SELECT
			COALESCE(SUM(o.grandtotal), 0) AS totalrevenue
		FROM
			bh_visit v
				JOIN c_order o
				ON v.bh_visit_id = o.bh_visit_id AND o.docstatus IN ('CO', 'CL')
		WHERE
			v.ad_client_id = _ad_client_id
			AND v.bh_visitdate BETWEEN _begin_date AND _end_date
	)
SELECT
	COALESCE(costofgoodssold, 0) /
	(CASE WHEN averagestock = 0 THEN 1 ELSE COALESCE(averagestock, 1) END)       AS inventory_turnover_rate,
	(COALESCE(averagestock, 0) / (CASE WHEN costofgoodssold = 0 THEN 1 ELSE COALESCE(costofgoodssold, 1) END)) *
	EXTRACT(DAY FROM _end_date - _begin_date)                                    AS days_on_hand,
	stock_to_sales_ratio                                                         AS sales_to_stock_ratio,
	(COALESCE(totalrevenue, 0) - COALESCE(costofgoodssold, 0)) /
	(CASE WHEN totalrevenue = 0 THEN 1 ELSE COALESCE(totalrevenue, 1) END) * 100 AS gross_margin,
	(COALESCE(totalrevenue, 0) - COALESCE(costofgoodssold, 0)) /
	(CASE WHEN stock_value = 0 THEN 1 ELSE COALESCE(stock_value, 1) END) * 100   AS return_on_investment
FROM
	data
		CROSS JOIN revenue
$$;
