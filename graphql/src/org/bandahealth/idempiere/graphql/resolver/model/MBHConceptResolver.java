package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptName;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHClientConceptExtraDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHConceptNameDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHConceptMappingDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHConceptResolver extends X_BH_ConceptResolver {
	public CompletableFuture<List<MBHClientConceptExtra>> BH_Client_Concept_Extras(MBHConcept entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHClientConceptExtra>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHClientConceptExtraDataLoader.DATALOADER_BH_Client_Concept_Extra_By_Concept_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Concept_ID()));
	}

	public CompletableFuture<List<MBHConceptName>> BH_Concept_Names(MBHConcept entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHConceptName>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHConceptNameDataLoader.DATALOADER_BH_Concept_Name_BY_Concept_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Concept_ID()));
	}

	/* FromBH_Concept_Mappings provides the parent mappings, linked by bh_to_concept_code
	 * to this concept's bh_oclid */
	public CompletableFuture<List<MBHConceptMapping>> FromBH_Concept_Mappings(MBHConcept entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHConceptMapping>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHConceptMappingDataLoader.DATALOADER_BH_Concept_Mapping_BY_BH_To_Concept_Code);
		return dataLoader.load(entity.getBH_OclID());
	}

	/* ToBH_Concept_Mappings provides the child mappings. They are linked by the bh_concept_id
	 * on the mapping, but could also be linked by checking for mappings where the bh_from_concept_code
	 * matches this concept's bh_oclid
	 */
	public CompletableFuture<List<MBHConceptMapping>> ToBH_Concept_Mappings(MBHConcept entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHConceptMapping>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHConceptMappingDataLoader.DATALOADER_BH_Concept_Mapping_BY_Concept_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Concept_ID()));
	}
}
