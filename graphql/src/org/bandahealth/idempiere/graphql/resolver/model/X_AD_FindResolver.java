package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColumn;
import org.compiere.model.X_AD_Find;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Find - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_FindResolver extends POResolver<X_AD_Find> implements GraphQLResolver<X_AD_Find> {



	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(X_AD_Find entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getAD_Column_ID());
	}

	public static Map<String, String> ANDOR_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "2a20f5be-1d08-4be6-9b94-9835ef8800cb"); // And
			put("O", "67af34aa-ef4f-4928-8536-427c8a6551e4"); // Or
		}
	};
	public CompletableFuture<MRefList_BH> AndOr(X_AD_Find entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAndOr())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ANDOR_UUIDS_BY_VALUE.get(entity.getAndOr()));
	}

	public static Map<String, String> OPERATION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("==", "3fefc2d0-9c5a-483c-b34f-00ca51a42bd0"); //  =
			put(">=", "c03b77ec-a80e-4628-812d-8f64a493da07"); // >=
			put(">>", "9bb7c5a6-b291-4c2c-9524-fa7e974a1160"); // >
			put("<<", "b4ee4ca1-39c6-4703-911b-e107aaca4af6"); // <
			put("~~", "c3b65756-69b3-4f47-a1ba-9161a7dcfc73"); //  ~
			put("<=", "d68ddcf5-efc3-4208-a583-3b4f40a01bee"); // <=
			put("AB", "990ca97f-1278-4171-aa70-0a16770124b5"); // |<x>|
			put("SQ", "d07128bf-2e88-42d9-8234-4ee181d35a5b"); // sql
			put("!=", "0bb893cb-cdcb-48c7-9c20-c7bb0041a51a"); // !=
		}
	};
	public CompletableFuture<MRefList_BH> Operation(X_AD_Find entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getOperation())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(OPERATION_UUIDS_BY_VALUE.get(entity.getOperation()));
	}

}
