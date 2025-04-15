package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReplicationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MReplication;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Replication - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ReplicationQuery extends POQuery<MReplication> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReplication.Table_Name;
	}

	public CompletableFuture<MReplication> AD_Replication(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MReplication> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ReplicationDataLoader.DATALOADER_AD_Replication_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MReplication> AD_ReplicationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
