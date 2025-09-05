package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectIssueDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProjectIssue;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_ProjectIssue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ProjectIssueQuery extends POQuery<MProjectIssue> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProjectIssue.Table_Name;
	}

	public CompletableFuture<MProjectIssue> C_ProjectIssue(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProjectIssue> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ProjectIssueDataLoader.DATALOADER_C_ProjectIssue_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProjectIssue> C_ProjectIssueGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
