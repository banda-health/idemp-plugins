package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHConceptDescription;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHConceptDescriptionDataLoader extends X_BH_Concept_DescriptionDataLoader {
	public static String DATALOADER_BH_Concept_Description_BY_Concept_ID = "DATALOADER_BH_Concept_Description_BY_Concept_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Concept_Description_BY_Concept_ID,
				DataLoader.newMappedDataLoader(getByConceptIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHConceptDescription>> getByConceptIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHConceptDescription::getBH_Concept_ID,
				MBHConceptExtra.COLUMNNAME_BH_Concept_ID, keys);
	}
}
