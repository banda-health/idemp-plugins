package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReplicationStrategyDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MReplicationStrategy;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ReplicationStrategy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ReplicationStrategyQuery extends POQuery<MReplicationStrategy> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReplicationStrategy.Table_Name;
	}

	public CompletableFuture<MReplicationStrategy> AD_ReplicationStrategy(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MReplicationStrategy> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ReplicationStrategyDataLoader.DATALOADER_AD_ReplicationStrategy_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MReplicationStrategy> AD_ReplicationStrategyGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
