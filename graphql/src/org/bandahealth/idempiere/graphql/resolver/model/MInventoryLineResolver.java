package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInventoryLineMADataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MInventoryLineMA;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MInventoryLineResolver extends X_M_InventoryLineResolver {

	public CompletableFuture<List<MInventoryLineMA>> M_InventoryLineMAList(MInventoryLine entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MInventoryLineMA>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInventoryLineMADataLoader.DATALOADER_M_InventoryLineMA_BY_M_InventoryLine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_InventoryLine_ID()));
	}
}
