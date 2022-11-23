-- Get the clients to update
DROP TABLE IF EXISTS tmp_c_client_id;
SELECT
	ad_client_id
INTO TEMP TABLE
	tmp_c_client_id
FROM
	ad_client
WHERE
		ad_client_id IN (
		SELECT
			ad_client_id
		FROM
			c_elementvalue
		WHERE
			value = 'DEFAULTS_NOT_CONFIGURED'
	)
	AND ad_client_id NOT IN (
	SELECT
		ad_client_id
	FROM
		c_elementvalue
	WHERE
		value = '99999'
);

DROP TABLE IF EXISTS tmp_c_elementvalue_id_to_update;
SELECT
	ad_client_id,
	c_elementvalue_id
INTO TEMP TABLE
	tmp_c_elementvalue_id_to_update
FROM
	c_elementvalue
WHERE
	value = 'DEFAULTS_NOT_CONFIGURED'
	AND ad_client_id IN (
	SELECT
		ad_client_id
	FROM
		tmp_c_client_id
);

DROP TABLE IF EXISTS tmp_c_elementvalue_id_to_remove;
SELECT
	c_elementvalue_id
INTO TEMP TABLE
	tmp_c_elementvalue_id_to_remove
FROM
	c_elementvalue
WHERE
		value IN (
		          'B_ASSET',
		          'B_INTRANSIT',
		          'B_UNALLOCATEDCASH',
		          'CB_ASSET',
		          'CB_CASHTRANSFER',
		          'C_RECEIVABLE',
		          'C_RECEIVABLE_SERVICES',
		          'V_PREPAYMENT',
		          'T_CREDIT',
		          'INTERCOMPANYDUEFROM',
		          'P_ASSET',
		          'PJ_ASSET',
		          'PJ_WIP',
		          'V_LIABILITY',
		          'NOTINVOICEDRECEIPTS',
		          'V_LIABILITY_SERVICES',
		          'B_PAYMENTSELECT',
		          'C_PREPAYMENT',
		          'T_DUE',
		          'INTERCOMPANYDUETO',
		          'P_REVENUE',
		          'UNEARNEDREVENUE',
		          'P_TRADEDISCOUNTGRANT',
		          'PAYDISCOUNT_EXP',
		          'P_COGS',
		          'P_EXPENSE',
		          'P_COSTADJUSTMENT',
		          'P_LANDEDCOSTCLEARING',
		          'P_INVENTORYCLEARING',
		          'W_DIFFERENCES',
		          'P_INVOICEPRICEVARIANCE',
		          'P_PURCHASEPRICEVARIANCE',
		          'PPVOFFSET',
		          'P_RATEVARIANCE',
		          'P_AVERAGECOSTVARIANCE',
		          'P_TRADEDISCOUNTREC',
		          'PAYDISCOUNT_REV',
		          'T_EXPENSE',
		          'WRITEOFF',
		          'CB_DIFFERENCES',
		          'DEFAULT',
		          'SUSPENSEBALANCING',
		          'CB_EXPENSE',
		          'CB_RECEIPT',
		          'CH_EXPENSE',
		          'B_INTERESTREV',
		          'UNREALIZEDGAIN',
		          'REALIZEDGAIN',
		          'B_INTERESTEXP',
		          'UNREALIZEDLOSS',
		          'REALIZEDLOSS',
		          'CURRENCYBALANCING',
		          'COMMITMENTOFFSET',
		          'COMMITMENTOFFSETSALES')
	AND ad_client_id IN (
	SELECT
		ad_client_id
	FROM
		tmp_c_client_id
);

-- Update the base DEFAULTS_NOT_CONFIGURED account to be the DO NOT USE account
UPDATE c_elementvalue
SET
	value       = '99999',
	name        = 'DO NOT USE',
	description = 'DO NOT USE',
	accounttype = 'E',
	issummary   = 'N'
WHERE
	value = 'DEFAULTS_NOT_CONFIGURED'
	AND ad_client_id IN (
	SELECT
		ad_client_id
	FROM
		tmp_c_client_id
);

-- Update the valid combination labels to match and point to this new account
UPDATE c_validcombination
SET
	combination = '*-99999-_-_',
	description = '*-DO NOT USE-_-_'
WHERE
		account_id IN (
		SELECT
			c_elementvalue_id
		FROM
			tmp_c_elementvalue_id_to_update
	);
UPDATE c_validcombination vc
SET
	combination = '*-99999-_-_',
	description = '*-DO NOT USE-_-_',
	account_id  = tevitu.c_elementvalue_id
FROM
	tmp_c_elementvalue_id_to_update tevitu
WHERE
		account_id IN (
		SELECT
			c_elementvalue_id
		FROM
			tmp_c_elementvalue_id_to_remove
	)
	AND vc.ad_client_id = tevitu.ad_client_id;

-- Update other tables that were mapping to these accounts
ALTER TABLE c_acctschema_element
	DROP CONSTRAINT celementvalue_caschemaelement;
ALTER TABLE c_cash
	DROP CONSTRAINT celementvalueuser1_ccash;
ALTER TABLE c_cash
	DROP CONSTRAINT celementvalueuser2_ccash;
ALTER TABLE c_cashplan
	DROP CONSTRAINT user1_ccashplan;
ALTER TABLE c_cashplan
	DROP CONSTRAINT user2_ccashplan;
ALTER TABLE c_cashplanline
	DROP CONSTRAINT user1_ccashplanline;
ALTER TABLE c_cashplanline
	DROP CONSTRAINT user2_ccashplanline;
ALTER TABLE c_charge
	DROP CONSTRAINT c_charge_c_elementvalue_id_fkey;
ALTER TABLE c_elementvalue_trl
	DROP CONSTRAINT c_elementvalue_trl_c_elementvalue_id_fkey;
ALTER TABLE c_invoice
	DROP CONSTRAINT c_invoice_user1_id_fkey;
ALTER TABLE c_invoice
	DROP CONSTRAINT c_invoice_user2_id_fkey;
ALTER TABLE c_invoicebatchline
	DROP CONSTRAINT celementvalueu1_cinvoicebline;
ALTER TABLE c_invoicebatchline
	DROP CONSTRAINT celementvalueu2_cinvoicebline;
ALTER TABLE c_invoiceline
	DROP CONSTRAINT c_invoiceline_user1_id_fkey;
ALTER TABLE c_invoiceline
	DROP CONSTRAINT c_invoiceline_user2_id_fkey;
ALTER TABLE c_order
	DROP CONSTRAINT c_order_user1_id_fkey;
ALTER TABLE c_order
	DROP CONSTRAINT c_order_user2_id_fkey;
ALTER TABLE c_orderline
	DROP CONSTRAINT c_orderline_user1_id_fkey;
ALTER TABLE c_orderline
	DROP CONSTRAINT c_orderline_user2_id_fkey;
ALTER TABLE c_payment
	DROP CONSTRAINT c_payment_user1_id_fkey;
ALTER TABLE c_payment
	DROP CONSTRAINT c_payment_user2_id_fkey;
ALTER TABLE c_paymenttransaction
	DROP CONSTRAINT user1_cpaymenttransaction;
ALTER TABLE c_paymenttransaction
	DROP CONSTRAINT user2_cpaymenttransaction;
ALTER TABLE c_subacct
	DROP CONSTRAINT celementvalue_csubacct;
ALTER TABLE c_validcombination
	DROP CONSTRAINT c_validcombination_account_id_fkey;
ALTER TABLE c_validcombination
	DROP CONSTRAINT c_validcombination_user1_id_fkey;
ALTER TABLE c_validcombination
	DROP CONSTRAINT c_validcombination_user2_id_fkey;
ALTER TABLE dd_order
	DROP CONSTRAINT user1_ddorder;
ALTER TABLE dd_order
	DROP CONSTRAINT user2_ddorder;
ALTER TABLE dd_orderline
	DROP CONSTRAINT user1_ddorderline;
ALTER TABLE dd_orderline
	DROP CONSTRAINT user2_ddorderline;
ALTER TABLE fact_acct
	DROP CONSTRAINT fact_acct_account_id_fkey;
ALTER TABLE fact_acct
	DROP CONSTRAINT fact_acct_user1_id_fkey;
ALTER TABLE fact_acct
	DROP CONSTRAINT fact_acct_user2_id_fkey;
ALTER TABLE fact_acct_summary
	DROP CONSTRAINT account_factacctsummary;
ALTER TABLE fact_acct_summary
	DROP CONSTRAINT user1_factacctsummary;
ALTER TABLE fact_acct_summary
	DROP CONSTRAINT user2_factacctsummary;
ALTER TABLE gl_distribution
	DROP CONSTRAINT cevalueacct_gldist;
ALTER TABLE gl_distribution
	DROP CONSTRAINT cevalueuser1_gldist;
ALTER TABLE gl_distribution
	DROP CONSTRAINT cevalueuser2_gldist;
ALTER TABLE gl_distributionline
	DROP CONSTRAINT cevalueacct_gldistline;
ALTER TABLE gl_distributionline
	DROP CONSTRAINT cevalueuser1_gldistline;
ALTER TABLE gl_distributionline
	DROP CONSTRAINT cevalueuser2_gldistline;
ALTER TABLE gl_fundrestriction
	DROP CONSTRAINT celementvalue_glfundrestr;
ALTER TABLE gl_journalgenerator
	DROP CONSTRAINT celementvalueadjustcr_qssjourn;
ALTER TABLE gl_journalgenerator
	DROP CONSTRAINT celementvalueadjustdr_qssjourn;
ALTER TABLE gl_journalgeneratorline
	DROP CONSTRAINT celementvaluecr_qssjournalgene;
ALTER TABLE gl_journalgeneratorline
	DROP CONSTRAINT celementvaluedr_qssjournalgene;
ALTER TABLE gl_journalgeneratorsource
	DROP CONSTRAINT celementvalue_qssjournalgenera;
ALTER TABLE gl_journalline
	DROP CONSTRAINT account_gljournalline;
ALTER TABLE gl_journalline
	DROP CONSTRAINT user1_gljournalline;
ALTER TABLE gl_journalline
	DROP CONSTRAINT user2_gljournalline;
ALTER TABLE hr_concept_acct
	DROP CONSTRAINT user1_hrconceptacct;
ALTER TABLE hr_movement
	DROP CONSTRAINT user1_hrmovement;
ALTER TABLE hr_movement
	DROP CONSTRAINT user2_hrmovement;
ALTER TABLE i_elementvalue
	DROP CONSTRAINT i_elementvalue_c_elementvalue_id_fkey;
ALTER TABLE i_elementvalue
	DROP CONSTRAINT i_elementvalue_parentelementvalue_id_fkey;
ALTER TABLE i_fajournal
	DROP CONSTRAINT account_ifajournal;
ALTER TABLE i_fajournal
	DROP CONSTRAINT user1_ifajournal;
ALTER TABLE i_fajournal
	DROP CONSTRAINT user2_ifajournal;
ALTER TABLE i_gljournal
	DROP CONSTRAINT celvalueaccount_igljournal;
ALTER TABLE i_gljournal
	DROP CONSTRAINT celvalueuser2_igljournal;
ALTER TABLE i_gljournal
	DROP CONSTRAINT cevalueuser1_igljournal;
ALTER TABLE i_reportline
	DROP CONSTRAINT celementvalue_ireportline;
ALTER TABLE m_inout
	DROP CONSTRAINT m_inout_user1_id_fkey;
ALTER TABLE m_inout
	DROP CONSTRAINT m_inout_user2_id_fkey;
ALTER TABLE m_inoutline
	DROP CONSTRAINT m_inoutline_user1_id_fkey;
ALTER TABLE m_inoutline
	DROP CONSTRAINT m_inoutline_user2_id_fkey;
ALTER TABLE m_inventory
	DROP CONSTRAINT celementvalueuser1_minvent;
ALTER TABLE m_inventory
	DROP CONSTRAINT celementvalueuser2_minvent;
ALTER TABLE m_movement
	DROP CONSTRAINT celementvalueuser1_mmove;
ALTER TABLE m_movement
	DROP CONSTRAINT celementvalueuser2_mmove;
ALTER TABLE m_production
	DROP CONSTRAINT celementvalueuser1_mprod;
ALTER TABLE m_production
	DROP CONSTRAINT celementvalueuser2_mprod;
ALTER TABLE pa_ratioelement
	DROP CONSTRAINT celementvalue_paratioelement;
ALTER TABLE pa_reportcolumn
	DROP CONSTRAINT celementvalue_pareportcolumn;
ALTER TABLE pa_reportsource
	DROP CONSTRAINT celementvalue_pareportsource;
ALTER TABLE pp_order
	DROP CONSTRAINT user1_pporder;
ALTER TABLE pp_order
	DROP CONSTRAINT user2_pporder;
ALTER TABLE c_elementvalue
	DROP CONSTRAINT c_elementvalue_pkey;
ALTER TABLE c_elementvalue_trl
	DROP CONSTRAINT c_elementvalue_trl_pkey;

UPDATE fact_acct fa
SET
	account_id = tevitu.c_elementvalue_id
FROM
	tmp_c_elementvalue_id_to_update tevitu
WHERE
		account_id IN (
		SELECT
			c_elementvalue_id
		FROM
			tmp_c_elementvalue_id_to_remove
	)
	AND fa.ad_client_id = tevitu.ad_client_id;
UPDATE c_charge c
SET
	c_elementvalue_id = tevitu.c_elementvalue_id
FROM
	tmp_c_elementvalue_id_to_update tevitu
WHERE
		c.c_elementvalue_id IN (
		SELECT
			c_elementvalue_id
		FROM
			tmp_c_elementvalue_id_to_remove
	)
	AND c.ad_client_id = tevitu.ad_client_id;
UPDATE c_acctschema_element ase
SET
	c_elementvalue_id = tevitu.c_elementvalue_id
FROM
	tmp_c_elementvalue_id_to_update tevitu
WHERE
		ase.c_elementvalue_id IN (
		SELECT
			c_elementvalue_id
		FROM
			tmp_c_elementvalue_id_to_remove
	)
	AND ase.ad_client_id = tevitu.ad_client_id;

-- Delete the other bad element values
DELETE
FROM
	c_elementvalue
WHERE
		c_elementvalue_id IN (
		SELECT
			c_elementvalue_id
		FROM
			tmp_c_elementvalue_id_to_remove
	);
DELETE
FROM
	c_elementvalue_trl
WHERE
		c_elementvalue_id IN (
		SELECT
			c_elementvalue_id
		FROM
			tmp_c_elementvalue_id_to_remove
	);

ALTER TABLE c_elementvalue_trl
	ADD CONSTRAINT c_elementvalue_trl_pkey PRIMARY KEY (c_elementvalue_id, ad_language);
ALTER TABLE c_elementvalue
	ADD CONSTRAINT c_elementvalue_pkey PRIMARY KEY (c_elementvalue_id);
ALTER TABLE pp_order
	ADD CONSTRAINT user2_pporder FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pp_order
	ADD CONSTRAINT user1_pporder FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pa_reportsource
	ADD CONSTRAINT celementvalue_pareportsource FOREIGN KEY (c_elementvalue_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pa_reportcolumn
	ADD CONSTRAINT celementvalue_pareportcolumn FOREIGN KEY (c_elementvalue_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pa_ratioelement
	ADD CONSTRAINT celementvalue_paratioelement FOREIGN KEY (account_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_production
	ADD CONSTRAINT celementvalueuser2_mprod FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_production
	ADD CONSTRAINT celementvalueuser1_mprod FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_movement
	ADD CONSTRAINT celementvalueuser2_mmove FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_movement
	ADD CONSTRAINT celementvalueuser1_mmove FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_inventory
	ADD CONSTRAINT celementvalueuser2_minvent FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_inventory
	ADD CONSTRAINT celementvalueuser1_minvent FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_inoutline
	ADD CONSTRAINT m_inoutline_user2_id_fkey FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_inoutline
	ADD CONSTRAINT m_inoutline_user1_id_fkey FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_inout
	ADD CONSTRAINT m_inout_user2_id_fkey FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_inout
	ADD CONSTRAINT m_inout_user1_id_fkey FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_reportline
	ADD CONSTRAINT celementvalue_ireportline FOREIGN KEY (c_elementvalue_id) REFERENCES c_elementvalue (c_elementvalue_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_gljournal
	ADD CONSTRAINT cevalueuser1_igljournal FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_gljournal
	ADD CONSTRAINT celvalueuser2_igljournal FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_gljournal
	ADD CONSTRAINT celvalueaccount_igljournal FOREIGN KEY (account_id) REFERENCES c_elementvalue (c_elementvalue_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_fajournal
	ADD CONSTRAINT user2_ifajournal FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_fajournal
	ADD CONSTRAINT user1_ifajournal FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_fajournal
	ADD CONSTRAINT account_ifajournal FOREIGN KEY (account_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_elementvalue
	ADD CONSTRAINT i_elementvalue_parentelementvalue_id_fkey FOREIGN KEY (parentelementvalue_id) REFERENCES c_elementvalue (c_elementvalue_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_elementvalue
	ADD CONSTRAINT i_elementvalue_c_elementvalue_id_fkey FOREIGN KEY (c_elementvalue_id) REFERENCES c_elementvalue (c_elementvalue_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE hr_movement
	ADD CONSTRAINT user2_hrmovement FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE hr_movement
	ADD CONSTRAINT user1_hrmovement FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE hr_concept_acct
	ADD CONSTRAINT user1_hrconceptacct FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_journalline
	ADD CONSTRAINT user2_gljournalline FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_journalline
	ADD CONSTRAINT user1_gljournalline FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_journalline
	ADD CONSTRAINT account_gljournalline FOREIGN KEY (account_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_journalgeneratorsource
	ADD CONSTRAINT celementvalue_qssjournalgenera FOREIGN KEY (c_elementvalue_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_journalgeneratorline
	ADD CONSTRAINT celementvaluedr_qssjournalgene FOREIGN KEY (c_elementvaluedr_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_journalgeneratorline
	ADD CONSTRAINT celementvaluecr_qssjournalgene FOREIGN KEY (c_elementvaluecr_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_journalgenerator
	ADD CONSTRAINT celementvalueadjustdr_qssjourn FOREIGN KEY (c_elementvalueadjustdr_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_journalgenerator
	ADD CONSTRAINT celementvalueadjustcr_qssjourn FOREIGN KEY (c_elementvalueadjustcr_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_fundrestriction
	ADD CONSTRAINT celementvalue_glfundrestr FOREIGN KEY (c_elementvalue_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_distributionline
	ADD CONSTRAINT cevalueuser2_gldistline FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_distributionline
	ADD CONSTRAINT cevalueuser1_gldistline FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_distributionline
	ADD CONSTRAINT cevalueacct_gldistline FOREIGN KEY (account_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_distribution
	ADD CONSTRAINT cevalueuser2_gldist FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_distribution
	ADD CONSTRAINT cevalueuser1_gldist FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_distribution
	ADD CONSTRAINT cevalueacct_gldist FOREIGN KEY (account_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE fact_acct_summary
	ADD CONSTRAINT user2_factacctsummary FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE fact_acct_summary
	ADD CONSTRAINT user1_factacctsummary FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE fact_acct_summary
	ADD CONSTRAINT account_factacctsummary FOREIGN KEY (account_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE fact_acct
	ADD CONSTRAINT fact_acct_user2_id_fkey FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE fact_acct
	ADD CONSTRAINT fact_acct_user1_id_fkey FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE fact_acct
	ADD CONSTRAINT fact_acct_account_id_fkey FOREIGN KEY (account_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE dd_orderline
	ADD CONSTRAINT user2_ddorderline FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE dd_orderline
	ADD CONSTRAINT user1_ddorderline FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE dd_order
	ADD CONSTRAINT user2_ddorder FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE dd_order
	ADD CONSTRAINT user1_ddorder FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_validcombination
	ADD CONSTRAINT c_validcombination_user2_id_fkey FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_validcombination
	ADD CONSTRAINT c_validcombination_user1_id_fkey FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_validcombination
	ADD CONSTRAINT c_validcombination_account_id_fkey FOREIGN KEY (account_id) REFERENCES c_elementvalue (c_elementvalue_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_subacct
	ADD CONSTRAINT celementvalue_csubacct FOREIGN KEY (c_elementvalue_id) REFERENCES c_elementvalue (c_elementvalue_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_paymenttransaction
	ADD CONSTRAINT user2_cpaymenttransaction FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_paymenttransaction
	ADD CONSTRAINT user1_cpaymenttransaction FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_payment
	ADD CONSTRAINT c_payment_user2_id_fkey FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_payment
	ADD CONSTRAINT c_payment_user1_id_fkey FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_orderline
	ADD CONSTRAINT c_orderline_user2_id_fkey FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_orderline
	ADD CONSTRAINT c_orderline_user1_id_fkey FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_order
	ADD CONSTRAINT c_order_user2_id_fkey FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_order
	ADD CONSTRAINT c_order_user1_id_fkey FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT c_invoiceline_user2_id_fkey FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT c_invoiceline_user1_id_fkey FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_invoicebatchline
	ADD CONSTRAINT celementvalueu2_cinvoicebline FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_invoicebatchline
	ADD CONSTRAINT celementvalueu1_cinvoicebline FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_invoice
	ADD CONSTRAINT c_invoice_user2_id_fkey FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_invoice
	ADD CONSTRAINT c_invoice_user1_id_fkey FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_elementvalue_trl
	ADD CONSTRAINT c_elementvalue_trl_c_elementvalue_id_fkey FOREIGN KEY (c_elementvalue_id) REFERENCES c_elementvalue (c_elementvalue_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_charge
	ADD CONSTRAINT c_charge_c_elementvalue_id_fkey FOREIGN KEY (c_elementvalue_id) REFERENCES c_elementvalue (c_elementvalue_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_cashplanline
	ADD CONSTRAINT user2_ccashplanline FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_cashplanline
	ADD CONSTRAINT user1_ccashplanline FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_cashplan
	ADD CONSTRAINT user2_ccashplan FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_cashplan
	ADD CONSTRAINT user1_ccashplan FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_cash
	ADD CONSTRAINT celementvalueuser2_ccash FOREIGN KEY (user2_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_cash
	ADD CONSTRAINT celementvalueuser1_ccash FOREIGN KEY (user1_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_acctschema_element
	ADD CONSTRAINT celementvalue_caschemaelement FOREIGN KEY (c_elementvalue_id) REFERENCES c_elementvalue (c_elementvalue_id) DEFERRABLE INITIALLY DEFERRED;

-- Update the charges to have the correct
UPDATE c_charge c
SET
	c_elementvalue_id = vc.account_id
FROM
	c_charge_acct ca
		JOIN c_validcombination vc
			ON ca.ch_expense_acct = vc.c_validcombination_id
WHERE
	c.bh_locked = 'Y'
	AND c.c_charge_id = ca.c_charge_id
	AND c.ad_client_id IN (
	SELECT
		ad_client_id
	FROM
		tmp_c_client_id
);

SELECT
	register_migration_script('202211221315_GO-2496.sql')
FROM
	dual;
