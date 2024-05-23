package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.X_AD_RelationType;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_RelationType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_RelationTypeResolver extends POResolver<X_AD_RelationType> implements GraphQLResolver<X_AD_RelationType> {



	/**
	 * Get Source Reference.
	 *
	 * @return Source Reference
	 */
	public CompletableFuture<MReference_BH> AD_Reference_Source(X_AD_RelationType entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_Source_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_Source_ID());
	}


	/**
	 * Get Target Reference.
	 *
	 * @return Target Reference
	 */
	public CompletableFuture<MReference_BH> AD_Reference_Target(X_AD_RelationType entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_Target_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_Target_ID());
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
	public CompletableFuture<MEntityType> AD_EntityType(X_AD_RelationType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	public Boolean IsDirected(X_AD_RelationType entity, DataFetchingEnvironment environment) {
		return entity.isDirected();
	}

	static Map<String, String> ROLE_SOURCE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Order", "a7720fdf-927d-4f4e-9408-ee7b87f2a569");
			put("Invoice", "30d0392a-5c63-4be9-a4fe-1707b285cba2");
		}
	};
	public CompletableFuture<MRefList_BH> Role_Source(X_AD_RelationType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getRole_Source())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ROLE_SOURCE_UUIDS_BY_VALUE.get(entity.getRole_Source()));
	}

	static Map<String, String> ROLE_TARGET_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Order", "a7720fdf-927d-4f4e-9408-ee7b87f2a569");
			put("Invoice", "30d0392a-5c63-4be9-a4fe-1707b285cba2");
		}
	};
	public CompletableFuture<MRefList_BH> Role_Target(X_AD_RelationType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getRole_Target())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ROLE_TARGET_UUIDS_BY_VALUE.get(entity.getRole_Target()));
	}

	static Map<String, String> TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("I", "2e12a173-2159-4d97-aa2f-8f958a5f0ece");
			put("E", "9cc497b9-98ee-41a2-b593-2efecab345ba");
		}
	};
	public CompletableFuture<MRefList_BH> Type(X_AD_RelationType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TYPE_UUIDS_BY_VALUE.get(entity.getType()));
	}

}
