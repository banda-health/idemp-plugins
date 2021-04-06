-- Drop constraints to/from/on c_payment to ensure the delete doesn't take forever
BEGIN;
	ALTER TABLE adempiere.c_bankaccount_processor DROP CONSTRAINT cpaymentprocessor_cbankaccount;
	ALTER TABLE adempiere.c_bp_bankaccount DROP CONSTRAINT cpaymentprocessor_cbpbankaccou;
	ALTER TABLE adempiere.c_bpartner DROP CONSTRAINT c_bpartner_c_paymentterm_id_fkey;
	ALTER TABLE adempiere.c_bpartner DROP CONSTRAINT c_bpartner_po_paymentterm_id_fkey;
	ALTER TABLE adempiere.c_dunninglevel DROP CONSTRAINT cpaymentterm_cdunninglevel;
	ALTER TABLE adempiere.c_invoice DROP CONSTRAINT c_invoice_c_paymentterm_id_fkey;
	ALTER TABLE adempiere.c_order DROP CONSTRAINT c_order_c_paymentterm_id_fkey;
	ALTER TABLE adempiere.c_payment DROP CONSTRAINT c_payment_c_paymentbatch_id_fkey;
	ALTER TABLE adempiere.c_payment DROP CONSTRAINT c_payment_c_paymentprocessor_id_fkey;
	ALTER TABLE adempiere.c_payment DROP CONSTRAINT c_payment_ref_payment_id_fkey;
	ALTER TABLE adempiere.c_payment DROP CONSTRAINT c_payment_reversal_id_fkey;
	ALTER TABLE adempiere.c_paymentbatch DROP CONSTRAINT cpaymtprocessor_cpaymtbatch;
	ALTER TABLE adempiere.c_paymentterm_trl DROP CONSTRAINT c_paymentterm_trl_c_paymentterm_id_fkey;
	ALTER TABLE adempiere.c_paymenttransaction DROP CONSTRAINT cpaymentbatch_cpaymenttransact;
	ALTER TABLE adempiere.c_paymenttransaction DROP CONSTRAINT cpaymentprocessor_cpaymenttran;
	ALTER TABLE adempiere.c_paymenttransaction DROP CONSTRAINT refpaymenttransaction_cpayment;
	ALTER TABLE adempiere.c_payschedule DROP CONSTRAINT cpaymentterm_cpayschedule;
	ALTER TABLE adempiere.c_project DROP CONSTRAINT c_project_c_paymentterm_id_fkey;
	ALTER TABLE adempiere.c_withholding DROP CONSTRAINT cpaymentterm_cwithholding;
	ALTER TABLE adempiere.i_invoice DROP CONSTRAINT cpaymentterm_iinvoice;
	ALTER TABLE adempiere.i_order DROP CONSTRAINT cpaymentterm_iorder;
	ALTER TABLE adempiere.w_store DROP CONSTRAINT cpaymentterm_wstore;
COMMIT;

-- Delete payments that weren't deleted when their orders were
BEGIN;

	DELETE
	FROM c_payment
	WHERE NOT EXISTS (SELECT * FROM c_order WHERE c_order.c_order_id = c_payment.bh_c_order_id)
		AND ad_client_id > 999999
		AND bh_c_order_id > 0;

COMMIT;

-- Re-add the constraints that were dropped above
BEGIN;
	ALTER TABLE adempiere.w_store ADD CONSTRAINT cpaymentterm_wstore FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm(c_paymentterm_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.i_order ADD CONSTRAINT cpaymentterm_iorder FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm(c_paymentterm_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.i_invoice ADD CONSTRAINT cpaymentterm_iinvoice FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm(c_paymentterm_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_withholding ADD CONSTRAINT cpaymentterm_cwithholding FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm(c_paymentterm_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_project ADD CONSTRAINT c_project_c_paymentterm_id_fkey FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm(c_paymentterm_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_payschedule ADD CONSTRAINT cpaymentterm_cpayschedule FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm(c_paymentterm_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_paymenttransaction ADD CONSTRAINT refpaymenttransaction_cpayment FOREIGN KEY (ref_paymenttransaction_id) REFERENCES c_paymenttransaction(c_paymenttransaction_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_paymenttransaction ADD CONSTRAINT cpaymentprocessor_cpaymenttran FOREIGN KEY (c_paymentprocessor_id) REFERENCES c_paymentprocessor(c_paymentprocessor_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_paymenttransaction ADD CONSTRAINT cpaymentbatch_cpaymenttransact FOREIGN KEY (c_paymentbatch_id) REFERENCES c_paymentbatch(c_paymentbatch_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_paymentterm_trl ADD CONSTRAINT c_paymentterm_trl_c_paymentterm_id_fkey FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm(c_paymentterm_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_paymentbatch ADD CONSTRAINT cpaymtprocessor_cpaymtbatch FOREIGN KEY (c_paymentprocessor_id) REFERENCES c_paymentprocessor(c_paymentprocessor_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_payment ADD CONSTRAINT c_payment_reversal_id_fkey FOREIGN KEY (reversal_id) REFERENCES c_payment(c_payment_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_payment ADD CONSTRAINT c_payment_ref_payment_id_fkey FOREIGN KEY (ref_payment_id) REFERENCES c_payment(c_payment_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_payment ADD CONSTRAINT c_payment_c_paymentprocessor_id_fkey FOREIGN KEY (c_paymentprocessor_id) REFERENCES c_paymentprocessor(c_paymentprocessor_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_payment ADD CONSTRAINT c_payment_c_paymentbatch_id_fkey FOREIGN KEY (c_paymentbatch_id) REFERENCES c_paymentbatch(c_paymentbatch_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_order ADD CONSTRAINT c_order_c_paymentterm_id_fkey FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm(c_paymentterm_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_invoice ADD CONSTRAINT c_invoice_c_paymentterm_id_fkey FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm(c_paymentterm_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_dunninglevel ADD CONSTRAINT cpaymentterm_cdunninglevel FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm(c_paymentterm_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_bpartner ADD CONSTRAINT c_bpartner_po_paymentterm_id_fkey FOREIGN KEY (po_paymentterm_id) REFERENCES c_paymentterm(c_paymentterm_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_bpartner ADD CONSTRAINT c_bpartner_c_paymentterm_id_fkey FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm(c_paymentterm_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_bp_bankaccount ADD CONSTRAINT cpaymentprocessor_cbpbankaccou FOREIGN KEY (c_paymentprocessor_id) REFERENCES c_paymentprocessor(c_paymentprocessor_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE adempiere.c_bankaccount_processor ADD CONSTRAINT cpaymentprocessor_cbankaccount FOREIGN KEY (c_paymentprocessor_id) REFERENCES c_paymentprocessor(c_paymentprocessor_id) DEFERRABLE INITIALLY DEFERRED;
COMMIT;

SELECT register_migration_script('202104061755_GO-1615.sql') FROM dual;
