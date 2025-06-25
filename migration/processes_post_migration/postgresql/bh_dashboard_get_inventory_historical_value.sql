DROP FUNCTION IF EXISTS bh_dashboard_get_inventory_historical_value(numeric);
CREATE OR REPLACE FUNCTION bh_dashboard_get_inventory_historical_value(_ad_client_id numeric)
	RETURNS table
	        (
		        bucket_value       timestamp,
		        inventory_value    numeric,
		        inventory_received numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH months AS (
	SELECT *
	FROM
		GENERATE_SERIES(DATE_TRUNC('month', NOW() - '5 months'::interval), DATE_TRUNC('month', NOW()), '1 month'::interval)
),
	inventory_value AS (
		SELECT
			DATE_TRUNC('month', t.updated) AS bucket_value,
			(SUM(pc.purchase_price * t.movementqty) FILTER ( WHERE t.updated BETWEEN
				DATE_TRUNC('month', NOW() - '5 months'::interval)::timestamp AND
				NOW()::timestamp ))          AS inventory_value,
			(SUM(pc.purchase_price * t.movementqty) FILTER ( WHERE t.movementtype IN ('V+', 'V-') AND t.updated BETWEEN
				DATE_TRUNC('month', NOW() - '5 months'::interval)::timestamp AND
				NOW()::timestamp ))          AS received_value
		FROM
			m_transaction t
				JOIN get_product_costs(_ad_client_id) pc
				ON t.m_product_id = pc.m_product_id AND t.m_attributesetinstance_id = pc.m_attributesetinstance_id
		WHERE
			t.ad_client_id = _ad_client_id
		GROUP BY DATE_TRUNC('month', t.updated)
	),
	initial_value AS (
		SELECT
			SUM(pc.purchase_price * t.movementqty) AS start
		FROM
			m_transaction t
				JOIN get_product_costs(_ad_client_id) pc
				ON t.m_product_id = pc.m_product_id AND t.m_attributesetinstance_id = pc.m_attributesetinstance_id
		WHERE
			t.ad_client_id = _ad_client_id
			AND t.updated < DATE_TRUNC('month', NOW() - '5 months'::interval)
	)
SELECT
	months.GENERATE_SERIES                                          AS bucket_value,
	COALESCE(initial_value.start, 0) + COALESCE(inventory_value, 0) AS inventory_value,
	COALESCE(received_value, 0)                                     AS inventory_received
FROM
	months
		LEFT JOIN inventory_value
		ON months.GENERATE_SERIES = inventory_value.bucket_value
		CROSS JOIN initial_value
ORDER BY
	months.GENERATE_SERIES;
$$;
