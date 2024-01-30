package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MInOutDataLoader extends X_M_InOutDataLoader {
	public static String DATALOADER_M_InOut_BY_C_Order_ID = "M_InOutByOrderIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_InOut_BY_C_Order_ID,
				DataLoader.newMappedDataLoader(getByOrderIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MInOut_BH>> getByOrderIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInOut_BH::getC_Order_ID,
				MInOut_BH.COLUMNNAME_C_Order_ID, keys);
	}
}
