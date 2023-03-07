UPDATE c_bpartner bp
SET
	m_pricelist_id = pl.m_pricelist_id
FROM
	m_pricelist pl
WHERE
	bp.ad_client_id = pl.ad_client_id
	AND pl.issopricelist = 'Y'
	AND pl.isdefault = 'Y'
	AND pl.isactive = 'Y'
	AND bp.m_pricelist_id IS NULL
	AND bp.ad_client_id > 999999;

UPDATE m_pricelist
SET
	ad_org_id    = CASE WHEN ad_org_id = 0 THEN ad_client_id ELSE ad_org_id END,
	ad_client_id = CASE
		               WHEN ad_client_id = 0 OR (ad_client_id > ad_org_id AND ad_org_id != 0) THEN ad_org_id
		               ELSE ad_client_id END
WHERE
	(ad_client_id > 999999 OR ad_org_id > 999999)
	AND ad_client_id != ad_org_id;

SELECT
	register_migration_script('202303031114_GO-2638.sql')
FROM
	dual;
