package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MRefListDataLoader extends X_AD_Ref_ListDataLoader {
	public static String DATALOADER_AD_Ref_List_BY_AD_Reference_ID = "AD_Ref_ListByReferenceIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_Ref_List_BY_AD_Reference_ID,
				DataLoader.newMappedDataLoader(getByReferenceIdBatchLoader(), getOptionsWithCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MRefList_BH>> getByReferenceIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MRefList_BH::getAD_Reference_ID,
				MRefList_BH.COLUMNNAME_AD_Reference_ID, keys);
	}
}
