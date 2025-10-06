package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_IssueSystemDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_IssueSystem;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_IssueSystem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_IssueSystemQuery extends POQuery<X_R_IssueSystem> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueSystem.Table_Name;
	}

	public CompletableFuture<X_R_IssueSystem> R_IssueSystem(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_R_IssueSystem> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_IssueSystemDataLoader.DATALOADER_R_IssueSystem_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_R_IssueSystem> R_IssueSystemGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
