package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MAllocationLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MAllocationLineDataLoader extends X_C_AllocationLineDataLoader {
	public static String DATALOADER_C_AllocationLine_BY_C_Payment_ID = "DATALOADER_C_AllocationLine_BY_C_Payment_ID";
	public static String DATALOADER_C_AllocationLine_BY_C_Invoice_ID = "DATALOADER_C_AllocationLine_BY_C_Invoice_ID";
	public static String DATALOADER_C_AllocationLine_BY_C_AllocationHdr_ID =
			"DATALOADER_C_AllocationLine_BY_C_AllocationHdr_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_AllocationLine_BY_C_Payment_ID,
				DataLoader.newMappedDataLoader(getByPaymentIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_C_AllocationLine_BY_C_Invoice_ID,
				DataLoader.newMappedDataLoader(getByInvoiceIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_C_AllocationLine_BY_C_AllocationHdr_ID,
				DataLoader.newMappedDataLoader(getByAllocationHdrIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MAllocationLine>> getByPaymentIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MAllocationLine::getC_Payment_ID,
				MAllocationLine.COLUMNNAME_C_Payment_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MAllocationLine>> getByInvoiceIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MAllocationLine::getC_Invoice_ID,
				MAllocationLine.COLUMNNAME_C_Invoice_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MAllocationLine>> getByAllocationHdrIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MAllocationLine::getC_AllocationHdr_ID,
				MAllocationLine.COLUMNNAME_C_AllocationHdr_ID, keys);
	}
}
