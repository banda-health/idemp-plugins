package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Process_ParaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_NodeDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MProcessPara;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WF_Node_Para;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_WF_Node_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_Node_ParaResolver extends POResolver<X_AD_WF_Node_Para> implements GraphQLResolver<X_AD_WF_Node_Para> {



	/**
	 * Get Process Parameter.
	 *
	 * @return Process Parameter
	 */
	public CompletableFuture<MProcessPara> AD_Process_Para(X_AD_WF_Node_Para entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_Para_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProcessPara> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Process_ParaDataLoader.DATALOADER_AD_Process_Para_BY_ID);
		return dataLoader.load(entity.getAD_Process_Para_ID());
	}


	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public CompletableFuture<X_AD_WF_Node> AD_WF_Node(X_AD_WF_Node_Para entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Node_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Node> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_NodeDataLoader.DATALOADER_AD_WF_Node_BY_ID);
		return dataLoader.load(entity.getAD_WF_Node_ID());
	}

	static Map<String, Integer> ENTITYTYPE_IDS_BY_ENTITY_TYPE = new HashMap<>() {
		{
			put("D", 10);
			put("C", 20);
			put("U", 100);
			put("CUST", 110);
			put("A", 200);
			put("EXT", 210);
			put("XX", 220);
			put("EE01", 50000);
			put("EE04", 50001);
			put("EE05", 50003);
			put("EE02", 50005);
			put("WSTORE", 200015);
		}
	};

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(X_AD_WF_Node_Para entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

}
