package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MAttributeUse;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MAttributeUseDataLoader extends X_M_AttributeUseDataLoader {
	public static String DATALOADER_M_AttributeUse_BY_M_AttributeSet_ID =
			"DATALOADER_M_AttributeUse_BY_M_AttributeSet_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_AttributeUse_BY_M_AttributeSet_ID,
				DataLoader.newMappedDataLoader(getByAttributeSetIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MAttributeUse>> getByAttributeSetIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MAttributeUse::getM_AttributeSet_ID,
				MAttributeUse.COLUMNNAME_M_AttributeSet_ID, keys);
	}
}
