package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ReplenishDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MReplenish;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Replenish - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ReplenishQuery extends POQuery<MReplenish> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReplenish.Table_Name;
	}

	public CompletableFuture<MReplenish> M_Replenish(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MReplenish> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ReplenishDataLoader.DATALOADER_M_Replenish_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MReplenish> M_ReplenishGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
