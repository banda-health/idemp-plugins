-- Get the purchase price lists for each client
SELECT
	m_priceList_version_id
INTO TEMP TABLE
	tmp_purchase_pricelist_version
FROM
	(
		SELECT
			plv.m_pricelist_version_id,
					ROW_NUMBER()
					OVER ( PARTITION BY pl.ad_client_id ORDER BY pl.isdefault DESC, pl.created DESC, plv.validfrom DESC) AS pl_num
		FROM
			m_pricelist_version plv
				JOIN m_pricelist pl
					ON plv.m_pricelist_id = pl.m_pricelist_id AND pl.isactive = 'Y' AND pl.issopricelist = 'N'
				JOIN ad_client c
					ON plv.ad_client_id = c.ad_client_id AND c.isactive = 'Y'
		WHERE
			plv.isactive = 'Y'
			AND plv.ad_client_id > 999999
	) l
WHERE
	pl_num = 1;

CREATE TEMP TABLE tmp_m_productprice
(
	m_pricelist_version_id numeric(10)             NOT NULL,
	m_product_id           numeric(10)             NOT NULL,
	ad_client_id           numeric(10)             NOT NULL,
	ad_org_id              numeric(10)             NOT NULL,
-- 	isactive char default 'Y'::bpchar not null,
-- 	created timestamp default now() not null,
	createdby              numeric(10) DEFAULT 100 NOT NULL,
-- 	updated timestamp default now() not null,
	updatedby              numeric(10) DEFAULT 100 NOT NULL,
	pricelist              numeric                 NOT NULL,
	pricestd               numeric                 NOT NULL,
	pricelimit             numeric                 NOT NULL,
	m_productprice_uu      varchar(36) DEFAULT uuid_generate_v4(),
	m_productprice_id      serial                  NOT NULL
);

SELECT
	SETVAL(
			'tmp_m_productprice_m_productprice_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'M_ProductPrice'
				LIMIT 1
			)::INT,
			FALSE
	);

-- Insert product prices for active products with no purchase product price
INSERT INTO
	tmp_m_productprice (m_pricelist_version_id, m_product_id, ad_client_id, ad_org_id, pricelist, pricestd, pricelimit)
SELECT
	tpplv.m_pricelist_version_id,
	p.m_product_id,
	p.ad_client_id,
	p.ad_org_id,
	COALESCE(p.bh_buyprice, 0),
	COALESCE(p.bh_buyprice, 0),
	COALESCE(p.bh_buyprice, 0)
FROM
	tmp_purchase_pricelist_version tpplv
		JOIN m_pricelist_version plv
			ON tpplv.m_priceList_version_id = plv.m_pricelist_version_id
		JOIN m_product p
			ON plv.ad_client_id = p.ad_client_id AND p.isactive = 'Y' and p.producttype = 'I'
		LEFT JOIN m_productprice pp
			ON p.m_product_id = pp.m_product_id AND plv.m_pricelist_version_id = pp.m_pricelist_version_id
WHERE
	pp.m_productprice_id IS NULL;

INSERT INTO
	m_productprice (m_pricelist_version_id, m_product_id, ad_client_id, ad_org_id, createdby, updatedby, pricelist,
	                pricestd, pricelimit, m_productprice_uu, m_productprice_id)
SELECT
	m_pricelist_version_id,
	m_product_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	pricelist,
	pricestd,
	pricelimit,
	m_productprice_uu,
	m_productprice_id
FROM
	tmp_m_productprice;

SELECT
	register_migration_script('2025080813012_GO-3390.sql')
FROM
	dual;
