-- Update the product selling price column to match the currently entered sell-price
UPDATE m_product p
SET
	bh_sellprice = pp.pricestd
FROM
	m_pricelist pl
		JOIN m_pricelist_version plv
		ON pl.m_pricelist_id = plv.m_pricelist_id AND plv.isactive = 'Y'
		JOIN m_productprice pp
		ON plv.m_pricelist_version_id = pp.m_pricelist_version_id
WHERE
	pp.m_product_id = p.m_product_id
	AND p.ad_client_id > 999999
	AND pl.isactive = 'Y'
	AND pl.issopricelist = 'Y'
	AND pl.isdefault = 'Y'
	AND p.bh_sellprice != pp.pricestd;

SELECT
	register_migration_script('202507141038_GO_3363.sql')
FROM
	dual;
