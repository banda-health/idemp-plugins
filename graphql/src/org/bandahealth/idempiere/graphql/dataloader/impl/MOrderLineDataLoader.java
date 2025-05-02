package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MOrderLineDataLoader extends X_C_OrderLineDataLoader {
	public static String DATALOADER_C_OrderLine_BY_C_Order_ID = "C_OrderLineByOrderIdDataLoader";
	public static String DATALOADER_C_OrderLine_BY_Included_OrderLine_ID =
			"DATALOADER_C_OrderLine_BY_Included_OrderLine_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_OrderLine_BY_C_Order_ID,
				DataLoader.newMappedDataLoader(getByOrderIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_C_OrderLine_BY_Included_OrderLine_ID,
				DataLoader.newMappedDataLoader(getByIncludedOrderLineIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MOrderLine_BH>> getByOrderIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MOrderLine_BH::getC_Order_ID,
				MOrderLine_BH.COLUMNNAME_C_Order_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MOrderLine_BH>> getByIncludedOrderLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MOrderLine_BH::getIncluded_OrderLine_ID,
				MOrderLine_BH.COLUMNNAME_Included_OrderLine_ID, keys);
	}
}
