package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_ConceptDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Concept_Mapping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Concept_MappingResolver extends POResolver<MBHConceptMapping> implements GraphQLResolver<MBHConceptMapping> {



	/**
	 * Get From Concept.
	 *
	 * @return From Concept
	 */
	public CompletableFuture<MBHConcept> From_BH_Concept(MBHConceptMapping entity, DataFetchingEnvironment environment) {
		if (entity.getFrom_BH_Concept_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHConcept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_ConceptDataLoader.DATALOADER_BH_Concept_BY_ID);
		return dataLoader.load(entity.getFrom_BH_Concept_ID());
	}


	/**
	 * Get To Concept.
	 *
	 * @return To Concept
	 */
	public CompletableFuture<MBHConcept> To_BH_Concept(MBHConceptMapping entity, DataFetchingEnvironment environment) {
		if (entity.getTo_BH_Concept_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHConcept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_ConceptDataLoader.DATALOADER_BH_Concept_BY_ID);
		return dataLoader.load(entity.getTo_BH_Concept_ID());
	}

}
