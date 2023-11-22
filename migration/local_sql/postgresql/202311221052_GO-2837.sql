CREATE INDEX c_order_visit ON c_order (bh_visit_id);
CREATE INDEX m_inout_visit ON m_inout (bh_visit_id);
CREATE INDEX c_invoice_visit ON c_invoice (bh_visit_id);
CREATE INDEX c_payment_visit ON c_payment (bh_visit_id);

SELECT
	register_migration_script('202311221052_GO-2837.sql')
FROM
	dual;
