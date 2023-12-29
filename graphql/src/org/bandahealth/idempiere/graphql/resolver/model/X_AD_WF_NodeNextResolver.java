package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_NodeDataLoader;
import org.compiere.model.MEntityType;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WF_NodeNext;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for AD_WF_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_NodeNextResolver extends POResolver<X_AD_WF_NodeNext> implements GraphQLResolver<X_AD_WF_NodeNext> {



	/**
	 * Get Next Node.
	 *
	 * @return Next Node in workflow
	 */
	public CompletableFuture<X_AD_WF_Node> AD_WF_Next(X_AD_WF_NodeNext entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Next_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Node> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_NodeDataLoader.AD_WF_Node_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_WF_Next_ID());
	}


	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public CompletableFuture<X_AD_WF_Node> AD_WF_Node(X_AD_WF_NodeNext entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Node_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Node> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_NodeDataLoader.AD_WF_Node_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_WF_Node_ID());
	}


	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(X_AD_WF_NodeNext entity, DataFetchingEnvironment environment) {
		if (entity.getEntityType() <= 0) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.AD_EntityType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEntityType());
	}

}
