UPDATE m_productprice pp
SET
	pricelimit = bh_sellprice,
	pricelist  = bh_sellprice,
	pricestd   = bh_sellprice
FROM
	m_product p
		CROSS JOIN m_pricelist_version plv
		JOIN m_pricelist pl
		ON plv.m_pricelist_id = pl.m_pricelist_id AND pl.issopricelist = 'Y' AND pl.isdefault = 'Y'
WHERE
	p.bh_sellprice != pp.pricestd
	AND p.m_product_id = pp.m_product_id
	AND pp.m_pricelist_version_id = plv.m_pricelist_version_id;

SELECT
	register_migration_script('202410091119_GO-3103.sql')
FROM
	dual;
