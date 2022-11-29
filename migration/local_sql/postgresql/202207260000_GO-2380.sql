CREATE INDEX IF NOT EXISTS c_payment_bh_corder_id_index
	ON c_payment (bh_c_order_id);

CREATE INDEX IF NOT EXISTS c_payment_cinvoiceid_index
	ON c_payment (c_invoice_id);

CREATE INDEX IF NOT EXISTS c_payment_docstatus_index
	ON c_payment (docstatus);

SELECT
	register_migration_script('202207260000_GO-2380.sql')
FROM
	dual;
