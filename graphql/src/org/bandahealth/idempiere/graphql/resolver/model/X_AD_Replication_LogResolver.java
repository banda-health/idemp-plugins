package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReplicationTableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Replication_RunDataLoader;
import org.compiere.model.MReplicationLog;
import org.compiere.model.MReplicationRun;
import org.compiere.model.X_AD_ReplicationTable;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Replication_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Replication_LogResolver extends POResolver<MReplicationLog> implements GraphQLResolver<MReplicationLog> {



	/**
	 * Get Replication Run.
	 *
	 * @return Data Replication Run
	 */
	public CompletableFuture<MReplicationRun> AD_Replication_Run(MReplicationLog entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Replication_Run_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReplicationRun> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Replication_RunDataLoader.AD_Replication_Run_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Replication_Run_ID());
	}


	/**
	 * Get Replication Table.
	 *
	 * @return Data Replication Strategy Table Info
	 */
	public CompletableFuture<X_AD_ReplicationTable> AD_ReplicationTable(MReplicationLog entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ReplicationTable_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_ReplicationTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReplicationTableDataLoader.AD_ReplicationTable_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_ReplicationTable_ID());
	}

	public Boolean IsReplicated(MReplicationLog entity, DataFetchingEnvironment environment) {
		return entity.isReplicated();
	}

}
