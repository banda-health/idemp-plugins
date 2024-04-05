package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHObservationDataLoader extends X_BH_ObservationDataLoader {
	public static String DATALOADER_BH_Observation_BY_Encounter_ID = "DATALOADER_BH_Observation_BY_Encounter_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Observation_BY_Encounter_ID,
				DataLoader.newMappedDataLoader(getByEncounterIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHObservation>> getByEncounterIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHObservation::getBH_Encounter_ID,
				MBHObservation.COLUMNNAME_BH_Encounter_ID, keys);
	}
}
