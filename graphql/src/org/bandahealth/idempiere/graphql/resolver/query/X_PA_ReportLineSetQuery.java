package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportLineSetDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.report.MReportLineSet;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_ReportLineSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportLineSetQuery extends POQuery<MReportLineSet> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReportLineSet.Table_Name;
	}

	public CompletableFuture<MReportLineSet> PA_ReportLineSet(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MReportLineSet> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_ReportLineSetDataLoader.DATALOADER_PA_ReportLineSet_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MReportLineSet> PA_ReportLineSetGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
