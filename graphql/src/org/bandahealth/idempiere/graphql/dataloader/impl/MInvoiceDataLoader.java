package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MInvoiceDataLoader extends X_C_InvoiceDataLoader {
	public static String DATALOADER_C_Invoice_BY_BH_Visit_ID = "C_InvoiceByVisitIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_Invoice_BY_BH_Visit_ID,
				DataLoader.newMappedDataLoader(getByVisitIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MInvoice_BH>> getByVisitIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInvoice_BH::getBH_Visit_ID,
				MInvoice_BH.COLUMNNAME_BH_Visit_ID, keys);
	}
}
