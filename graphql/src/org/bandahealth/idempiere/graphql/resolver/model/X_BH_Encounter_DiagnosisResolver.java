package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_ConceptDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_EncounterDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Encounter_Diagnosis - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Encounter_DiagnosisResolver extends POResolver<MBHEncounterDiagnosis> implements GraphQLResolver<MBHEncounterDiagnosis> {



	/**
	 * Get Concept.
	 *
	 * @return Concept
	 */
	public CompletableFuture<MBHConcept> BH_Concept(MBHEncounterDiagnosis entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Concept_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHConcept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_ConceptDataLoader.DATALOADER_BH_Concept_BY_ID);
		return dataLoader.load(entity.getBH_Concept_ID());
	}


	/**
	 * Get Encounter.
	 *
	 * @return Encounter
	 */
	public CompletableFuture<MBHEncounter> BH_Encounter(MBHEncounterDiagnosis entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Encounter_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHEncounter> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_EncounterDataLoader.DATALOADER_BH_Encounter_BY_ID);
		return dataLoader.load(entity.getBH_Encounter_ID());
	}

}
