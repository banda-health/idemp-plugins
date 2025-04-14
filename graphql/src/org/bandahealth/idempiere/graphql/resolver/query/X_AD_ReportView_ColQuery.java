package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReportView_ColDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_ReportView_Col;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ReportView_Col - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ReportView_ColQuery extends POQuery<X_AD_ReportView_Col> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_ReportView_Col.Table_Name;
	}

	public CompletableFuture<X_AD_ReportView_Col> AD_ReportView_Col(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_ReportView_Col> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ReportView_ColDataLoader.DATALOADER_AD_ReportView_Col_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_ReportView_Col> AD_ReportView_ColGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
