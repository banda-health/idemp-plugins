DROP FUNCTION IF EXISTS bh_dashboard_get_financial_historical(numeric);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_historical(_ad_client_id numeric)
	RETURNS table
	        (
		        bucket_value   timestamp,
		        total_income   numeric,
		        total_expenses numeric,
		        profit_loss    numeric
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
	),
	other_payments AS (
		SELECT
			DATE_TRUNC('month', payment_date) AS date,
			COALESCE(SUM(payment_amount), 0)  AS income
		FROM
			bh_get_insurer_donor_payments(_ad_client_id, DATE_TRUNC('month', NOW() - '5 months'::interval)::timestamp,
			                              NOW()::timestamp)
		GROUP BY DATE_TRUNC('month', payment_date)
	),
	debtPayments AS (
		SELECT
			DATE_TRUNC('month', payment_date) AS date,
			COALESCE(SUM(payment_amount), 0)  AS debtpaymentamount
		FROM
			bh_get_debt_payments(_ad_client_id, DATE_TRUNC('month', NOW() - '5 months'::interval)::timestamp,
			                     NOW()::timestamp)
		GROUP BY DATE_TRUNC('month', payment_date)
	),
	received_products AS (
		SELECT
			DATE_TRUNC('month', o.dateordered) AS date,
			COALESCE(SUM(ol.linenetamt)
			         FILTER ( WHERE pc.name IN ('Laboratory', 'Pharmacy', 'Radiology', 'Other', 'Standard') ),
			         0)                        AS total
		FROM
			c_order o
				JOIN c_orderline ol
				ON o.c_order_id = ol.c_order_id
				JOIN m_product p
				ON ol.m_product_id = p.m_product_id
				JOIN m_product_category pc
				ON p.m_product_category_id = pc.m_product_category_id
		WHERE
			o.ad_client_id = _ad_client_id
			AND o.issotrx = 'N'
			AND o.docstatus = 'CO'
			AND o.dateordered BETWEEN DATE_TRUNC('month', NOW() - '5 months'::interval) AND NOW()::date
		GROUP BY DATE_TRUNC('month', o.dateordered)
	)
SELECT
	months.GENERATE_SERIES                                                                   AS bucket_value,
	COALESCE(p.total_income, 0) + COALESCE(dp.debtpaymentamount, 0) + COALESCE(op.income, 0) AS total_income,
	COALESCE(e.total_expenses, 0) + COALESCE(rp.total, 0)                                    AS total_expenses,
	COALESCE(p.total_income, 0) + COALESCE(dp.debtpaymentamount, 0) + COALESCE(op.income, 0) -
	COALESCE(e.total_expenses, 0) - COALESCE(rp.total, 0)                                    AS profit_loss
FROM
	months
		LEFT JOIN payments p
		ON months.GENERATE_SERIES = p.date
		LEFT JOIN expenses e
		ON months.GENERATE_SERIES = e.date
		LEFT JOIN debtPayments dp
		ON months.GENERATE_SERIES = dp.date
		LEFT JOIN received_products rp
		ON months.GENERATE_SERIES = rp.date
		LEFT JOIN other_payments op
		ON months.GENERATE_SERIES = op.date
ORDER BY
	months.GENERATE_SERIES;
$$;
