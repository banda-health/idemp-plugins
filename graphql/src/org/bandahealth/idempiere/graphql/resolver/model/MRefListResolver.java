package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHEncounterTypeWindowDataLoader;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MRefListResolver extends X_AD_Ref_ListResolver {
	public CompletableFuture<List<MBHEncounterTypeWindow>> BH_Encounter_Type_WindowList(MRefList_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHEncounterTypeWindow>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHEncounterTypeWindowDataLoader.DATALOADER_BH_Encounter_Type_Window_BY_BH_Encounter_Type);
		return dataLoader.load(entity.getValue());
	}
}
