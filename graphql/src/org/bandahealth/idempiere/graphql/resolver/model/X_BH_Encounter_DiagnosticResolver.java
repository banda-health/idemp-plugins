package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_ConceptDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_EncounterDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Encounter_Diagnostic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Encounter_DiagnosticResolver extends POResolver<MBHEncounterDiagnostic> implements GraphQLResolver<MBHEncounterDiagnostic> {



	/**
	 * Get Concept.
	 *
	 * @return Concept
	 */
	public CompletableFuture<MBHConcept> BH_Concept(MBHEncounterDiagnostic entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Concept_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHConcept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_ConceptDataLoader.DATALOADER_BH_Concept_BY_ID);
		return dataLoader.load(entity.getBH_Concept_ID());
	}

	public static Map<String, String> BH_DIAGNOSTIC_STATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("P", "5d4d92c0-64a0-4552-aec7-0b73f3f4c189"); // Pending
			put("C", "6c5382b6-6f12-4115-bcea-68a573400296"); // Complete
		}
	};
	public CompletableFuture<MRefList_BH> BH_Diagnostic_Status(MBHEncounterDiagnostic entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Diagnostic_Status())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_DIAGNOSTIC_STATUS_UUIDS_BY_VALUE.get(entity.getBH_Diagnostic_Status()));
	}


	/**
	 * Get Encounter.
	 *
	 * @return Encounter
	 */
	public CompletableFuture<MBHEncounter> BH_Encounter(MBHEncounterDiagnostic entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Encounter_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHEncounter> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_EncounterDataLoader.DATALOADER_BH_Encounter_BY_ID);
		return dataLoader.load(entity.getBH_Encounter_ID());
	}


	/**
	 * Get Selected Panel.
	 *
	 * @return Selected Panel
	 */
	public CompletableFuture<MBHConcept> Selected_Panel(MBHEncounterDiagnostic entity, DataFetchingEnvironment environment) {
		if (entity.getSelected_Panel_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHConcept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_ConceptDataLoader.DATALOADER_BH_Concept_BY_ID);
		return dataLoader.load(entity.getSelected_Panel_ID());
	}

}
