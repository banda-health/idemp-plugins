package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MRequestProcessorLog;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MRequestProcessorLogDataLoader extends X_R_RequestProcessorLogDataLoader {
	public static String DATALOADER_R_RequestProcessorLog_BY_R_RequestProcessor_ID =
			"DATALOADER_R_RequestProcessorLog_BY_R_RequestProcessor_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_R_RequestProcessorLog_BY_R_RequestProcessor_ID,
				DataLoader.newMappedDataLoader(getByRequestProcessorIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MRequestProcessorLog>> getByRequestProcessorIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MRequestProcessorLog::getR_RequestProcessor_ID,
				MRequestProcessorLog.COLUMNNAME_R_RequestProcessor_ID, keys);
	}
}
