-- There are some drafted visits that have been around for a while that escaped our recent update, so fix them
UPDATE c_invoice i
SET
	m_pricelist_id = o.m_pricelist_id
FROM
	bh_visit v
		JOIN c_order o
			ON v.bh_visit_id = o.bh_visit_id
WHERE
	i.bh_visit_id = v.bh_visit_id
	AND i.docstatus IN ('DR', 'IP')
	AND o.m_pricelist_id != i.m_pricelist_id
	AND o.c_bpartner_id = i.c_bpartner_id;

SELECT
	register_migration_script('202603061630_GO-3516.sql')
FROM
	dual;
