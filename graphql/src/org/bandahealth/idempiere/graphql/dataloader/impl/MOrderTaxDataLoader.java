package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MOrderTax;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MOrderTaxDataLoader extends X_C_OrderTaxDataLoader {
	public static String DATALOADER_C_OrderTax_BY_C_Order_ID = "DATALOADER_C_OrderTax_BY_C_Order_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_OrderTax_BY_C_Order_ID,
				DataLoader.newMappedDataLoader(getByOrderIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MOrderTax>> getByOrderIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MOrderTax::getC_Order_ID,
				MOrderTax.COLUMNNAME_C_Order_ID, keys);
	}
}
