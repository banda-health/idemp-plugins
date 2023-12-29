package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_CtxHelpDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MCtxHelp;
import org.compiere.model.MEntityType;
import org.compiere.model.MForm;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Form - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_FormResolver extends POResolver<MForm> implements GraphQLResolver<MForm> {


	static Map<String, String> ACCESSLEVEL_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MForm.ACCESSLEVEL_Organization, "3cc495d2-7e46-4d2d-b8b8-a38bfa97fa60");
			put(MForm.ACCESSLEVEL_ClientPlusOrganization, "b8062c9f-fb7c-4e91-98ec-0a913a3b367f");
			put(MForm.ACCESSLEVEL_SystemOnly, "6e8bdb2d-b494-401c-b586-7d20727b5eab");
			put(MForm.ACCESSLEVEL_All, "04c9829a-008e-4a71-9598-224f770491dc");
			put(MForm.ACCESSLEVEL_SystemPlusClient, "e05482a2-71be-461d-b522-9cda71a9fa5d");
			put(MForm.ACCESSLEVEL_ClientOnly, "391e2c9a-b8e5-43b0-895b-eea914023e59");
		}
	};
	public CompletableFuture<MRefList> AccessLevel_RL(MForm entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAccessLevel())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(ACCESSLEVEL_UUIDS_BY_VALUE.get(entity.getAccessLevel()));
	}


	/**
	 * Get Context Help.
	 *
	 * @return Context Help
	 */
	public CompletableFuture<MCtxHelp> AD_CtxHelp(MForm entity, DataFetchingEnvironment environment) {
		if (entity.getAD_CtxHelp_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCtxHelp> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_CtxHelpDataLoader.AD_CtxHelp_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_CtxHelp_ID());
	}


	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(MForm entity, DataFetchingEnvironment environment) {
		if (entity.getEntityType() <= 0) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.AD_EntityType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEntityType());
	}

}
