package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReplicationDataLoader;
import org.compiere.model.MReplication;
import org.compiere.model.MReplicationRun;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Replication_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Replication_RunResolver extends POResolver<MReplicationRun> implements GraphQLResolver<MReplicationRun> {



	/**
	 * Get Replication.
	 *
	 * @return Data Replication Target
	 */
	public CompletableFuture<MReplication> AD_Replication(MReplicationRun entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Replication_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReplication> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReplicationDataLoader.DATALOADER_AD_Replication_BY_ID);
		return dataLoader.load(entity.getAD_Replication_ID());
	}

	public Boolean IsReplicated(MReplicationRun entity, DataFetchingEnvironment environment) {
		return entity.isReplicated();
	}

}
