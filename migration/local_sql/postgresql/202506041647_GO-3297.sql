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

DROP FUNCTION IF EXISTS bh_dashboard_get_inventory_historical_value(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_inventory_historical_value(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        bucket_value         	timestamp,
		        inventory_value         numeric,
		        inventory_received		numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH buckets_cte AS (
	SELECT
		COALESCE(purchase_price * sold_stock, 0)											   AS inventory_value,
		COALESCE(received_stock, 0)															   AS inventory_received,
		WIDTH_BUCKET(EXTRACT(EPOCH FROM purchase_date), EXTRACT(EPOCH FROM _begin_date),
		             EXTRACT(EPOCH FROM _end_date), 6)                  						AS bucket_number
	FROM
		get_inventory_changes(_ad_client_id, _begin_date, _end_date)
	WHERE
        received_stock > 0 AND sold_stock > 0
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
	COALESCE(SUM(inventory_value), 0) 				AS inventory_value,
	COALESCE(SUM(inventory_received), 0)			AS inventory_received
FROM
	bucket_mapping bm
LEFT JOIN buckets_cte bcte
ON bcte.bucket_number = bm.bucket_number
GROUP BY
	bm.bucket_value;
$$;

DROP FUNCTION IF EXISTS bh_dashboard_get_inventory_historical_charge_earnings(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_inventory_historical_charge_earnings(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        bucket_value         	timestamp,
		        charges         		numeric,
		        margins					numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH buckets_cte AS (
	SELECT
		COALESCE(sell_price * sold_stock, 0)											   AS charges,
		COALESCE((sell_price - purchase_price) * sold_stock, 0)							   AS margins,
		WIDTH_BUCKET(EXTRACT(EPOCH FROM purchase_date), EXTRACT(EPOCH FROM _begin_date),
		             EXTRACT(EPOCH FROM _end_date), 6)                  				   AS bucket_number
	FROM
		get_inventory_changes(_ad_client_id, _begin_date, _end_date)
	WHERE
        sold_stock > 0
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
	COALESCE(SUM(charges), 0) 				AS charges,
	COALESCE(SUM(margins), 0)				AS margins
FROM
	bucket_mapping bm
LEFT JOIN buckets_cte bcte
ON bcte.bucket_number = bm.bucket_number
GROUP BY
	bm.bucket_value;
$$;

SELECT 
	register_migration_script('202506041647_GO-3297.sql')
FROM dual;
