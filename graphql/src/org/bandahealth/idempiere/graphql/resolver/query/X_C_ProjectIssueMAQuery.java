package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectIssueMADataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_ProjectIssueMA;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_ProjectIssueMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ProjectIssueMAQuery extends POQuery<X_C_ProjectIssueMA> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectIssueMA.Table_Name;
	}

	public CompletableFuture<X_C_ProjectIssueMA> C_ProjectIssueMA(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_ProjectIssueMA> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ProjectIssueMADataLoader.DATALOADER_C_ProjectIssueMA_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_ProjectIssueMA> C_ProjectIssueMAGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
