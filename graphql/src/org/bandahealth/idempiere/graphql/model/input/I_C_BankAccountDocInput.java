package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BankAccountDoc;

/**
 * Generated Interface for C_BankAccountDoc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_BankAccountDocInput extends I_C_BankAccountDoc {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

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
	 * Set Check_PrintFormat.
	 *
	 * @param Check_PrintFormat Print Format for printing Checks
	 */
	void setCheck_PrintFormatInput(ForeignEntityInput Check_PrintFormat);

	/**
	 * Get Check_PrintFormat.
	 *
	 * @return Print Format for printing Checks
	 */
	ForeignEntityInput Check_PrintFormat();

	/**
	 * Set PaymentRule.
	 *
	 * @param PaymentRule How you pay the invoice
	 */
	void setPaymentRuleInput(I_AD_Ref_ListInput PaymentRule);

	/**
	 * Get PaymentRule.
	 *
	 * @return How you pay the invoice
	 */
	I_AD_Ref_ListInput PaymentRule();
}
