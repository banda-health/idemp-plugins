package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_PaymentProcessor;

/**
 * Generated Interface for C_PaymentProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_PaymentProcessorInput extends I_C_PaymentProcessor {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_Sequence.
	 *
	 * @param AD_Sequence Document Sequence
	 */
	void setAD_Sequence(I_AD_SequenceInput AD_Sequence);

	/**
	 * Get AD_Sequence.
	 *
	 * @return Document Sequence
	 */
	I_AD_SequenceInput getAD_Sequence();

	/**
	 * Set C_BankAccount.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	void setC_BankAccount(I_C_BankAccountInput C_BankAccount);

	/**
	 * Get C_BankAccount.
	 *
	 * @return Account at the Bank
	 */
	I_C_BankAccountInput getC_BankAccount();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_Currency(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput getC_Currency();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set TrxType_RL.
	 *
	 * @param TrxType_RL Type of credit card transaction
	 */
	void setTrxType_RL(I_AD_Ref_ListInput TrxType_RL);

	/**
	 * Get TrxType_RL.
	 *
	 * @return Type of credit card transaction
	 */
	I_AD_Ref_ListInput getTrxType_RL();
}
