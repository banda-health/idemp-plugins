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
			AND o.dateordered BETWEEN _begin_date::date AND _end_date::date
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
			AND i.bh_visit_id IS NULL
			AND i.dateinvoiced BETWEEN _begin_date AND _end_date
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
