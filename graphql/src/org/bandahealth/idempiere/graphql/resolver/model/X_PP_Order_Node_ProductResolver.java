package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Order_NodeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Order_WorkflowDataLoader;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_Node;
import org.eevolution.model.X_PP_Order_Node_Product;
import org.eevolution.model.X_PP_Order_Workflow;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PP_Order_Node_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_Node_ProductResolver extends POResolver<X_PP_Order_Node_Product> implements GraphQLResolver<X_PP_Order_Node_Product> {


	public Boolean IsSubcontracting(X_PP_Order_Node_Product entity, DataFetchingEnvironment environment) {
		return entity.isSubcontracting();
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_PP_Order_Node_Product entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	public CompletableFuture<X_PP_Order> PP_Order(X_PP_Order_Node_Product entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PP_Order> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_OrderDataLoader.PP_Order_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPP_Order_ID());
	}


	/**
	 * Get Manufacturing Order Activity.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public CompletableFuture<X_PP_Order_Node> PP_Order_Node(X_PP_Order_Node_Product entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_Node_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PP_Order_Node> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Order_NodeDataLoader.PP_Order_Node_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPP_Order_Node_ID());
	}


	/**
	 * Get Manufacturing Order Workflow.
	 *
	 * @return Manufacturing Order Workflow
	 */
	public CompletableFuture<X_PP_Order_Workflow> PP_Order_Workflow(X_PP_Order_Node_Product entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_Workflow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PP_Order_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Order_WorkflowDataLoader.PP_Order_Workflow_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPP_Order_Workflow_ID());
	}

}
