package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MAlertProcessorLog;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MAlertProcessorLogDataLoader extends X_AD_AlertProcessorLogDataLoader {
	public static String DATALOADER_AD_AlertProcessorLog_BY_AD_AlertProcessor_ID =
			"DATALOADER_AD_AlertProcessorLog_BY_AD_AlertProcessor_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_AlertProcessorLog_BY_AD_AlertProcessor_ID,
				DataLoader.newMappedDataLoader(getByAlertProcessorIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MAlertProcessorLog>> getByAlertProcessorIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MAlertProcessorLog::getAD_AlertProcessor_ID,
				MAlertProcessorLog.COLUMNNAME_AD_AlertProcessor_ID, keys);
	}
}
