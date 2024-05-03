package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MSchedulerPara;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MSchedulerParaDataLoader extends X_AD_Scheduler_ParaDataLoader {
	public static String DATALOADER_AD_Scheduler_Para_BY_AD_Scheduler_ID =
			"DATALOADER_AD_Scheduler_Para_BY_AD_Scheduler_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_Scheduler_Para_BY_AD_Scheduler_ID,
				DataLoader.newMappedDataLoader(getBySchedulerIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MSchedulerPara>> getBySchedulerIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MSchedulerPara::getAD_Scheduler_ID,
				MSchedulerPara.COLUMNNAME_AD_Scheduler_ID, keys);
	}
}
