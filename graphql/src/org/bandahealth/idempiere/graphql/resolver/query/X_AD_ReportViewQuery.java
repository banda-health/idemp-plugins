package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReportViewDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MReportView;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ReportView - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ReportViewQuery extends POQuery<MReportView> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReportView.Table_Name;
	}

	public CompletableFuture<MReportView> AD_ReportView(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MReportView> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ReportViewDataLoader.DATALOADER_AD_ReportView_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MReportView> AD_ReportViewGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
