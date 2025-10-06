package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostQueueDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCostQueue;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_CostQueue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_CostQueueQuery extends POQuery<MCostQueue> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCostQueue.Table_Name;
	}

	public CompletableFuture<MCostQueue> M_CostQueue(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCostQueue> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_CostQueueDataLoader.DATALOADER_M_CostQueue_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCostQueue> M_CostQueueGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
