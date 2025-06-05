DROP FUNCTION IF EXISTS bh_dashboard_get_inventory_top_sellers_earners(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp, _sort_by varchar);
CREATE OR REPLACE FUNCTION bh_dashboard_get_inventory_top_sellers_earners(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp, _sort_by varchar)
	RETURNS table
	        (
		        name        					varchar,
		        quantity_sold      				numeric,
		        value_goods_sold	 			numeric,
		        income_generated   				numeric,
		        margin_earned		      		numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT *
FROM (
    SELECT
        p.name 																							AS name,
        SUM(inv.sold_stock) 																			AS quantity_sold,
        COALESCE(SUM(inv.sold_stock * inv.purchase_price), 0) 											AS value_goods_sold,
        COALESCE(SUM(inv.sold_stock * inv.sell_price), 0) 												AS income_generated,
        COALESCE(SUM(inv.sold_stock * inv.sell_price) - SUM(inv.sold_stock * inv.purchase_price), 0) 	AS margin_earned
    FROM
        get_inventory_changes(_ad_client_id, _begin_date, _end_date) inv
    JOIN
        m_product p ON inv.m_product_id = p.m_product_id
    WHERE
        inv.opening_stock >= 0 AND inv.sold_stock > 0
    GROUP BY
        p.name
) AS summary
ORDER BY
    CASE
        WHEN _sort_by = 'Margin' THEN summary.margin_earned
        WHEN _sort_by = 'Charge' THEN summary.income_generated
        ELSE summary.value_goods_sold
    END DESC
$$;