package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_ForecastDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Depreciation_Forecast;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Depreciation_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Depreciation_ForecastQuery extends POQuery<X_A_Depreciation_Forecast> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_Forecast.Table_Name;
	}

	public CompletableFuture<X_A_Depreciation_Forecast> A_Depreciation_Forecast(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_A_Depreciation_Forecast> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Depreciation_ForecastDataLoader.DATALOADER_A_Depreciation_Forecast_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_A_Depreciation_Forecast> A_Depreciation_ForecastGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
