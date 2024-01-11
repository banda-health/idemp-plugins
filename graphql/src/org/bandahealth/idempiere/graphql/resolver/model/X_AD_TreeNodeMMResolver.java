package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeDataLoader;
import org.compiere.model.MTree;
import org.compiere.model.MTree_NodeMM;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_TreeNodeMM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeMMResolver extends POResolver<MTree_NodeMM> implements GraphQLResolver<MTree_NodeMM> {



	/**
	 * Get Tree.
	 *
	 * @return Identifies a Tree
	 */
	public CompletableFuture<MTree> AD_Tree(MTree_NodeMM entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.AD_Tree_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Tree_ID());
	}

}
