package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ChartDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MChart;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Chart - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ChartQuery extends POQuery<MChart> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MChart.Table_Name;
	}

	public CompletableFuture<MChart> AD_Chart(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MChart> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ChartDataLoader.DATALOADER_AD_Chart_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MChart> AD_ChartGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
