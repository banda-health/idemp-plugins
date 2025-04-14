package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestTypeUpdatesDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_RequestTypeUpdates;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_RequestTypeUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_RequestTypeUpdatesQuery extends POQuery<X_R_RequestTypeUpdates> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestTypeUpdates.Table_Name;
	}

	public CompletableFuture<X_R_RequestTypeUpdates> R_RequestTypeUpdates(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_R_RequestTypeUpdates> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_RequestTypeUpdatesDataLoader.DATALOADER_R_RequestTypeUpdates_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_R_RequestTypeUpdates> R_RequestTypeUpdatesGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
