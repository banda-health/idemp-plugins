package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MBHConceptMappingDataLoader extends X_BH_Concept_MappingDataLoader {
	public static String DATALOADER_BH_Concept_Mapping_BY_Concept_ID = "DATALOADER_BH_Concept_Mapping_BY_Concept_ID";
	public static String DATALOADER_BH_Concept_Mapping_BY_BH_From_Concept_Code = "DATALOADER_BH_Concept_Mapping_BY_BH_From_Concept_Code";
	public static String DATALOADER_BH_Concept_Mapping_BY_BH_To_Concept_Code = "DATALOADER_BH_Concept_Mapping_BY_BH_To_Concept_Code";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Concept_Mapping_BY_Concept_ID,
				DataLoader.newMappedDataLoader(getByConceptIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_BH_Concept_Mapping_BY_BH_From_Concept_Code,
				DataLoader.newMappedDataLoader(getByFromConceptCodeBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_BH_Concept_Mapping_BY_BH_To_Concept_Code,
				DataLoader.newMappedDataLoader(getByToConceptCodeBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHConceptMapping>> getByConceptIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHConceptMapping::getBH_Concept_ID,
				MBHConceptMapping.COLUMNNAME_BH_Concept_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MBHConceptMapping>> getByFromConceptCodeBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			List<Object> parameters = new ArrayList<>();
			String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);
			Repository.setCopyOfPropertiesForNestedThreadUsage(batchLoaderEnvironment.getContext());
			List<MBHConceptMapping> models =
					Repository.getQuery(batchLoaderEnvironment.getContext(), getTableName(), null, true, false,
							getTableName() + "." + MBHConceptMapping.COLUMNNAME_BH_From_Concept_Code + " IN (" + whereCondition +
									")", parameters).list();
			return models.stream().collect(Collectors.groupingBy(MBHConceptMapping::getBH_From_Concept_Code));	
		});
	}
	
	private MappedBatchLoaderWithContext<String, List<MBHConceptMapping>> getByToConceptCodeBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			List<Object> parameters = new ArrayList<>();
			String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);
			Repository.setCopyOfPropertiesForNestedThreadUsage(batchLoaderEnvironment.getContext());
			List<MBHConceptMapping> models =
					Repository.getQuery(batchLoaderEnvironment.getContext(), getTableName(), null, true, false,
							getTableName() + "." + MBHConceptMapping.COLUMNNAME_BH_To_Concept_Code + " IN (" + whereCondition +
									")", parameters).list();
			return models.stream().collect(Collectors.groupingBy(MBHConceptMapping::getBH_To_Concept_Code));	
		});
	}
}
