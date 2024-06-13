package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportColumnDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.report.MReportColumn;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_ReportColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportColumnQuery extends POQuery<MReportColumn> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReportColumn.Table_Name;
	}

	public CompletableFuture<MReportColumn> PA_ReportColumn(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MReportColumn> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_ReportColumnDataLoader.DATALOADER_PA_ReportColumn_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MReportColumn> PA_ReportColumnGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
