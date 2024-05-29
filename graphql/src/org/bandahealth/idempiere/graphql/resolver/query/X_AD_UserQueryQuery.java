package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserQueryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserQuery;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_UserQuery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserQueryQuery extends POQuery<MUserQuery> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserQuery.Table_Name;
	}

	public CompletableFuture<MUserQuery> AD_UserQuery(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUserQuery> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_UserQueryDataLoader.DATALOADER_AD_UserQuery_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUserQuery> AD_UserQueryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
