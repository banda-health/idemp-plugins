package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.report.MReportLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportLineQuery extends POQuery<MReportLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReportLine.Table_Name;
	}

	public CompletableFuture<MReportLine> PA_ReportLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MReportLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_ReportLineDataLoader.DATALOADER_PA_ReportLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MReportLine> PA_ReportLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
