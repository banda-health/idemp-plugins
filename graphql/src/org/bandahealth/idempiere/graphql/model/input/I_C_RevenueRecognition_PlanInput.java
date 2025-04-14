package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_RevenueRecognition_Plan;

/**
 * Generated Interface for C_RevenueRecognition_Plan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_RevenueRecognition_PlanInput extends I_C_RevenueRecognition_Plan {

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
	 * Set C_InvoiceLine.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	void setC_InvoiceLineInput(ForeignEntityInput C_InvoiceLine);

	/**
	 * Get C_InvoiceLine.
	 *
	 * @return Invoice Detail Line
	 */
	ForeignEntityInput C_InvoiceLine();

	/**
	 * Set C_RevenueRecognition.
	 *
	 * @param C_RevenueRecognition Method for recording revenue
	 */
	void setC_RevenueRecognitionInput(ForeignEntityInput C_RevenueRecognition);

	/**
	 * Get C_RevenueRecognition.
	 *
	 * @return Method for recording revenue
	 */
	ForeignEntityInput C_RevenueRecognition();

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
	 * Set P_Revenue_A.
	 *
	 * @param P_Revenue_A Account for Product Revenue (Sales Account)
	 */
	void setP_Revenue_AInput(ForeignEntityInput P_Revenue_A);

	/**
	 * Get P_Revenue_A.
	 *
	 * @return Account for Product Revenue (Sales Account)
	 */
	ForeignEntityInput P_Revenue_A();

	/**
	 * Set UnEarnedRevenue_A.
	 *
	 * @param UnEarnedRevenue_A Account for unearned revenue
	 */
	void setUnEarnedRevenue_AInput(ForeignEntityInput UnEarnedRevenue_A);

	/**
	 * Get UnEarnedRevenue_A.
	 *
	 * @return Account for unearned revenue
	 */
	ForeignEntityInput UnEarnedRevenue_A();
}
