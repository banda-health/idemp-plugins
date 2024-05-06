package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MMatchInv;
import org.compiere.model.MMatchPO;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MMatchPODataLoader extends X_M_MatchPODataLoader {
	public static String DATALOADER_M_MatchPO_BY_C_OrderLine_ID = "DATALOADER_M_MatchPO_BY_C_OrderLine_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_MatchPO_BY_C_OrderLine_ID,
				DataLoader.newMappedDataLoader(getByOrderLineIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MMatchPO>> getByOrderLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MMatchPO::getC_OrderLine_ID,
				MMatchPO.COLUMNNAME_C_OrderLine_ID, keys);
	}
}
