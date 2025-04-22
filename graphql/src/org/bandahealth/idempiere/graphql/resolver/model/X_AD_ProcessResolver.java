package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_CtxHelpDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FormDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Process_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReportViewDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MCtxHelp;
import org.compiere.model.MEntityType;
import org.compiere.model.MForm;
import org.compiere.model.MReportView;
import org.compiere.model.PO;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_Workflow;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ProcessResolver extends POResolver<MProcess_BH> implements GraphQLResolver<MProcess_BH> {


	public static Map<String, String> ACCESSLEVEL_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("1", "3cc495d2-7e46-4d2d-b8b8-a38bfa97fa60"); // Organization
			put("3", "b8062c9f-fb7c-4e91-98ec-0a913a3b367f"); // Client+Organization
			put("4", "6e8bdb2d-b494-401c-b586-7d20727b5eab"); // System only
			put("7", "04c9829a-008e-4a71-9598-224f770491dc"); // All
			put("6", "e05482a2-71be-461d-b522-9cda71a9fa5d"); // System+Client
			put("2", "391e2c9a-b8e5-43b0-895b-eea914023e59"); // Client only
		}
	};
	public CompletableFuture<MRefList_BH> AccessLevel(MProcess_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAccessLevel())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ACCESSLEVEL_UUIDS_BY_VALUE.get(entity.getAccessLevel()));
	}


	/**
	 * Get Context Help.
	 *
	 * @return Context Help
	 */
	public CompletableFuture<MCtxHelp> AD_CtxHelp(MProcess_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_CtxHelp_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCtxHelp> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_CtxHelpDataLoader.DATALOADER_AD_CtxHelp_BY_ID);
		return dataLoader.load(entity.getAD_CtxHelp_ID());
	}


	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	public CompletableFuture<MForm> AD_Form(MProcess_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Form_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MForm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_FormDataLoader.DATALOADER_AD_Form_BY_ID);
		return dataLoader.load(entity.getAD_Form_ID());
	}


	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public CompletableFuture<X_AD_PrintFormat> AD_PrintFormat(MProcess_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFormat_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.DATALOADER_AD_PrintFormat_BY_ID);
		return dataLoader.load(entity.getAD_PrintFormat_ID());
	}


	/**
	 * Get Report View.
	 *
	 * @return View used to generate this report
	 */
	public CompletableFuture<MReportView> AD_ReportView(MProcess_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ReportView_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MReportView> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReportViewDataLoader.DATALOADER_AD_ReportView_BY_ID);
		return dataLoader.load(entity.getAD_ReportView_ID());
	}


	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public CompletableFuture<X_AD_Workflow> AD_Workflow(MProcess_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workflow_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.DATALOADER_AD_Workflow_BY_ID);
		return dataLoader.load(entity.getAD_Workflow_ID());
	}

	public static Map<String, String> ALLOWMULTIPLEEXECUTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "cd374cc2-e928-4e76-a376-9021ec5f31e7"); // Not from same user
			put("P", "1dcb3178-d9f5-449e-9592-5e6e29453cf1"); // Not from same user and parameters
			put("NA", "8911db76-92ef-4c9b-9482-442cf31a2fc4"); // Not from any user
			put("PA", "d13ecbd0-370f-4935-826b-2ae7313add8a"); // Not from any user and same parameters
			put("Y", "832cb3cb-d520-4c5d-98e5-a302f0fa0f39"); // Yes
		}
	};
	public CompletableFuture<MRefList_BH> AllowMultipleExecution(MProcess_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAllowMultipleExecution())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ALLOWMULTIPLEEXECUTION_UUIDS_BY_VALUE.get(entity.getAllowMultipleExecution()));
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MProcess_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Process_TrlDataLoader.DATALOADER_AD_Process_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MProcess_BH.COLUMNNAME_Description) :
						entity.getDescription());
	}

	static Map<String, Integer> ENTITYTYPE_IDS_BY_ENTITY_TYPE = new HashMap<>() {
		{
			put("D", 10);
			put("C", 20);
			put("U", 100);
			put("CUST", 110);
			put("A", 200);
			put("EXT", 210);
			put("XX", 220);
			put("EE01", 50000);
			put("EE04", 50001);
			put("EE05", 50003);
			put("EE02", 50005);
			put("WSTORE", 200015);
		}
	};

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(MProcess_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	public static Map<String, String> EXECUTIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "24e2cb33-193c-45ca-9281-fea9752bf59f"); // Force Background
			put("F", "9a4c7179-17f7-4fc0-9ccb-bdcdf36488a4"); // Force Foreground
		}
	};
	public CompletableFuture<MRefList_BH> ExecutionType(MProcess_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getExecutionType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(EXECUTIONTYPE_UUIDS_BY_VALUE.get(entity.getExecutionType()));
	}

	/**
	 * Get Comment/Help.
	 *
	 * @return Comment or Hint
	 */
	public CompletableFuture<String> Help(MProcess_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getHelp);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Process_TrlDataLoader.DATALOADER_AD_Process_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MProcess_BH.COLUMNNAME_Help) :
						entity.getHelp());
	}

	public Boolean IsBetaFunctionality(MProcess_BH entity, DataFetchingEnvironment environment) {
		return entity.isBetaFunctionality();
	}

	public Boolean IsDirectPrint(MProcess_BH entity, DataFetchingEnvironment environment) {
		return entity.isDirectPrint();
	}

	public Boolean IsReport(MProcess_BH entity, DataFetchingEnvironment environment) {
		return entity.isReport();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MProcess_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Process_TrlDataLoader.DATALOADER_AD_Process_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MProcess_BH.COLUMNNAME_Name) :
						entity.getName());
	}

	public static Map<String, String> SHOWHELP_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "f59c706c-acef-44de-a237-e29816990c1d"); // Ask user (for future use)
			put("N", "f113960a-7f8c-40c6-8f91-c7c852d66c52"); // Don't show help
			put("Y", "a2ed1180-6626-47b4-95c0-b7c265f8ed59"); // Show Help
			put("S", "7474b66d-3658-4fc8-ac27-08c80f8ce257"); // Run silently - Take Defaults
		}
	};
	public CompletableFuture<MRefList_BH> ShowHelp(MProcess_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getShowHelp())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(SHOWHELP_UUIDS_BY_VALUE.get(entity.getShowHelp()));
	}

}
