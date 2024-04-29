package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MMatchInv;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MMatchInvDataLoader extends X_M_MatchInvDataLoader {
	public static String DATALOADER_M_MatchInv_BY_C_InvoiceLine_ID = "DATALOADER_M_MatchInv_BY_C_InvoiceLine_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_MatchInv_BY_C_InvoiceLine_ID,
				DataLoader.newMappedDataLoader(getByInvoiceLineIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MMatchInv>> getByInvoiceLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MMatchInv::getC_InvoiceLine_ID,
				MMatchInv.COLUMNNAME_C_InvoiceLine_ID, keys);
	}
}
