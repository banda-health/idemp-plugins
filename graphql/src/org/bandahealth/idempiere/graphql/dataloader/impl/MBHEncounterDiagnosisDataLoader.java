package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHEncounterDiagnosisDataLoader extends X_BH_Encounter_DiagnosisDataLoader {
	public static String DATALOADER_BH_Encounter_Diagnosis_BY_Encounter_ID =
			"DATALOADER_BH_Encounter_Diagnosis_BY_Encounter_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Encounter_Diagnosis_BY_Encounter_ID,
				DataLoader.newMappedDataLoader(getByEncounterIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHEncounterDiagnosis>> getByEncounterIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHEncounterDiagnosis::getBH_Encounter_ID,
				MBHEncounterDiagnosis.COLUMNNAME_BH_Encounter_ID, keys);
	}
}
