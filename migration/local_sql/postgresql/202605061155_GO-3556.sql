-- Return the standard position from 10 to 2
UPDATE c_currency
SET
	stdprecision = 2
WHERE
	c_currency_id = 266;

-- Correct buying prices of products that have too many decimals
UPDATE m_productprice pp
SET
	pricestd   = ROUND(pricestd, 2),
	pricelist  = ROUND(pricelist, 2),
	pricelimit = ROUND(pricelimit, 2)
FROM
	m_pricelist_version plv
		CROSS JOIN m_product p
		JOIN m_pricelist pl
			ON plv.m_pricelist_id = pl.m_pricelist_id AND pl.issopricelist = 'Y' AND pl.isactive = 'Y'
WHERE
	pp.m_pricelist_version_id = plv.m_pricelist_version_id
	AND pp.m_product_id = p.m_product_id
	AND p.bh_sellprice != ROUND(p.bh_sellprice, 2);
UPDATE m_product
SET
	bh_sellprice = ROUND(bh_sellprice, 2)
WHERE
	bh_sellprice != ROUND(bh_sellprice, 2)
	AND updated > '2026-04-10';

-- Go through and update orders that have used this to make sure that all the buying prices and things are correct

-- TODO: Update invoices, payments, allocations, and accounting. Then finally, reset open balances for the involved business partners. 

-- Register the migration script
SELECT
	register_migration_script('202605061155_GO-3556.sql')
FROM
	dual;
