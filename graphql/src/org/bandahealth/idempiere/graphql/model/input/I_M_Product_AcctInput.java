package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Product_Acct;

/**
 * Generated Interface for M_Product_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_Product_AcctInput extends I_M_Product_Acct {

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
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(ForeignEntityInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	ForeignEntityInput M_Product();

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
}
