package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.X_C_BankAccount_Acct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_BankAccount_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankAccount_AcctResolver extends POResolver<X_C_BankAccount_Acct> implements GraphQLResolver<X_C_BankAccount_Acct> {



	/**
	 * Get Bank Asset.
	 *
	 * @return Bank Asset Account
	 */
	public CompletableFuture<MAccount> B_Asset_A(X_C_BankAccount_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getB_Asset_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getB_Asset_Acct());
	}


	/**
	 * Get Bank Interest Expense.
	 *
	 * @return Bank Interest Expense Account
	 */
	public CompletableFuture<MAccount> B_InterestExp_A(X_C_BankAccount_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getB_InterestExp_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getB_InterestExp_Acct());
	}


	/**
	 * Get Bank Interest Revenue.
	 *
	 * @return Bank Interest Revenue Account
	 */
	public CompletableFuture<MAccount> B_InterestRev_A(X_C_BankAccount_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getB_InterestRev_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getB_InterestRev_Acct());
	}


	/**
	 * Get Bank In Transit.
	 *
	 * @return Bank In Transit Account
	 */
	public CompletableFuture<MAccount> B_InTransit_A(X_C_BankAccount_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getB_InTransit_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getB_InTransit_Acct());
	}


	/**
	 * Get Payment Selection.
	 *
	 * @return AP Payment Selection Clearing Account
	 */
	public CompletableFuture<MAccount> B_PaymentSelect_A(X_C_BankAccount_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getB_PaymentSelect_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getB_PaymentSelect_Acct());
	}


	/**
	 * Get Unallocated Cash.
	 *
	 * @return Unallocated Cash Clearing Account
	 */
	public CompletableFuture<MAccount> B_UnallocatedCash_A(X_C_BankAccount_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getB_UnallocatedCash_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getB_UnallocatedCash_Acct());
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_C_BankAccount_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public CompletableFuture<MBankAccount_BH> C_BankAccount(X_C_BankAccount_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.DATALOADER_C_BankAccount_BY_ID);
		return dataLoader.load(entity.getC_BankAccount_ID());
	}

}
