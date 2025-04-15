package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ChartDatasourceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MChartDatasource;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ChartDatasource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ChartDatasourceQuery extends POQuery<MChartDatasource> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MChartDatasource.Table_Name;
	}

	public CompletableFuture<MChartDatasource> AD_ChartDatasource(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MChartDatasource> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ChartDatasourceDataLoader.DATALOADER_AD_ChartDatasource_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MChartDatasource> AD_ChartDatasourceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
