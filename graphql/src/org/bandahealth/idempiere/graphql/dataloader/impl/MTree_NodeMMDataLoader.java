package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MTree_NodeMM;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MTree_NodeMMDataLoader extends X_AD_TreeNodeMMDataLoader {
	public static String DATALOADER_AD_TreeNodeMM_BY_Parent_ID = "AD_TreeNodeMMByParentIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_TreeNodeMM_BY_Parent_ID,
				DataLoader.newMappedDataLoader(getByParentIdBatchLoader(), getOptionsWithCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MTree_NodeMM>> getByParentIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MTree_NodeMM::getParent_ID,
				MTree_NodeMM.COLUMNNAME_Parent_ID, keys);
	}
}
