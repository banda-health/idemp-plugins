-- Re-running part of 202311221052_GO-2837.sql since the DB sanitation for iDempiere 11 removed it accidentally
CREATE INDEX c_order_visit ON c_order (bh_visit_id);

SELECT
	register_migration_script('202412030906_GO-2837.sql')
FROM
	dual;
