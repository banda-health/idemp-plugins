package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashBookDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCashBook;
import org.compiere.model.X_C_CashBook_Acct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_CashBook_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CashBook_AcctResolver extends POResolver<X_C_CashBook_Acct> implements GraphQLResolver<X_C_CashBook_Acct> {



	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_C_CashBook_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Cash Book.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	public CompletableFuture<MCashBook> C_CashBook(X_C_CashBook_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_CashBook_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCashBook> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashBookDataLoader.DATALOADER_C_CashBook_BY_ID);
		return dataLoader.load(entity.getC_CashBook_ID());
	}


	/**
	 * Get Cash Book Asset.
	 *
	 * @return Cash Book Asset Account
	 */
	public CompletableFuture<MAccount> CB_Asset_A(X_C_CashBook_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getCB_Asset_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getCB_Asset_Acct());
	}


	/**
	 * Get Cash Transfer.
	 *
	 * @return Cash Transfer Clearing Account
	 */
	public CompletableFuture<MAccount> CB_CashTransfer_A(X_C_CashBook_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getCB_CashTransfer_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getCB_CashTransfer_Acct());
	}


	/**
	 * Get Cash Book Differences.
	 *
	 * @return Cash Book Differences Account
	 */
	public CompletableFuture<MAccount> CB_Differences_A(X_C_CashBook_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getCB_Differences_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getCB_Differences_Acct());
	}


	/**
	 * Get Cash Book Expense.
	 *
	 * @return Cash Book Expense Account
	 */
	public CompletableFuture<MAccount> CB_Expense_A(X_C_CashBook_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getCB_Expense_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getCB_Expense_Acct());
	}


	/**
	 * Get Cash Book Receipt.
	 *
	 * @return Cash Book Receipts Account
	 */
	public CompletableFuture<MAccount> CB_Receipt_A(X_C_CashBook_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getCB_Receipt_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getCB_Receipt_Acct());
	}

}
