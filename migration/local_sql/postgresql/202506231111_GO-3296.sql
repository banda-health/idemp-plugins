DROP FUNCTION IF EXISTS bh_dashboard_get_inventory_historical_charge_earnings(numeric, timestamp, timestamp);
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

DROP FUNCTION IF EXISTS bh_dashboard_get_inventory_historical_value(numeric, timestamp, timestamp);
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
			DATE_TRUNC('month', t.updated)              AS bucket_value,
			SUM(pc.purchase_price * t.movementqty) * -1 AS inventory_value
		FROM
			m_transaction t
				JOIN get_product_costs(_ad_client_id) pc
				ON t.m_product_id = pc.m_product_id AND t.m_attributesetinstance_id = pc.m_attributesetinstance_id
		WHERE
			t.movementtype IN ('C+', 'C-')
			AND t.updated BETWEEN
				DATE_TRUNC('month', NOW() - '5 months'::interval)::timestamp AND
				NOW()::timestamp
		GROUP BY DATE_TRUNC('month', t.updated)
	),
	stock_value AS (
		SELECT
			DATE_TRUNC('month', t.updated) AS bucket_value,
			SUM(t.movementqty)             AS stock_value
		FROM
			m_transaction t
		WHERE
			t.movementtype IN ('V+', 'V-')
			AND t.updated BETWEEN
				DATE_TRUNC('month', NOW() - '5 months'::interval)::timestamp AND
				NOW()::timestamp
		GROUP BY DATE_TRUNC('month', t.updated)
	)
SELECT
	months.GENERATE_SERIES       AS bucket_value,
	COALESCE(inventory_value, 0) AS inventory_value,
	COALESCE(stock_value, 0)     AS inventory_received
FROM
	months
		LEFT JOIN inventory_value
		ON months.GENERATE_SERIES = inventory_value.bucket_value
		LEFT JOIN stock_value
		ON months.GENERATE_SERIES = stock_value.bucket_value
ORDER BY
	months.GENERATE_SERIES;
$$;

DROP FUNCTION IF EXISTS bh_dashboard_get_financial_historical(numeric);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_historical(_ad_client_id numeric)
	RETURNS table
	        (
		        bucket_value   timestamp,
		        total_income   numeric,
		        total_expenses numeric,
		        net_profit     numeric
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
	expenses AS (
		SELECT
			COALESCE(SUM(i.grandtotal), 0)      AS total_expenses,
			DATE_TRUNC('month', i.dateinvoiced) AS date
		FROM
			c_invoice i
		WHERE
			i.ad_client_id = _ad_client_id
			AND i.docstatus = 'CO'
			AND i.issotrx = 'N'
			AND i.bh_visit_id IS NULL
			AND i.dateinvoiced >= DATE_TRUNC('month', NOW() - '5 months'::interval)
		GROUP BY DATE_TRUNC('month', i.dateinvoiced)
	),
	payments AS (
		SELECT
			COALESCE(SUM(p.payamt), 0)     AS total_income,
			DATE_TRUNC('month', p.datetrx) AS date
		FROM
			bh_get_visit_payments(_ad_client_id, DATE_TRUNC('month', NOW() - '5 months'::interval)::timestamp,
			                      NOW()::timestamp) p
		GROUP BY DATE_TRUNC('month', p.datetrx)
	)
SELECT
	months.GENERATE_SERIES                         AS bucket_value,
	COALESCE(p.total_income, 0)                    AS total_income,
	COALESCE(e.total_expenses, 0)                  AS total_expenses,
	COALESCE(p.total_income - e.total_expenses, 0) AS net_profit
FROM
	months
		LEFT JOIN payments p
		ON months.GENERATE_SERIES = p.date
		LEFT JOIN expenses e
		ON months.GENERATE_SERIES = e.date
ORDER BY
	months.GENERATE_SERIES;
$$;

DROP FUNCTION IF EXISTS bh_dashboard_get_financial_visit_charges(numeric);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_visit_charges(_ad_client_id numeric)
	RETURNS table
	        (
		        bucket_value       timestamp,
		        patient_visits     numeric,
		        avg_charge_patient numeric
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
			DATE_TRUNC('month', v.bh_visitdate)            AS bucket_value,
			COUNT(*)                                       AS patient_visits,
			ROUND(COALESCE(AVG(o.grandtotal)::numeric, 0)) AS avg_charge_patient
		FROM
			bh_visit v
				JOIN c_order o
				ON v.bh_visit_id = o.bh_visit_id AND o.docstatus IN ('CO', 'CL')
		WHERE
			v.ad_client_id = _ad_client_id
			AND v.bh_visitdate BETWEEN DATE_TRUNC('month', NOW() - '5 months'::interval) AND NOW()
		GROUP BY
			DATE_TRUNC('month', v.bh_visitdate)
	)
SELECT
	months.GENERATE_SERIES               AS bucket_value,
	COALESCE(data.patient_visits, 0)     AS patient_visits,
	COALESCE(data.avg_charge_patient, 0) AS avg_charge_patient
FROM
	months
		LEFT JOIN data
		ON months.GENERATE_SERIES = data.bucket_value
ORDER BY
	months.GENERATE_SERIES;
$$;

SELECT
	register_migration_script('202506231111_GO-3296.sql')
FROM
	dual;
