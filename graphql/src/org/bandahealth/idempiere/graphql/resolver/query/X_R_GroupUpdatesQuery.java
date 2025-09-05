package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_GroupUpdatesDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_GroupUpdates;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_GroupUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_GroupUpdatesQuery extends POQuery<X_R_GroupUpdates> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_GroupUpdates.Table_Name;
	}

	public CompletableFuture<X_R_GroupUpdates> R_GroupUpdates(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_R_GroupUpdates> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_GroupUpdatesDataLoader.DATALOADER_R_GroupUpdates_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_R_GroupUpdates> R_GroupUpdatesGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
