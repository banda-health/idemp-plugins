package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LanguageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.MPInstance;
import org.compiere.model.X_AD_PrintFormat;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_PInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PInstanceResolver extends POResolver<MPInstance> implements GraphQLResolver<MPInstance> {



	/**
	 * Get Language ID.
	 *
	 * @return Language ID
	 */
	public CompletableFuture<MLanguage> AD_Language(MPInstance entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Language_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLanguage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_LanguageDataLoader.DATALOADER_AD_Language_BY_ID);
		return dataLoader.load(entity.getAD_Language_ID());
	}


	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public CompletableFuture<X_AD_PrintFormat> AD_PrintFormat(MPInstance entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.DATALOADER_AD_PrintFormat_BY_ID);
		return dataLoader.load(entity.getAD_PrintFormat_ID());
	}


	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public CompletableFuture<MProcess_BH> AD_Process(MPInstance entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_ID);
		return dataLoader.load(entity.getAD_Process_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MPInstance entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}

	public Boolean IsProcessing(MPInstance entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	public Boolean IsRunAsJob(MPInstance entity, DataFetchingEnvironment environment) {
		return entity.isRunAsJob();
	}

	public Boolean IsSummary(MPInstance entity, DataFetchingEnvironment environment) {
		return entity.isSummary();
	}

	static Map<String, String> NOTIFICATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("E", "e1ca3bcf-d8cb-451f-acd4-0a6773257650");
			put("N", "a85de9af-6e78-48e5-ae43-4f07734c2df3");
			put("X", "ca78475e-7191-402b-9d15-7244e87620f1");
			put("B", "aae5e850-38ca-4b15-9c9d-bee6402e7427");
		}
	};
	public CompletableFuture<MRefList_BH> NotificationType(MPInstance entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getNotificationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(NOTIFICATIONTYPE_UUIDS_BY_VALUE.get(entity.getNotificationType()));
	}

}
