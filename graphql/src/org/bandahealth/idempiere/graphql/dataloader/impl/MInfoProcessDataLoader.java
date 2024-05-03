package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.X_AD_InfoProcess;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MInfoProcessDataLoader extends X_AD_InfoRelatedDataLoader {
	public static String DATALOADER_AD_InfoRelated_BY_AD_InfoWindow_ID = "DATALOADER_AD_InfoRelated_BY_AD_InfoWindow_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_InfoRelated_BY_AD_InfoWindow_ID,
				DataLoader.newMappedDataLoader(getByInfoWindowIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<X_AD_InfoProcess>> getByInfoWindowIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, X_AD_InfoProcess::getAD_InfoWindow_ID,
				X_AD_InfoProcess.COLUMNNAME_AD_InfoWindow_ID, keys);
	}
}
