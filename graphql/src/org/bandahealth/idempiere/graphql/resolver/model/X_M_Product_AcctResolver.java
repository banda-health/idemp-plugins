package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.X_M_Product_Acct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Product_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_Product_AcctResolver extends POResolver<X_M_Product_Acct> implements GraphQLResolver<X_M_Product_Acct> {



	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Product Asset.
	 *
	 * @return Account for Product Asset (Inventory)
	 */
	public CompletableFuture<MAccount> P_Asset_A(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getP_Asset_Acct() < 0) {
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
	public CompletableFuture<MAccount> P_AverageCostVariance_A(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getP_AverageCostVariance_Acct() < 0) {
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
	public CompletableFuture<MAccount> P_COGS_A(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getP_COGS_Acct() < 0) {
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
	public CompletableFuture<MAccount> P_CostAdjustment_A(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getP_CostAdjustment_Acct() < 0) {
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
	public CompletableFuture<MAccount> P_Expense_A(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getP_Expense_Acct() < 0) {
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
	public CompletableFuture<MAccount> P_InventoryClearing_A(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getP_InventoryClearing_Acct() < 0) {
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
	public CompletableFuture<MAccount> P_InvoicePriceVariance_A(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getP_InvoicePriceVariance_Acct() < 0) {
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
	public CompletableFuture<MAccount> P_LandedCostClearing_A(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getP_LandedCostClearing_Acct() < 0) {
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
	public CompletableFuture<MAccount> P_PurchasePriceVariance_A(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getP_PurchasePriceVariance_Acct() < 0) {
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
	public CompletableFuture<MAccount> P_RateVariance_A(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getP_RateVariance_Acct() < 0) {
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
	public CompletableFuture<MAccount> P_Revenue_A(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getP_Revenue_Acct() < 0) {
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
	public CompletableFuture<MAccount> P_TradeDiscountGrant_A(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getP_TradeDiscountGrant_Acct() < 0) {
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
	public CompletableFuture<MAccount> P_TradeDiscountRec_A(X_M_Product_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getP_TradeDiscountRec_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_TradeDiscountRec_Acct());
	}

}
