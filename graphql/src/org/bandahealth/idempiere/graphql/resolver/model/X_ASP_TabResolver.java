package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TabDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_ASP_WindowDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MTab;
import org.compiere.model.X_ASP_Tab;
import org.compiere.model.X_ASP_Window;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for ASP_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_TabResolver extends POResolver<X_ASP_Tab> implements GraphQLResolver<X_ASP_Tab> {



	/**
	 * Get Tab.
	 *
	 * @return Tab within a Window
	 */
	public CompletableFuture<MTab> AD_Tab(X_ASP_Tab entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tab_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTab> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TabDataLoader.DATALOADER_AD_Tab_BY_ID);
		return dataLoader.load(entity.getAD_Tab_ID());
	}

	public Boolean AllFields(X_ASP_Tab entity, DataFetchingEnvironment environment) {
		return entity.isAllFields();
	}

	public static Map<String, String> ASP_STATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("H", "864906b8-9311-4af2-9464-434e25fa6f72"); // Hide
			put("S", "e06c95b8-62c4-4d5d-b9fc-e23c5049489e"); // Show
			put("U", "e718a86a-8c1d-490d-9d3f-f1a2dfe6af69"); // Undefined
		}
	};
	public CompletableFuture<MRefList_BH> ASP_Status(X_ASP_Tab entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getASP_Status())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ASP_STATUS_UUIDS_BY_VALUE.get(entity.getASP_Status()));
	}


	/**
	 * Get ASP Window.
	 *
	 * @return ASP Window
	 */
	public CompletableFuture<X_ASP_Window> ASP_Window(X_ASP_Tab entity, DataFetchingEnvironment environment) {
		if (entity.getASP_Window_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_ASP_Window> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_ASP_WindowDataLoader.DATALOADER_ASP_Window_BY_ID);
		return dataLoader.load(entity.getASP_Window_ID());
	}

	public Boolean Processing(X_ASP_Tab entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
