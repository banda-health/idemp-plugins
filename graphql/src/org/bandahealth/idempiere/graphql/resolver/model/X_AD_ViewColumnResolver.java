package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ViewComponentDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MViewColumn;
import org.compiere.model.MViewComponent;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_ViewColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ViewColumnResolver extends POResolver<MViewColumn> implements GraphQLResolver<MViewColumn> {



	/**
	 * Get Database View Component.
	 *
	 * @return Database View Component
	 */
	public CompletableFuture<MViewComponent> AD_ViewComponent(MViewColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ViewComponent_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MViewComponent> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ViewComponentDataLoader.DATALOADER_AD_ViewComponent_BY_ID);
		return dataLoader.load(entity.getAD_ViewComponent_ID());
	}

	static Map<String, String> DBDATATYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "da6b3cf4-f719-418f-b395-bbf193b703fa");
			put("C", "7db6163c-92ac-4f63-b81f-63277341e5ff");
			put("D", "7ffa55a1-6089-45c9-9fbd-9132c134bd18");
			put("I", "1eb7b0f8-23f3-4622-a890-a93410bd0d80");
			put("L", "3c799a29-5017-4fc2-9402-0fbf55b198cd");
			put("N", "7bd0bc54-a940-4afd-98ab-a3011ace6b3f");
			put("T", "363a5407-0f48-443b-8b78-626ac45b6590");
			put("V", "ab034a7b-aeba-4bd9-b621-620d67dca79e");
		}
	};
	public CompletableFuture<MRefList_BH> DBDataType(MViewColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDBDataType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DBDATATYPE_UUIDS_BY_VALUE.get(entity.getDBDataType()));
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
	public CompletableFuture<MEntityType> AD_EntityType(MViewColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

}
