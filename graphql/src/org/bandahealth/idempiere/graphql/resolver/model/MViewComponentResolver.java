package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MViewColumnDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MViewColumn;
import org.compiere.model.MViewComponent;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MViewComponentResolver extends X_AD_ViewComponentResolver {

	public CompletableFuture<List<MViewColumn>> AD_ViewColumns(MViewComponent entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MViewColumn>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MViewColumnDataLoader.DATALOADER_AD_ViewColumn_BY_AD_ViewComponent_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_ViewComponent_ID()));
	}
}
