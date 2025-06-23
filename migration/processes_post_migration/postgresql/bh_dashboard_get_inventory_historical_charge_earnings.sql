DROP FUNCTION IF EXISTS bh_dashboard_get_inventory_historical_charge_earnings(numeric);
CREATE OR REPLACE FUNCTION bh_dashboard_get_inventory_historical_charge_earnings(_ad_client_id numeric)
	RETURNS table
	        (
		        bucket_value timestamp,
		        charges      numeric,
		        margins      numeric
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
	data AS (
		SELECT
			ol.priceactual * t.movementqty * -1                                    AS charges,
			COALESCE((ol.priceactual - pc.purchase_price) * t.movementqty * -1, 0) AS margins,
			DATE_TRUNC('month', t.updated)                                         AS bucket_number
		FROM
			m_transaction t
				JOIN m_inoutline iol
				ON t.m_inoutline_id = iol.m_inoutline_id
				JOIN c_orderline ol
				ON iol.c_orderline_id = ol.c_orderline_id
				JOIN get_product_costs(_ad_client_id) pc
				ON t.m_product_id = pc.m_product_id AND t.m_attributesetinstance_id = pc.m_attributesetinstance_id
		WHERE
			t.movementtype IN ('C+', 'C-')
			AND t.updated BETWEEN
				DATE_TRUNC('month', NOW() - '5 months'::interval)::timestamp AND
				NOW()::timestamp
	)
SELECT
	months.GENERATE_SERIES    AS bucket_value,
	COALESCE(SUM(charges), 0) AS charges,
	COALESCE(SUM(margins), 0) AS margins
FROM
	months
		LEFT JOIN data
		ON months.GENERATE_SERIES = DATA.bucket_number
GROUP BY
	months.GENERATE_SERIES
ORDER BY
	months.GENERATE_SERIES;
$$;
