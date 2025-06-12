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