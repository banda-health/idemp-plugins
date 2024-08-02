package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;
import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHEncounterDiagnosisDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHEncounterDiagnosticDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHEncounterTypeWindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHObservationDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHEncounterResolver extends X_BH_EncounterResolver {
	public CompletableFuture<List<MBHObservation>> BH_Observations(MBHEncounter entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHObservation>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHObservationDataLoader.DATALOADER_BH_Observation_BY_Encounter_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Encounter_ID()));
	}

	public CompletableFuture<List<MBHEncounterDiagnosis>> BH_Encounter_DiagnosisList(MBHEncounter entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHEncounterDiagnosis>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHEncounterDiagnosisDataLoader.DATALOADER_BH_Encounter_Diagnosis_BY_Encounter_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Encounter_ID()));
	}

	public CompletableFuture<List<MBHEncounterDiagnostic>> BH_Encounter_DiagnosticList(MBHEncounter entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHEncounterDiagnostic>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHEncounterDiagnosticDataLoader.DATALOADER_BH_Encounter_Diagnostic_BY_Encounter_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Encounter_ID()));
	}

	public CompletableFuture<List<MBHEncounterTypeWindow>> BH_Encounter_Type_Windows(MBHEncounter entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHEncounterTypeWindow>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHEncounterTypeWindowDataLoader.DATALOADER_BH_Encounter_Type_Window_BY_BH_Encounter_Type);
		return dataLoader.load(entity.getBH_Encounter_Type());
	}
}
