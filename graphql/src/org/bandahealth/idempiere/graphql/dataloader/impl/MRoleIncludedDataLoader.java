package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MRoleIncluded;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MRoleIncludedDataLoader extends X_AD_Role_IncludedDataLoader {
	public static String DATALOADER_AD_Role_Included_BY_AD_Role_ID = "AD_Role_IncludedByRoleIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_Role_Included_BY_AD_Role_ID,
				DataLoader.newMappedDataLoader(getByRoleIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MRoleIncluded>> getByRoleIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MRoleIncluded::getAD_Role_ID,
				MRoleIncluded.COLUMNNAME_AD_Role_ID, keys);
	}
}
