ALTER TABLE bh_product_included
	ADD CONSTRAINT bh_product_included_key
		PRIMARY KEY (m_product_id, included_product_id);

SELECT
	register_migration_script('202504301426_GO-2334.sql')
FROM
	dual;
