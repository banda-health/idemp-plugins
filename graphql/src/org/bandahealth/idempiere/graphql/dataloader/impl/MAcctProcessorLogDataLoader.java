package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MAcctProcessorLog;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MAcctProcessorLogDataLoader extends X_C_AcctProcessorLogDataLoader {
	public static String DATALOADER_C_AcctProcessorLog_BY_C_AcctProcessor_ID =
			"DATALOADER_C_AcctProcessorLog_BY_C_AcctProcessor_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_AcctProcessorLog_BY_C_AcctProcessor_ID,
				DataLoader.newMappedDataLoader(getByAcctProcessorId(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MAcctProcessorLog>> getByAcctProcessorId() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MAcctProcessorLog::getC_AcctProcessor_ID,
				MAcctProcessorLog.COLUMNNAME_C_AcctProcessor_ID, keys);
	}
}
