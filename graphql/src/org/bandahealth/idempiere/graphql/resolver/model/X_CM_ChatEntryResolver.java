package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_CM_ChatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_CM_ChatEntryDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MChat;
import org.compiere.model.MChatEntry;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for CM_ChatEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_CM_ChatEntryResolver extends POResolver<MChatEntry> implements GraphQLResolver<MChatEntry> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MChatEntry entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}

	public static Map<String, String> CHATENTRYTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("W", "afbefe8f-d3da-4c6b-b600-392ed0314198"); // Wiki
			put("N", "a4d64cd0-5449-4916-bd90-205c85560cf0"); // Note (flat)
			put("F", "48206093-4e04-44bd-b00c-adc1d38ebb4c"); // Forum (threaded)
		}
	};
	public CompletableFuture<MRefList_BH> ChatEntryType(MChatEntry entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getChatEntryType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CHATENTRYTYPE_UUIDS_BY_VALUE.get(entity.getChatEntryType()));
	}


	/**
	 * Get Chat.
	 *
	 * @return Chat or discussion thread
	 */
	public CompletableFuture<MChat> CM_Chat(MChatEntry entity, DataFetchingEnvironment environment) {
		if (entity.getCM_Chat_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MChat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_CM_ChatDataLoader.DATALOADER_CM_Chat_BY_ID);
		return dataLoader.load(entity.getCM_Chat_ID());
	}


	/**
	 * Get Chat Entry Grandparent.
	 *
	 * @return Link to Grand Parent (root level)
	 */
	public CompletableFuture<MChatEntry> CM_ChatEntryGrandParent(MChatEntry entity, DataFetchingEnvironment environment) {
		if (entity.getCM_ChatEntryGrandParent_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MChatEntry> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_CM_ChatEntryDataLoader.DATALOADER_CM_ChatEntry_BY_ID);
		return dataLoader.load(entity.getCM_ChatEntryGrandParent_ID());
	}


	/**
	 * Get Chat Entry Parent.
	 *
	 * @return Link to direct Parent
	 */
	public CompletableFuture<MChatEntry> CM_ChatEntryParent(MChatEntry entity, DataFetchingEnvironment environment) {
		if (entity.getCM_ChatEntryParent_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MChatEntry> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_CM_ChatEntryDataLoader.DATALOADER_CM_ChatEntry_BY_ID);
		return dataLoader.load(entity.getCM_ChatEntryParent_ID());
	}

	public static Map<String, String> CONFIDENTIALTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "1eb43dd1-53c0-4b5c-aae4-585c7d3fc9c2"); // Public Information
			put("C", "0f1983c1-e543-4a8f-9b8a-4a00d2a111f4"); // Partner Confidential
			put("I", "7c6def43-3d72-4c5b-93ce-dfbefd8545e4"); // Internal
			put("P", "467c826c-2a44-4f65-8026-8dc6b1d7edec"); // Private Information
		}
	};
	public CompletableFuture<MRefList_BH> ConfidentialType(MChatEntry entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getConfidentialType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CONFIDENTIALTYPE_UUIDS_BY_VALUE.get(entity.getConfidentialType()));
	}

	public static Map<String, String> MODERATORSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "3db5a09c-6691-45e3-9e96-b5d1177bfddb"); // Not Displayed
			put("P", "a19e1d0d-4969-466f-af73-4c6ecab3e86b"); // Published
			put("R", "f5b46f16-69d2-42c4-9525-26431a486056"); // To be reviewed
			put("S", "9218908f-fb7d-4b1e-8fac-4ee7796cc8c9"); // Suspicious
		}
	};
	public CompletableFuture<MRefList_BH> ModeratorStatus(MChatEntry entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getModeratorStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(MODERATORSTATUS_UUIDS_BY_VALUE.get(entity.getModeratorStatus()));
	}

}
