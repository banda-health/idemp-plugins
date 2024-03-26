package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MInvoiceLineDataLoader extends X_C_InvoiceLineDataLoader {
	public static String DATALOADER_C_InvoiceLine_BY_C_Invoice_ID = "C_InvoiceLineByInvoiceIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_InvoiceLine_BY_C_Invoice_ID,
				DataLoader.newMappedDataLoader(getByInvoiceIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MInvoiceLine_BH>> getByInvoiceIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInvoiceLine_BH::getC_Invoice_ID,
				MInvoiceLine_BH.COLUMNNAME_C_Invoice_ID, keys);
	}
}
