package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptName;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_ConceptDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Concept_Name - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Concept_NameResolver extends POResolver<MBHConceptName> implements GraphQLResolver<MBHConceptName> {



	/**
	 * Get Concept.
	 *
	 * @return Concept
	 */
	public CompletableFuture<MBHConcept> BH_Concept(MBHConceptName entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Concept_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBHConcept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_ConceptDataLoader.DATALOADER_BH_Concept_BY_ID);
		return dataLoader.load(entity.getBH_Concept_ID());
	}

	public Boolean BH_Concept_Locale_Preferred(MBHConceptName entity, DataFetchingEnvironment environment) {
		return entity.isBH_Concept_Locale_Preferred();
	}

}
