package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MMenuDataLoader;
import org.compiere.model.MTree_NodeMM;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

public class MTree_NodeMMResolver extends X_AD_TreeNodeMMResolver {
	public CompletableFuture<MMenu_BH> Node(MTree_NodeMM entity, DataFetchingEnvironment environment) {
		DataLoader<Integer, MMenu_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MMenuDataLoader.DATALOADER_AD_Menu_BY_ID);
		return dataLoader.load(entity.getNode_ID());
	}

	public CompletableFuture<MMenu_BH> Parent(MTree_NodeMM entity, DataFetchingEnvironment environment) {
		DataLoader<Integer, MMenu_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MMenuDataLoader.DATALOADER_AD_Menu_BY_ID);
		return dataLoader.load(entity.getParent_ID());
	}
}
