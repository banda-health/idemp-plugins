package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MInventoryLineDataLoader extends X_M_InventoryLineDataLoader {
	public static String M_InventoryLine_BY_INVENTORY_ID_DATA_LOADER = "M_InventoryLine_ByInventoryIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(M_InventoryLine_BY_INVENTORY_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByInventoryIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MInventoryLine_BH>> getByInventoryIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInventoryLine_BH::getM_Inventory_ID,
				MInventoryLine_BH.COLUMNNAME_M_Inventory_ID, keys);
	}
}
