package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_Conversion_RateDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MConversionRate;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Conversion_Rate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_Conversion_RateQuery extends POQuery<MConversionRate> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MConversionRate.Table_Name;
	}

	public CompletableFuture<MConversionRate> C_Conversion_Rate(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MConversionRate> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Conversion_RateDataLoader.DATALOADER_C_Conversion_Rate_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MConversionRate> C_Conversion_RateGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
