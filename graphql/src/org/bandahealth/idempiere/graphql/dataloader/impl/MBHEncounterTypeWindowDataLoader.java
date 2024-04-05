package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MBHEncounterTypeWindowDataLoader extends X_BH_Encounter_Type_WindowDataLoader {
	public static String DATALOADER_BH_Encounter_Type_Window_BY_BH_Encounter_Type =
			"DATALOADER_BH_Encounter_Type_Window_BY_BH_Encounter_Type";
	public static String DATALOADER_BH_Encounter_Type_Window_BY_Window_ID =
			"DATALOADER_BH_Encounter_Type_Window_BY_Window_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Encounter_Type_Window_BY_BH_Encounter_Type,
				DataLoader.newMappedDataLoader(getByEncounterTypeBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_BH_Encounter_Type_Window_BY_Window_ID,
				DataLoader.newMappedDataLoader(getByWindowIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHEncounterTypeWindow>> getByEncounterTypeBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			List<Object> parameters = new ArrayList<>();
			String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);
			Repository.setCopyOfPropertiesForNestedThreadUsage(batchLoaderEnvironment.getContext());
			List<MBHEncounterTypeWindow> models =
					Repository.getQuery(batchLoaderEnvironment.getContext(), getTableName(), null, true, false,
							getTableName() + "." + MBHEncounterTypeWindow.COLUMNNAME_BH_Encounter_Type + " IN (" + whereCondition +
									")", parameters).list();
			return models.stream().collect(Collectors.groupingBy(MBHEncounterTypeWindow::getBH_Encounter_Type));
		});
	}

	private MappedBatchLoaderWithContext<String, List<MBHEncounterTypeWindow>> getByWindowIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHEncounterTypeWindow::getAD_Window_ID,
				MBHEncounterTypeWindow.COLUMNNAME_AD_Window_ID, keys);
	}
}
