package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TabDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MTab;
import org.compiere.model.MToolBarButton;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_ToolBarButton - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ToolBarButtonResolver extends POResolver<MToolBarButton> implements GraphQLResolver<MToolBarButton> {


	public static Map<String, String> ACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("W", "50032107-b314-40a1-ae3a-809f3e643572"); // Window
			put("T", "df7f040f-75dd-4025-947e-34479cf8811b"); // Task
			put("F", "9a71d7fd-585b-4896-a454-9b823d2ae291"); // WorkFlow
			put("P", "172a85d0-4f69-4486-9f95-bfd30c092519"); // Process
			put("R", "e3f9a66b-72b1-4552-9c6a-ff27de1cb83c"); // Report
			put("X", "96201326-b894-4f80-a572-ccac1d7dd878"); // Form
			put("B", "df913f43-3e3b-45bc-9d03-26e0d506f9f3"); // Workbench
			put("I", "5484a32f-202c-4316-9ae7-c295ed508aee"); // Info
			put("D", "c08370ea-385c-4569-bc28-1b6a869f700a"); // Detail
		}
	};
	public CompletableFuture<MRefList_BH> Action(MToolBarButton entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ACTION_UUIDS_BY_VALUE.get(entity.getAction()));
	}


	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public CompletableFuture<MProcess_BH> AD_Process(MToolBarButton entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_ID);
		return dataLoader.load(entity.getAD_Process_ID());
	}


	/**
	 * Get Tab.
	 *
	 * @return Tab within a Window
	 */
	public CompletableFuture<MTab> AD_Tab(MToolBarButton entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tab_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MTab> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TabDataLoader.DATALOADER_AD_Tab_BY_ID);
		return dataLoader.load(entity.getAD_Tab_ID());
	}

	static Map<String, Integer> ENTITYTYPE_IDS_BY_ENTITY_TYPE = new HashMap<>() {
		{
			put("D", 10);
			put("C", 20);
			put("U", 100);
			put("CUST", 110);
			put("A", 200);
			put("EXT", 210);
			put("XX", 220);
			put("EE01", 50000);
			put("EE04", 50001);
			put("EE05", 50003);
			put("EE02", 50005);
			put("WSTORE", 200015);
		}
	};

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(MToolBarButton entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	public Boolean IsAddSeparator(MToolBarButton entity, DataFetchingEnvironment environment) {
		return entity.isAddSeparator();
	}

	public Boolean IsAdvancedButton(MToolBarButton entity, DataFetchingEnvironment environment) {
		return entity.isAdvancedButton();
	}

	public Boolean IsCustomization(MToolBarButton entity, DataFetchingEnvironment environment) {
		return entity.isCustomization();
	}

	public Boolean IsShowMore(MToolBarButton entity, DataFetchingEnvironment environment) {
		return entity.isShowMore();
	}

}
