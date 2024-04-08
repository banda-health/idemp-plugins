package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MInOutLineMA;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MInOutLineMADataLoader extends X_M_InOutLineMADataLoader {
	public static String DATALOADER_M_InOutLineMA_BY_M_InOutLine_ID = "DATALOADER_M_InOutLineMA_BY_M_InOutLine_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_InOutLineMA_BY_M_InOutLine_ID,
				DataLoader.newMappedDataLoader(getByInOutLineIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MInOutLineMA>> getByInOutLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInOutLineMA::getM_InOutLine_ID,
				MInOutLineMA.COLUMNNAME_M_InOutLine_ID, keys);
	}
}
