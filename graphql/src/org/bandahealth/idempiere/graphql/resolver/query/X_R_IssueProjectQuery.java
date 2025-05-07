package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_IssueProjectDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MIssueProject;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_IssueProject - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_IssueProjectQuery extends POQuery<MIssueProject> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MIssueProject.Table_Name;
	}

	public CompletableFuture<MIssueProject> R_IssueProject(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MIssueProject> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_IssueProjectDataLoader.DATALOADER_R_IssueProject_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MIssueProject> R_IssueProjectGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
