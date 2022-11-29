DROP FUNCTION IF EXISTS get_inventory_changes(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE OR REPLACE FUNCTION get_inventory_changes(ad_client_id numeric,
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
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN QUERY
		WITH product_costs AS (
			SELECT
				pc.m_product_id,
				pc.m_attributesetinstance_id,
				pc.purchase_price,
				pc.purchase_date
			FROM
				get_product_costs($1) pc
		),
			non_reversed_inoutlines AS (
				SELECT
					iol.m_inoutline_id
				FROM
					m_inoutline iol
						LEFT JOIN m_inoutline riol
							ON iol.m_inoutline_id = riol.reversalline_id
				WHERE
					iol.ad_client_id = $1
					AND riol.m_inoutline_id IS NULL
					AND iol.reversalline_id IS NULL
			)
		SELECT
			p.m_product_id,
			p.m_attributesetinstance_id,
			p.PurchasePrice                                           AS purchase_price,
			p.PurchaseDate                                            AS purchase_date,
			p.sell_price,
			p.soldstock * p.PurchasePrice                             AS cost_of_goods_sold,
			p.soldstock * (p.sell_price - p.PurchasePrice)            AS gross_profit,
			p.openingstock                                            AS opening_stock,
			p.endingstock                                             AS ending_stock,
			p.receivedstock                                           AS received_stock,
			p.soldstock                                               AS sold_stock,
			p.balancestock                                            AS balanced_stock
		FROM
			(
				SELECT
					productname.m_product_id,
					productname.m_attributesetinstance_id,
					COALESCE(openqty.openqty, 0)             AS openingstock,
					COALESCE(currentqty.closingqty, 0)       AS endingstock,
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
							t.m_product_id,
							t.m_attributesetinstance_id,
							SUM(t.movementqty) AS openqty
						FROM
							m_transaction t
						WHERE
							t.ad_client_id = $1
							AND DATE(movementdate) < start_date
							AND t.isactive = 'Y'
						GROUP BY
							t.m_product_id,
							t.m_attributesetinstance_id
					) openqty
							ON openqty.m_product_id = productname.m_product_id
						AND openqty.m_attributesetinstance_id = productname.m_attributesetinstance_id
						LEFT JOIN (
						SELECT
							t.m_product_id,
							t.m_attributesetinstance_id,
							SUM(t.movementqty) AS closingqty
						FROM
							m_transaction t
						WHERE
							t.ad_client_id = $1
							AND DATE(movementdate) <= end_date
							AND t.isactive = 'Y'
						GROUP BY
							t.m_product_id,
							t.m_attributesetinstance_id
					) currentqty
							ON currentqty.m_product_id = productname.m_product_id
						AND currentqty.m_attributesetinstance_id = productname.m_attributesetinstance_id
						LEFT JOIN (
						SELECT
							ol.m_product_id,
							ol.m_attributesetinstance_id,
							SUM(ol.qtyentered) AS qtyreceived
						FROM
							c_orderline ol
								JOIN c_order o
									ON ol.c_order_id = o.c_order_id
						WHERE
							o.ad_client_id = $1
							AND DATE(ol.dateordered) BETWEEN $2 AND $3
							AND o.issotrx = 'N'
							AND o.docstatus IN ('CL', 'CO')
							AND ol.m_product_id IS NOT NULL
						GROUP BY
							ol.m_product_id,
							ol.m_attributesetinstance_id
					) stockreceived
							ON productname.m_product_id = stockreceived.m_product_id
						AND productname.m_attributesetinstance_id = stockreceived.m_attributesetinstance_id
						LEFT JOIN (
						SELECT
							t.m_product_id,
							t.m_attributesetinstance_id,
							SUM(t.movementqty) AS qtybalanced
						FROM
							m_transaction t
						WHERE
							t.ad_client_id = $1
							AND date(t.movementdate) BETWEEN $2 AND $3
							AND movementtype IN ('I+', 'I-')
						GROUP BY
							t.m_product_id,
							t.m_attributesetinstance_id
					) stocktakechange
							ON productname.m_product_id = stocktakechange.m_product_id
						AND productname.m_attributesetinstance_id = stocktakechange.m_attributesetinstance_id
						LEFT JOIN (
						SELECT
							iol.m_product_id,
							iolma.m_attributesetinstance_id,
							ol.priceactual         AS price,
							SUM(iolma.movementqty) AS qtysold
						FROM
							m_inoutline iol
								JOIN non_reversed_inoutlines nriol
									ON nriol.m_inoutline_id = iol.m_inoutline_id
								INNER JOIN m_inout io
									ON iol.m_inout_id = io.m_inout_id
								JOIN m_inoutlinema iolma
									ON iol.m_inoutline_id = iolma.m_inoutline_id
								JOIN c_orderline ol
									ON iol.c_orderline_id = ol.c_orderline_id
						WHERE
							iol.ad_client_id = $1
							AND date(io.movementdate) BETWEEN $2 AND $3
							AND io.movementtype = 'C-'
						GROUP BY
							iol.m_product_id,
							iolma.m_attributesetinstance_id,
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
			OR balancestock > 0;
END
$$;
