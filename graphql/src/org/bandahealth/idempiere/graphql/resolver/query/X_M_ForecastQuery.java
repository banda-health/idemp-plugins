package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ForecastDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MForecast;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ForecastQuery extends POQuery<MForecast> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MForecast.Table_Name;
	}

	public CompletableFuture<MForecast> M_Forecast(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MForecast> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ForecastDataLoader.DATALOADER_M_Forecast_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MForecast> M_ForecastGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
