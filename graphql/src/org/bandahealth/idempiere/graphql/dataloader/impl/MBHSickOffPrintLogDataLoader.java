package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHSickOffPrintLog;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHSickOffPrintLogDataLoader extends X_BH_SickOff_Print_LogDataLoader {
	public static String DATALOADER_BH_SickOff_Print_Log_BY_BH_SickOff_ID =
			"DATALOADER_BH_SickOff_Print_Log_BY_BH_SickOff_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_SickOff_Print_Log_BY_BH_SickOff_ID,
				DataLoader.newMappedDataLoader(getByBHSickOffIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHSickOffPrintLog>> getByBHSickOffIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHSickOffPrintLog::getBH_SickOff_ID,
				MBHSickOffPrintLog.COLUMNNAME_BH_SickOff_ID, keys);
	}
}
