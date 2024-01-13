package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MFieldDataLoader extends X_AD_FieldDataLoader {
	public static String DATALOADER_AD_Field_BY_AD_Tab_ID = "AD_FieldByTabIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_Field_BY_AD_Tab_ID,
				DataLoader.newMappedDataLoader(getByTabIdBatchLoader(), getOptionsWithCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MField_BH>> getByTabIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MField_BH::getAD_Tab_ID,
				MField_BH.COLUMNNAME_AD_Field_ID, keys);
	}
}
