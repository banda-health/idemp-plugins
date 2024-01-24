package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.MProductCategoryAcct;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for M_Product_Category_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_Category_AcctInput extends MProductCategoryAcct implements I_M_Product_Category_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mM_Product_Category;
	private ForeignEntityInput mP_Asset_A;
	private ForeignEntityInput mP_AverageCostVariance_A;
	private ForeignEntityInput mP_COGS_A;
	private ForeignEntityInput mP_CostAdjustment_A;
	private ForeignEntityInput mP_Expense_A;
	private ForeignEntityInput mP_InventoryClearing_A;
	private ForeignEntityInput mP_InvoicePriceVariance_A;
	private ForeignEntityInput mP_LandedCostClearing_A;
	private ForeignEntityInput mP_PurchasePriceVariance_A;
	private ForeignEntityInput mP_RateVariance_A;
	private ForeignEntityInput mP_Revenue_A;
	private ForeignEntityInput mP_TradeDiscountGrant_A;
	private ForeignEntityInput mP_TradeDiscountRec_A;
	private I_AD_Ref_ListInput mCostingLevel;
	private I_AD_Ref_ListInput mCostingMethod;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_Product_Category_AcctInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MProductCategoryAcct(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (get_ID() == 0 && C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctSchema_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public ForeignEntityInput C_AcctSchema() {
		return mC_AcctSchema;
	}

	/**
	 * Set Costing Level.
	 *
	 * @param CostingLevel The lowest level to accumulate Costing Information
	 */
	@JsonProperty("CostingLevel")
	public void setCostingLevelInput(I_AD_Ref_ListInput CostingLevel) {
		this.mCostingLevel = CostingLevel;
		MRefList_BH foreignEntity;
		if (CostingLevel != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CostingLevel.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCostingLevel(foreignEntity.getValue());
		} else {
			this.setCostingLevel(null);
		}
	}

	/**
	 * Get Costing Level.
	 *
	 * @return The lowest level to accumulate Costing Information
	 */
	@JsonProperty("CostingLevel")
	public I_AD_Ref_ListInput CostingLevel() {
		return mCostingLevel;
	}

	/**
	 * Set Costing Method.
	 *
	 * @param CostingMethod Indicates how Costs will be calculated
	 */
	@JsonProperty("CostingMethod")
	public void setCostingMethodInput(I_AD_Ref_ListInput CostingMethod) {
		this.mCostingMethod = CostingMethod;
		MRefList_BH foreignEntity;
		if (CostingMethod != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CostingMethod.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCostingMethod(foreignEntity.getValue());
		} else {
			this.setCostingMethod(null);
		}
	}

	/**
	 * Get Costing Method.
	 *
	 * @return Indicates how Costs will be calculated
	 */
	@JsonProperty("CostingMethod")
	public I_AD_Ref_ListInput CostingMethod() {
		return mCostingMethod;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_Product_Category_Acct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_Product_Category_Acct_UU();
	}

	/**
	 * Set Product Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	@JsonProperty("M_Product_Category")
	public void setM_Product_CategoryInput(ForeignEntityInput M_Product_Category) {
		this.mM_Product_Category = M_Product_Category;
		MProductCategory_BH foreignEntity;
		if (get_ID() == 0 && M_Product_Category != null &&
				(foreignEntity = new Query(getCtx(), "M_Product_Category", "M_Product_Category_UU=?", get_TrxName())
						.setParameters(M_Product_Category.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_Category_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	@JsonProperty("M_Product_Category")
	public ForeignEntityInput M_Product_Category() {
		return mM_Product_Category;
	}

	/**
	 * Set Product Asset.
	 *
	 * @param P_Asset_A Account for Product Asset (Inventory)
	 */
	@JsonProperty("P_Asset_A")
	public void setP_Asset_AInput(ForeignEntityInput P_Asset_A) {
		this.mP_Asset_A = P_Asset_A;
		MAccount foreignEntity;
		if (P_Asset_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(P_Asset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setP_Asset_Acct(foreignEntity.get_ID());
		} else {
			super.setP_Asset_Acct(0);
		}
	}

	/**
	 * Get Product Asset.
	 *
	 * @return Account for Product Asset (Inventory)
	 */
	@JsonProperty("P_Asset_A")
	public ForeignEntityInput P_Asset_A() {
		return mP_Asset_A;
	}

	/**
	 * Set Average Cost Variance.
	 *
	 * @param P_AverageCostVariance_A Average Cost Variance
	 */
	@JsonProperty("P_AverageCostVariance_A")
	public void setP_AverageCostVariance_AInput(ForeignEntityInput P_AverageCostVariance_A) {
		this.mP_AverageCostVariance_A = P_AverageCostVariance_A;
		MAccount foreignEntity;
		if (P_AverageCostVariance_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(P_AverageCostVariance_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setP_AverageCostVariance_Acct(foreignEntity.get_ID());
		} else {
			super.setP_AverageCostVariance_Acct(0);
		}
	}

	/**
	 * Get Average Cost Variance.
	 *
	 * @return Average Cost Variance
	 */
	@JsonProperty("P_AverageCostVariance_A")
	public ForeignEntityInput P_AverageCostVariance_A() {
		return mP_AverageCostVariance_A;
	}

	/**
	 * Set Product COGS.
	 *
	 * @param P_COGS_A Account for Cost of Goods Sold
	 */
	@JsonProperty("P_COGS_A")
	public void setP_COGS_AInput(ForeignEntityInput P_COGS_A) {
		this.mP_COGS_A = P_COGS_A;
		MAccount foreignEntity;
		if (P_COGS_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(P_COGS_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setP_COGS_Acct(foreignEntity.get_ID());
		} else {
			super.setP_COGS_Acct(0);
		}
	}

	/**
	 * Get Product COGS.
	 *
	 * @return Account for Cost of Goods Sold
	 */
	@JsonProperty("P_COGS_A")
	public ForeignEntityInput P_COGS_A() {
		return mP_COGS_A;
	}

	/**
	 * Set Cost Adjustment.
	 *
	 * @param P_CostAdjustment_A Product Cost Adjustment Account
	 */
	@JsonProperty("P_CostAdjustment_A")
	public void setP_CostAdjustment_AInput(ForeignEntityInput P_CostAdjustment_A) {
		this.mP_CostAdjustment_A = P_CostAdjustment_A;
		MAccount foreignEntity;
		if (P_CostAdjustment_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(P_CostAdjustment_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setP_CostAdjustment_Acct(foreignEntity.get_ID());
		} else {
			super.setP_CostAdjustment_Acct(0);
		}
	}

	/**
	 * Get Cost Adjustment.
	 *
	 * @return Product Cost Adjustment Account
	 */
	@JsonProperty("P_CostAdjustment_A")
	public ForeignEntityInput P_CostAdjustment_A() {
		return mP_CostAdjustment_A;
	}

	/**
	 * Set Product Expense.
	 *
	 * @param P_Expense_A Account for Product Expense
	 */
	@JsonProperty("P_Expense_A")
	public void setP_Expense_AInput(ForeignEntityInput P_Expense_A) {
		this.mP_Expense_A = P_Expense_A;
		MAccount foreignEntity;
		if (P_Expense_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(P_Expense_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setP_Expense_Acct(foreignEntity.get_ID());
		} else {
			super.setP_Expense_Acct(0);
		}
	}

	/**
	 * Get Product Expense.
	 *
	 * @return Account for Product Expense
	 */
	@JsonProperty("P_Expense_A")
	public ForeignEntityInput P_Expense_A() {
		return mP_Expense_A;
	}

	/**
	 * Set Inventory Clearing.
	 *
	 * @param P_InventoryClearing_A Product Inventory Clearing Account
	 */
	@JsonProperty("P_InventoryClearing_A")
	public void setP_InventoryClearing_AInput(ForeignEntityInput P_InventoryClearing_A) {
		this.mP_InventoryClearing_A = P_InventoryClearing_A;
		MAccount foreignEntity;
		if (P_InventoryClearing_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(P_InventoryClearing_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setP_InventoryClearing_Acct(foreignEntity.get_ID());
		} else {
			super.setP_InventoryClearing_Acct(0);
		}
	}

	/**
	 * Get Inventory Clearing.
	 *
	 * @return Product Inventory Clearing Account
	 */
	@JsonProperty("P_InventoryClearing_A")
	public ForeignEntityInput P_InventoryClearing_A() {
		return mP_InventoryClearing_A;
	}

	/**
	 * Set Invoice Price Variance.
	 *
	 * @param P_InvoicePriceVariance_A Difference between Costs and Invoice Price (IPV)
	 */
	@JsonProperty("P_InvoicePriceVariance_A")
	public void setP_InvoicePriceVariance_AInput(ForeignEntityInput P_InvoicePriceVariance_A) {
		this.mP_InvoicePriceVariance_A = P_InvoicePriceVariance_A;
		MAccount foreignEntity;
		if (P_InvoicePriceVariance_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(P_InvoicePriceVariance_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setP_InvoicePriceVariance_Acct(foreignEntity.get_ID());
		} else {
			super.setP_InvoicePriceVariance_Acct(0);
		}
	}

	/**
	 * Get Invoice Price Variance.
	 *
	 * @return Difference between Costs and Invoice Price (IPV)
	 */
	@JsonProperty("P_InvoicePriceVariance_A")
	public ForeignEntityInput P_InvoicePriceVariance_A() {
		return mP_InvoicePriceVariance_A;
	}

	/**
	 * Set Landed Cost Clearing.
	 *
	 * @param P_LandedCostClearing_A Product Landed Cost Clearing Account
	 */
	@JsonProperty("P_LandedCostClearing_A")
	public void setP_LandedCostClearing_AInput(ForeignEntityInput P_LandedCostClearing_A) {
		this.mP_LandedCostClearing_A = P_LandedCostClearing_A;
		MAccount foreignEntity;
		if (P_LandedCostClearing_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(P_LandedCostClearing_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setP_LandedCostClearing_Acct(foreignEntity.get_ID());
		} else {
			super.setP_LandedCostClearing_Acct(0);
		}
	}

	/**
	 * Get Landed Cost Clearing.
	 *
	 * @return Product Landed Cost Clearing Account
	 */
	@JsonProperty("P_LandedCostClearing_A")
	public ForeignEntityInput P_LandedCostClearing_A() {
		return mP_LandedCostClearing_A;
	}

	/**
	 * Set Purchase Price Variance.
	 *
	 * @param P_PurchasePriceVariance_A Difference between Standard Cost and Purchase Price (PPV)
	 */
	@JsonProperty("P_PurchasePriceVariance_A")
	public void setP_PurchasePriceVariance_AInput(ForeignEntityInput P_PurchasePriceVariance_A) {
		this.mP_PurchasePriceVariance_A = P_PurchasePriceVariance_A;
		MAccount foreignEntity;
		if (P_PurchasePriceVariance_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(P_PurchasePriceVariance_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setP_PurchasePriceVariance_Acct(foreignEntity.get_ID());
		} else {
			super.setP_PurchasePriceVariance_Acct(0);
		}
	}

	/**
	 * Get Purchase Price Variance.
	 *
	 * @return Difference between Standard Cost and Purchase Price (PPV)
	 */
	@JsonProperty("P_PurchasePriceVariance_A")
	public ForeignEntityInput P_PurchasePriceVariance_A() {
		return mP_PurchasePriceVariance_A;
	}

	/**
	 * Set Rate Variance.
	 *
	 * @param P_RateVariance_A The Rate Variance account is the account used Manufacturing Order
	 */
	@JsonProperty("P_RateVariance_A")
	public void setP_RateVariance_AInput(ForeignEntityInput P_RateVariance_A) {
		this.mP_RateVariance_A = P_RateVariance_A;
		MAccount foreignEntity;
		if (P_RateVariance_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(P_RateVariance_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setP_RateVariance_Acct(foreignEntity.get_ID());
		} else {
			super.setP_RateVariance_Acct(0);
		}
	}

	/**
	 * Get Rate Variance.
	 *
	 * @return The Rate Variance account is the account used Manufacturing Order
	 */
	@JsonProperty("P_RateVariance_A")
	public ForeignEntityInput P_RateVariance_A() {
		return mP_RateVariance_A;
	}

	/**
	 * Set Product Revenue.
	 *
	 * @param P_Revenue_A Account for Product Revenue (Sales Account)
	 */
	@JsonProperty("P_Revenue_A")
	public void setP_Revenue_AInput(ForeignEntityInput P_Revenue_A) {
		this.mP_Revenue_A = P_Revenue_A;
		MAccount foreignEntity;
		if (P_Revenue_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(P_Revenue_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setP_Revenue_Acct(foreignEntity.get_ID());
		} else {
			super.setP_Revenue_Acct(0);
		}
	}

	/**
	 * Get Product Revenue.
	 *
	 * @return Account for Product Revenue (Sales Account)
	 */
	@JsonProperty("P_Revenue_A")
	public ForeignEntityInput P_Revenue_A() {
		return mP_Revenue_A;
	}

	/**
	 * Set Trade Discount Granted.
	 *
	 * @param P_TradeDiscountGrant_A Trade Discount Granted Account
	 */
	@JsonProperty("P_TradeDiscountGrant_A")
	public void setP_TradeDiscountGrant_AInput(ForeignEntityInput P_TradeDiscountGrant_A) {
		this.mP_TradeDiscountGrant_A = P_TradeDiscountGrant_A;
		MAccount foreignEntity;
		if (P_TradeDiscountGrant_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(P_TradeDiscountGrant_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setP_TradeDiscountGrant_Acct(foreignEntity.get_ID());
		} else {
			super.setP_TradeDiscountGrant_Acct(0);
		}
	}

	/**
	 * Get Trade Discount Granted.
	 *
	 * @return Trade Discount Granted Account
	 */
	@JsonProperty("P_TradeDiscountGrant_A")
	public ForeignEntityInput P_TradeDiscountGrant_A() {
		return mP_TradeDiscountGrant_A;
	}

	/**
	 * Set Trade Discount Received.
	 *
	 * @param P_TradeDiscountRec_A Trade Discount Receivable Account
	 */
	@JsonProperty("P_TradeDiscountRec_A")
	public void setP_TradeDiscountRec_AInput(ForeignEntityInput P_TradeDiscountRec_A) {
		this.mP_TradeDiscountRec_A = P_TradeDiscountRec_A;
		MAccount foreignEntity;
		if (P_TradeDiscountRec_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(P_TradeDiscountRec_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setP_TradeDiscountRec_Acct(foreignEntity.get_ID());
		} else {
			super.setP_TradeDiscountRec_Acct(0);
		}
	}

	/**
	 * Get Trade Discount Received.
	 *
	 * @return Trade Discount Receivable Account
	 */
	@JsonProperty("P_TradeDiscountRec_A")
	public ForeignEntityInput P_TradeDiscountRec_A() {
		return mP_TradeDiscountRec_A;
	}
}
