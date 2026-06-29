package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHClientConcept;
import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptDescription;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptName;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHClientConceptDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHClientConceptExtraDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHConceptDescriptionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHConceptExtraDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHConceptNameDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHConceptMappingDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHConceptResolver extends X_BH_ConceptResolver {
	public CompletableFuture<List<MBHClientConcept>> BH_Client_Concepts(MBHConcept entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHClientConcept>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHClientConceptDataLoader.DATALOADER_BH_Client_Concept_BY_Concept_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Concept_ID()));
	}

	public CompletableFuture<List<MBHConceptDescription>> BH_Concept_Descriptions(MBHConcept entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHConceptDescription>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHConceptDescriptionDataLoader.DATALOADER_BH_Concept_Description_BY_Concept_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Concept_ID()));
	}

	public CompletableFuture<List<MBHConceptExtra>> BH_Concept_Extras(MBHConcept entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHConceptExtra>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHConceptExtraDataLoader.DATALOADER_BH_Concept_Extra_BY_Concept_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Concept_ID()));
	}

	public CompletableFuture<List<MBHClientConceptExtra>> BH_Client_Concept_Extras(MBHConcept entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHClientConceptExtra>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHClientConceptExtraDataLoader.DATALOADER_BH_Client_Concept_Extra_BY_Concept_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Concept_ID()));
	}

	public CompletableFuture<List<MBHConceptName>> BH_Concept_Names(MBHConcept entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHConceptName>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHConceptNameDataLoader.DATALOADER_BH_Concept_Name_BY_Concept_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Concept_ID()));
	}

	/* FromBH_Concept_Mappings provides the parent mappings, linked by to_bh_concept_id
	 * to this concept's Id */
	public CompletableFuture<List<MBHConceptMapping>> FromBH_Concept_Mappings(MBHConcept entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHConceptMapping>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHConceptMappingDataLoader.DATALOADER_BH_Concept_Mapping_BY_To_BH_Concept_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Concept_ID()));
	}

	/* ToBH_Concept_Mappings provides the child mappings. They are linked by the from_bh_concept_id
	 * on the mapping
	 */
	public CompletableFuture<List<MBHConceptMapping>> ToBH_Concept_Mappings(MBHConcept entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHConceptMapping>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHConceptMappingDataLoader.DATALOADER_BH_Concept_Mapping_BY_From_BH_Concept_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Concept_ID()));
	}
}
