DROP FUNCTION IF EXISTS bh_dashboard_get_financial_open_balances(numeric, timestamp, timestamp);

DROP FUNCTION IF EXISTS bh_dashboard_get_financial_general_metrics(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_general_metrics(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        revenue_sales       numeric,
		        total_expenses      numeric,
		        net_profit          numeric,
		        total_owed          numeric,
		        inventory_value     numeric,
		        total_charges       numeric,
		        cost_of_goods_sold  numeric,
		        gross_profit        numeric,
		        gross_profit_margin numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH payments AS (
	SELECT
		COALESCE(SUM(payamt), 0) AS revenuesales
	FROM
		bh_get_visit_payments(_ad_client_id, _begin_date, _end_date)
)

SELECT
	payments.revenuesales                                                   AS revenuesales,
	expenses.totalexpenses                                                  AS totalexpenses,
	payments.revenuesales - expenses.totalexpenses                          AS netprofit,
	billdetails.saleslineitemtotals - payments.revenuesales                 AS totalowed,
	inventory.inventoryvalue                                                AS inventoryvalue,
	charges.totalcharges                                                    AS totalcharges,
	inventory.costofgoodssold                                               AS costofgoodssold,
	inventory.grossprofit                                                   AS grossprofit,
	COALESCE(ROUND(inventory.grossprofit / payments.revenuesales * 100), 0) AS grossprofitmargin
FROM
	payments
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
			COALESCE(SUM(saleslineitemtotals), 0) AS saleslineitemtotals,
			COALESCE(SUM(salestotals), 0)         AS salestotals
		FROM
			bh_get_visit_details(_ad_client_id, _begin_date, _end_date)
		WHERE
			docstatus NOT IN ('VO', 'DR')
	) billdetails
		CROSS JOIN (
		SELECT
			COALESCE(SUM((opening_stock + ending_stock) / 2 * purchase_price), 0) AS inventoryvalue,
			COALESCE(SUM(cost_of_goods_sold), 0)                                  AS costofgoodssold,
			COALESCE(SUM(gross_profit), 0)                                        AS grossprofit
		FROM
			get_inventory_changes(_ad_client_id, _begin_date, _end_date)
		WHERE
			opening_stock > 0
			OR ending_stock > 0
	) AS inventory
		CROSS JOIN (
		SELECT
			COALESCE(SUM(o.grandtotal), 0) AS totalcharges
		FROM
			bh_visit v
				JOIN c_order o
				ON v.bh_visit_id = o.bh_visit_id AND o.docstatus IN ('CO', 'CL')
		WHERE
			v.ad_client_id = _ad_client_id
			AND v.bh_visitdate BETWEEN _begin_date AND _end_date
	) AS charges
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
	months.GENERATE_SERIES                                                           AS bucket_value,
	COALESCE(p.total_income + dp.debtpaymentamount, 0)                               AS total_income,
	COALESCE(e.total_expenses + rp.total, 0)                                         AS total_expenses,
	COALESCE(p.total_income + dp.debtpaymentamount - e.total_expenses - rp.total, 0) AS net_profit
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
ORDER BY
	months.GENERATE_SERIES;
$$;

DROP FUNCTION IF EXISTS bh_dashboard_get_financial_open_balances(numeric);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_open_balances(_ad_client_id numeric)
	RETURNS table
	        (
		        name             character varying,
		        totalopenbalance numeric,
		        type             character varying
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	name,
	totalopenbalance,
	type
FROM
	(
		SELECT
			bp.name             AS name,
			bp.totalopenbalance AS totalopenbalance,
			'Patient'           AS type
		FROM
			c_bpartner bp
				LEFT JOIN c_payment p
				ON bp.c_bpartner_id = p.c_bpartner_id
				JOIN c_bp_group bpg
				ON bp.c_bp_group_id = bpg.c_bp_group_id
		WHERE
			bp.ad_client_id = _ad_client_id
			AND bp.totalopenbalance != 0
			AND bpg.name = 'Patients - DO NOT CHANGE'
		GROUP BY
			bp.name, bp.totalopenbalance
		ORDER BY bp.totalopenbalance DESC
		LIMIT 10
	) AS summary1

UNION ALL

SELECT
	name,
	SUM(totalopenbalance) AS totalopenbalance,
	type
FROM
	(
		SELECT
			'Other'                  AS name,
			SUM(bp.totalopenbalance) AS totalopenbalance,
			'Patient'                AS type
		FROM
			c_bpartner bp
				LEFT JOIN c_payment p
				ON bp.c_bpartner_id = p.c_bpartner_id
				JOIN c_bp_group bpg
				ON bp.c_bp_group_id = bpg.c_bp_group_id
		WHERE
			bp.ad_client_id = _ad_client_id
			AND bp.totalopenbalance != 0
			AND bpg.name = 'Patients - DO NOT CHANGE'
		GROUP BY bp.totalopenbalance
		ORDER BY bp.totalopenbalance DESC
		OFFSET 10
	) AS summary2
GROUP BY
	name, type

UNION ALL

SELECT
	name,
	totalopenbalance,
	type
FROM
	(
		SELECT
			bp.name             AS name,
			bp.totalopenbalance AS totalopenbalance,
			'Provider'          AS type
		FROM
			c_bpartner bp
				LEFT JOIN c_payment p
				ON bp.c_bpartner_id = p.c_bpartner_id
				JOIN c_bp_group bpg
				ON bp.c_bp_group_id = bpg.c_bp_group_id
		WHERE
			bp.ad_client_id = _ad_client_id
			AND bp.totalopenbalance != 0
			AND
			bpg.name IN ('Capitation Insurance - DO NOT CHANGE', 'Donors - DO NOT CHANGE', 'FFS Insurance - DO NOT CHANGE')
		ORDER BY bp.totalopenbalance DESC
		LIMIT 10
	) AS summary3

UNION ALL

SELECT
	name,
	totalopenbalance,
	type
FROM
	(
		SELECT
			'Other'                  AS name,
			SUM(bp.totalopenbalance) AS totalopenbalance,
			'Provider'               AS type
		FROM
			c_bpartner bp
				LEFT JOIN c_payment p
				ON bp.c_bpartner_id = p.c_bpartner_id
				JOIN c_bp_group bpg
				ON bp.c_bp_group_id = bpg.c_bp_group_id
		WHERE
			bp.ad_client_id = _ad_client_id
			AND bp.totalopenbalance != 0
			AND
			bpg.name IN ('Capitation Insurance - DO NOT CHANGE', 'Donors - DO NOT CHANGE', 'FFS Insurance - DO NOT CHANGE')
		GROUP BY bp.totalopenbalance
		ORDER BY bp.totalopenbalance DESC
		OFFSET 10
	) AS summary2;
$$;

DROP FUNCTION IF EXISTS bh_dashboard_get_financial_sources(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_sources(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        source    character varying,
		        frequency numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH nonpatientpayments AS (
	SELECT
		npp.charge_subtype_name AS source,
		SUM(linenetamt) * -1    AS frequency
	FROM
		bh_get_visit_non_patient_payments(_ad_client_id, _begin_date, _end_date) npp
	GROUP BY charge_subtype_name
),
	patientpayments AS (
		SELECT
			'Patient Direct' AS source,
			SUM(payamt)      AS frequency
		FROM
			bh_get_visit_payments(_ad_client_id, _begin_date, _end_date)
	)

SELECT
	source,
	frequency
FROM
	nonpatientpayments npp
UNION ALL
SELECT
	source,
	frequency
FROM
	patientpayments
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
	AND i.bh_visit_id IS NULL
	AND i.dateinvoiced BETWEEN _begin_date AND _end_date
GROUP BY
	c.Name
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
		SUM(sold_stock * sell_price) FILTER ( WHERE sold_stock > 0 ) AS sales_value,
		COALESCE(SUM(cost_of_goods_sold), 0)                         AS costofgoodssold,
		COALESCE(SUM(gross_profit), 0)                               AS grossprofit,
		SUM((opening_stock + ending_stock) / 2 * purchase_price) /
		SUM(sold_stock * sell_price) FILTER ( WHERE sold_stock > 0 ) AS stock_to_sales_ratio
	FROM
		get_inventory_changes(_ad_client_id, _begin_date, _end_date)
	WHERE
		opening_stock > 0
		OR ending_stock > 0
)
SELECT
	costofgoodssold / averagestock                                               AS inventory_turnover_rate,
	(averagestock / costofgoodssold) * EXTRACT(DAY FROM _end_date - _begin_date) AS days_on_hand,
	stock_to_sales_ratio                                                         AS sales_to_stock_ratio,
	grossprofit / sales_value * 100                                              AS gross_margin,
	(grossprofit / stock_value) * 100                                            AS return_on_investment
FROM
	data
$$;

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
			t.ad_client_id = _ad_client_id
			AND t.movementtype IN ('C+', 'C-')
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
			t.ad_client_id = _ad_client_id
			AND t.movementtype IN ('C+', 'C-')
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
			t.ad_client_id = _ad_client_id
			AND t.movementtype IN ('V+', 'V-')
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

SELECT
	register_migration_script('202506231926_GO-3297.sql')
FROM
	dual;
