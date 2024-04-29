package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MInventoryLineMA;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MInventoryLineMADataLoader extends X_M_InventoryLineMADataLoader {
	public static String DATALOADER_M_InventoryLineMA_BY_M_InventoryLine_ID =
			"DATALOADER_M_InventoryLineMA_BY_M_InventoryLine_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_InventoryLineMA_BY_M_InventoryLine_ID,
				DataLoader.newMappedDataLoader(getByInventoryLineIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MInventoryLineMA>> getByInventoryLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInventoryLineMA::getM_InventoryLine_ID,
				MInventoryLineMA.COLUMNNAME_M_InventoryLine_ID, keys);
	}
}
