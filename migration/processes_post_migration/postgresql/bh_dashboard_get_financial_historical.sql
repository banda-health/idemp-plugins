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
WITH expenses AS (
	SELECT
		COALESCE(SUM(i.grandtotal), 0) AS total_expenses,
		date(i.dateinvoiced)           AS date
	FROM
		c_invoice i
	WHERE
		i.ad_client_id = _ad_client_id
		AND i.docstatus = 'CO'
		AND i.issotrx = 'N'
		AND i.bh_visit_id IS NULL
		AND i.dateinvoiced >= DATE_TRUNC('month', NOW() - '5 months'::interval)
	GROUP BY date(i.dateinvoiced)
),
	payments AS (
		SELECT
			COALESCE(SUM(p.payamt), 0) AS total_income,
			date(p.datetrx)            AS date
		FROM
			bh_get_visit_payments(_ad_client_id, DATE_TRUNC('month', NOW() - '5 months'::interval)::timestamp, NOW()::timestamp) p
		GROUP BY date(p.datetrx)
	)
SELECT
	DATE_TRUNC('month', COALESCE(p.date, e.date))       AS bucket_value,
	COALESCE(SUM(p.total_income), 0)                    AS total_income,
	COALESCE(SUM(e.total_expenses), 0)                  AS total_expenses,
	COALESCE(SUM(p.total_income - e.total_expenses), 0) AS net_profit
FROM
	payments p
		FULL OUTER JOIN expenses e
		ON p.date = e.date
GROUP BY
	DATE_TRUNC('month', COALESCE(p.date, e.date));
$$;