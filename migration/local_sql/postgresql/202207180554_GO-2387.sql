-- Add a check to only pull costs that match the currency of the client's default bank account's currency
CREATE OR REPLACE FUNCTION get_product_costs(ad_client_id numeric,
                                             m_product_ids character varying DEFAULT ''::character varying)
	RETURNS TABLE
	        (
		        m_product_id              numeric,
		        m_attributesetinstance_id numeric,
		        purchase_price            numeric,
		        purchase_date             timestamp WITHOUT TIME ZONE
	        )
	LANGUAGE plpgsql
AS
$$
BEGIN
	DROP TABLE IF EXISTS tmp_m_product_id;
	CREATE TEMP TABLE tmp_m_product_id
	(
		m_product_id numeric
	);

	IF m_product_ids = '' THEN
		BEGIN
			INSERT INTO tmp_m_product_id SELECT p.m_product_id FROM m_product p WHERE p.ad_client_id = $1;
		END;
	ELSE
		BEGIN
			EXECUTE
						'INSERT INTO tmp_m_product_id SELECT p.m_product_id FROM m_product p WHERE p.ad_client_id = $1 AND p.m_product_id IN (' ||
						$2 || ');' USING $1;
		END;
	END IF;

	RETURN QUERY
		SELECT
			p.m_product_id,
			p_asis.m_attributesetinstance_id                                                       AS m_attributesetinstance_id,
			CASE
				WHEN p.m_attributeset_id != 0 AND p_asis.m_attributesetinstance_id = 0 THEN NULL
				ELSE
					COALESCE(price_on_reception.po_price, costs.currentcostprice, p.bh_buyprice, productPP.PurchasePrice,
					         0) END                                                                    AS purchase_price,
			CASE
				WHEN p.m_attributeset_id != 0 AND
				     p_asis.m_attributesetinstance_id = 0 THEN NULL
				ELSE
					COALESCE(price_on_reception.date_purchased, soh.datematerialpolicy, p.created) END AS purchase_date
		FROM
			m_product p
				JOIN (
				SELECT
					t.m_product_id,
					t.m_attributesetinstance_id
				FROM
					m_transaction t
						JOIN tmp_m_product_id tpi
							ON t.m_product_id = tpi.m_product_id
				WHERE
					t.ad_client_id = $1
				GROUP BY t.m_product_id, t.m_attributesetinstance_id
			) p_asis
					ON p_asis.m_product_id = p.m_product_id
				LEFT JOIN (
				SELECT
					soh.m_product_id,
					soh.m_attributesetinstance_id,
					soh.datematerialpolicy
				FROM
					m_storageonhand soh
				WHERE
					soh.ad_client_id = $1
				GROUP BY soh.m_product_id, soh.m_attributesetinstance_id, soh.datematerialpolicy
			) soh
					ON p.m_product_id = soh.m_product_id AND soh.m_attributesetinstance_id = p_asis.m_attributesetinstance_id
				LEFT JOIN (
				SELECT
					l.m_product_id,
					l.po_price,
					l.m_attributesetinstance_id,
					l.date_purchased
				FROM
					(
						SELECT
							ol.m_product_id,
							ol.priceactual                                                                                                    AS po_price,
							ol.m_attributesetinstance_id,
							o.dateordered::DATE + o.updated::TIME                                                                             AS date_purchased,
									ROW_NUMBER()
									OVER (PARTITION BY ol.m_product_id, ol.m_attributesetinstance_id ORDER BY o.dateordered DESC, o.updated DESC) AS rownum
						FROM
							c_orderline ol
								JOIN c_order o
									ON ol.c_order_id = o.c_order_id
						WHERE
							o.issotrx = 'N'
							AND o.docstatus IN ('CL', 'CO')
							AND ol.m_product_id IS NOT NULL
							AND o.ad_client_id = $1
					) l
				WHERE
					rownum = 1
			) AS price_on_reception
					ON price_on_reception.m_product_id = p.m_product_id AND
					   price_on_reception.m_attributesetinstance_id = p_asis.m_attributesetinstance_id
				LEFT JOIN (
				SELECT
					c.m_product_id,
					c.m_attributesetinstance_id,
					c.currentcostprice
				FROM
					m_cost c
						JOIN c_acctschema actsch
							ON c.c_acctschema_id = actsch.c_acctschema_id
						AND c.m_costtype_id = actsch.m_costtype_id
						JOIN m_costelement ce
							ON c.m_costelement_id = ce.m_costelement_id
						AND ce.costingmethod = actsch.costingmethod
				WHERE
					c.currentcostprice > 0
					AND c.ad_client_id = $1
					AND actsch.c_currency_id IN (
					SELECT ba.c_currency_id FROM c_bankaccount ba WHERE ba.ad_client_id = $1 AND ba.isdefault = 'Y'
				)
			) costs
					ON costs.m_product_id = p.m_product_id AND costs.m_attributesetinstance_id = p_asis.m_attributesetinstance_id
				LEFT JOIN (
				SELECT
					pp.m_product_id,
					pp.pricestd AS PurchasePrice
				FROM
					(
						SELECT
							pl.m_pricelist_id,
							ROW_NUMBER() OVER (ORDER BY pl.created DESC) AS row_num
						FROM
							m_pricelist pl
						WHERE
							pl.issopricelist = 'N'
							AND pl.isdefault = 'Y'
							AND pl.isactive = 'Y'
							AND pl.ad_client_id = $1
					) pl
						JOIN m_pricelist_version plv
							ON pl.m_pricelist_id = plv.m_pricelist_id
						JOIN m_productprice pp
							ON plv.m_pricelist_version_id = pp.m_pricelist_version_id
				WHERE
					pl.row_num = 1
			) AS productPP
					ON productPP.m_product_id = p.m_product_id
		WHERE
			p.ad_client_id = $1;

	DROP TABLE IF EXISTS tmp_m_product_id;
END
$$;

SELECT register_migration_script('202207180554_GO-2387.sql') FROM dual;
