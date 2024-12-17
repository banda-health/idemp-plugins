package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MChangeLog;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MChangeLogDataLoader extends X_AD_ChangeLogDataLoader {
	public static String DATALOADER_AD_ChangeLog_BY_Record_ID = "DATALOADER_AD_ChangeLog_BY_Record_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_ChangeLog_BY_Record_ID,
				DataLoader.newMappedDataLoader(getByRecordIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MChangeLog>> getByRecordIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MChangeLog::getRecord_ID,
				MChangeLog.COLUMNNAME_Record_ID, keys);
	}
}
