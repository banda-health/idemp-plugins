package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MProcessPara;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MProcessParaDataLoader extends X_AD_Process_ParaDataLoader {
	public static String DATALOADER_AD_Process_Para_BY_AD_Process_ID = "AD_Process_ParaByProcessIDDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_Process_Para_BY_AD_Process_ID,
				DataLoader.newMappedDataLoader(getByProcessIdBatchLoader(), getOptionsWithCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MProcessPara>> getByProcessIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MProcessPara::getAD_Process_ID,
				MProcessPara.COLUMNNAME_AD_Process_ID, keys);
	}
}
