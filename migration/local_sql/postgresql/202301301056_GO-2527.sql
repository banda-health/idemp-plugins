/**********************************************************************************************************/
-- This script tries to clean up the open balances for our OTC patients by doing the following things:
-- 1. Get a list of all Banda payments and the iDempiere payments
-- 2. Update all allocations for the automatically-created iDempiere payments to point to Banda's
-- 3. Delete the automatically-created iDempiere payments
-- 4. Mark the Banda payments as allocated
-- 5. Update total open balance for all the OTC business partners
-- 6. Update payment rules and wrap up
/**********************************************************************************************************/

/**********************************************************************************************************/
-- 1. Get a list of all Banda payments and the iDempiere payments
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_payment_id_mapping;

SELECT
	ip.c_payment_id   AS idemp_payment_id,
	banp.c_payment_id AS banda_payment_id
INTO TEMP TABLE
	tmp_payment_id_mapping
FROM
	c_payment ip
		JOIN c_allocationline al
			ON ip.c_payment_id = al.c_payment_id
		JOIN c_allocationhdr ah
			ON al.c_allocationhdr_id = ah.c_allocationhdr_id
		JOIN c_invoice i
			ON al.c_invoice_id = i.c_invoice_id
		JOIN c_order o
			ON i.c_order_id = o.c_order_id
		JOIN c_payment banp
			ON banp.bh_c_order_id = o.c_order_id
		JOIN c_bpartner bp
			ON o.c_bpartner_id = bp.c_bpartner_id
		JOIN c_bp_group bpg
			ON bp.c_bp_group_id = bpg.c_bp_group_id
WHERE
	ip.bh_tender_amount IS NULL
	AND banp.bh_tender_amount IS NOT NULL
	AND ip.isallocated = 'Y'
	AND bpg.name = 'OTC Patient'
	AND ah.docstatus NOT IN ('VO', 'RE', 'RA');

/**********************************************************************************************************/
-- 2. Update all allocations for the automatically-created iDempiere payments to point to Banda's
/**********************************************************************************************************/
UPDATE c_allocationline
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;

UPDATE C_BankStatementLine
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE C_AllocationLine
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE R_RequestAction
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE C_DunningRunLine
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE C_Recurring_Run
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE B_SellerFunds
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE C_Recurring
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE I_BankStatement
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE B_BuyerFunds
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE C_PaymentAllocate
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE I_Payment
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE C_DepositBatchLine
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE C_Invoice
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE C_PaymentTransaction
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE C_PaySelectionCheck
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE R_Request
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE C_Order
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE C_POSPayment
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;
UPDATE C_CashLine
SET
	c_payment_id = banda_payment_id
FROM
	tmp_payment_id_mapping
WHERE
	c_payment_id = idemp_payment_id;

/**********************************************************************************************************/
-- 3. Delete the automatically-created iDempiere payments
/**********************************************************************************************************/
DELETE
FROM
	c_payment
WHERE
		c_payment_id IN (
		SELECT
			idemp_payment_id
		FROM
			tmp_payment_id_mapping
	);

/**********************************************************************************************************/
-- 4. Mark the Banda payments as allocated
/**********************************************************************************************************/
ALTER TABLE b_buyerfunds
	DROP CONSTRAINT IF EXISTS cpayment_bbuyerfunds;
ALTER TABLE b_sellerfunds
	DROP CONSTRAINT IF EXISTS cpayment_bsellerfunds;
ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS c_allocationline_c_payment_id_fkey;
ALTER TABLE c_bankstatementline
	DROP CONSTRAINT IF EXISTS cpayment_cbankstmtline;
ALTER TABLE c_cashline
	DROP CONSTRAINT IF EXISTS cpayment_ccashline;
ALTER TABLE c_depositbatchline
	DROP CONSTRAINT IF EXISTS cpayment_cdepositbatchline;
ALTER TABLE c_dunningrunline
	DROP CONSTRAINT IF EXISTS cpayment_cdunningrunline;
ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_payment_id_fkey;
ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_payment_id_fkey;
ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_ref_payment_id_fkey;
ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_reversal_id_fkey;
ALTER TABLE c_paymentallocate
	DROP CONSTRAINT IF EXISTS cpayment_cpaymentallocate;
ALTER TABLE c_paymenttransaction
	DROP CONSTRAINT IF EXISTS cpayment_cpaymenttransaction;
ALTER TABLE c_payselectioncheck
	DROP CONSTRAINT IF EXISTS cpayment_cpayselectioncheck;
ALTER TABLE c_pospayment
	DROP CONSTRAINT IF EXISTS cpayment_cpospayment;
ALTER TABLE c_recurring
	DROP CONSTRAINT IF EXISTS cpayment_crecurring;
ALTER TABLE c_recurring_run
	DROP CONSTRAINT IF EXISTS cpayment_crecurringrun;
ALTER TABLE i_bankstatement
	DROP CONSTRAINT IF EXISTS cpayment_ibankstatement;
ALTER TABLE i_payment
	DROP CONSTRAINT IF EXISTS cpayment_ipayment;
ALTER TABLE r_request
	DROP CONSTRAINT IF EXISTS cpayment_rrequest;
ALTER TABLE r_requestaction
	DROP CONSTRAINT IF EXISTS cpayment_rrequestaction;

UPDATE c_payment
SET
	isallocated = 'Y'
WHERE
		c_payment_id IN (
		SELECT
			banda_payment_id
		FROM
			tmp_payment_id_mapping
	);

ALTER TABLE r_requestaction
	ADD CONSTRAINT cpayment_rrequestaction FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE r_request
	ADD CONSTRAINT cpayment_rrequest FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_payment
	ADD CONSTRAINT cpayment_ipayment FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_bankstatement
	ADD CONSTRAINT cpayment_ibankstatement FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_recurring_run
	ADD CONSTRAINT cpayment_crecurringrun FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_recurring
	ADD CONSTRAINT cpayment_crecurring FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_pospayment
	ADD CONSTRAINT cpayment_cpospayment FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_payselectioncheck
	ADD CONSTRAINT cpayment_cpayselectioncheck FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_paymenttransaction
	ADD CONSTRAINT cpayment_cpaymenttransaction FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_paymentallocate
	ADD CONSTRAINT cpayment_cpaymentallocate FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_payment
	ADD CONSTRAINT c_payment_reversal_id_fkey FOREIGN KEY (reversal_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_payment
	ADD CONSTRAINT c_payment_ref_payment_id_fkey FOREIGN KEY (ref_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_order
	ADD CONSTRAINT c_order_c_payment_id_fkey FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_invoice
	ADD CONSTRAINT c_invoice_c_payment_id_fkey FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_dunningrunline
	ADD CONSTRAINT cpayment_cdunningrunline FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_depositbatchline
	ADD CONSTRAINT cpayment_cdepositbatchline FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_cashline
	ADD CONSTRAINT cpayment_ccashline FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_bankstatementline
	ADD CONSTRAINT cpayment_cbankstmtline FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_allocationline
	ADD CONSTRAINT c_allocationline_c_payment_id_fkey FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE b_sellerfunds
	ADD CONSTRAINT cpayment_bsellerfunds FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE b_buyerfunds
	ADD CONSTRAINT cpayment_bbuyerfunds FOREIGN KEY (c_payment_id) REFERENCES c_payment (c_payment_id) DEFERRABLE INITIALLY DEFERRED;

/**********************************************************************************************************/
-- 5. Update total open balance for all the OTC business partners
/**********************************************************************************************************/
UPDATE c_bpartner bp
SET
	so_creditused    = COALESCE(calc.so_creditused, bp.so_creditused),
	totalopenbalance = COALESCE(calc.totalopenbalance, bp.totalopenbalance),
	socreditstatus   = CASE
		                   WHEN bp.socreditstatus IN ('X', 'S') OR bp.so_creditlimit = 0 THEN bp.socreditstatus
		                   WHEN bp.so_creditlimit < COALESCE(calc.totalopenbalance, bp.totalopenbalance) THEN 'H'
		                   WHEN bp.so_creditlimit * 0.9 < COALESCE(calc.totalopenbalance, bp.totalopenbalance) THEN 'W'
		                   ELSE 'O' END
FROM
	(
		SELECT
			COALESCE((
				         SELECT
					         SUM(currencyBase(invoiceOpen(i.C_Invoice_ID, i.C_InvoicePaySchedule_ID), i.C_Currency_ID,
					                          i.DateInvoiced,
					                          i.AD_Client_ID, i.AD_Org_ID))
				         FROM
					         C_Invoice_v i
				         WHERE
					         i.C_BPartner_ID = bp.C_BPartner_ID
					         AND i.IsSOTrx = 'Y'
					         AND i.IsPaid = 'N'
					         AND i.DocStatus IN ('CO', 'CL')
			         ), 0)                    AS so_creditused,
				COALESCE((
					         SELECT
						         SUM(currencyBase(invoiceOpen(i.C_Invoice_ID, i.C_InvoicePaySchedule_ID), i.C_Currency_ID,
						                          i.DateInvoiced, i.AD_Client_ID, i.AD_Org_ID) * i.MultiplierAP)
					         FROM
						         C_Invoice_v i
					         WHERE
						         i.C_BPartner_ID = bp.C_BPartner_ID
						         AND i.IsPaid = 'N'
						         AND i.DocStatus IN ('CO', 'CL')
				         ), 0) - COALESCE((
					                          SELECT
						                          SUM(currencyBase(Paymentavailable(p.C_Payment_ID), p.C_Currency_ID, p.DateTrx,
						                                           p.AD_Client_ID, p.AD_Org_ID))
					                          FROM
						                          C_Payment_v p
					                          WHERE
						                          p.C_BPartner_ID = bp.C_BPartner_ID
						                          AND p.IsAllocated = 'N'
						                          AND p.C_Charge_ID IS NULL
						                          AND p.DocStatus IN ('CO', 'CL')
				                          ), 0) AS totalopenbalance,
			c_bpartner_id
		FROM
			C_BPartner bp
		WHERE
				bp.c_bpartner_id IN (
				SELECT
					c_bpartner_id
				FROM
					c_payment
				WHERE
						c_payment_id IN (
						SELECT
							banda_payment_id
						FROM
							tmp_payment_id_mapping
					)
			)
	) calc
WHERE
	calc.c_bpartner_id = bp.c_bpartner_id;

/**********************************************************************************************************/
-- 6. Update payment rules and wrap up
/**********************************************************************************************************/
DROP TABLE tmp_payment_id_mapping;

-- Update payment rules of the OTC business partners to be credit
UPDATE c_bpartner
SET
	paymentrule    = 'P', -- on credit
	socreditstatus = 'X'  -- no credit check
WHERE
	ad_client_id > 999999
	OR ad_client_id = 2;

SELECT
	register_migration_script('202301301056_GO-2527.sql')
FROM
	dual;
