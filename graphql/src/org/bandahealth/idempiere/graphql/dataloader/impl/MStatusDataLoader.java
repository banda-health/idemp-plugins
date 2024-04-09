package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MStatusCategory;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MStatusDataLoader extends X_R_StatusDataLoader {
	public static String DATALOADER_R_Status_BY_R_StatusCategory_ID = "DATALOADER_R_Status_BY_R_StatusCategory_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_R_Status_BY_R_StatusCategory_ID,
				DataLoader.newMappedDataLoader(getByStatusCategoryIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MStatusCategory>> getByStatusCategoryIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MStatusCategory::getR_StatusCategory_ID,
				MStatusCategory.COLUMNNAME_R_StatusCategory_ID, keys);
	}
}
