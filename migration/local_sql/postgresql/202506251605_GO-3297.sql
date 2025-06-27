DROP FUNCTION IF EXISTS bh_get_insurer_donor_payments(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION bh_get_insurer_donor_payments(_ad_client_id numeric, _begin_date timestamp WITHOUT TIME ZONE,
                                              _end_date timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        c_payment_id        numeric,
		        cashier_id          numeric,
		        cashier_uu          character varying,
		        cashier             character varying,
		        payment_date        timestamp,
		        c_bpartner_id       numeric,
		        c_bpartner_uu       character varying,
		        patient_name        character varying,
		        payment_mode_letter character varying,
		        payment_mode_name   character varying,
		        totalopenbalance    numeric,
		        payment_amount      numeric,
		        docstatus           character varying,
		        processing          character varying
	        )
	LANGUAGE sql
AS
$$
SELECT
	p.c_payment_id,
	cashier.ad_user_id    AS cashier_id,
	cashier.ad_user_uu    AS cashier_uu,
	cashier.name          AS cashier,
	p.datetrx             AS payment_date,
	bp.c_bpartner_id      AS c_bpartner_id,
	bp.c_bpartner_uu      AS c_bpartner_uu,
	bp.name               AS patient_name,
	p.tendertype::varchar AS payment_mode_letter,
	rl.name               AS payment_mode_name,
	bp.totalopenbalance   AS totalopenbalance,
	p.payamt              AS payment_amount,
	p.docstatus::varchar,
	p.processing::varchar
FROM
	c_payment p
		JOIN c_bpartner bp
		ON p.c_bpartner_id = bp.c_bpartner_id
		JOIN c_bp_group bpg
		ON bp.c_bp_group_id = bpg.c_bp_group_id
		JOIN ad_ref_list rl
		ON p.tendertype = rl.value AND AD_Reference_ID = 214
		JOIN ad_user cashier
		ON p.createdby = cashier.ad_user_id
		LEFT JOIN c_payment p2
		ON p.c_payment_id = p2.reversal_id
WHERE
	p.ad_client_id = _ad_client_id
	AND p.bh_visit_id IS NULL
	AND bpg.bh_subtype IN ('I', 'D')
	AND p.datetrx BETWEEN _begin_date::date AND _end_date::date
	AND p.bh_visit_id IS NULL
	AND p.reversal_id IS NULL
	AND p.docstatus NOT IN ('RE', 'VO')
	AND p2.c_payment_id IS NULL;
$$;

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

DROP FUNCTION IF EXISTS bh_dashboard_get_inventory_general_metrics(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_inventory_general_metrics(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        inventory_turnover_rate numeric,
		        days_on_hand            numeric,
		        sales_to_stock_ratio    numeric,
		        gross_margin            numeric,
		        return_on_investment    numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH data AS (
	SELECT
		SUM((opening_stock + ending_stock) / 2)                      AS averagestock,
		SUM((opening_stock + ending_stock) / 2 * purchase_price)     AS stock_value,
		COALESCE(SUM(cost_of_goods_sold), 0)                         AS costofgoodssold,
		SUM((opening_stock + ending_stock) / 2 * purchase_price) /
		SUM(sold_stock * sell_price) FILTER ( WHERE sold_stock > 0 ) AS stock_to_sales_ratio
	FROM
		get_inventory_changes(_ad_client_id, _begin_date, _end_date)
),
	revenue AS (
		SELECT
			COALESCE(SUM(o.grandtotal), 0) AS totalrevenue
		FROM
			bh_visit v
				JOIN c_order o
				ON v.bh_visit_id = o.bh_visit_id AND o.docstatus IN ('CO', 'CL')
		WHERE
			v.ad_client_id = _ad_client_id
			AND v.bh_visitdate BETWEEN _begin_date AND _end_date
	)
SELECT
	COALESCE(costofgoodssold, 0) /
	(CASE WHEN averagestock = 0 THEN 1 ELSE COALESCE(averagestock, 1) END)       AS inventory_turnover_rate,
	(COALESCE(averagestock, 0) / (CASE WHEN costofgoodssold = 0 THEN 1 ELSE COALESCE(costofgoodssold, 1) END)) *
	EXTRACT(DAY FROM _end_date - _begin_date)                                    AS days_on_hand,
	stock_to_sales_ratio                                                         AS sales_to_stock_ratio,
	(COALESCE(totalrevenue, 0) - COALESCE(costofgoodssold, 0)) /
	(CASE WHEN totalrevenue = 0 THEN 1 ELSE COALESCE(totalrevenue, 1) END) * 100 AS gross_margin,
	(COALESCE(totalrevenue, 0) - COALESCE(costofgoodssold, 0)) /
	(CASE WHEN stock_value = 0 THEN 1 ELSE COALESCE(stock_value, 1) END) * 100   AS return_on_investment
FROM
	data
		CROSS JOIN revenue
$$;

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

DROP FUNCTION IF EXISTS get_inventory_changes(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION get_inventory_changes(_ad_client_id numeric,
                                      _start_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                      _end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        m_product_id              numeric,
		        m_attributesetinstance_id numeric,
		        purchase_price            numeric,
		        purchase_date             timestamp WITHOUT TIME ZONE,
		        sell_price                numeric,
		        cost_of_goods_sold        numeric,
		        gross_profit              numeric,
		        gain_loss                 numeric,
		        opening_stock             numeric,
		        ending_stock              numeric,
		        received_stock            numeric,
		        sold_stock                numeric,
		        balanced_stock            numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH product_costs AS (
	SELECT
		pc.m_product_id,
		pc.m_attributesetinstance_id,
		pc.purchase_price,
		pc.purchase_date
	FROM
		get_product_costs(_ad_client_id) pc
)
SELECT
	p.m_product_id,
	p.m_attributesetinstance_id,
	p.PurchasePrice                                AS purchase_price,
	p.PurchaseDate                                 AS purchase_date,
	p.sell_price,
	p.soldstock * p.PurchasePrice                  AS cost_of_goods_sold,
	p.soldstock * (p.sell_price - p.PurchasePrice) AS gross_profit,
	p.balancestock * p.PurchasePrice               AS gain_loss,
	p.openingstock                                 AS opening_stock,
	p.endingstock                                  AS ending_stock,
	p.receivedstock                                AS received_stock,
	p.soldstock                                    AS sold_stock,
	p.balancestock                                 AS balanced_stock
FROM
	(
		SELECT
			m_product_id,
			m_attributesetinstance_id,
			openingstock,
			endingstock,
			receivedstock,
			balancestock,
			PurchaseDate,
			PurchasePrice,
			COALESCE(SUM((STRING_TO_ARRAY(sell_information, ',', 'null'))[1]::numeric), 0) AS soldstock,
			(STRING_TO_ARRAY(sell_information, ',', 'null'))[2]::numeric                   AS sell_price
		FROM
			(
				SELECT
					p.m_product_id,
					pc.m_attributesetinstance_id,
					COALESCE(SUM(t.movementqty) FILTER ( WHERE t.updated < _start_date ), 0)   AS openingstock,
					COALESCE(SUM(t.movementqty) FILTER ( WHERE t.updated <= _end_date ), 0)    AS endingstock,
					COALESCE(
							SUM(t.movementqty) FILTER ( WHERE t.updated BETWEEN _start_date AND _end_date AND
							                                  t.movementtype IN ('V+', 'V-') ), 0) AS receivedstock,
					COALESCE(
							SUM(t.movementqty) FILTER ( WHERE t.updated BETWEEN _start_date AND _end_date AND
							                                  t.movementtype IN ('I+', 'I-') ), 0) AS balancestock,
					pc.purchase_price                                                          AS PurchasePrice,
					pc.purchase_date                                                           AS PurchaseDate,
					UNNEST(CASE
						       WHEN ARRAY_AGG(t.movementqty * -1 || ',' || COALESCE(ol.priceactual, 0))
						            FILTER ( WHERE t.updated BETWEEN _start_date AND _end_date AND
						                           t.movementtype IN ('C+', 'C-') ) IS NULL THEN '{null}'
						       ELSE ARRAY_AGG(t.movementqty * -1 || ',' || COALESCE(ol.priceactual, 0))
						            FILTER ( WHERE t.updated BETWEEN _start_date AND _end_date AND
						                           t.movementtype IN ('C+', 'C-') ) END)         AS sell_information
				FROM
					m_product p
						LEFT JOIN product_costs pc
						ON pc.m_product_id = p.m_product_id
						LEFT JOIN m_transaction t
						ON p.m_product_id = t.m_product_id AND t.m_attributesetinstance_id = pc.m_attributesetinstance_id
						LEFT JOIN m_inoutline iol
						ON iol.m_inoutline_id = t.m_inoutline_id AND t.movementtype IN ('C+', 'C-')
						LEFT JOIN c_orderline ol
						ON iol.c_orderline_id = ol.c_orderline_id
				WHERE
					p.ad_client_id = _ad_client_id
				GROUP BY
					p.m_product_id, pc.m_attributesetinstance_id, pc.purchase_price, pc.purchase_date
			) AS p
		GROUP BY
			m_product_id, m_attributesetinstance_id, openingstock, endingstock, receivedstock, balancestock, PurchaseDate,
			PurchasePrice, (STRING_TO_ARRAY(sell_information, ',', 'null'))[2]::numeric
	) AS p
WHERE
	endingstock > 0
	OR openingstock > 0
	OR receivedstock > 0
	OR soldstock > 0
	OR balancestock > 0
$$;

SELECT
	register_migration_script('202506251605_GO-3297.sql')
FROM
	dual;
