package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MPaymentDataLoader extends X_C_PaymentDataLoader {
	public static String DATALOADER_C_Payment_BY_BH_Visit_ID = "C_PaymentByVisitIdDataLoader";
	public static String DATALOADER_C_Payment_BY_BH_Original_C_Invoice_ID =
			"DATALOADER_C_Payment_BY_BH_Original_C_Invoice_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_Payment_BY_BH_Visit_ID,
				DataLoader.newMappedDataLoader(getByVisitIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_C_Payment_BY_BH_Original_C_Invoice_ID,
				DataLoader.newMappedDataLoader(getByBhOriginalInvoiceIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MPayment_BH>> getByVisitIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MPayment_BH::getBH_Visit_ID,
				MPayment_BH.COLUMNNAME_BH_Visit_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MPayment_BH>> getByBhOriginalInvoiceIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MPayment_BH::getBH_Original_C_Invoice_ID,
				MPayment_BH.COLUMNNAME_BH_Original_C_Invoice_ID, keys);
	}
}
