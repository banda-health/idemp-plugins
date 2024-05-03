package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_CM_ChatTypeDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MChat;
import org.compiere.model.MChatType;
import org.compiere.model.MTable;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for CM_Chat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_CM_ChatResolver extends POResolver<MChat> implements GraphQLResolver<MChat> {



	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MChat entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get Chat Type.
	 *
	 * @return Type of discussion / chat
	 */
	public CompletableFuture<MChatType> CM_ChatType(MChat entity, DataFetchingEnvironment environment) {
		if (entity.getCM_ChatType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MChatType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_CM_ChatTypeDataLoader.DATALOADER_CM_ChatType_BY_ID);
		return dataLoader.load(entity.getCM_ChatType_ID());
	}

	static Map<String, String> CONFIDENTIALTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "1eb43dd1-53c0-4b5c-aae4-585c7d3fc9c2");
			put("C", "0f1983c1-e543-4a8f-9b8a-4a00d2a111f4");
			put("I", "7c6def43-3d72-4c5b-93ce-dfbefd8545e4");
			put("P", "467c826c-2a44-4f65-8026-8dc6b1d7edec");
		}
	};
	public CompletableFuture<MRefList_BH> ConfidentialType(MChat entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getConfidentialType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CONFIDENTIALTYPE_UUIDS_BY_VALUE.get(entity.getConfidentialType()));
	}

	static Map<String, String> MODERATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "09318ba5-7fc0-4f9c-9470-4df2fbe8fb8d");
			put("B", "e6f0ed41-923b-46a7-ad1c-962173583ac4");
			put("A", "16fa5956-4594-4cfc-a406-7d76d60c8876");
		}
	};
	public CompletableFuture<MRefList_BH> ModerationType(MChat entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getModerationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(MODERATIONTYPE_UUIDS_BY_VALUE.get(entity.getModerationType()));
	}

}
