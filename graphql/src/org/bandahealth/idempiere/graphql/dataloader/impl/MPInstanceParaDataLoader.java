package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MPInstancePara;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MPInstanceParaDataLoader extends X_AD_PInstance_ParaDataLoader {
	public static String DATALOADER_AD_PInstance_Para_BY_AD_PInstance_ID =
			"DATALOADER_AD_PInstance_Para_BY_AD_PInstance_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_PInstance_Para_BY_AD_PInstance_ID,
				DataLoader.newMappedDataLoader(getByPInstanceIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MPInstancePara>> getByPInstanceIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MPInstancePara::getAD_PInstance_ID,
				MPInstancePara.COLUMNNAME_AD_PInstance_ID, keys);
	}
}
