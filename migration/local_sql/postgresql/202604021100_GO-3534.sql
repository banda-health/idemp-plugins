-- Get all ASIs that don't have any transactions in the system
SELECT
	asi.m_attributesetinstance_id
INTO TEMP TABLE
	tmp_unused_asis
FROM
	m_attributesetinstance asi
WHERE
	asi.m_attributesetinstance_id != 0
	AND NOT EXISTS(
		SELECT 1 FROM m_transaction t WHERE t.m_attributesetinstance_id = asi.m_attributesetinstance_id
	);

-- Get all V+ ASIs that have transactions but aren't used on any shipment
SELECT
	t.m_attributesetinstance_id
INTO TEMP TABLE
	tmp_unshipped_asis
FROM
	m_transaction t
WHERE
	t.movementtype = 'V+'
	AND m_attributesetinstance_id != 0
	AND NOT EXISTS(
		SELECT
			1
		FROM
			m_inoutline iol
		WHERE
			iol.m_inoutline_id = t.m_inoutline_id
			AND iol.m_attributesetinstance_id = t.m_attributesetinstance_id
	);

-- Map them together and update InOuts/Orders to use the transaction ASIs
SELECT
	iol.m_attributesetinstance_id AS old_asi,
	t.m_attributesetinstance_id   AS new_asi
INTO TEMP TABLE
	tmp_asi_mappings
FROM
	m_transaction t
		JOIN m_inoutline iol
			ON t.m_inoutline_id = iol.m_inoutline_id
WHERE
	EXISTS(
		SELECT 1 FROM tmp_unshipped_asis WHERE m_attributesetinstance_id = t.m_attributesetinstance_id
	)
	AND EXISTS(
		SELECT 1 FROM tmp_unused_asis WHERE m_attributesetinstance_id = iol.m_attributesetinstance_id
	);
UPDATE m_inoutline iol
SET
	m_attributesetinstance_id = tam.new_asi
FROM
	tmp_asi_mappings tam
WHERE
	iol.m_attributesetinstance_id = tam.old_asi;
UPDATE c_orderline ol
SET
	m_attributesetinstance_id = tam.new_asi
FROM
	tmp_asi_mappings tam
WHERE
	ol.m_attributesetinstance_id = tam.old_asi;
UPDATE m_storagereservationlog srl
SET
	m_attributesetinstance_id = tam.new_asi
FROM
	tmp_asi_mappings tam
WHERE
	srl.m_attributesetinstance_id = tam.old_asi;
DELETE
FROM
	m_storagereservation
WHERE
	m_attributesetinstance_id IN (
		SELECT
			old_asi
		FROM
			tmp_asi_mappings
	);
UPDATE m_matchpo mpo
SET
	m_attributesetinstance_id = tam.new_asi
FROM
	tmp_asi_mappings tam
WHERE
	mpo.m_attributesetinstance_id = tam.old_asi;
UPDATE m_matchinv mi
SET
	m_attributesetinstance_id = tam.new_asi
FROM
	tmp_asi_mappings tam
WHERE
	mi.m_attributesetinstance_id = tam.old_asi;
UPDATE m_costdetail cd
SET
	m_attributesetinstance_id = tam.new_asi
FROM
	tmp_asi_mappings tam
WHERE
	cd.m_attributesetinstance_id = tam.old_asi;
DELETE
FROM
	m_cost
WHERE
	m_attributesetinstance_id IN (
		SELECT
			old_asi
		FROM
			tmp_asi_mappings
	);
UPDATE c_invoiceline il
SET
	m_attributesetinstance_id = tam.new_asi
FROM
	tmp_asi_mappings tam
WHERE
	il.m_attributesetinstance_id = tam.old_asi;

-- Delete the ASIs that aren't used anywhere
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	m_attributesetinstance
WHERE
	m_attributesetinstance_id IN (
		SELECT old_asi
		FROM tmp_asi_mappings
	);$$, 'm_attributesetinstance_id');

DROP FUNCTION IF EXISTS get_product_costs(numeric);
CREATE FUNCTION get_product_costs(_ad_client_id numeric)
	RETURNS TABLE
	        (
		        m_product_id              numeric,
		        m_attributesetinstance_id numeric,
		        purchase_price            numeric,
		        purchase_date             timestamp WITHOUT TIME ZONE
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	t.m_product_id,
	t.m_attributesetinstance_id,
	t.purchase_price,
	t.purchase_date
FROM
	(
		SELECT
			p.m_product_id,
			COALESCE(p_asis.m_attributesetinstance_id, 0)                               AS m_attributesetinstance_id,
			CASE
				WHEN p.m_attributeset_id != 0 AND p_asis.m_attributesetinstance_id = 0 THEN NULL
				ELSE
					COALESCE(price_on_reception.po_price, CASE WHEN p.bh_buyprice = 0 THEN NULL ELSE p.bh_buyprice END,
					         productPP.PurchasePrice, 0) END                                AS purchase_price,
			CASE
				WHEN p.m_attributeset_id != 0 AND
				     p_asis.m_attributesetinstance_id = 0 THEN NULL
				ELSE
					COALESCE(price_on_reception.date_purchased, asi.created, p.created) END AS purchase_date
		FROM
			m_product p
				LEFT JOIN (
				SELECT
					t.m_product_id,
					t.m_attributesetinstance_id
				FROM
					m_transaction t
				WHERE
					t.ad_client_id = _ad_client_id
				GROUP BY t.m_product_id, t.m_attributesetinstance_id
			) p_asis
					ON p_asis.m_product_id = p.m_product_id
				LEFT JOIN (
				SELECT
					asi.m_attributesetinstance_id,
					asi.created
				FROM
					m_attributesetinstance asi
				WHERE
					asi.ad_client_id = _ad_client_id
			) asi
					ON asi.m_attributesetinstance_id = p_asis.m_attributesetinstance_id
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
							AND o.ad_client_id = _ad_client_id
					) l
				WHERE
					rownum = 1
			) AS price_on_reception
					ON price_on_reception.m_product_id = p.m_product_id AND
					   price_on_reception.m_attributesetinstance_id = p_asis.m_attributesetinstance_id
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
							AND pl.ad_client_id = _ad_client_id
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
			p.ad_client_id = _ad_client_id
	) t
GROUP BY
	t.m_product_id, t.m_attributesetinstance_id, t.purchase_price, t.purchase_date;
$$;

SELECT
	register_migration_script('202604021100_GO-3534.sql')
FROM
	dual;