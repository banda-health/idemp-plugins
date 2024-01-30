package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MOrderLineDataLoader extends X_C_OrderLineDataLoader {
	public static String DATALOADER_C_OrderLine_By_C_Order_ID = "C_OrderLineByOrderIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_OrderLine_By_C_Order_ID,
				DataLoader.newMappedDataLoader(getByOrderIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MOrderLine_BH>> getByOrderIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MOrderLine_BH::getC_Order_ID,
				MOrderLine_BH.COLUMNNAME_C_Order_ID, keys);
	}
}
