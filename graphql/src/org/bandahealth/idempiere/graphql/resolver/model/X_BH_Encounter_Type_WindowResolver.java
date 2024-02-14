package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MWindow;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Encounter_Type_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Encounter_Type_WindowResolver extends POResolver<MBHEncounterTypeWindow> implements GraphQLResolver<MBHEncounterTypeWindow> {



	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public CompletableFuture<MWindow> AD_Window(MBHEncounterTypeWindow entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.DATALOADER_AD_Window_BY_ID);
		return dataLoader.load(entity.getAD_Window_ID());
	}

	static Map<String, String> BH_ENCOUNTER_TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("I", "c03f4d1d-fcec-4f91-a673-0ab1c3327578");
			put("V", "6b25aa54-bbae-4432-a4e9-7a9a3116fc95");
			put("m", "ba49a71c-938a-4e16-9cd9-e0819e4e9d3b");
			put("D", "9bd78d1a-3ec7-46eb-a7b9-58c183b823ae");
			put("C", "e822496b-fc64-4db9-9b89-39c7ee6e9986");
		}
	};
	public CompletableFuture<MRefList_BH> BH_Encounter_Type(MBHEncounterTypeWindow entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Encounter_Type())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_ENCOUNTER_TYPE_UUIDS_BY_VALUE.get(entity.getBH_Encounter_Type()));
	}

}
