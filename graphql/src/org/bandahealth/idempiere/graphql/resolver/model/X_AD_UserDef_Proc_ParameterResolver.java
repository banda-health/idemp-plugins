package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MFieldGroup_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FieldGroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Process_ParaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDef_ProcDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Val_RuleDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MProcessPara;
import org.compiere.model.MUserDefProc;
import org.compiere.model.MUserDefProcParameter;
import org.compiere.model.MValRule;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_UserDef_Proc_Parameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserDef_Proc_ParameterResolver extends POResolver<MUserDefProcParameter> implements GraphQLResolver<MUserDefProcParameter> {



	/**
	 * Get Field Group.
	 *
	 * @return Logical grouping of fields
	 */
	public CompletableFuture<MFieldGroup_BH> AD_FieldGroup(MUserDefProcParameter entity, DataFetchingEnvironment environment) {
		if (entity.getAD_FieldGroup_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MFieldGroup_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_FieldGroupDataLoader.DATALOADER_AD_FieldGroup_BY_ID);
		return dataLoader.load(entity.getAD_FieldGroup_ID());
	}


	/**
	 * Get Process Parameter.
	 *
	 * @return Process Parameter
	 */
	public CompletableFuture<MProcessPara> AD_Process_Para(MUserDefProcParameter entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_Para_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProcessPara> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Process_ParaDataLoader.DATALOADER_AD_Process_Para_BY_ID);
		return dataLoader.load(entity.getAD_Process_Para_ID());
	}


	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(MUserDefProcParameter entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() < 0) {
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
	public CompletableFuture<MReference_BH> AD_Reference_Value(MUserDefProcParameter entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_Value_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_Value_ID());
	}


	/**
	 * Get User defined Process.
	 *
	 * @return Primary Key : User defined Process
	 */
	public CompletableFuture<MUserDefProc> AD_UserDef_Proc(MUserDefProcParameter entity, DataFetchingEnvironment environment) {
		if (entity.getAD_UserDef_Proc_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUserDefProc> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDef_ProcDataLoader.DATALOADER_AD_UserDef_Proc_BY_ID);
		return dataLoader.load(entity.getAD_UserDef_Proc_ID());
	}


	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	public CompletableFuture<MValRule> AD_Val_Rule(MUserDefProcParameter entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Val_Rule_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MValRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Val_RuleDataLoader.DATALOADER_AD_Val_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Val_Rule_ID());
	}

	public static Map<String, String> ISDISPLAYED_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsDisplayed(MUserDefProcParameter entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsDisplayed())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISDISPLAYED_UUIDS_BY_VALUE.get(entity.getIsDisplayed()));
	}

	public static Map<String, String> ISMANDATORY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsMandatory(MUserDefProcParameter entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsMandatory())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISMANDATORY_UUIDS_BY_VALUE.get(entity.getIsMandatory()));
	}

	public Boolean IsRange(MUserDefProcParameter entity, DataFetchingEnvironment environment) {
		return entity.isRange();
	}

}
