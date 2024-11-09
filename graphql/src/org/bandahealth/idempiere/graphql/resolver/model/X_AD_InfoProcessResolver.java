package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoWindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MInfoColumn;
import org.compiere.model.MInfoWindow;
import org.compiere.model.X_AD_InfoProcess;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_InfoProcess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_InfoProcessResolver extends POResolver<X_AD_InfoProcess> implements GraphQLResolver<X_AD_InfoProcess> {



	/**
	 * Get Info Column.
	 *
	 * @return Info Window Column
	 */
	public CompletableFuture<MInfoColumn> AD_InfoColumn(X_AD_InfoProcess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_InfoColumn_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInfoColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_InfoColumnDataLoader.DATALOADER_AD_InfoColumn_BY_ID);
		return dataLoader.load(entity.getAD_InfoColumn_ID());
	}


	/**
	 * Get Info Window.
	 *
	 * @return Info and search/select Window
	 */
	public CompletableFuture<MInfoWindow> AD_InfoWindow(X_AD_InfoProcess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_InfoWindow_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInfoWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_InfoWindowDataLoader.DATALOADER_AD_InfoWindow_BY_ID);
		return dataLoader.load(entity.getAD_InfoWindow_ID());
	}


	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public CompletableFuture<MProcess_BH> AD_Process(X_AD_InfoProcess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_ID);
		return dataLoader.load(entity.getAD_Process_ID());
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
	public CompletableFuture<MEntityType> AD_EntityType(X_AD_InfoProcess entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	public static Map<String, String> LAYOUTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "6884dcd1-bc9a-4d16-9b2c-fe40968747f8"); // Button
			put("M", "7b539591-296a-43ee-916c-c87c35acc84d"); // Menu
			put("L", "ff0cba3e-e82c-4aa8-9f9b-bedf681b822d"); // List
		}
	};
	public CompletableFuture<MRefList_BH> LayoutType(X_AD_InfoProcess entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getLayoutType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(LAYOUTTYPE_UUIDS_BY_VALUE.get(entity.getLayoutType()));
	}

}
