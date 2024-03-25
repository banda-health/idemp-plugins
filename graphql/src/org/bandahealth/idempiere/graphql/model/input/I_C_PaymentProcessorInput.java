package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_PaymentProcessor;

/**
 * Generated Interface for C_PaymentProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_PaymentProcessorInput extends I_C_PaymentProcessor {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set AD_Sequence.
	 *
	 * @param AD_Sequence Document Sequence
	 */
	void setAD_SequenceInput(ForeignEntityInput AD_Sequence);

	/**
	 * Get AD_Sequence.
	 *
	 * @return Document Sequence
	 */
	ForeignEntityInput AD_Sequence();

	/**
	 * Set C_BankAccount.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	void setC_BankAccountInput(ForeignEntityInput C_BankAccount);

	/**
	 * Get C_BankAccount.
	 *
	 * @return Account at the Bank
	 */
	ForeignEntityInput C_BankAccount();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(ForeignEntityInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	ForeignEntityInput C_Currency();

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();

	/**
	 * Set TrxType.
	 *
	 * @param TrxType Type of credit card transaction
	 */
	void setTrxTypeInput(I_AD_Ref_ListInput TrxType);

	/**
	 * Get TrxType.
	 *
	 * @return Type of credit card transaction
	 */
	I_AD_Ref_ListInput TrxType();
}
