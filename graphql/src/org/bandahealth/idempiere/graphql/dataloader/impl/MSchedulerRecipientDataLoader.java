package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MSchedulerRecipient;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MSchedulerRecipientDataLoader extends X_AD_SchedulerRecipientDataLoader {
	public static String DATALOADER_AD_SchedulerRecipient_BY_AD_Scheduler_ID =
			"DATALOADER_AD_SchedulerRecipient_BY_AD_Scheduler_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_SchedulerRecipient_BY_AD_Scheduler_ID,
				DataLoader.newMappedDataLoader(getBySchedulerIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MSchedulerRecipient>> getBySchedulerIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MSchedulerRecipient::getAD_Scheduler_ID,
				MSchedulerRecipient.COLUMNNAME_AD_Scheduler_ID, keys);
	}
}
