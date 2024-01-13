package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MLocatorDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLocator;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MWarehouseResolver extends X_M_WarehouseResolver {
	public CompletableFuture<List<MLocator>> M_Locators(MWarehouse_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MLocator>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MLocatorDataLoader.DATALOADER_M_Locator_BY_M_Warehouse_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.get_ID()));
	}
}
