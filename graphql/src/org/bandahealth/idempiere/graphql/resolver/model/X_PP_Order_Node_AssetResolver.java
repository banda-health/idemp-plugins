package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Order_NodeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Order_WorkflowDataLoader;
import org.compiere.model.MAsset;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_Node;
import org.eevolution.model.X_PP_Order_Node_Asset;
import org.eevolution.model.X_PP_Order_Workflow;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PP_Order_Node_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PP_Order_Node_AssetResolver extends POResolver<X_PP_Order_Node_Asset> implements GraphQLResolver<X_PP_Order_Node_Asset> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(X_PP_Order_Node_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}


	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	public CompletableFuture<X_PP_Order> PP_Order(X_PP_Order_Node_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_PP_Order> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_OrderDataLoader.DATALOADER_PP_Order_BY_ID);
		return dataLoader.load(entity.getPP_Order_ID());
	}


	/**
	 * Get Manufacturing Order Activity.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public CompletableFuture<X_PP_Order_Node> PP_Order_Node(X_PP_Order_Node_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_Node_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_PP_Order_Node> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Order_NodeDataLoader.DATALOADER_PP_Order_Node_BY_ID);
		return dataLoader.load(entity.getPP_Order_Node_ID());
	}


	/**
	 * Get Manufacturing Order Workflow.
	 *
	 * @return Manufacturing Order Workflow
	 */
	public CompletableFuture<X_PP_Order_Workflow> PP_Order_Workflow(X_PP_Order_Node_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_Workflow_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_PP_Order_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Order_WorkflowDataLoader.DATALOADER_PP_Order_Workflow_BY_ID);
		return dataLoader.load(entity.getPP_Order_Workflow_ID());
	}

}
