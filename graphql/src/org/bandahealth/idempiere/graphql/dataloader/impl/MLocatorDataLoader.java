package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MLocator;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MLocatorDataLoader extends X_M_LocatorDataLoader {
	public static String DATALOADER_M_Locator_BY_M_Warehouse_ID = "M_LocatorByWarehouseIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_Locator_BY_M_Warehouse_ID,
				DataLoader.newMappedDataLoader(getByWarehouseIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MLocator>> getByWarehouseIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MLocator::getM_Warehouse_ID,
				MLocator.COLUMNNAME_M_Warehouse_ID, keys);
	}
}
