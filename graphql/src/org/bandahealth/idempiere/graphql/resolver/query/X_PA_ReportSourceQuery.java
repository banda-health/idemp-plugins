package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportSourceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.report.MReportSource;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_ReportSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_ReportSourceQuery extends POQuery<MReportSource> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReportSource.Table_Name;
	}

	public CompletableFuture<MReportSource> PA_ReportSource(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MReportSource> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_ReportSourceDataLoader.DATALOADER_PA_ReportSource_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MReportSource> PA_ReportSourceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
