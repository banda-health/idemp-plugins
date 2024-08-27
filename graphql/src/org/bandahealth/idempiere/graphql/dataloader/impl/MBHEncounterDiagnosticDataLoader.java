package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHEncounterDiagnosticDataLoader extends X_BH_Encounter_DiagnosticDataLoader {
	public static String DATALOADER_BH_Encounter_Diagnostic_BY_Encounter_ID =
			"DATALOADER_BH_Encounter_Diagnostic_BY_Encounter_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Encounter_Diagnostic_BY_Encounter_ID,
				DataLoader.newMappedDataLoader(getByEncounterIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHEncounterDiagnostic>> getByEncounterIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHEncounterDiagnostic::getBH_Encounter_ID,
				MBHEncounterDiagnostic.COLUMNNAME_BH_Encounter_ID, keys);
	}
}
