package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.compiere.model.MAcctSchema;
import org.compiere.model.X_PA_Ratio;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for PA_Ratio - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_RatioResolver extends POResolver<X_PA_Ratio> implements GraphQLResolver<X_PA_Ratio> {



	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_PA_Ratio entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.C_AcctSchema_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}

}
