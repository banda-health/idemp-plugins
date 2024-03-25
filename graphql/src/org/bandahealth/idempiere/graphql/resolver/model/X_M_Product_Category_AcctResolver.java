package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MProductCategoryAcct;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Product_Category_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_Product_Category_AcctResolver extends POResolver<MProductCategoryAcct> implements GraphQLResolver<MProductCategoryAcct> {



	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}

	static Map<String, String> COSTINGLEVEL_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "b9ccb6ca-ac26-47cd-9bc5-86d3ab30fa2f");
			put("O", "94923c72-8b13-4fe6-8d48-510bbd85ab5d");
			put("B", "582aa0b8-f288-4ad0-a1a0-eaf48e93e00d");
		}
	};
	public CompletableFuture<MRefList_BH> CostingLevel(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCostingLevel())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(COSTINGLEVEL_UUIDS_BY_VALUE.get(entity.getCostingLevel()));
	}

	static Map<String, String> COSTINGMETHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "d3ba6803-5479-4b30-ba20-6b40e658c5d8");
			put("A", "29b356c5-1757-4bab-a331-a01b9415f4e6");
			put("L", "fb47834b-767e-4ffe-b7ea-f690279d4345");
			put("F", "835a19ab-521e-406c-b0b2-f3e4c64c44b7");
			put("p", "01741faf-094c-46ed-9266-2d3adac2c504");
			put("I", "9127a623-4d9b-4a1a-8462-b31d8ddb24ed");
			put("i", "f4296d4f-761c-4545-a2ec-ca5c86e1b741");
			put("U", "10ca122c-b77e-410e-8755-5033f17405d4");
			put("x", "c788f7ef-7cf6-479e-85fc-7212ae0a9f9b");
		}
	};
	public CompletableFuture<MRefList_BH> CostingMethod(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCostingMethod())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(COSTINGMETHOD_UUIDS_BY_VALUE.get(entity.getCostingMethod()));
	}


	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	public CompletableFuture<MProductCategory_BH> M_Product_Category(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_Category_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProductCategory_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_Product_CategoryDataLoader.DATALOADER_M_Product_Category_BY_ID);
		return dataLoader.load(entity.getM_Product_Category_ID());
	}


	/**
	 * Get Product Asset.
	 *
	 * @return Account for Product Asset (Inventory)
	 */
	public CompletableFuture<MAccount> P_Asset_A(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getP_Asset_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_Asset_Acct());
	}


	/**
	 * Get Average Cost Variance.
	 *
	 * @return Average Cost Variance
	 */
	public CompletableFuture<MAccount> P_AverageCostVariance_A(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getP_AverageCostVariance_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_AverageCostVariance_Acct());
	}


	/**
	 * Get Product COGS.
	 *
	 * @return Account for Cost of Goods Sold
	 */
	public CompletableFuture<MAccount> P_COGS_A(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getP_COGS_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_COGS_Acct());
	}


	/**
	 * Get Cost Adjustment.
	 *
	 * @return Product Cost Adjustment Account
	 */
	public CompletableFuture<MAccount> P_CostAdjustment_A(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getP_CostAdjustment_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_CostAdjustment_Acct());
	}


	/**
	 * Get Product Expense.
	 *
	 * @return Account for Product Expense
	 */
	public CompletableFuture<MAccount> P_Expense_A(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getP_Expense_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_Expense_Acct());
	}


	/**
	 * Get Inventory Clearing.
	 *
	 * @return Product Inventory Clearing Account
	 */
	public CompletableFuture<MAccount> P_InventoryClearing_A(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getP_InventoryClearing_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_InventoryClearing_Acct());
	}


	/**
	 * Get Invoice Price Variance.
	 *
	 * @return Difference between Costs and Invoice Price (IPV)
	 */
	public CompletableFuture<MAccount> P_InvoicePriceVariance_A(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getP_InvoicePriceVariance_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_InvoicePriceVariance_Acct());
	}


	/**
	 * Get Landed Cost Clearing.
	 *
	 * @return Product Landed Cost Clearing Account
	 */
	public CompletableFuture<MAccount> P_LandedCostClearing_A(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getP_LandedCostClearing_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_LandedCostClearing_Acct());
	}


	/**
	 * Get Purchase Price Variance.
	 *
	 * @return Difference between Standard Cost and Purchase Price (PPV)
	 */
	public CompletableFuture<MAccount> P_PurchasePriceVariance_A(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getP_PurchasePriceVariance_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_PurchasePriceVariance_Acct());
	}


	/**
	 * Get Rate Variance.
	 *
	 * @return The Rate Variance account is the account used Manufacturing Order
	 */
	public CompletableFuture<MAccount> P_RateVariance_A(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getP_RateVariance_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_RateVariance_Acct());
	}


	/**
	 * Get Product Revenue.
	 *
	 * @return Account for Product Revenue (Sales Account)
	 */
	public CompletableFuture<MAccount> P_Revenue_A(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getP_Revenue_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_Revenue_Acct());
	}


	/**
	 * Get Trade Discount Granted.
	 *
	 * @return Trade Discount Granted Account
	 */
	public CompletableFuture<MAccount> P_TradeDiscountGrant_A(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getP_TradeDiscountGrant_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_TradeDiscountGrant_Acct());
	}


	/**
	 * Get Trade Discount Received.
	 *
	 * @return Trade Discount Receivable Account
	 */
	public CompletableFuture<MAccount> P_TradeDiscountRec_A(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		if (entity.getP_TradeDiscountRec_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_TradeDiscountRec_Acct());
	}

	public Boolean Processing(MProductCategoryAcct entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
