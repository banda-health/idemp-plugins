package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHEncounterDiagnosisDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHObservationDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHEncounterResolver extends X_BH_EncounterResolver {
	public CompletableFuture<List<MBHObservation>> BH_Observations(MBHEncounter entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHObservation>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHObservationDataLoader.BH_Observation_BY_ENCOUNTER_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Encounter_ID()));
	}

	public CompletableFuture<List<MBHEncounterDiagnosis>> BH_Encounter_DiagnosisList(MBHEncounter entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHEncounterDiagnosis>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHEncounterDiagnosisDataLoader.BH_Encounter_Diagnosis_BY_ENCOUNTER_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Encounter_ID()));
	}
}
