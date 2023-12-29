package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BankAccount;

/**
 * Generated Interface for C_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_BankAccountInput extends I_C_BankAccount {

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
	 * Set BankAccountType_RL.
	 *
	 * @param BankAccountType_RL Bank Account Type
	 */
	void setBankAccountType_RL(I_AD_Ref_ListInput BankAccountType_RL);

	/**
	 * Get BankAccountType_RL.
	 *
	 * @return Bank Account Type
	 */
	I_AD_Ref_ListInput getBankAccountType_RL();

	/**
	 * Set C_Bank.
	 *
	 * @param C_Bank Bank
	 */
	void setC_Bank(I_C_BankInput C_Bank);

	/**
	 * Get C_Bank.
	 *
	 * @return Bank
	 */
	I_C_BankInput getC_Bank();

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
}
