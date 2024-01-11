package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAcctSchemaDefault;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_AcctSchema_Default - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctSchema_DefaultResolver extends POResolver<MAcctSchemaDefault> implements GraphQLResolver<MAcctSchemaDefault> {



	/**
	 * Get Bank Asset.
	 *
	 * @return Bank Asset Account
	 */
	public CompletableFuture<MAccount> B_Asset_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getB_Asset_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getB_Asset_Acct());
	}


	/**
	 * Get Bank Interest Expense.
	 *
	 * @return Bank Interest Expense Account
	 */
	public CompletableFuture<MAccount> B_InterestExp_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getB_InterestExp_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getB_InterestExp_Acct());
	}


	/**
	 * Get Bank Interest Revenue.
	 *
	 * @return Bank Interest Revenue Account
	 */
	public CompletableFuture<MAccount> B_InterestRev_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getB_InterestRev_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getB_InterestRev_Acct());
	}


	/**
	 * Get Bank In Transit.
	 *
	 * @return Bank In Transit Account
	 */
	public CompletableFuture<MAccount> B_InTransit_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getB_InTransit_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getB_InTransit_Acct());
	}


	/**
	 * Get Payment Selection.
	 *
	 * @return AP Payment Selection Clearing Account
	 */
	public CompletableFuture<MAccount> B_PaymentSelect_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getB_PaymentSelect_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getB_PaymentSelect_Acct());
	}


	/**
	 * Get Unallocated Cash.
	 *
	 * @return Unallocated Cash Clearing Account
	 */
	public CompletableFuture<MAccount> B_UnallocatedCash_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getB_UnallocatedCash_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getB_UnallocatedCash_Acct());
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.C_AcctSchema_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Customer Prepayment.
	 *
	 * @return Account for customer prepayments
	 */
	public CompletableFuture<MAccount> C_Prepayment_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getC_Prepayment_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Prepayment_Acct());
	}


	/**
	 * Get Customer Receivables.
	 *
	 * @return Account for Customer Receivables
	 */
	public CompletableFuture<MAccount> C_Receivable_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getC_Receivable_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Receivable_Acct());
	}


	/**
	 * Get Receivable Services.
	 *
	 * @return Customer Accounts Receivables Services Account
	 */
	public CompletableFuture<MAccount> C_Receivable_Services_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getC_Receivable_Services_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Receivable_Services_Acct());
	}


	/**
	 * Get Cash Book Asset.
	 *
	 * @return Cash Book Asset Account
	 */
	public CompletableFuture<MAccount> CB_Asset_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getCB_Asset_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getCB_Asset_Acct());
	}


	/**
	 * Get Cash Transfer.
	 *
	 * @return Cash Transfer Clearing Account
	 */
	public CompletableFuture<MAccount> CB_CashTransfer_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getCB_CashTransfer_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getCB_CashTransfer_Acct());
	}


	/**
	 * Get Cash Book Differences.
	 *
	 * @return Cash Book Differences Account
	 */
	public CompletableFuture<MAccount> CB_Differences_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getCB_Differences_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getCB_Differences_Acct());
	}


	/**
	 * Get Cash Book Expense.
	 *
	 * @return Cash Book Expense Account
	 */
	public CompletableFuture<MAccount> CB_Expense_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getCB_Expense_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getCB_Expense_Acct());
	}


	/**
	 * Get Cash Book Receipt.
	 *
	 * @return Cash Book Receipts Account
	 */
	public CompletableFuture<MAccount> CB_Receipt_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getCB_Receipt_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getCB_Receipt_Acct());
	}


	/**
	 * Get Charge Account.
	 *
	 * @return Charge Account
	 */
	public CompletableFuture<MAccount> Ch_Expense_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getCh_Expense_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getCh_Expense_Acct());
	}


	/**
	 * Get Not-invoiced Receipts.
	 *
	 * @return Account for not-invoiced Material Receipts
	 */
	public CompletableFuture<MAccount> NotInvoicedReceipts_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getNotInvoicedReceipts_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getNotInvoicedReceipts_Acct());
	}


	/**
	 * Get Product Asset.
	 *
	 * @return Account for Product Asset (Inventory)
	 */
	public CompletableFuture<MAccount> P_Asset_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getP_Asset_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getP_Asset_Acct());
	}


	/**
	 * Get Average Cost Variance.
	 *
	 * @return Average Cost Variance
	 */
	public CompletableFuture<MAccount> P_AverageCostVariance_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getP_AverageCostVariance_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getP_AverageCostVariance_Acct());
	}


	/**
	 * Get Product COGS.
	 *
	 * @return Account for Cost of Goods Sold
	 */
	public CompletableFuture<MAccount> P_COGS_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getP_COGS_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getP_COGS_Acct());
	}


	/**
	 * Get Cost Adjustment.
	 *
	 * @return Product Cost Adjustment Account
	 */
	public CompletableFuture<MAccount> P_CostAdjustment_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getP_CostAdjustment_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getP_CostAdjustment_Acct());
	}


	/**
	 * Get Product Expense.
	 *
	 * @return Account for Product Expense
	 */
	public CompletableFuture<MAccount> P_Expense_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getP_Expense_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getP_Expense_Acct());
	}


	/**
	 * Get Inventory Clearing.
	 *
	 * @return Product Inventory Clearing Account
	 */
	public CompletableFuture<MAccount> P_InventoryClearing_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getP_InventoryClearing_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getP_InventoryClearing_Acct());
	}


	/**
	 * Get Invoice Price Variance.
	 *
	 * @return Difference between Costs and Invoice Price (IPV)
	 */
	public CompletableFuture<MAccount> P_InvoicePriceVariance_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getP_InvoicePriceVariance_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getP_InvoicePriceVariance_Acct());
	}


	/**
	 * Get Landed Cost Clearing.
	 *
	 * @return Product Landed Cost Clearing Account
	 */
	public CompletableFuture<MAccount> P_LandedCostClearing_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getP_LandedCostClearing_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getP_LandedCostClearing_Acct());
	}


	/**
	 * Get Purchase Price Variance.
	 *
	 * @return Difference between Standard Cost and Purchase Price (PPV)
	 */
	public CompletableFuture<MAccount> P_PurchasePriceVariance_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getP_PurchasePriceVariance_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getP_PurchasePriceVariance_Acct());
	}


	/**
	 * Get Rate Variance.
	 *
	 * @return The Rate Variance account is the account used Manufacturing Order
	 */
	public CompletableFuture<MAccount> P_RateVariance_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getP_RateVariance_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getP_RateVariance_Acct());
	}


	/**
	 * Get Product Revenue.
	 *
	 * @return Account for Product Revenue (Sales Account)
	 */
	public CompletableFuture<MAccount> P_Revenue_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getP_Revenue_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getP_Revenue_Acct());
	}


	/**
	 * Get Trade Discount Granted.
	 *
	 * @return Trade Discount Granted Account
	 */
	public CompletableFuture<MAccount> P_TradeDiscountGrant_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getP_TradeDiscountGrant_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getP_TradeDiscountGrant_Acct());
	}


	/**
	 * Get Trade Discount Received.
	 *
	 * @return Trade Discount Receivable Account
	 */
	public CompletableFuture<MAccount> P_TradeDiscountRec_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getP_TradeDiscountRec_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getP_TradeDiscountRec_Acct());
	}


	/**
	 * Get Payment Discount Expense.
	 *
	 * @return Payment Discount Expense Account
	 */
	public CompletableFuture<MAccount> PayDiscount_Exp_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getPayDiscount_Exp_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPayDiscount_Exp_Acct());
	}


	/**
	 * Get Payment Discount Revenue.
	 *
	 * @return Payment Discount Revenue Account
	 */
	public CompletableFuture<MAccount> PayDiscount_Rev_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getPayDiscount_Rev_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPayDiscount_Rev_Acct());
	}


	/**
	 * Get Project Asset.
	 *
	 * @return Project Asset Account
	 */
	public CompletableFuture<MAccount> PJ_Asset_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getPJ_Asset_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPJ_Asset_Acct());
	}


	/**
	 * Get Work In Progress.
	 *
	 * @return Account for Work in Progress
	 */
	public CompletableFuture<MAccount> PJ_WIP_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getPJ_WIP_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPJ_WIP_Acct());
	}

	public Boolean Processing(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Realized Gain Acct.
	 *
	 * @return Realized Gain Account
	 */
	public CompletableFuture<MAccount> RealizedGain_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getRealizedGain_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getRealizedGain_Acct());
	}


	/**
	 * Get Realized Loss Acct.
	 *
	 * @return Realized Loss Account
	 */
	public CompletableFuture<MAccount> RealizedLoss_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getRealizedLoss_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getRealizedLoss_Acct());
	}


	/**
	 * Get Tax Credit.
	 *
	 * @return Account for Tax you can reclaim
	 */
	public CompletableFuture<MAccount> T_Credit_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getT_Credit_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getT_Credit_Acct());
	}


	/**
	 * Get Tax Due.
	 *
	 * @return Account for Tax you have to pay
	 */
	public CompletableFuture<MAccount> T_Due_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getT_Due_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getT_Due_Acct());
	}


	/**
	 * Get Tax Expense.
	 *
	 * @return Account for paid tax you cannot reclaim
	 */
	public CompletableFuture<MAccount> T_Expense_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getT_Expense_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getT_Expense_Acct());
	}


	/**
	 * Get Unearned Revenue.
	 *
	 * @return Account for unearned revenue
	 */
	public CompletableFuture<MAccount> UnEarnedRevenue_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getUnEarnedRevenue_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getUnEarnedRevenue_Acct());
	}


	/**
	 * Get Unrealized Gain Acct.
	 *
	 * @return Unrealized Gain Account for currency revaluation
	 */
	public CompletableFuture<MAccount> UnrealizedGain_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getUnrealizedGain_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getUnrealizedGain_Acct());
	}


	/**
	 * Get Unrealized Loss Acct.
	 *
	 * @return Unrealized Loss Account for currency revaluation
	 */
	public CompletableFuture<MAccount> UnrealizedLoss_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getUnrealizedLoss_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getUnrealizedLoss_Acct());
	}


	/**
	 * Get Vendor Liability.
	 *
	 * @return Account for Vendor Liability
	 */
	public CompletableFuture<MAccount> V_Liability_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getV_Liability_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getV_Liability_Acct());
	}


	/**
	 * Get Vendor Service Liability.
	 *
	 * @return Account for Vendor Service Liability
	 */
	public CompletableFuture<MAccount> V_Liability_Services_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getV_Liability_Services_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getV_Liability_Services_Acct());
	}


	/**
	 * Get Vendor Prepayment.
	 *
	 * @return Account for Vendor Prepayments
	 */
	public CompletableFuture<MAccount> V_Prepayment_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getV_Prepayment_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getV_Prepayment_Acct());
	}


	/**
	 * Get Warehouse Differences.
	 *
	 * @return Warehouse Differences Account
	 */
	public CompletableFuture<MAccount> W_Differences_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getW_Differences_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getW_Differences_Acct());
	}


	/**
	 * Get Write-off.
	 *
	 * @return Account for Receivables write-off
	 */
	public CompletableFuture<MAccount> WriteOff_A(MAcctSchemaDefault entity, DataFetchingEnvironment environment) {
		if (entity.getWriteOff_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getWriteOff_Acct());
	}

}
