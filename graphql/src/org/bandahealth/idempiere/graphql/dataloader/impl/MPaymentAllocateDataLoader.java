package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MPaymentAllocate;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MPaymentAllocateDataLoader extends X_C_PaymentAllocateDataLoader {
	public static String DATALOADER_C_PaymentAllocate_BY_C_Payment_ID = "DATALOADER_C_PaymentAllocate_BY_C_Payment_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_PaymentAllocate_BY_C_Payment_ID,
				DataLoader.newMappedDataLoader(getByPaymentIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MPaymentAllocate>> getByPaymentIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MPaymentAllocate::getC_Payment_ID,
				MPaymentAllocate.COLUMNNAME_C_Payment_ID, keys);
	}
}
