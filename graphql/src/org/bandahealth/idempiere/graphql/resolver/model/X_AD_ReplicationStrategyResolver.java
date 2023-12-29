package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_EXP_ProcessorDataLoader;
import org.compiere.model.MEXPProcessor;
import org.compiere.model.MEntityType;
import org.compiere.model.MReplicationStrategy;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for AD_ReplicationStrategy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReplicationStrategyResolver extends POResolver<MReplicationStrategy> implements GraphQLResolver<MReplicationStrategy> {



	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(MReplicationStrategy entity, DataFetchingEnvironment environment) {
		if (entity.getEntityType() <= 0) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.AD_EntityType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEntityType());
	}


	/**
	 * Get Export Processor.
	 *
	 * @return Export Processor
	 */
	public CompletableFuture<MEXPProcessor> EXP_Processor(MReplicationStrategy entity, DataFetchingEnvironment environment) {
		if (entity.getEXP_Processor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MEXPProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_EXP_ProcessorDataLoader.EXP_Processor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEXP_Processor_ID());
	}

}
