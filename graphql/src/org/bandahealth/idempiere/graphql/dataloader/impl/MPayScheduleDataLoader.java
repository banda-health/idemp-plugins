package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MPaySchedule;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MPayScheduleDataLoader extends X_C_PayScheduleDataLoader {
	public static String DATALOADER_C_PaySchedule_BY_C_PaymentTerm_ID = "DATALOADER_C_PaySchedule_BY_C_PaymentTerm_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_PaySchedule_BY_C_PaymentTerm_ID,
				DataLoader.newMappedDataLoader(getByPaymentTermIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MPaySchedule>> getByPaymentTermIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MPaySchedule::getC_PaymentTerm_ID,
				MPaySchedule.COLUMNNAME_C_PaymentTerm_ID, keys);
	}
}
