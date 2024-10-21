package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHConceptMappingDataLoader extends X_BH_Concept_MappingDataLoader {
	public static String DATALOADER_BH_Concept_Mapping_BY_From_BH_Concept_ID =
			"DATALOADER_BH_Concept_Mapping_BY_From_BH_Concept_ID";
	public static String DATALOADER_BH_Concept_Mapping_BY_To_BH_Concept_ID =
			"DATALOADER_BH_Concept_Mapping_BY_To_BH_Concept_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Concept_Mapping_BY_From_BH_Concept_ID,
				DataLoader.newMappedDataLoader(getByConceptIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_BH_Concept_Mapping_BY_To_BH_Concept_ID,
				DataLoader.newMappedDataLoader(getByToConceptIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHConceptMapping>> getByConceptIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHConceptMapping::getBH_Concept_ID,
				MBHConceptMapping.COLUMNNAME_BH_Concept_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MBHConceptMapping>> getByToConceptIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHConceptMapping::getTo_BH_Concept_ID,
				MBHConceptMapping.COLUMNNAME_To_BH_Concept_ID, keys);
	}
}
