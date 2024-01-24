package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_StyleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDef_InfoDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Val_RuleDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MInfoColumn;
import org.compiere.model.MStyle;
import org.compiere.model.MUserDefInfo;
import org.compiere.model.MUserDefInfoColumn;
import org.compiere.model.MValRule;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_UserDef_Info_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_Info_ColumnResolver extends POResolver<MUserDefInfoColumn> implements GraphQLResolver<MUserDefInfoColumn> {



	/**
	 * Get Field Style.
	 *
	 * @return Field CSS Style 
	 */
	public CompletableFuture<MStyle> AD_FieldStyle(MUserDefInfoColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_FieldStyle_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MStyle> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_StyleDataLoader.DATALOADER_AD_Style_BY_ID);
		return dataLoader.load(entity.getAD_FieldStyle_ID());
	}


	/**
	 * Get Info Column.
	 *
	 * @return Info Window Column
	 */
	public CompletableFuture<MInfoColumn> AD_InfoColumn(MUserDefInfoColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_InfoColumn_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInfoColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_InfoColumnDataLoader.DATALOADER_AD_InfoColumn_BY_ID);
		return dataLoader.load(entity.getAD_InfoColumn_ID());
	}


	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(MUserDefInfoColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_ID());
	}


	/**
	 * Get Reference Key.
	 *
	 * @return Required to specify, if data type is Table or List
	 */
	public CompletableFuture<MReference_BH> AD_Reference_Value(MUserDefInfoColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_Value_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_Value_ID());
	}


	/**
	 * Get User defined Info Window.
	 *
	 * @return User defined Info Window
	 */
	public CompletableFuture<MUserDefInfo> AD_UserDef_Info(MUserDefInfoColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_UserDef_Info_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUserDefInfo> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDef_InfoDataLoader.DATALOADER_AD_UserDef_Info_BY_ID);
		return dataLoader.load(entity.getAD_UserDef_Info_ID());
	}


	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	public CompletableFuture<MValRule> AD_Val_Rule(MUserDefInfoColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Val_Rule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MValRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Val_RuleDataLoader.DATALOADER_AD_Val_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Val_Rule_ID());
	}

	static Map<String, String> ISAUTOCOMPLETE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5");
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db");
		}
	};
	public CompletableFuture<MRefList_BH> IsAutocomplete(MUserDefInfoColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsAutocomplete())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ISAUTOCOMPLETE_UUIDS_BY_VALUE.get(entity.getIsAutocomplete()));
	}

	static Map<String, String> ISDISPLAYED_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5");
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db");
		}
	};
	public CompletableFuture<MRefList_BH> IsDisplayed(MUserDefInfoColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsDisplayed())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ISDISPLAYED_UUIDS_BY_VALUE.get(entity.getIsDisplayed()));
	}

	static Map<String, String> ISMANDATORY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5");
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db");
		}
	};
	public CompletableFuture<MRefList_BH> IsMandatory(MUserDefInfoColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsMandatory())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ISMANDATORY_UUIDS_BY_VALUE.get(entity.getIsMandatory()));
	}

	static Map<String, String> ISQUERYCRITERIA_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5");
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db");
		}
	};
	public CompletableFuture<MRefList_BH> IsQueryCriteria(MUserDefInfoColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsQueryCriteria())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ISQUERYCRITERIA_UUIDS_BY_VALUE.get(entity.getIsQueryCriteria()));
	}

	static Map<String, String> ISREADONLY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5");
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db");
		}
	};
	public CompletableFuture<MRefList_BH> IsReadOnly(MUserDefInfoColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsReadOnly())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ISREADONLY_UUIDS_BY_VALUE.get(entity.getIsReadOnly()));
	}

	static Map<String, String> QUERYOPERATOR_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Like", "cd02fd21-8913-4bc7-9ef4-a405069f8665");
			put("=", "1e99d0eb-d4ba-46ad-98be-1e9f0a20d387");
			put(">", "da5910a0-4b7a-4986-ada4-ecba7eb953ad");
			put(">=", "653d78b9-8a2b-40cd-a0f1-c7e8bf5cea1c");
			put("<", "2673aa9f-3efc-4625-9659-9242f8140d8c");
			put("<=", "dc557f72-fae9-463f-86ab-7d078eef739f");
			put("!=", "bc2fee0b-7738-4d57-9d12-e60d55ff2256");
			put("LIKE", "9562f4db-97a9-4df5-99d0-b2f5bc0e2b4c");
		}
	};
	public CompletableFuture<MRefList_BH> QueryOperator(MUserDefInfoColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getQueryOperator())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(QUERYOPERATOR_UUIDS_BY_VALUE.get(entity.getQueryOperator()));
	}

}
