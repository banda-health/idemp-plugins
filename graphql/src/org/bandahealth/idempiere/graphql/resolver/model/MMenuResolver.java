package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MMenuDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MMenuResolver extends X_AD_MenuResolver {
	public CompletableFuture<List<MMenu_BH>> ChildrenMM(MMenu_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MMenu_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MMenuDataLoader.AD_Menu_BY_AD_MENU_PARENT_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Menu_ID()));
	}
}
