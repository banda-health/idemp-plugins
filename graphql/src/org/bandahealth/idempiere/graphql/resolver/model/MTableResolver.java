package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MIndexColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MViewComponentDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MTable;
import org.compiere.model.MViewComponent;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MTableResolver extends X_AD_TableResolver {

	public CompletableFuture<List<MColumn>> AD_Columns(MTable entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MColumn>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MIndexColumnDataLoader.DATALOADER_AD_IndexColumn_BY_AD_TableIndex_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Table_ID()));
	}

	public CompletableFuture<List<MViewComponent>> AD_ViewComponents(MTable entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MViewComponent>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MViewComponentDataLoader.DATALOADER_AD_ViewComponent_BY_AD_Table_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Table_ID()));
	}
}
