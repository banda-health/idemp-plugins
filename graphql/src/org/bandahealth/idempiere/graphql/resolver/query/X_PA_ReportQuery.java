package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.report.MReport;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportQuery extends POQuery<MReport> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReport.Table_Name;
	}

	public CompletableFuture<MReport> PA_Report(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MReport> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_ReportDataLoader.DATALOADER_PA_Report_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MReport> PA_ReportGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
