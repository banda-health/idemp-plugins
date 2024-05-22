package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MLot;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MLotDataLoader extends X_M_LotDataLoader {
	public static String DATALOADER_M_Lot_BY_M_Product_ID = "DATALOADER_M_Lot_BY_M_Product_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_Lot_BY_M_Product_ID,
				DataLoader.newMappedDataLoader(getByProductIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MLot>> getByProductIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MLot::getM_Product_ID,
				MLot.COLUMNNAME_M_Product_ID, keys);
	}
}
