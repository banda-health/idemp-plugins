package org.bandahealth.idempiere.graphql.resolver.model;

import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHConceptDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHConceptMappingDataLoader;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import graphql.schema.DataFetchingEnvironment;

public class MBHConceptMappingResolver extends X_BH_Concept_MappingResolver {
	public CompletableFuture<MBHConcept> FromBH_Concept(MBHConceptMapping entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, MBHConcept> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHConceptDataLoader.DATALOADER_BH_Concept_BY_BH_OclID);
		return dataLoader.load(entity.getBH_From_Concept_Code());
	}

	public CompletableFuture<MBHConcept> ToBH_Concept(MBHConceptMapping entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, MBHConcept> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHConceptDataLoader.DATALOADER_BH_Concept_BY_BH_OclID);
		return dataLoader.load(entity.getBH_To_Concept_Code());
	}
	
	public CompletableFuture<List<MBHConceptMapping>> FromBH_Concept_Mappings(MBHConceptMapping entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHConceptMapping>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHConceptMappingDataLoader.DATALOADER_BH_Concept_Mapping_BY_BH_To_Concept_Code);
		return dataLoader.load(entity.getBH_From_Concept_Code());
	}

	public CompletableFuture<List<MBHConceptMapping>> ToBH_Concept_Mappings(MBHConceptMapping entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHConceptMapping>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHConceptMappingDataLoader.DATALOADER_BH_Concept_Mapping_BY_BH_From_Concept_Code);
		return dataLoader.load(entity.getBH_To_Concept_Code());
	}
}
