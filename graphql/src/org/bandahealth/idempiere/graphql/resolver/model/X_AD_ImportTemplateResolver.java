package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TabDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MImportTemplate;
import org.compiere.model.MTab;
import org.compiere.model.MWindow;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_ImportTemplate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ImportTemplateResolver extends POResolver<MImportTemplate> implements GraphQLResolver<MImportTemplate> {



	/**
	 * Get Tab.
	 *
	 * @return Tab within a Window
	 */
	public CompletableFuture<MTab> AD_Tab(MImportTemplate entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tab_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTab> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TabDataLoader.DATALOADER_AD_Tab_BY_ID);
		return dataLoader.load(entity.getAD_Tab_ID());
	}


	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public CompletableFuture<MWindow> AD_Window(MImportTemplate entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.DATALOADER_AD_Window_BY_ID);
		return dataLoader.load(entity.getAD_Window_ID());
	}

	public static Map<String, String> IMPORTTEMPLATETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("CSV", "7259e211-5477-4f1b-b2a3-1ce67f919749"); // Comma-separated values (CSV)
			put("XLS", "4c979a06-6550-4763-9cd2-066c0d897b9c"); // XLS
			put("XLSX", "0f46a993-00ac-4572-935c-0590629d092b"); // Excel (XLS/XLSX)
		}
	};
	public CompletableFuture<MRefList_BH> ImportTemplateType(MImportTemplate entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getImportTemplateType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(IMPORTTEMPLATETYPE_UUIDS_BY_VALUE.get(entity.getImportTemplateType()));
	}

}
