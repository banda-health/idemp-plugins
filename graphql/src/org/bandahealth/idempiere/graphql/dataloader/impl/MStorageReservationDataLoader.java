package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MStorageReservation;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MStorageReservationDataLoader extends X_M_StorageReservationDataLoader {
	public static String DATALOADER_M_StorageReservation_BY_M_Product_ID =
			"DATALOADER_M_StorageReservation_BY_M_Product_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_StorageReservation_BY_M_Product_ID,
				DataLoader.newMappedDataLoader(getByProductIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MStorageReservation>> getByProductIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MStorageReservation::getM_Product_ID,
				MStorageReservation.COLUMNNAME_M_Product_ID, keys);
	}
}
