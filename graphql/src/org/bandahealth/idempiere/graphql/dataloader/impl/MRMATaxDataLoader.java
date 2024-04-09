package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MRMATax;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MRMATaxDataLoader extends X_M_RMATaxDataLoader {
	public static String DATALOADER_M_RMATax_BY_M_RMA_ID = "DATALOADER_M_RMATax_BY_M_RMA_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_RMATax_BY_M_RMA_ID,
				DataLoader.newMappedDataLoader(getByRmaIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MRMATax>> getByRmaIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MRMATax::getM_RMA_ID,
				MRMATax.COLUMNNAME_M_RMA_ID, keys);
	}
}
