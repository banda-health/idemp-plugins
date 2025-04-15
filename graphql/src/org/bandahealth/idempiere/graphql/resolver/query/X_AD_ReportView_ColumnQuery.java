package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReportView_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_ReportView_Column;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ReportView_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ReportView_ColumnQuery extends POQuery<X_AD_ReportView_Column> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_ReportView_Column.Table_Name;
	}

	public CompletableFuture<X_AD_ReportView_Column> AD_ReportView_Column(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_ReportView_Column> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ReportView_ColumnDataLoader.DATALOADER_AD_ReportView_Column_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_ReportView_Column> AD_ReportView_ColumnGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
