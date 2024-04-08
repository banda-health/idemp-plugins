package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MInvoiceTax;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MInvoiceTaxDataLoader extends X_C_InvoiceTaxDataLoader {
	public static String DATALOADER_C_InvoiceTax_BY_C_Invoice_ID = "DATALOADER_C_InvoiceTax_BY_C_Invoice_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_InvoiceTax_BY_C_Invoice_ID,
				DataLoader.newMappedDataLoader(getByInvoiceIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MInvoiceTax>> getByInvoiceIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInvoiceTax::getC_Invoice_ID,
				MInvoiceTax.COLUMNNAME_C_Invoice_ID, keys);
	}
}
