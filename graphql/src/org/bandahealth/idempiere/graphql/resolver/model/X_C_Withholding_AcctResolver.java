package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_WithholdingDataLoader;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MWithholding;
import org.compiere.model.X_C_Withholding_Acct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Withholding_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_Withholding_AcctResolver extends POResolver<X_C_Withholding_Acct> implements GraphQLResolver<X_C_Withholding_Acct> {



	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_C_Withholding_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Withholding.
	 *
	 * @return Withholding type defined
	 */
	public CompletableFuture<MWithholding> C_Withholding(X_C_Withholding_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getC_Withholding_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWithholding> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_WithholdingDataLoader.DATALOADER_C_Withholding_BY_ID);
		return dataLoader.load(entity.getC_Withholding_ID());
	}


	/**
	 * Get Withholding.
	 *
	 * @return Account for Withholdings
	 */
	public CompletableFuture<MAccount> Withholding_A(X_C_Withholding_Acct entity, DataFetchingEnvironment environment) {
		if (entity.getWithholding_Acct() < 1) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getWithholding_Acct());
	}

}
