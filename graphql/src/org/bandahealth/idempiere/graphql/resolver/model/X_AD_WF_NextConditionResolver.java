package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_NodeNextDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MEntityType;
import org.compiere.model.MRefList;
import org.compiere.model.X_AD_WF_NextCondition;
import org.compiere.model.X_AD_WF_NodeNext;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_WF_NextCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_NextConditionResolver extends POResolver<X_AD_WF_NextCondition> implements GraphQLResolver<X_AD_WF_NextCondition> {



	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(X_AD_WF_NextCondition entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.AD_Column_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Node Transition.
	 *
	 * @return Workflow Node Transition
	 */
	public CompletableFuture<X_AD_WF_NodeNext> AD_WF_NodeNext(X_AD_WF_NextCondition entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_NodeNext_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_NodeNext> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_NodeNextDataLoader.AD_WF_NodeNext_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_WF_NodeNext_ID());
	}

	static Map<String, String> ANDOR_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_AD_WF_NextCondition.ANDOR_And, "2a20f5be-1d08-4be6-9b94-9835ef8800cb");
			put(X_AD_WF_NextCondition.ANDOR_Or, "67af34aa-ef4f-4928-8536-427c8a6551e4");
		}
	};
	public CompletableFuture<MRefList> AndOr_RL(X_AD_WF_NextCondition entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAndOr())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(ANDOR_UUIDS_BY_VALUE.get(entity.getAndOr()));
	}


	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(X_AD_WF_NextCondition entity, DataFetchingEnvironment environment) {
		if (entity.getEntityType() <= 0) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.AD_EntityType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEntityType());
	}

	static Map<String, String> OPERATION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_AD_WF_NextCondition.OPERATION_Eq, "3fefc2d0-9c5a-483c-b34f-00ca51a42bd0");
			put(X_AD_WF_NextCondition.OPERATION_GtEq, "c03b77ec-a80e-4628-812d-8f64a493da07");
			put(X_AD_WF_NextCondition.OPERATION_Gt, "9bb7c5a6-b291-4c2c-9524-fa7e974a1160");
			put(X_AD_WF_NextCondition.OPERATION_Le, "b4ee4ca1-39c6-4703-911b-e107aaca4af6");
			put(X_AD_WF_NextCondition.OPERATION_Like, "c3b65756-69b3-4f47-a1ba-9161a7dcfc73");
			put(X_AD_WF_NextCondition.OPERATION_LeEq, "d68ddcf5-efc3-4208-a583-3b4f40a01bee");
			put(X_AD_WF_NextCondition.OPERATION_X, "990ca97f-1278-4171-aa70-0a16770124b5");
			put(X_AD_WF_NextCondition.OPERATION_Sql, "d07128bf-2e88-42d9-8234-4ee181d35a5b");
			put(X_AD_WF_NextCondition.OPERATION_NotEq, "0bb893cb-cdcb-48c7-9c20-c7bb0041a51a");
		}
	};
	public CompletableFuture<MRefList> Operation_RL(X_AD_WF_NextCondition entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getOperation())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(OPERATION_UUIDS_BY_VALUE.get(entity.getOperation()));
	}

}
