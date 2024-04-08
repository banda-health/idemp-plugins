package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MPOSKey;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MPOSKeyDataLoader extends X_C_POSKeyDataLoader {
	public static String DATALOADER_C_POSKey_BY_C_POSKeyLayout_ID = "DATALOADER_C_POSKey_BY_C_POSKeyLayout_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_POSKey_BY_C_POSKeyLayout_ID,
				DataLoader.newMappedDataLoader(getByPosKeyLayoutIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MPOSKey>> getByPosKeyLayoutIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MPOSKey::getC_POSKeyLayout_ID,
				MPOSKey.COLUMNNAME_C_POSKeyLayout_ID, keys);
	}
}
