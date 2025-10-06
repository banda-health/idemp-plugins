package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ForecastLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MForecastLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ForecastLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ForecastLineQuery extends POQuery<MForecastLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MForecastLine.Table_Name;
	}

	public CompletableFuture<MForecastLine> M_ForecastLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MForecastLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ForecastLineDataLoader.DATALOADER_M_ForecastLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MForecastLine> M_ForecastLineGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
