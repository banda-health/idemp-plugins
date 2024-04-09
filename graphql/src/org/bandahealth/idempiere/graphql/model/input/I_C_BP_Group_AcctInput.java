package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BP_Group_Acct;

/**
 * Generated Interface for C_BP_Group_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_BP_Group_AcctInput extends I_C_BP_Group_Acct {

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
	 * Set C_BP_Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	void setC_BP_GroupInput(ForeignEntityInput C_BP_Group);

	/**
	 * Get C_BP_Group.
	 *
	 * @return Business Partner Group
	 */
	ForeignEntityInput C_BP_Group();

	/**
	 * Set C_Prepayment_A.
	 *
	 * @param C_Prepayment_A Account for customer prepayments
	 */
	void setC_Prepayment_AInput(ForeignEntityInput C_Prepayment_A);

	/**
	 * Get C_Prepayment_A.
	 *
	 * @return Account for customer prepayments
	 */
	ForeignEntityInput C_Prepayment_A();

	/**
	 * Set C_Receivable_A.
	 *
	 * @param C_Receivable_A Account for Customer Receivables
	 */
	void setC_Receivable_AInput(ForeignEntityInput C_Receivable_A);

	/**
	 * Get C_Receivable_A.
	 *
	 * @return Account for Customer Receivables
	 */
	ForeignEntityInput C_Receivable_A();

	/**
	 * Set C_Receivable_Services_A.
	 *
	 * @param C_Receivable_Services_A Customer Accounts Receivables Services Account
	 */
	void setC_Receivable_Services_AInput(ForeignEntityInput C_Receivable_Services_A);

	/**
	 * Get C_Receivable_Services_A.
	 *
	 * @return Customer Accounts Receivables Services Account
	 */
	ForeignEntityInput C_Receivable_Services_A();

	/**
	 * Set NotInvoicedReceipts_A.
	 *
	 * @param NotInvoicedReceipts_A Account for not-invoiced Material Receipts
	 */
	void setNotInvoicedReceipts_AInput(ForeignEntityInput NotInvoicedReceipts_A);

	/**
	 * Get NotInvoicedReceipts_A.
	 *
	 * @return Account for not-invoiced Material Receipts
	 */
	ForeignEntityInput NotInvoicedReceipts_A();

	/**
	 * Set PayDiscount_Exp_A.
	 *
	 * @param PayDiscount_Exp_A Payment Discount Expense Account
	 */
	void setPayDiscount_Exp_AInput(ForeignEntityInput PayDiscount_Exp_A);

	/**
	 * Get PayDiscount_Exp_A.
	 *
	 * @return Payment Discount Expense Account
	 */
	ForeignEntityInput PayDiscount_Exp_A();

	/**
	 * Set PayDiscount_Rev_A.
	 *
	 * @param PayDiscount_Rev_A Payment Discount Revenue Account
	 */
	void setPayDiscount_Rev_AInput(ForeignEntityInput PayDiscount_Rev_A);

	/**
	 * Get PayDiscount_Rev_A.
	 *
	 * @return Payment Discount Revenue Account
	 */
	ForeignEntityInput PayDiscount_Rev_A();

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

	/**
	 * Set V_Liability_A.
	 *
	 * @param V_Liability_A Account for Vendor Liability
	 */
	void setV_Liability_AInput(ForeignEntityInput V_Liability_A);

	/**
	 * Get V_Liability_A.
	 *
	 * @return Account for Vendor Liability
	 */
	ForeignEntityInput V_Liability_A();

	/**
	 * Set V_Liability_Services_A.
	 *
	 * @param V_Liability_Services_A Account for Vendor Service Liability
	 */
	void setV_Liability_Services_AInput(ForeignEntityInput V_Liability_Services_A);

	/**
	 * Get V_Liability_Services_A.
	 *
	 * @return Account for Vendor Service Liability
	 */
	ForeignEntityInput V_Liability_Services_A();

	/**
	 * Set V_Prepayment_A.
	 *
	 * @param V_Prepayment_A Account for Vendor Prepayments
	 */
	void setV_Prepayment_AInput(ForeignEntityInput V_Prepayment_A);

	/**
	 * Get V_Prepayment_A.
	 *
	 * @return Account for Vendor Prepayments
	 */
	ForeignEntityInput V_Prepayment_A();

	/**
	 * Set WriteOff_A.
	 *
	 * @param WriteOff_A Account for Receivables write-off
	 */
	void setWriteOff_AInput(ForeignEntityInput WriteOff_A);

	/**
	 * Get WriteOff_A.
	 *
	 * @return Account for Receivables write-off
	 */
	ForeignEntityInput WriteOff_A();
}
