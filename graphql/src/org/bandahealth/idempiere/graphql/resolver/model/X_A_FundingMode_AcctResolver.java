package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_FundingModeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.X_A_FundingMode;
import org.compiere.model.X_A_FundingMode_Acct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_FundingMode_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_FundingMode_AcctResolver extends POResolver<X_A_FundingMode_Acct> implements GraphQLResolver<X_A_FundingMode_Acct> {



	/**
	 * Get Funding Mode Account.
	 *
	 * @return Funding Mode Account
	 */
	public CompletableFuture<MAccount> A_FundingMode_A(X_A_FundingMode_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getA_FundingMode_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_FundingMode_Acct());
	}


	/**
	 * Get Asset Funding Mode.
	 *
	 * @return Asset Funding Mode
	 */
	public CompletableFuture<X_A_FundingMode> A_FundingMode(X_A_FundingMode_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getA_FundingMode_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_A_FundingMode> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_FundingModeDataLoader.A_FundingMode_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_FundingMode_ID());
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_A_FundingMode_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.C_AcctSchema_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}

}
