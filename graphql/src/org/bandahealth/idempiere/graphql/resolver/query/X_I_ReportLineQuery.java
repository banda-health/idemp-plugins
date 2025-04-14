package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_I_ReportLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_ReportLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for I_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_I_ReportLineQuery extends POQuery<X_I_ReportLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_ReportLine.Table_Name;
	}

	public CompletableFuture<X_I_ReportLine> I_ReportLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_I_ReportLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_I_ReportLineDataLoader.DATALOADER_I_ReportLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_I_ReportLine> I_ReportLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
