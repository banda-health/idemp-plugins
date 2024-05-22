package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MShippingTransactionLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MShippingTransactionLineDataLoader extends X_M_ShippingTransactionLineDataLoader {
	public static String DATALOADER_M_ShippingTransactionLine_BY_M_ShippingTransaction_ID =
			"DATALOADER_M_ShippingTransactionLine_BY_M_ShippingTransaction_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_ShippingTransactionLine_BY_M_ShippingTransaction_ID,
				DataLoader.newMappedDataLoader(getByShippingTransactionIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MShippingTransactionLine>> getByShippingTransactionIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null,
				MShippingTransactionLine::getM_ShippingTransaction_ID,
				MShippingTransactionLine.COLUMNNAME_M_ShippingTransaction_ID, keys);
	}
}
