package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_CashLine;

/**
 * Generated Interface for C_CashLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_CashLineInput extends I_C_CashLine {

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
	 * Set C_Cash.
	 *
	 * @param C_Cash Cash Journal
	 */
	void setC_Cash(I_C_CashInput C_Cash);

	/**
	 * Get C_Cash.
	 *
	 * @return Cash Journal
	 */
	I_C_CashInput getC_Cash();

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
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_Charge(I_C_ChargeInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	I_C_ChargeInput getC_Charge();

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
	 * Set C_Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	void setC_Invoice(I_C_InvoiceInput C_Invoice);

	/**
	 * Get C_Invoice.
	 *
	 * @return Invoice Identifier
	 */
	I_C_InvoiceInput getC_Invoice();

	/**
	 * Set C_Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	void setC_Payment(I_C_PaymentInput C_Payment);

	/**
	 * Get C_Payment.
	 *
	 * @return Payment identifier
	 */
	I_C_PaymentInput getC_Payment();

	/**
	 * Set CashType_RL.
	 *
	 * @param CashType_RL Source of Cash
	 */
	void setCashType_RL(I_AD_Ref_ListInput CashType_RL);

	/**
	 * Get CashType_RL.
	 *
	 * @return Source of Cash
	 */
	I_AD_Ref_ListInput getCashType_RL();
}
