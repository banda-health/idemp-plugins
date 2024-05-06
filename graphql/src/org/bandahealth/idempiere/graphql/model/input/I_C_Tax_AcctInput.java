package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Tax_Acct;

/**
 * Generated Interface for C_Tax_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_Tax_AcctInput extends I_C_Tax_Acct {

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
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	ForeignEntityInput C_AcctSchema();

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
	 * Set C_Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	void setC_TaxInput(ForeignEntityInput C_Tax);

	/**
	 * Get C_Tax.
	 *
	 * @return Tax identifier
	 */
	ForeignEntityInput C_Tax();

	/**
	 * Set T_Credit_A.
	 *
	 * @param T_Credit_A Account for Tax you can reclaim
	 */
	void setT_Credit_AInput(ForeignEntityInput T_Credit_A);

	/**
	 * Get T_Credit_A.
	 *
	 * @return Account for Tax you can reclaim
	 */
	ForeignEntityInput T_Credit_A();

	/**
	 * Set T_Due_A.
	 *
	 * @param T_Due_A Account for Tax you have to pay
	 */
	void setT_Due_AInput(ForeignEntityInput T_Due_A);

	/**
	 * Get T_Due_A.
	 *
	 * @return Account for Tax you have to pay
	 */
	ForeignEntityInput T_Due_A();

	/**
	 * Set T_Expense_A.
	 *
	 * @param T_Expense_A Account for paid tax you cannot reclaim
	 */
	void setT_Expense_AInput(ForeignEntityInput T_Expense_A);

	/**
	 * Get T_Expense_A.
	 *
	 * @return Account for paid tax you cannot reclaim
	 */
	ForeignEntityInput T_Expense_A();
}
