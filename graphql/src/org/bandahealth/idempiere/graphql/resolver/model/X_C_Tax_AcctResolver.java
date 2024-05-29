package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MTax;
import org.compiere.model.X_C_Tax_Acct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Tax_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_Tax_AcctResolver extends POResolver<X_C_Tax_Acct> implements GraphQLResolver<X_C_Tax_Acct> {



	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_C_Tax_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	public CompletableFuture<MTax> C_Tax(X_C_Tax_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_Tax_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MTax> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxDataLoader.DATALOADER_C_Tax_BY_ID);
		return dataLoader.load(entity.getC_Tax_ID());
	}


	/**
	 * Get Tax Credit.
	 *
	 * @return Account for Tax you can reclaim
	 */
	public CompletableFuture<MAccount> T_Credit_A(X_C_Tax_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getT_Credit_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getT_Credit_Acct());
	}


	/**
	 * Get Tax Due.
	 *
	 * @return Account for Tax you have to pay
	 */
	public CompletableFuture<MAccount> T_Due_A(X_C_Tax_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getT_Due_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getT_Due_Acct());
	}


	/**
	 * Get Tax Expense.
	 *
	 * @return Account for paid tax you cannot reclaim
	 */
	public CompletableFuture<MAccount> T_Expense_A(X_C_Tax_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getT_Expense_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getT_Expense_Acct());
	}

}
