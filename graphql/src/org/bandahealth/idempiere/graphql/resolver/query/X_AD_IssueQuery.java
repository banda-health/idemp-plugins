package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_IssueDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MIssue;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Issue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_IssueQuery extends POQuery<MIssue> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MIssue.Table_Name;
	}

	public CompletableFuture<MIssue> AD_Issue(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MIssue> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_IssueDataLoader.DATALOADER_AD_Issue_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MIssue> AD_IssueGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
