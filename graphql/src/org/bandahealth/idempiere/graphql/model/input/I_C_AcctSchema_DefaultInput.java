package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_AcctSchema_Default;

/**
 * Generated Interface for C_AcctSchema_Default - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_AcctSchema_DefaultInput extends I_C_AcctSchema_Default {

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
	 * Set B_Asset_A.
	 *
	 * @param B_Asset_A Bank Asset Account
	 */
	void setB_Asset_AInput(ForeignEntityInput B_Asset_A);

	/**
	 * Get B_Asset_A.
	 *
	 * @return Bank Asset Account
	 */
	ForeignEntityInput B_Asset_A();

	/**
	 * Set B_InterestExp_A.
	 *
	 * @param B_InterestExp_A Bank Interest Expense Account
	 */
	void setB_InterestExp_AInput(ForeignEntityInput B_InterestExp_A);

	/**
	 * Get B_InterestExp_A.
	 *
	 * @return Bank Interest Expense Account
	 */
	ForeignEntityInput B_InterestExp_A();

	/**
	 * Set B_InterestRev_A.
	 *
	 * @param B_InterestRev_A Bank Interest Revenue Account
	 */
	void setB_InterestRev_AInput(ForeignEntityInput B_InterestRev_A);

	/**
	 * Get B_InterestRev_A.
	 *
	 * @return Bank Interest Revenue Account
	 */
	ForeignEntityInput B_InterestRev_A();

	/**
	 * Set B_InTransit_A.
	 *
	 * @param B_InTransit_A Bank In Transit Account
	 */
	void setB_InTransit_AInput(ForeignEntityInput B_InTransit_A);

	/**
	 * Get B_InTransit_A.
	 *
	 * @return Bank In Transit Account
	 */
	ForeignEntityInput B_InTransit_A();

	/**
	 * Set B_PaymentSelect_A.
	 *
	 * @param B_PaymentSelect_A AP Payment Selection Clearing Account
	 */
	void setB_PaymentSelect_AInput(ForeignEntityInput B_PaymentSelect_A);

	/**
	 * Get B_PaymentSelect_A.
	 *
	 * @return AP Payment Selection Clearing Account
	 */
	ForeignEntityInput B_PaymentSelect_A();

	/**
	 * Set B_UnallocatedCash_A.
	 *
	 * @param B_UnallocatedCash_A Unallocated Cash Clearing Account
	 */
	void setB_UnallocatedCash_AInput(ForeignEntityInput B_UnallocatedCash_A);

	/**
	 * Get B_UnallocatedCash_A.
	 *
	 * @return Unallocated Cash Clearing Account
	 */
	ForeignEntityInput B_UnallocatedCash_A();

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
	 * Set CB_Asset_A.
	 *
	 * @param CB_Asset_A Cash Book Asset Account
	 */
	void setCB_Asset_AInput(ForeignEntityInput CB_Asset_A);

	/**
	 * Get CB_Asset_A.
	 *
	 * @return Cash Book Asset Account
	 */
	ForeignEntityInput CB_Asset_A();

	/**
	 * Set CB_CashTransfer_A.
	 *
	 * @param CB_CashTransfer_A Cash Transfer Clearing Account
	 */
	void setCB_CashTransfer_AInput(ForeignEntityInput CB_CashTransfer_A);

	/**
	 * Get CB_CashTransfer_A.
	 *
	 * @return Cash Transfer Clearing Account
	 */
	ForeignEntityInput CB_CashTransfer_A();

	/**
	 * Set CB_Differences_A.
	 *
	 * @param CB_Differences_A Cash Book Differences Account
	 */
	void setCB_Differences_AInput(ForeignEntityInput CB_Differences_A);

	/**
	 * Get CB_Differences_A.
	 *
	 * @return Cash Book Differences Account
	 */
	ForeignEntityInput CB_Differences_A();

	/**
	 * Set CB_Expense_A.
	 *
	 * @param CB_Expense_A Cash Book Expense Account
	 */
	void setCB_Expense_AInput(ForeignEntityInput CB_Expense_A);

	/**
	 * Get CB_Expense_A.
	 *
	 * @return Cash Book Expense Account
	 */
	ForeignEntityInput CB_Expense_A();

	/**
	 * Set CB_Receipt_A.
	 *
	 * @param CB_Receipt_A Cash Book Receipts Account
	 */
	void setCB_Receipt_AInput(ForeignEntityInput CB_Receipt_A);

	/**
	 * Get CB_Receipt_A.
	 *
	 * @return Cash Book Receipts Account
	 */
	ForeignEntityInput CB_Receipt_A();

	/**
	 * Set Ch_Expense_A.
	 *
	 * @param Ch_Expense_A Charge Account
	 */
	void setCh_Expense_AInput(ForeignEntityInput Ch_Expense_A);

	/**
	 * Get Ch_Expense_A.
	 *
	 * @return Charge Account
	 */
	ForeignEntityInput Ch_Expense_A();

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
	 * Set P_Asset_A.
	 *
	 * @param P_Asset_A Account for Product Asset (Inventory)
	 */
	void setP_Asset_AInput(ForeignEntityInput P_Asset_A);

	/**
	 * Get P_Asset_A.
	 *
	 * @return Account for Product Asset (Inventory)
	 */
	ForeignEntityInput P_Asset_A();

	/**
	 * Set P_AverageCostVariance_A.
	 *
	 * @param P_AverageCostVariance_A Average Cost Variance
	 */
	void setP_AverageCostVariance_AInput(ForeignEntityInput P_AverageCostVariance_A);

	/**
	 * Get P_AverageCostVariance_A.
	 *
	 * @return Average Cost Variance
	 */
	ForeignEntityInput P_AverageCostVariance_A();

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
	 * Set P_COGS_A.
	 *
	 * @param P_COGS_A Account for Cost of Goods Sold
	 */
	void setP_COGS_AInput(ForeignEntityInput P_COGS_A);

	/**
	 * Get P_COGS_A.
	 *
	 * @return Account for Cost of Goods Sold
	 */
	ForeignEntityInput P_COGS_A();

	/**
	 * Set P_CostAdjustment_A.
	 *
	 * @param P_CostAdjustment_A Product Cost Adjustment Account
	 */
	void setP_CostAdjustment_AInput(ForeignEntityInput P_CostAdjustment_A);

	/**
	 * Get P_CostAdjustment_A.
	 *
	 * @return Product Cost Adjustment Account
	 */
	ForeignEntityInput P_CostAdjustment_A();

	/**
	 * Set P_Expense_A.
	 *
	 * @param P_Expense_A Account for Product Expense
	 */
	void setP_Expense_AInput(ForeignEntityInput P_Expense_A);

	/**
	 * Get P_Expense_A.
	 *
	 * @return Account for Product Expense
	 */
	ForeignEntityInput P_Expense_A();

	/**
	 * Set P_InventoryClearing_A.
	 *
	 * @param P_InventoryClearing_A Product Inventory Clearing Account
	 */
	void setP_InventoryClearing_AInput(ForeignEntityInput P_InventoryClearing_A);

	/**
	 * Get P_InventoryClearing_A.
	 *
	 * @return Product Inventory Clearing Account
	 */
	ForeignEntityInput P_InventoryClearing_A();

	/**
	 * Set P_InvoicePriceVariance_A.
	 *
	 * @param P_InvoicePriceVariance_A Difference between Costs and Invoice Price (IPV)
	 */
	void setP_InvoicePriceVariance_AInput(ForeignEntityInput P_InvoicePriceVariance_A);

	/**
	 * Get P_InvoicePriceVariance_A.
	 *
	 * @return Difference between Costs and Invoice Price (IPV)
	 */
	ForeignEntityInput P_InvoicePriceVariance_A();

	/**
	 * Set PJ_Asset_A.
	 *
	 * @param PJ_Asset_A Project Asset Account
	 */
	void setPJ_Asset_AInput(ForeignEntityInput PJ_Asset_A);

	/**
	 * Get PJ_Asset_A.
	 *
	 * @return Project Asset Account
	 */
	ForeignEntityInput PJ_Asset_A();

	/**
	 * Set PJ_WIP_A.
	 *
	 * @param PJ_WIP_A Account for Work in Progress
	 */
	void setPJ_WIP_AInput(ForeignEntityInput PJ_WIP_A);

	/**
	 * Get PJ_WIP_A.
	 *
	 * @return Account for Work in Progress
	 */
	ForeignEntityInput PJ_WIP_A();

	/**
	 * Set P_LandedCostClearing_A.
	 *
	 * @param P_LandedCostClearing_A Product Landed Cost Clearing Account
	 */
	void setP_LandedCostClearing_AInput(ForeignEntityInput P_LandedCostClearing_A);

	/**
	 * Get P_LandedCostClearing_A.
	 *
	 * @return Product Landed Cost Clearing Account
	 */
	ForeignEntityInput P_LandedCostClearing_A();

	/**
	 * Set P_PurchasePriceVariance_A.
	 *
	 * @param P_PurchasePriceVariance_A Difference between Standard Cost and Purchase Price (PPV)
	 */
	void setP_PurchasePriceVariance_AInput(ForeignEntityInput P_PurchasePriceVariance_A);

	/**
	 * Get P_PurchasePriceVariance_A.
	 *
	 * @return Difference between Standard Cost and Purchase Price (PPV)
	 */
	ForeignEntityInput P_PurchasePriceVariance_A();

	/**
	 * Set P_RateVariance_A.
	 *
	 * @param P_RateVariance_A The Rate Variance account is the account used Manufacturing Order
	 */
	void setP_RateVariance_AInput(ForeignEntityInput P_RateVariance_A);

	/**
	 * Get P_RateVariance_A.
	 *
	 * @return The Rate Variance account is the account used Manufacturing Order
	 */
	ForeignEntityInput P_RateVariance_A();

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
	 * Set P_TradeDiscountGrant_A.
	 *
	 * @param P_TradeDiscountGrant_A Trade Discount Granted Account
	 */
	void setP_TradeDiscountGrant_AInput(ForeignEntityInput P_TradeDiscountGrant_A);

	/**
	 * Get P_TradeDiscountGrant_A.
	 *
	 * @return Trade Discount Granted Account
	 */
	ForeignEntityInput P_TradeDiscountGrant_A();

	/**
	 * Set P_TradeDiscountRec_A.
	 *
	 * @param P_TradeDiscountRec_A Trade Discount Receivable Account
	 */
	void setP_TradeDiscountRec_AInput(ForeignEntityInput P_TradeDiscountRec_A);

	/**
	 * Get P_TradeDiscountRec_A.
	 *
	 * @return Trade Discount Receivable Account
	 */
	ForeignEntityInput P_TradeDiscountRec_A();

	/**
	 * Set RealizedGain_A.
	 *
	 * @param RealizedGain_A Realized Gain Account
	 */
	void setRealizedGain_AInput(ForeignEntityInput RealizedGain_A);

	/**
	 * Get RealizedGain_A.
	 *
	 * @return Realized Gain Account
	 */
	ForeignEntityInput RealizedGain_A();

	/**
	 * Set RealizedLoss_A.
	 *
	 * @param RealizedLoss_A Realized Loss Account
	 */
	void setRealizedLoss_AInput(ForeignEntityInput RealizedLoss_A);

	/**
	 * Get RealizedLoss_A.
	 *
	 * @return Realized Loss Account
	 */
	ForeignEntityInput RealizedLoss_A();

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
	 * Set UnrealizedGain_A.
	 *
	 * @param UnrealizedGain_A Unrealized Gain Account for currency revaluation
	 */
	void setUnrealizedGain_AInput(ForeignEntityInput UnrealizedGain_A);

	/**
	 * Get UnrealizedGain_A.
	 *
	 * @return Unrealized Gain Account for currency revaluation
	 */
	ForeignEntityInput UnrealizedGain_A();

	/**
	 * Set UnrealizedLoss_A.
	 *
	 * @param UnrealizedLoss_A Unrealized Loss Account for currency revaluation
	 */
	void setUnrealizedLoss_AInput(ForeignEntityInput UnrealizedLoss_A);

	/**
	 * Get UnrealizedLoss_A.
	 *
	 * @return Unrealized Loss Account for currency revaluation
	 */
	ForeignEntityInput UnrealizedLoss_A();

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
	 * Set W_Differences_A.
	 *
	 * @param W_Differences_A Warehouse Differences Account
	 */
	void setW_Differences_AInput(ForeignEntityInput W_Differences_A);

	/**
	 * Get W_Differences_A.
	 *
	 * @return Warehouse Differences Account
	 */
	ForeignEntityInput W_Differences_A();

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
