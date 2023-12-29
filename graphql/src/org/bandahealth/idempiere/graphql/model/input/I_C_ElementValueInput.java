package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ElementValue;

/**
 * Generated Interface for C_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_ElementValueInput extends I_C_ElementValue {

	/**
	 * Set AccountSign_RL.
	 *
	 * @param AccountSign_RL Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	void setAccountSign_RL(I_AD_Ref_ListInput AccountSign_RL);

	/**
	 * Get AccountSign_RL.
	 *
	 * @return Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	I_AD_Ref_ListInput getAccountSign_RL();

	/**
	 * Set AccountType_RL.
	 *
	 * @param AccountType_RL Indicates the type of account
	 */
	void setAccountType_RL(I_AD_Ref_ListInput AccountType_RL);

	/**
	 * Get AccountType_RL.
	 *
	 * @return Indicates the type of account
	 */
	I_AD_Ref_ListInput getAccountType_RL();

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
	 * Set BPartnerType_RL.
	 *
	 * @param BPartnerType_RL BPartnerType_RL
	 */
	void setBPartnerType_RL(I_AD_Ref_ListInput BPartnerType_RL);

	/**
	 * Get BPartnerType_RL.
	 *
	 * @return BPartnerType_RL
	 */
	I_AD_Ref_ListInput getBPartnerType_RL();

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
	 * Set C_Element.
	 *
	 * @param C_Element Accounting Element
	 */
	void setC_Element(I_C_ElementInput C_Element);

	/**
	 * Get C_Element.
	 *
	 * @return Accounting Element
	 */
	I_C_ElementInput getC_Element();

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
}
