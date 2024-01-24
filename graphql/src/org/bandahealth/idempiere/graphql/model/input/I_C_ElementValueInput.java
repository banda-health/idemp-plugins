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
	 * Set AccountSign.
	 *
	 * @param AccountSign Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	void setAccountSignInput(I_AD_Ref_ListInput AccountSign);

	/**
	 * Get AccountSign.
	 *
	 * @return Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	I_AD_Ref_ListInput AccountSign();

	/**
	 * Set AccountType.
	 *
	 * @param AccountType Indicates the type of account
	 */
	void setAccountTypeInput(I_AD_Ref_ListInput AccountType);

	/**
	 * Get AccountType.
	 *
	 * @return Indicates the type of account
	 */
	I_AD_Ref_ListInput AccountType();

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
	 * Set BPartnerType.
	 *
	 * @param BPartnerType BPartnerType
	 */
	void setBPartnerTypeInput(I_AD_Ref_ListInput BPartnerType);

	/**
	 * Get BPartnerType.
	 *
	 * @return BPartnerType
	 */
	I_AD_Ref_ListInput BPartnerType();

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
	 * Set C_Element.
	 *
	 * @param C_Element Accounting Element
	 */
	void setC_ElementInput(ForeignEntityInput C_Element);

	/**
	 * Get C_Element.
	 *
	 * @return Accounting Element
	 */
	ForeignEntityInput C_Element();

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
