package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReplicationStrategyDataLoader;
import org.compiere.model.MOrg;
import org.compiere.model.MReplicationStrategy;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Org - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_OrgResolver extends POResolver<MOrg> implements GraphQLResolver<MOrg> {



	/**
	 * Get Replication Strategy.
	 *
	 * @return Data Replication Strategy
	 */
	public CompletableFuture<MReplicationStrategy> AD_ReplicationStrategy(MOrg entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ReplicationStrategy_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReplicationStrategy> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReplicationStrategyDataLoader.DATALOADER_AD_ReplicationStrategy_BY_ID);
		return dataLoader.load(entity.getAD_ReplicationStrategy_ID());
	}

	public Boolean IsSummary(MOrg entity, DataFetchingEnvironment environment) {
		return entity.isSummary();
	}

}
