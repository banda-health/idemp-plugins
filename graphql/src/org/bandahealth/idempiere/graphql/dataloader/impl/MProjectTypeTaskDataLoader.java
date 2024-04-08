package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MProjectTypeTask;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MProjectTypeTaskDataLoader extends X_C_TaskDataLoader {
	public static String DATALOADER_C_Task_BY_C_Phase_ID = "DATALOADER_C_Task_BY_C_Phase_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_Task_BY_C_Phase_ID,
				DataLoader.newMappedDataLoader(getByPhaseIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MProjectTypeTask>> getByPhaseIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MProjectTypeTask::getC_Phase_ID,
				MProjectTypeTask.COLUMNNAME_C_Phase_ID, keys);
	}
}
