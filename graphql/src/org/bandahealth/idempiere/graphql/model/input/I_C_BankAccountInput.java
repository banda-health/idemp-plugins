package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BankAccount;

/**
 * Generated Interface for C_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_BankAccountInput extends I_C_BankAccount {

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
	 * Set BankAccountType.
	 *
	 * @param BankAccountType Bank Account Type
	 */
	void setBankAccountTypeInput(I_AD_Ref_ListInput BankAccountType);

	/**
	 * Get BankAccountType.
	 *
	 * @return Bank Account Type
	 */
	I_AD_Ref_ListInput BankAccountType();

	/**
	 * Set C_Bank.
	 *
	 * @param C_Bank Bank
	 */
	void setC_BankInput(ForeignEntityInput C_Bank);

	/**
	 * Get C_Bank.
	 *
	 * @return Bank
	 */
	ForeignEntityInput C_Bank();

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
}
