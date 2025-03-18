package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHAllergy;
import org.bandahealth.idempiere.base.model.MBHAllergyReaction;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_AllergyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_ConceptDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Allergy_Reaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Allergy_ReactionResolver extends POResolver<MBHAllergyReaction> implements GraphQLResolver<MBHAllergyReaction> {



	/**
	 * Get Allergy.
	 *
	 * @return Allergy
	 */
	public CompletableFuture<MBHAllergy> BH_Allergy(MBHAllergyReaction entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Allergy_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHAllergy> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_AllergyDataLoader.DATALOADER_BH_Allergy_BY_ID);
		return dataLoader.load(entity.getBH_Allergy_ID());
	}


	/**
	 * Get Concept.
	 *
	 * @return Concept
	 */
	public CompletableFuture<MBHConcept> BH_Concept(MBHAllergyReaction entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Concept_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHConcept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_ConceptDataLoader.DATALOADER_BH_Concept_BY_ID);
		return dataLoader.load(entity.getBH_Concept_ID());
	}

}
