-- Combine storage records with the same product, ASI, and locator into the most recent date material policy row
DROP TABLE IF EXISTS tmp_storageonhand_to_update;
SELECT
	soh.m_product_id,
	soh.m_attributesetinstance_id,
	soh.m_locator_id,
	SUM(qtyonhand) AS totalqty,
	mmp.m_storageonhand_uu
INTO TEMP TABLE
	tmp_storageonhand_to_update
FROM
	m_storageonhand soh
		JOIN (
		SELECT
			m_product_id,
			m_attributesetinstance_id,
			m_locator_id,
			COUNT(*) AS storage_count
		FROM
			m_storageonhand
		GROUP BY m_product_id, m_attributesetinstance_id, m_locator_id
	) d -- duplicates
			ON d.m_product_id = soh.m_product_id AND d.m_attributesetinstance_id = soh.m_attributesetinstance_id AND
			   d.m_locator_id = soh.m_locator_id AND d.storage_count > 1
		JOIN (
		SELECT
			m_product_id,
			m_attributesetinstance_id,
			m_locator_id,
			m_storageonhand_uu,
					ROW_NUMBER()
					OVER (PARTITION BY m_product_id,m_attributesetinstance_id,m_locator_id ORDER BY datematerialpolicy DESC) AS row_num
		FROM
			m_storageonhand
	) mmp -- max_material_policy
			ON mmp.m_product_id = soh.m_product_id AND mmp.m_attributesetinstance_id = soh.m_attributesetinstance_id AND
			   mmp.m_locator_id = soh.m_locator_id AND mmp.row_num = 1
GROUP BY
	soh.m_product_id, soh.m_attributesetinstance_id, soh.m_locator_id, mmp.m_storageonhand_uu;

-- Update the row totals to be the one with the most recent material policy date
UPDATE m_storageonhand soh
SET
	qtyonhand = tsohtu.totalqty
FROM
	tmp_storageonhand_to_update tsohtu
WHERE
	tsohtu.m_storageonhand_uu = soh.m_storageonhand_uu;

-- Set all other records = 0
UPDATE m_storageonhand soh
SET
	qtyonhand = 0
FROM
	tmp_storageonhand_to_update tsohtu
WHERE
	tsohtu.m_storageonhand_uu != soh.m_storageonhand_uu
	AND tsohtu.m_product_id = soh.m_product_id
	AND tsohtu.m_attributesetinstance_id = soh.m_attributesetinstance_id
	AND tsohtu.m_locator_id = soh.m_locator_id;

-- Remove records older than three days
DELETE
FROM
	m_storageonhand
WHERE
	created < 'now'::timestamp - '3 days'::interval
	AND qtyonhand = 0;


-- Update the product costs function
-- NB: Unfortunately, this update slows the function down to 1/3 it's previous speed. Despite all my thoughts,
-- I couldn't speed it up. I would welcome any suggestions...
DROP FUNCTION IF EXISTS get_product_costs(ad_client_id numeric);
CREATE OR REPLACE FUNCTION get_product_costs(ad_client_id numeric, m_product_ids varchar = '')
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
					iol.m_product_id,
					iol.m_attributesetinstance_id
				FROM
					m_inoutline iol
						JOIN tmp_m_product_id tpi
							ON iol.m_product_id = tpi.m_product_id
				WHERE
					iol.ad_client_id = $1
				GROUP BY iol.m_product_id, iol.m_attributesetinstance_id
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


SELECT register_migration_script('202206170530_GO-2354.sql') FROM dual;
