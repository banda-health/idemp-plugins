package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_PaymentRef_BankAcct;

/**
 * Generated Interface for BH_PaymentRef_BankAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_PaymentRef_BankAcctInput extends I_BH_PaymentRef_BankAcct {

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
	 * Set AD_Ref_List.
	 *
	 * @param AD_Ref_List Reference List based on Table
	 */
	void setAD_Ref_ListInput(ForeignEntityInput AD_Ref_List);

	/**
	 * Get AD_Ref_List.
	 *
	 * @return Reference List based on Table
	 */
	ForeignEntityInput AD_Ref_List();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

	/**
	 * Set BH_PaymentRef.
	 *
	 * @param BH_PaymentRef BH_PaymentRef
	 */
	void setBH_PaymentRefInput(ForeignEntityInput BH_PaymentRef);

	/**
	 * Get BH_PaymentRef.
	 *
	 * @return BH_PaymentRef
	 */
	ForeignEntityInput BH_PaymentRef();

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
}
