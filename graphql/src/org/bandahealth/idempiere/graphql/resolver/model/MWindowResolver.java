package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MTabDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MTab;
import org.compiere.model.MWindow;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MWindowResolver extends X_AD_WindowResolver {
	public CompletableFuture<List<MTab>> AD_Tabs(MWindow entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MTab>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MTabDataLoader.DATALOADER_AD_Tab_BY_AD_Window_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Window_ID()));
	}
}
