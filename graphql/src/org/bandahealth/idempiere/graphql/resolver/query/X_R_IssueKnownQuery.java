package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_IssueKnownDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_IssueKnown;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_IssueKnown - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_IssueKnownQuery extends POQuery<X_R_IssueKnown> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueKnown.Table_Name;
	}

	public CompletableFuture<X_R_IssueKnown> R_IssueKnown(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_R_IssueKnown> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_IssueKnownDataLoader.DATALOADER_R_IssueKnown_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_R_IssueKnown> R_IssueKnownGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
