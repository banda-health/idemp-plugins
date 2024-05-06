package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MInfoColumn;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MInfoColumnDataLoader extends X_AD_InfoColumnDataLoader {
	public static String DATALOADER_AD_InfoColumn_BY_AD_InfoWindow_ID = "DATALOADER_AD_InfoColumn_BY_AD_InfoWindow_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_InfoColumn_BY_AD_InfoWindow_ID,
				DataLoader.newMappedDataLoader(getByInfoWindowIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MInfoColumn>> getByInfoWindowIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInfoColumn::getAD_InfoWindow_ID,
				MInfoColumn.COLUMNNAME_AD_InfoWindow_ID, keys);
	}
}
