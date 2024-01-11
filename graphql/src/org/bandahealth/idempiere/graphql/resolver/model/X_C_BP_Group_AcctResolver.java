package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.X_C_BP_Group_Acct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_BP_Group_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_Group_AcctResolver extends POResolver<X_C_BP_Group_Acct> implements GraphQLResolver<X_C_BP_Group_Acct> {



	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_C_BP_Group_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.C_AcctSchema_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	public CompletableFuture<MBPGroup_BH> C_BP_Group(X_C_BP_Group_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Group_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPGroup_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_GroupDataLoader.C_BP_Group_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BP_Group_ID());
	}


	/**
	 * Get Customer Prepayment.
	 *
	 * @return Account for customer prepayments
	 */
	public CompletableFuture<MAccount> C_Prepayment_A(X_C_BP_Group_Acct entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MAccount> C_Receivable_A(X_C_BP_Group_Acct entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MAccount> C_Receivable_Services_A(X_C_BP_Group_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_Receivable_Services_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Receivable_Services_Acct());
	}


	/**
	 * Get Not-invoiced Receipts.
	 *
	 * @return Account for not-invoiced Material Receipts
	 */
	public CompletableFuture<MAccount> NotInvoicedReceipts_A(X_C_BP_Group_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getNotInvoicedReceipts_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getNotInvoicedReceipts_Acct());
	}


	/**
	 * Get Payment Discount Expense.
	 *
	 * @return Payment Discount Expense Account
	 */
	public CompletableFuture<MAccount> PayDiscount_Exp_A(X_C_BP_Group_Acct entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MAccount> PayDiscount_Rev_A(X_C_BP_Group_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getPayDiscount_Rev_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPayDiscount_Rev_Acct());
	}

	public Boolean Processing(X_C_BP_Group_Acct entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Unearned Revenue.
	 *
	 * @return Account for unearned revenue
	 */
	public CompletableFuture<MAccount> UnEarnedRevenue_A(X_C_BP_Group_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getUnEarnedRevenue_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getUnEarnedRevenue_Acct());
	}


	/**
	 * Get Vendor Liability.
	 *
	 * @return Account for Vendor Liability
	 */
	public CompletableFuture<MAccount> V_Liability_A(X_C_BP_Group_Acct entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MAccount> V_Liability_Services_A(X_C_BP_Group_Acct entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MAccount> V_Prepayment_A(X_C_BP_Group_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getV_Prepayment_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getV_Prepayment_Acct());
	}


	/**
	 * Get Write-off.
	 *
	 * @return Account for Receivables write-off
	 */
	public CompletableFuture<MAccount> WriteOff_A(X_C_BP_Group_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getWriteOff_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getWriteOff_Acct());
	}

}
