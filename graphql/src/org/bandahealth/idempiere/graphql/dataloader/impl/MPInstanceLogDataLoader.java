package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.X_AD_PInstance_Log;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MPInstanceLogDataLoader extends X_AD_PInstance_LogDataLoader {
	public static String DATALOADER_AD_PInstance_Log_BY_AD_PInstance_ID =
			"DATALOADER_AD_PInstance_Log_BY_AD_PInstance_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_PInstance_Log_BY_AD_PInstance_ID,
				DataLoader.newMappedDataLoader(getByPInstanceIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<X_AD_PInstance_Log>> getByPInstanceIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, X_AD_PInstance_Log::getAD_PInstance_ID,
				X_AD_PInstance_Log.COLUMNNAME_AD_PInstance_ID, keys);
	}
}
