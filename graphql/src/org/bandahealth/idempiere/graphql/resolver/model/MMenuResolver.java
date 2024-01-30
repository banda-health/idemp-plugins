package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MTree_NodeMMDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MTree_NodeMM;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MMenuResolver extends X_AD_MenuResolver {
	public CompletableFuture<List<MTree_NodeMM>> ChildrenTree_NodeMMList(MMenu_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MTree_NodeMM>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MTree_NodeMMDataLoader.DATALOADER_AD_TreeNodeMM_BY_Parent_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Menu_ID()));
	}
}
