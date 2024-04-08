package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MInvoiceBatchLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MInvoiceBatchLineDataLoader extends X_C_InvoiceBatchLineDataLoader {
	public static String DATALOADER_C_InvoiceBatchLine_BY_C_InvoiceBatch_ID =
			"DATALOADER_C_InvoiceBatchLine_BY_C_InvoiceBatch_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_InvoiceBatchLine_BY_C_InvoiceBatch_ID,
				DataLoader.newMappedDataLoader(getByInvoiceBatchIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MInvoiceBatchLine>> getByInvoiceBatchIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInvoiceBatchLine::getC_InvoiceBatch_ID,
				MInvoiceBatchLine.COLUMNNAME_C_InvoiceBatch_ID, keys);
	}
}
