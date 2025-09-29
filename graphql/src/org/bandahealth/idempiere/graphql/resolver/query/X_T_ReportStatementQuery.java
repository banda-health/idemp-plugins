package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_T_ReportStatementDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_T_ReportStatement;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for T_ReportStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_T_ReportStatementQuery extends POQuery<X_T_ReportStatement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_ReportStatement.Table_Name;
	}

	public CompletableFuture<X_T_ReportStatement> T_ReportStatement(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_T_ReportStatement> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_T_ReportStatementDataLoader.DATALOADER_T_ReportStatement_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_T_ReportStatement> T_ReportStatementGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
