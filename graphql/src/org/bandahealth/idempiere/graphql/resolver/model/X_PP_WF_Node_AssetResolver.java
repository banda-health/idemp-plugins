package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_NodeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.compiere.model.MAsset;
import org.compiere.model.X_AD_WF_Node;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_WF_Node_Asset;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PP_WF_Node_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PP_WF_Node_AssetResolver extends POResolver<X_PP_WF_Node_Asset> implements GraphQLResolver<X_PP_WF_Node_Asset> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(X_PP_WF_Node_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}


	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public CompletableFuture<X_AD_WF_Node> AD_WF_Node(X_PP_WF_Node_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Node_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Node> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_NodeDataLoader.DATALOADER_AD_WF_Node_BY_ID);
		return dataLoader.load(entity.getAD_WF_Node_ID());
	}

}
