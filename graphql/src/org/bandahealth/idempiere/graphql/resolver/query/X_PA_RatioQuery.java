package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_RatioDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_PA_Ratio;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_Ratio - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_RatioQuery extends POQuery<X_PA_Ratio> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PA_Ratio.Table_Name;
	}

	public CompletableFuture<X_PA_Ratio> PA_Ratio(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_PA_Ratio> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_RatioDataLoader.DATALOADER_PA_Ratio_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_PA_Ratio> PA_RatioGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
