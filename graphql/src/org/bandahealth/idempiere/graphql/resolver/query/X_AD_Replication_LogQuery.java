package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Replication_LogDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MReplicationLog;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Replication_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Replication_LogQuery extends POQuery<MReplicationLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReplicationLog.Table_Name;
	}

	public CompletableFuture<MReplicationLog> AD_Replication_Log(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MReplicationLog> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Replication_LogDataLoader.DATALOADER_AD_Replication_Log_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MReplicationLog> AD_Replication_LogGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
