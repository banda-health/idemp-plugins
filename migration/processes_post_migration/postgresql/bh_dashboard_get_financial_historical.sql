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
