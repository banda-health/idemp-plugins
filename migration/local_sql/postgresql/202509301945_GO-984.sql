-- Update all payments with invoice IDs to point to also leverage the BH_Original_C_Invoice_ID column
UPDATE c_payment
SET
	bh_original_c_invoice_id = c_invoice_id
WHERE
	c_invoice_id IS NOT NULL;

SELECT
	register_migration_script('202509301945_GO-984.sql')
FROM
	dual;
