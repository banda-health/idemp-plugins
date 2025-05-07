package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_IssueUserDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MIssueUser;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_IssueUser - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_IssueUserQuery extends POQuery<MIssueUser> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MIssueUser.Table_Name;
	}

	public CompletableFuture<MIssueUser> R_IssueUser(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MIssueUser> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_IssueUserDataLoader.DATALOADER_R_IssueUser_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MIssueUser> R_IssueUserGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
