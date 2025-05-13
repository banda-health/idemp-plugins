package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_ConceptDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Concept_MappingDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Concept_Extra - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Concept_ExtraResolver extends POResolver<MBHConceptExtra> implements GraphQLResolver<MBHConceptExtra> {



	/**
	 * Get Concept.
	 *
	 * @return Concept
	 */
	public CompletableFuture<MBHConcept> BH_Concept(MBHConceptExtra entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Concept_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHConcept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_ConceptDataLoader.DATALOADER_BH_Concept_BY_ID);
		return dataLoader.load(entity.getBH_Concept_ID());
	}


	/**
	 * Get Concept Mapping.
	 *
	 * @return Concept Mapping
	 */
	public CompletableFuture<MBHConceptMapping> BH_Concept_Mapping(MBHConceptExtra entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Concept_Mapping_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHConceptMapping> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Concept_MappingDataLoader.DATALOADER_BH_Concept_Mapping_BY_ID);
		return dataLoader.load(entity.getBH_Concept_Mapping_ID());
	}

}
