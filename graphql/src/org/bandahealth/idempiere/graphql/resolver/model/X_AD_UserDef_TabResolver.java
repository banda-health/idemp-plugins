package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TabDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDef_WinDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MTab;
import org.compiere.model.MUserDefTab;
import org.compiere.model.MUserDefWin;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_UserDef_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_TabResolver extends POResolver<MUserDefTab> implements GraphQLResolver<MUserDefTab> {



	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public CompletableFuture<MProcess_BH> AD_Process(MUserDefTab entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_ID);
		return dataLoader.load(entity.getAD_Process_ID());
	}


	/**
	 * Get Tab.
	 *
	 * @return Tab within a Window
	 */
	public CompletableFuture<MTab> AD_Tab(MUserDefTab entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tab_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTab> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TabDataLoader.DATALOADER_AD_Tab_BY_ID);
		return dataLoader.load(entity.getAD_Tab_ID());
	}


	/**
	 * Get User defined Window.
	 *
	 * @return User defined Window
	 */
	public CompletableFuture<MUserDefWin> AD_UserDef_Win(MUserDefTab entity, DataFetchingEnvironment environment) {
		if (entity.getAD_UserDef_Win_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUserDefWin> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDef_WinDataLoader.DATALOADER_AD_UserDef_Win_BY_ID);
		return dataLoader.load(entity.getAD_UserDef_Win_ID());
	}

	static Map<String, String> ISALLOWADVANCEDLOOKUP_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5");
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db");
		}
	};
	public CompletableFuture<MRefList_BH> IsAllowAdvancedLookup(MUserDefTab entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsAllowAdvancedLookup())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISALLOWADVANCEDLOOKUP_UUIDS_BY_VALUE.get(entity.getIsAllowAdvancedLookup()));
	}

	static Map<String, String> ISLOOKUPONLYSELECTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5");
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db");
		}
	};
	public CompletableFuture<MRefList_BH> IsLookupOnlySelection(MUserDefTab entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsLookupOnlySelection())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISLOOKUPONLYSELECTION_UUIDS_BY_VALUE.get(entity.getIsLookupOnlySelection()));
	}

	public Boolean IsMultiRowOnly(MUserDefTab entity, DataFetchingEnvironment environment) {
		return entity.isMultiRowOnly();
	}

	static Map<String, String> ISREADONLY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5");
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db");
		}
	};
	public CompletableFuture<MRefList_BH> IsReadOnly(MUserDefTab entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsReadOnly())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISREADONLY_UUIDS_BY_VALUE.get(entity.getIsReadOnly()));
	}

	static Map<String, String> ISSINGLEROW_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5");
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db");
		}
	};
	public CompletableFuture<MRefList_BH> IsSingleRow(MUserDefTab entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsSingleRow())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISSINGLEROW_UUIDS_BY_VALUE.get(entity.getIsSingleRow()));
	}

}
