package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_T_ReplenishDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_T_Replenish;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for T_Replenish - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_ReplenishQuery extends POQuery<X_T_Replenish> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_Replenish.Table_Name;
	}

	public CompletableFuture<X_T_Replenish> T_Replenish(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_T_Replenish> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_T_ReplenishDataLoader.DATALOADER_T_Replenish_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_T_Replenish> T_ReplenishGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
