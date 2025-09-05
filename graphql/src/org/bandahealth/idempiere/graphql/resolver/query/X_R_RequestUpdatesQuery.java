package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestUpdatesDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_RequestUpdates;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_RequestUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_RequestUpdatesQuery extends POQuery<X_R_RequestUpdates> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestUpdates.Table_Name;
	}

	public CompletableFuture<X_R_RequestUpdates> R_RequestUpdates(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_R_RequestUpdates> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_RequestUpdatesDataLoader.DATALOADER_R_RequestUpdates_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_R_RequestUpdates> R_RequestUpdatesGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
