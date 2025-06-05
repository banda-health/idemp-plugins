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