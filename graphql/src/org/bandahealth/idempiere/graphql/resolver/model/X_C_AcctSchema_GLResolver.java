package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAcctSchemaGL;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_AcctSchema_GL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_AcctSchema_GLResolver extends POResolver<MAcctSchemaGL> implements GraphQLResolver<MAcctSchemaGL> {



	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MAcctSchemaGL entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Commitment Offset.
	 *
	 * @return Budgetary Commitment Offset Account
	 */
	public CompletableFuture<MAccount> CommitmentOffset_A(MAcctSchemaGL entity, DataFetchingEnvironment environment) {
		if (entity.getCommitmentOffset_Acct() < 1) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getCommitmentOffset_Acct());
	}


	/**
	 * Get Commitment Offset Sales.
	 *
	 * @return Budgetary Commitment Offset Account for Sales
	 */
	public CompletableFuture<MAccount> CommitmentOffsetSales_A(MAcctSchemaGL entity, DataFetchingEnvironment environment) {
		if (entity.getCommitmentOffsetSales_Acct() < 1) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getCommitmentOffsetSales_Acct());
	}


	/**
	 * Get Currency Balancing Acct.
	 *
	 * @return Account used when a currency is out of balance
	 */
	public CompletableFuture<MAccount> CurrencyBalancing_A(MAcctSchemaGL entity, DataFetchingEnvironment environment) {
		if (entity.getCurrencyBalancing_Acct() < 1) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getCurrencyBalancing_Acct());
	}


	/**
	 * Get Intercompany Due From Acct.
	 *
	 * @return Intercompany Due From / Receivables Account
	 */
	public CompletableFuture<MAccount> IntercompanyDueFrom_A(MAcctSchemaGL entity, DataFetchingEnvironment environment) {
		if (entity.getIntercompanyDueFrom_Acct() < 1) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getIntercompanyDueFrom_Acct());
	}


	/**
	 * Get Intercompany Due To Acct.
	 *
	 * @return Intercompany Due To / Payable Account
	 */
	public CompletableFuture<MAccount> IntercompanyDueTo_A(MAcctSchemaGL entity, DataFetchingEnvironment environment) {
		if (entity.getIntercompanyDueTo_Acct() < 1) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getIntercompanyDueTo_Acct());
	}


	/**
	 * Get PPV Offset.
	 *
	 * @return Purchase Price Variance Offset Account
	 */
	public CompletableFuture<MAccount> PPVOffset_A(MAcctSchemaGL entity, DataFetchingEnvironment environment) {
		if (entity.getPPVOffset_Acct() < 1) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getPPVOffset_Acct());
	}


	/**
	 * Get Suspense Balancing Acct.
	 *
	 * @return Suspense Balancing Acct
	 */
	public CompletableFuture<MAccount> SuspenseBalancing_A(MAcctSchemaGL entity, DataFetchingEnvironment environment) {
		if (entity.getSuspenseBalancing_Acct() < 1) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getSuspenseBalancing_Acct());
	}

	public Boolean UseCurrencyBalancing(MAcctSchemaGL entity, DataFetchingEnvironment environment) {
		return entity.isUseCurrencyBalancing();
	}

	public Boolean UseSuspenseBalancing(MAcctSchemaGL entity, DataFetchingEnvironment environment) {
		return entity.isUseSuspenseBalancing();
	}

	public Boolean UseSuspenseError(MAcctSchemaGL entity, DataFetchingEnvironment environment) {
		return entity.isUseSuspenseError();
	}

}
