package org.bandahealth.idempiere.graphql.dataloader.impl;

import java.util.List;
import java.util.Properties;

import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;
import org.bandahealth.idempiere.base.model.MBHBPartnerTags;
import org.bandahealth.idempiere.graphql.repository.Repository;

public class MBHBPartnerTagsDataLoader extends X_BH_BPartner_TagsDataLoader{
	
	public static String DATALOADER_BH_BPartner_Tags_BY_ID = "BH_BPartner_TagsByIdDataLoader";
	
	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_BPartner_Tags_BY_ID,
				DataLoader.newMappedDataLoader(getByBusinessPartnerIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHBPartnerTags>> getByBusinessPartnerIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHBPartnerTags::getC_BPartner_ID,
				MBHBPartnerTags.COLUMNNAME_C_BPartner_ID, keys);
	}


}
