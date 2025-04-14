package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_CategoryUpdatesDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_CategoryUpdates;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_CategoryUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_CategoryUpdatesQuery extends POQuery<X_R_CategoryUpdates> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_CategoryUpdates.Table_Name;
	}

	public CompletableFuture<X_R_CategoryUpdates> R_CategoryUpdates(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_R_CategoryUpdates> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_CategoryUpdatesDataLoader.DATALOADER_R_CategoryUpdates_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_R_CategoryUpdates> R_CategoryUpdatesGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
