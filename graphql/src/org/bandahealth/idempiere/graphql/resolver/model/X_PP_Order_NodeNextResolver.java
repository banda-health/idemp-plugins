package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_NodeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Order_NodeDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.X_AD_WF_Node;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_Node;
import org.eevolution.model.X_PP_Order_NodeNext;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PP_Order_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PP_Order_NodeNextResolver extends POResolver<X_PP_Order_NodeNext> implements GraphQLResolver<X_PP_Order_NodeNext> {



	/**
	 * Get Next Node.
	 *
	 * @return Next Node in workflow
	 */
	public CompletableFuture<X_AD_WF_Node> AD_WF_Next(X_PP_Order_NodeNext entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Next_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Node> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_NodeDataLoader.DATALOADER_AD_WF_Node_BY_ID);
		return dataLoader.load(entity.getAD_WF_Next_ID());
	}


	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public CompletableFuture<X_AD_WF_Node> AD_WF_Node(X_PP_Order_NodeNext entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MEntityType> AD_EntityType(X_PP_Order_NodeNext entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	public Boolean IsStdUserWorkflow(X_PP_Order_NodeNext entity, DataFetchingEnvironment environment) {
		return entity.isStdUserWorkflow();
	}


	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	public CompletableFuture<X_PP_Order> PP_Order(X_PP_Order_NodeNext entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PP_Order> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_OrderDataLoader.DATALOADER_PP_Order_BY_ID);
		return dataLoader.load(entity.getPP_Order_ID());
	}


	/**
	 * Get Manufacturing Order Activity Next.
	 *
	 * @return Manufacturing Order Activity Next
	 */
	public CompletableFuture<X_PP_Order_Node> PP_Order_Next(X_PP_Order_NodeNext entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_Next_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PP_Order_Node> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Order_NodeDataLoader.DATALOADER_PP_Order_Node_BY_ID);
		return dataLoader.load(entity.getPP_Order_Next_ID());
	}


	/**
	 * Get Manufacturing Order Activity.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public CompletableFuture<X_PP_Order_Node> PP_Order_Node(X_PP_Order_NodeNext entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_Node_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PP_Order_Node> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Order_NodeDataLoader.DATALOADER_PP_Order_Node_BY_ID);
		return dataLoader.load(entity.getPP_Order_Node_ID());
	}

}
