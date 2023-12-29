package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_CtxHelpDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_NodeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ResponsibleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowProcessorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MCtxHelp;
import org.compiere.model.MEntityType;
import org.compiere.model.MRefList;
import org.compiere.model.MResource;
import org.compiere.model.MTable;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WF_Responsible;
import org.compiere.model.X_AD_Workflow;
import org.compiere.model.X_AD_WorkflowProcessor;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkflowResolver extends POResolver<X_AD_Workflow> implements GraphQLResolver<X_AD_Workflow> {


	static Map<String, String> ACCESSLEVEL_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_AD_Workflow.ACCESSLEVEL_Organization, "3cc495d2-7e46-4d2d-b8b8-a38bfa97fa60");
			put(X_AD_Workflow.ACCESSLEVEL_ClientPlusOrganization, "b8062c9f-fb7c-4e91-98ec-0a913a3b367f");
			put(X_AD_Workflow.ACCESSLEVEL_SystemOnly, "6e8bdb2d-b494-401c-b586-7d20727b5eab");
			put(X_AD_Workflow.ACCESSLEVEL_All, "04c9829a-008e-4a71-9598-224f770491dc");
			put(X_AD_Workflow.ACCESSLEVEL_SystemPlusClient, "e05482a2-71be-461d-b522-9cda71a9fa5d");
			put(X_AD_Workflow.ACCESSLEVEL_ClientOnly, "391e2c9a-b8e5-43b0-895b-eea914023e59");
		}
	};
	public CompletableFuture<MRefList> AccessLevel_RL(X_AD_Workflow entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MCtxHelp> AD_CtxHelp(X_AD_Workflow entity, DataFetchingEnvironment environment) {
		if (entity.getAD_CtxHelp_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCtxHelp> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_CtxHelpDataLoader.AD_CtxHelp_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_CtxHelp_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(X_AD_Workflow entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.AD_Table_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public CompletableFuture<X_AD_WF_Node> AD_WF_Node(X_AD_Workflow entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Node_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Node> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_NodeDataLoader.AD_WF_Node_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_WF_Node_ID());
	}


	/**
	 * Get Workflow Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	public CompletableFuture<X_AD_WF_Responsible> AD_WF_Responsible(X_AD_Workflow entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Responsible_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Responsible> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_ResponsibleDataLoader.AD_WF_Responsible_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_WF_Responsible_ID());
	}


	/**
	 * Get Workflow Processor.
	 *
	 * @return Workflow Processor Server
	 */
	public CompletableFuture<X_AD_WorkflowProcessor> AD_WorkflowProcessor(X_AD_Workflow entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WorkflowProcessor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_WorkflowProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowProcessorDataLoader.AD_WorkflowProcessor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_WorkflowProcessor_ID());
	}

	static Map<String, String> DURATIONUNIT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_AD_Workflow.DURATIONUNIT_Year, "ee4ca59c-d942-4638-bd76-03e91811756f");
			put(X_AD_Workflow.DURATIONUNIT_Month, "0da46165-4200-4a89-a1de-155fe706a4ec");
			put(X_AD_Workflow.DURATIONUNIT_Day, "a25e6649-b7d7-46e3-ad82-865dd54be04b");
			put(X_AD_Workflow.DURATIONUNIT_Hour, "69c872df-abbd-4d3f-a492-bf24fcb194f3");
			put(X_AD_Workflow.DURATIONUNIT_Minute, "608fdbf8-2d8b-4dda-b270-650e1477c0d2");
			put(X_AD_Workflow.DURATIONUNIT_Second, "5c2461a7-e999-4ca3-8edd-1704891e55a7");
		}
	};
	public CompletableFuture<MRefList> DurationUnit_RL(X_AD_Workflow entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDurationUnit())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DURATIONUNIT_UUIDS_BY_VALUE.get(entity.getDurationUnit()));
	}


	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(X_AD_Workflow entity, DataFetchingEnvironment environment) {
		if (entity.getEntityType() <= 0) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.AD_EntityType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEntityType());
	}

	static Map<String, String> PROCESSTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_AD_Workflow.PROCESSTYPE_BatchFlow, "f06d6e78-1856-441a-be92-94792d2fb9ee");
			put(X_AD_Workflow.PROCESSTYPE_ContinuousFlow, "d86d0206-f6a2-4553-8751-614a8558f3d4");
			put(X_AD_Workflow.PROCESSTYPE_DedicateRepetititiveFlow, "2501da7a-9998-4122-91f5-ec543d618b85");
			put(X_AD_Workflow.PROCESSTYPE_JobShop, "af325ee0-d91e-41b1-89dc-c701de4593a5");
			put(X_AD_Workflow.PROCESSTYPE_MixedRepetitiveFlow, "95b5335e-8e21-469a-acd6-3088a2d854a7");
			put(X_AD_Workflow.PROCESSTYPE_Plant, "fc20d258-d35e-4197-b080-12fa85285498");
		}
	};
	public CompletableFuture<MRefList> ProcessType_RL(X_AD_Workflow entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getProcessType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(PROCESSTYPE_UUIDS_BY_VALUE.get(entity.getProcessType()));
	}

	static Map<String, String> PUBLISHSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_AD_Workflow.PUBLISHSTATUS_Released, "8c56b9e2-5d7d-4e10-bc38-3088bb02adc6");
			put(X_AD_Workflow.PUBLISHSTATUS_Test, "03ab5de6-847d-47c8-bc6f-0fc4c1464caa");
			put(X_AD_Workflow.PUBLISHSTATUS_UnderRevision, "71db1f24-db92-4fb7-a7e0-2d6282bf5033");
			put(X_AD_Workflow.PUBLISHSTATUS_Void, "21402b39-fb9e-47a8-8aff-5c18820165ef");
		}
	};
	public CompletableFuture<MRefList> PublishStatus_RL(X_AD_Workflow entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPublishStatus())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(PUBLISHSTATUS_UUIDS_BY_VALUE.get(entity.getPublishStatus()));
	}


	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public CompletableFuture<MResource> S_Resource(X_AD_Workflow entity, DataFetchingEnvironment environment) {
		if (entity.getS_Resource_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MResource> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ResourceDataLoader.S_Resource_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getS_Resource_ID());
	}

	static Map<String, String> WORKFLOWTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_AD_Workflow.WORKFLOWTYPE_General, "5b4a919b-0205-4fe3-bd85-cf286ba02c16");
			put(X_AD_Workflow.WORKFLOWTYPE_DocumentProcess, "6d1c2e96-17ca-4d5f-91ff-625029f75d3d");
			put(X_AD_Workflow.WORKFLOWTYPE_DocumentValue, "c8226074-2287-478e-a9e2-d673775494c9");
			put(X_AD_Workflow.WORKFLOWTYPE_Manufacturing, "6184505f-79b2-407b-93d8-5cd5b19f7a5b");
			put(X_AD_Workflow.WORKFLOWTYPE_Quality, "35045b6a-c6d1-4d01-ad5f-4dd1e07cfb9d");
			put(X_AD_Workflow.WORKFLOWTYPE_Wizard, "f1ffc07b-f822-4659-bdd7-e8dde31acac5");
		}
	};
	public CompletableFuture<MRefList> WorkflowType_RL(X_AD_Workflow entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getWorkflowType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(WORKFLOWTYPE_UUIDS_BY_VALUE.get(entity.getWorkflowType()));
	}

}
