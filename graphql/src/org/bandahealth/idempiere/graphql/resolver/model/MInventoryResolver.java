package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInventoryLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MInventoryResolver extends X_M_InventoryResolver {
	public CompletableFuture<List<MInventoryLine_BH>> M_InventoryLines(MInventory_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MInventoryLine_BH>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInventoryLineDataLoader.M_InventoryLine_BY_INVENTORY_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_Inventory_ID()));
	}
}
