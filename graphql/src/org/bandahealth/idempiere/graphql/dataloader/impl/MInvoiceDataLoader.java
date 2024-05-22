package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MInvoiceDataLoader extends X_C_InvoiceDataLoader {
	public static String DATALOADER_C_Invoice_BY_BH_Visit_ID = "DATALOADER_C_Invoice_BY_BH_Visit_ID";
	public static String DATALOADER_C_Invoice_BY_C_Order_ID = "DATALOADER_C_Invoice_BY_C_Order_ID";
	public static String DATALOADER_C_Invoice_BY_C_Project_ID = "DATALOADER_C_Invoice_BY_C_Project_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_Invoice_BY_BH_Visit_ID,
				DataLoader.newMappedDataLoader(getByVisitIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_C_Invoice_BY_C_Order_ID,
				DataLoader.newMappedDataLoader(getByOrderIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_C_Invoice_BY_C_Project_ID,
				DataLoader.newMappedDataLoader(getByProjectIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MInvoice_BH>> getByVisitIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInvoice_BH::getBH_Visit_ID,
				MInvoice_BH.COLUMNNAME_BH_Visit_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MInvoice_BH>> getByOrderIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInvoice_BH::getC_Order_ID,
				MInvoice_BH.COLUMNNAME_C_Order_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MInvoice_BH>> getByProjectIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInvoice_BH::getC_Project_ID,
				MInvoice_BH.COLUMNNAME_C_Project_ID, keys);
	}
}
