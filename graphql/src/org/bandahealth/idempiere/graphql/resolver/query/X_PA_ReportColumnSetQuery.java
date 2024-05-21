package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportColumnSetDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.report.MReportColumnSet;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_ReportColumnSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportColumnSetQuery extends POQuery<MReportColumnSet> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReportColumnSet.Table_Name;
	}

	public CompletableFuture<MReportColumnSet> PA_ReportColumnSet(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MReportColumnSet> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_ReportColumnSetDataLoader.DATALOADER_PA_ReportColumnSet_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MReportColumnSet> PA_ReportColumnSetGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
