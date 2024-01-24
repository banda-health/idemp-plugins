package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_BroadcastMessage_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.PO;
import org.compiere.model.X_AD_BroadcastMessage;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_BroadcastMessage - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_BroadcastMessageResolver extends POResolver<X_AD_BroadcastMessage> implements GraphQLResolver<X_AD_BroadcastMessage> {



	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(X_AD_BroadcastMessage entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_AD_BroadcastMessage entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}

	static Map<String, String> BROADCASTFREQUENCY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("J", "eb20103b-6c47-449d-b7f5-2e28c797beaf");
			put("E", "e60b5002-3fa4-49bf-aca3-d8146471a538");
			put("A", "d6b87260-502d-4984-b9e3-8daafde1acd9");
			put("O", "aa345f63-dfbe-4d18-aae4-e5ed06cd4407");
		}
	};
	public CompletableFuture<MRefList_BH> BroadcastFrequency(X_AD_BroadcastMessage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBroadcastFrequency())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BROADCASTFREQUENCY_UUIDS_BY_VALUE.get(entity.getBroadcastFrequency()));
	}

	/**
	 * Get Broadcast Message.
	 *
	 * @return Broadcast Message
	 */
	public CompletableFuture<String> BroadcastMessage(X_AD_BroadcastMessage entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getBroadcastMessage);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_BroadcastMessage_TrlDataLoader.DATALOADER_AD_BroadcastMessage_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_AD_BroadcastMessage.COLUMNNAME_BroadcastMessage));
	}

	static Map<String, String> BROADCASTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("I", "616b30c8-b810-4eb8-97c7-69ac8c5d042f");
			put("IL", "6237108e-64f8-4873-9d9b-4523d5b86f77");
			put("L", "6cd78804-e0f9-4f33-bd0d-b7fdde926648");
		}
	};
	public CompletableFuture<MRefList_BH> BroadcastType(X_AD_BroadcastMessage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBroadcastType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BROADCASTTYPE_UUIDS_BY_VALUE.get(entity.getBroadcastType()));
	}

	public Boolean Expired(X_AD_BroadcastMessage entity, DataFetchingEnvironment environment) {
		return entity.isExpired();
	}

	public Boolean IsPublished(X_AD_BroadcastMessage entity, DataFetchingEnvironment environment) {
		return entity.isPublished();
	}

	public Boolean LogAcknowledge(X_AD_BroadcastMessage entity, DataFetchingEnvironment environment) {
		return entity.isLogAcknowledge();
	}

	public Boolean Processed(X_AD_BroadcastMessage entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	static Map<String, String> TARGET_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "1371569d-a605-41c8-86b6-f175ef4eb390");
			put("E", "294904a2-0672-46f4-91ba-cbe14be17fe0");
			put("R", "ea261c96-1b82-43ce-8f6a-e1e170f2851c");
			put("U", "3ff1c5d6-9c71-49e7-b3ea-73ee6d025b28");
		}
	};
	public CompletableFuture<MRefList_BH> Target(X_AD_BroadcastMessage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTarget())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TARGET_UUIDS_BY_VALUE.get(entity.getTarget()));
	}

}
