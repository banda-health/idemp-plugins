ALTER TABLE c_invoice
	DROP CONSTRAINT bhvisit_cinvoice;
ALTER TABLE c_order
	DROP CONSTRAINT bhvisit_corder;
ALTER TABLE c_payment
	DROP CONSTRAINT bhvisit_cpayment;
ALTER TABLE m_inout
	DROP CONSTRAINT bhvisit_minout;

DELETE
FROM
	bh_visit
WHERE
	bh_visit_id IN (
		SELECT
			v.bh_visit_id
		FROM
			bh_visit v
				LEFT JOIN c_order o
				ON v.bh_visit_id = o.bh_visit_id
				LEFT JOIN c_invoice i
				ON v.bh_visit_id = i.bh_visit_id
				LEFT JOIN c_payment p
				ON v.bh_visit_id = p.bh_visit_id
				LEFT JOIN m_inout io
				ON v.bh_visit_id = io.bh_visit_id
		WHERE
			o.c_order_id IS NULL
			AND i.c_invoice_id IS NULL
			AND p.c_payment_id IS NULL
			AND io.bh_visit_id IS NULL
	);

ALTER TABLE m_inout
	ADD CONSTRAINT bhvisit_minout FOREIGN KEY (bh_visit_id) REFERENCES bh_visit (bh_visit_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_payment
	ADD CONSTRAINT bhvisit_cpayment FOREIGN KEY (bh_visit_id) REFERENCES bh_visit (bh_visit_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_order
	ADD CONSTRAINT bhvisit_corder FOREIGN KEY (bh_visit_id) REFERENCES bh_visit (bh_visit_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_invoice
	ADD CONSTRAINT bhvisit_cinvoice FOREIGN KEY (bh_visit_id) REFERENCES bh_visit (bh_visit_id) DEFERRABLE INITIALLY DEFERRED;

SELECT
	register_migration_script('202410090835_GO-3094.sql')
FROM
	dual;
