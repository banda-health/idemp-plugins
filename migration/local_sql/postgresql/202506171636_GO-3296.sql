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
	p.openingstock                                 AS opening_stock,
	p.endingstock                                  AS ending_stock,
	p.receivedstock                                AS received_stock,
	p.soldstock                                    AS sold_stock,
	p.balancestock                                 AS balanced_stock
FROM
	(
		SELECT
			p.m_product_id,
			pc.m_attributesetinstance_id,
			COALESCE(SUM(t.movementqty) FILTER ( WHERE t.updated < _start_date ), 0)               AS openingstock,
			COALESCE(SUM(t.movementqty) FILTER ( WHERE t.updated <= _end_date ), 0)                AS endingstock,
			COALESCE(SUM(t.movementqty) FILTER ( WHERE t.updated BETWEEN _start_date AND _end_date AND
			                                           t.movementtype IN ('V+', 'V-') ), 0)        AS receivedstock,
			COALESCE((SUM(t.movementqty) FILTER ( WHERE t.updated BETWEEN _start_date AND _end_date AND
			                                            t.movementtype IN ('C+', 'C-') ) * -1), 0) AS soldstock,
			COALESCE(SUM(t.movementqty) FILTER ( WHERE t.updated BETWEEN _start_date AND _end_date AND
			                                           t.movementtype IN ('I+', 'I-') ), 0)        AS balancestock,
			pc.purchase_price                                                                      AS PurchasePrice,
			pc.purchase_date                                                                       AS PurchaseDate,
			ol.priceactual                                                                         AS sell_price
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
		GROUP BY p.m_product_id, pc.m_attributesetinstance_id, pc.purchase_price, pc.purchase_date, ol.priceactual
	) p
WHERE
	endingstock > 0
	OR openingstock > 0
	OR receivedstock > 0
	OR soldstock > 0
	OR balancestock > 0
$$;

DROP FUNCTION IF EXISTS bh_dashboard_get_financial_historical(numeric, timestamp, timestamp);
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

DROP FUNCTION IF EXISTS bh_dashboard_get_financial_visit_charges(numeric, timestamp, timestamp);
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
	DATE_TRUNC('month', v.bh_visitdate);
$$;

SELECT
	register_migration_script('202506171636_GO-3296.sql')
FROM
	dual;
