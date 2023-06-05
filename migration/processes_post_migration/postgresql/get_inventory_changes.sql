DROP FUNCTION IF EXISTS get_inventory_changes(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION get_inventory_changes(ad_client_id numeric,
                                      start_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                      end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
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
		get_product_costs($1) pc
),
	product_history AS (
		SELECT
			t.m_product_id,
			t.updatedby,
			t.m_inventoryline_id,
			t.m_inoutline_id,
			t.movementtype,
			t.m_attributesetinstance_id,
			COALESCE(v.bh_visitdate, t.updated)                                                                                                   AS date,
			t.movementqty,
					SUM(t.movementqty)
					OVER (PARTITION BY t.m_product_id ORDER BY COALESCE(v.bh_visitdate, t.updated) ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW ) AS endingqty
		FROM
			m_transaction t
				LEFT JOIN m_inoutline iol
					ON t.m_inoutline_id = iol.m_inoutline_id
				LEFT JOIN m_inout io
					ON iol.m_inout_id = io.m_inout_id
				LEFT JOIN bh_visit v
					ON io.bh_visit_id = v.bh_visit_id
		WHERE
			t.ad_client_id = $1
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
			productname.m_product_id,
			productname.m_attributesetinstance_id,
			COALESCE(openqty.openqty, 0)             AS openingstock,
			COALESCE(endingqty.closingqty, 0)        AS endingstock,
			COALESCE(stockreceived.qtyreceived, 0)   AS receivedstock,
			COALESCE(stocksold.qtysold, 0)           AS soldstock,
			COALESCE(stocktakechange.qtybalanced, 0) AS balancestock,
			product_costs.purchase_price             AS PurchasePrice,
			product_costs.purchase_date              AS PurchaseDate,
			stocksold.price                          AS sell_price
		FROM
			(
				SELECT
					p.m_product_id,
					pc.m_attributesetinstance_id,
					p.name
				FROM
					m_product p
						LEFT JOIN product_costs pc
							ON pc.m_product_id = p.m_product_id
				WHERE
					p.ad_client_id = $1
				GROUP BY
					p.m_product_id,
					p.name,
					pc.m_attributesetinstance_id
			) productname
				LEFT JOIN (
				SELECT
					ph.m_product_id,
					ph.m_attributesetinstance_id,
					SUM(ph.movementqty) AS openqty
				FROM
					product_history ph
				WHERE
					ph.date < $2
				GROUP BY
					ph.m_product_id,
					ph.m_attributesetinstance_id
			) openqty
					ON openqty.m_product_id = productname.m_product_id
				AND openqty.m_attributesetinstance_id = productname.m_attributesetinstance_id
				LEFT JOIN (
				SELECT
					ph.m_product_id,
					ph.m_attributesetinstance_id,
					SUM(ph.movementqty) AS closingqty
				FROM
					product_history ph
				WHERE
					ph.date <= $3
				GROUP BY
					ph.m_product_id,
					ph.m_attributesetinstance_id
			) endingqty
					ON endingqty.m_product_id = productname.m_product_id
				AND endingqty.m_attributesetinstance_id = productname.m_attributesetinstance_id
				LEFT JOIN (
				SELECT
					ph.m_product_id,
					ph.m_attributesetinstance_id,
					SUM(ph.movementqty) AS qtyreceived
				FROM
					product_history ph
				WHERE
					ph.date BETWEEN $2 AND $3
					AND ph.movementtype IN ('V+', 'V-')
				GROUP BY
					ph.m_product_id,
					ph.m_attributesetinstance_id
			) stockreceived
					ON productname.m_product_id = stockreceived.m_product_id
				AND productname.m_attributesetinstance_id = stockreceived.m_attributesetinstance_id
				LEFT JOIN (
				SELECT
					ph.m_product_id,
					ph.m_attributesetinstance_id,
					SUM(ph.movementqty) AS qtybalanced
				FROM
					product_history ph
				WHERE
					ph.date BETWEEN $2 AND $3
					AND ph.movementtype IN ('I+', 'I-')
				GROUP BY
					ph.m_product_id,
					ph.m_attributesetinstance_id
			) stocktakechange
					ON productname.m_product_id = stocktakechange.m_product_id
				AND productname.m_attributesetinstance_id = stocktakechange.m_attributesetinstance_id
				LEFT JOIN (
				SELECT
					ph.m_product_id,
					ph.m_attributesetinstance_id,
					ol.priceactual           AS price,
					SUM(ph.movementqty) * -1 AS qtysold
				FROM
					product_history ph
						JOIN m_inoutline iol
							ON iol.m_inoutline_id = ph.m_inoutline_id
						JOIN c_orderline ol
							ON iol.c_orderline_id = ol.c_orderline_id
				WHERE
					ph.date BETWEEN $2 AND $3
					AND ph.movementtype IN ('C+', 'C-')
				GROUP BY
					ph.m_product_id,
					ph.m_attributesetinstance_id,
					ol.priceactual
			) stocksold
					ON productname.m_product_id = stocksold.m_product_id
				AND productname.m_attributesetinstance_id = stocksold.m_attributesetinstance_id
				LEFT JOIN product_costs
					ON product_costs.m_product_id = productname.m_product_id
				AND product_costs.m_attributesetinstance_id = productname.m_attributesetinstance_id
	) p
WHERE
	endingstock > 0
	OR openingstock > 0
	OR receivedstock > 0
	OR soldstock > 0
	OR balancestock > 0
$$;
