DROP FUNCTION IF EXISTS bh_dashboard_get_financial_general_metrics(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_general_metrics(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        total_income        numeric,
		        total_expenses      numeric,
		        profit_loss         numeric,
		        unpaid_amount       numeric,
		        inventory_value     numeric,
		        total_revenue       numeric,
		        cost_of_goods_sold  numeric,
		        gross_profit        numeric,
		        gross_profit_margin numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	payments.revenuesales + debtPayments.debtpaymentamount + other_payments.paymentamount        AS total_income,
	expenses.totalexpenses + received_products.total                                             AS total_expenses,
	payments.revenuesales + debtPayments.debtpaymentamount + other_payments.paymentamount - expenses.totalexpenses -
	received_products.total                                                                      AS profit_loss,
	revenue.totalrevenue - payments.revenuesales                                                 AS unpaid_amount,
	inventory.inventoryvalue                                                                     AS inventory_value,
	revenue.totalrevenue                                                                         AS total_revenue,
	inventory.costofgoodssold                                                                    AS cost_of_goods_sold,
	revenue.totalrevenue - inventory.costofgoodssold                                             AS gross_profit,
	COALESCE((revenue.totalrevenue - inventory.costofgoodssold) / revenue.totalrevenue * 100, 0) AS gross_profit_margin
FROM
	(
		SELECT
			COALESCE(SUM(payamt), 0) AS revenuesales
		FROM
			bh_get_visit_payments(_ad_client_id, _begin_date, _end_date)
	) payments
		CROSS JOIN (
		SELECT
			COALESCE(SUM(payment_amount), 0) AS paymentamount
		FROM
			bh_get_insurer_donor_payments(_ad_client_id, _begin_date, _end_date)
	) AS other_payments
		CROSS JOIN (
		SELECT
			COALESCE(SUM(payment_amount), 0) AS debtpaymentamount
		FROM
			bh_get_debt_payments(_ad_client_id, _begin_date, _end_date)
	) AS debtPayments
		CROSS JOIN (
		SELECT
			COALESCE(SUM(ol.linenetamt)
			         FILTER ( WHERE pc.name IN ('Laboratory', 'Pharmacy', 'Radiology', 'Other', 'Standard') ),
			         0) AS total
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
			AND o.dateordered::date + o.updated::time BETWEEN _begin_date AND _end_date
	) received_products
		CROSS JOIN (
		SELECT
			COALESCE(SUM(i.grandtotal), 0) AS totalexpenses
		FROM
			c_invoice i
		WHERE
			i.ad_client_id = _ad_client_id
			AND i.docstatus = 'CO'
			AND i.issotrx = 'N'
			AND i.c_order_id IS NULL
			AND i.bh_visit_id IS NULL
			AND i.dateinvoiced::date + i.updated::time BETWEEN _begin_date AND _end_date
	) AS expenses
		CROSS JOIN (
		SELECT
			COALESCE(SUM((opening_stock + ending_stock) / 2 * purchase_price), 0) AS inventoryvalue,
			COALESCE(SUM(cost_of_goods_sold), 0)                                  AS costofgoodssold,
			COALESCE(SUM(gross_profit), 0)                                        AS grossprofit,
			COALESCE(SUM(sold_stock * sell_price), 0)                             AS inventory_sales
		FROM
			get_inventory_changes(_ad_client_id, _begin_date, _end_date)
	) AS inventory
		CROSS JOIN (
		SELECT
			COALESCE(SUM(o.grandtotal), 0) AS totalrevenue
		FROM
			bh_visit v
				JOIN c_order o
					ON v.bh_visit_id = o.bh_visit_id AND o.docstatus IN ('CO', 'CL')
		WHERE
			v.ad_client_id = _ad_client_id
			AND v.bh_visitdate BETWEEN _begin_date AND _end_date
	) AS revenue
$$;

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
			AND i.c_order_id IS NULL
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

DROP FUNCTION IF EXISTS bh_dashboard_get_financial_types(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_types(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        name      character varying,
		        frequency numeric,
		        type      character varying
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	chargetype_name      AS name,
	SUM(linenetamt) * -1 AS frequency,
	'Income'             AS type
FROM
	bh_get_visit_non_patient_payments(_ad_client_id, _begin_date, _end_date)
GROUP BY
	chargetype_name
UNION ALL
SELECT
	payment_mode_name AS name,
	SUM(payamt)       AS frequency,
	'Income'          AS type
FROM
	bh_get_visit_payments(_ad_client_id, _begin_date, _end_date)
GROUP BY
	payment_mode_name
UNION ALL
SELECT
	c.Name              AS name,
	SUM(cil.linenetamt) AS frequency,
	'Expense'
FROM
	c_invoice i
		JOIN c_invoiceline cil
			ON cil.c_invoice_id = i.c_invoice_id
		JOIN c_charge c
			ON c.c_charge_id = cil.c_charge_id
WHERE
	i.ad_client_id = _ad_client_id
	AND i.docstatus = 'CO'
	AND i.issotrx = 'N'
	AND i.c_order_id IS NULL
	AND i.bh_visit_id IS NULL
	AND i.dateinvoiced::date + i.updated::time BETWEEN _begin_date AND _end_date
GROUP BY
	c.Name
$$;

SELECT
	register_migration_script('202510101208_GO-3431.sql')
FROM
	dual;
