package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
//import org.bandahealth.idempiere.base.model.MBHConceptMapping;
//import org.bandahealth.idempiere.base.model.MBHConceptName;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHConceptExtraDataLoader;
//import org.bandahealth.idempiere.graphql.dataloader.impl.MBHConceptMappingDataLoader;
//import org.bandahealth.idempiere.graphql.dataloader.impl.MBHConceptNameDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHConceptResolver extends X_BH_ConceptResolver {
	public CompletableFuture<List<MBHConceptExtra>> BH_Concept_Extras(MBHConcept entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHConceptExtra>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHConceptExtraDataLoader.DATALOADER_BH_Concept_Extra_BY_Concept_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Concept_ID()));
	}
}
