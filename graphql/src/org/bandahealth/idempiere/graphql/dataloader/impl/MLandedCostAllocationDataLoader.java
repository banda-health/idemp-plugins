package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MLandedCostAllocation;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MLandedCostAllocationDataLoader extends X_C_LandedCostAllocationDataLoader {
	public static String DATALOADER_C_LandedCostAllocation_BY_C_InvoiceLine_ID =
			"DATALOADER_C_LandedCostAllocation_BY_C_InvoiceLine_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_LandedCostAllocation_BY_C_InvoiceLine_ID,
				DataLoader.newMappedDataLoader(getByInvoiceLineIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MLandedCostAllocation>> getByInvoiceLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MLandedCostAllocation::getC_InvoiceLine_ID,
				MLandedCostAllocation.COLUMNNAME_C_InvoiceLine_ID, keys);
	}
}
