DROP FUNCTION IF EXISTS bh_dashboard_get_financial_historical(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_historical(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        bucket_value         timestamp,
		        total_income         numeric,
		        total_expenses		 numeric,
		        net_profit           numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH expenses AS (
SELECT
    COALESCE(SUM(i.grandtotal), 0)      AS total_expenses,
    date(i.dateinvoiced)                AS date
FROM
    c_invoice i
WHERE
    i.ad_client_id = _ad_client_id
    AND i.docstatus = 'CO'
    AND i.issotrx = 'N'
    AND i.bh_visit_id IS NULL
    AND i.dateinvoiced BETWEEN _begin_date AND _end_date
    GROUP BY date(i.dateinvoiced)
),
payments AS (
	SELECT
		COALESCE(SUM(p.payamt), 0)                  AS total_income,
		date(p.datetrx)                             AS date
	FROM
		bh_get_visit_payments(_ad_client_id, _begin_date, _end_date) p
	GROUP BY date(p.datetrx)
),
payments_expenses AS (
	SELECT
		COALESCE(p.date, e.date)                        AS date,
		p.total_income				                    AS total_income,
		e.total_expenses                   				AS total_expenses,
		p.total_income - e.total_expenses  				AS net_profit
	FROM
		payments p
	FULL OUTER JOIN expenses e ON p.date = e.date
),
buckets_cte AS (
	SELECT
		total_income,
		total_expenses,
		net_profit,
		WIDTH_BUCKET(EXTRACT(EPOCH FROM date), EXTRACT(EPOCH FROM _begin_date),
		             EXTRACT(EPOCH FROM _end_date), 6)                  						AS bucket_number
	FROM
		payments_expenses
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
	COALESCE(SUM(total_income), 0) 				AS total_income,
	COALESCE(SUM(total_expenses), 0)			AS total_expenses,
	COALESCE(SUM(net_profit), 0)				AS net_profit
FROM
	bucket_mapping bm
LEFT JOIN buckets_cte bcte
ON bcte.bucket_number = bm.bucket_number
GROUP BY
	bm.bucket_value;
$$;