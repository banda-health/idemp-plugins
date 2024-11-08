package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_NodeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ResponsibleDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MTable;
import org.compiere.model.X_AD_WF_EventAudit;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WF_Process;
import org.compiere.model.X_AD_WF_Responsible;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_WF_EventAudit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_EventAuditResolver extends POResolver<X_AD_WF_EventAudit> implements GraphQLResolver<X_AD_WF_EventAudit> {



	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(X_AD_WF_EventAudit entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_AD_WF_EventAudit entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public CompletableFuture<X_AD_WF_Node> AD_WF_Node(X_AD_WF_EventAudit entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Node_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Node> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_NodeDataLoader.DATALOADER_AD_WF_Node_BY_ID);
		return dataLoader.load(entity.getAD_WF_Node_ID());
	}


	/**
	 * Get Workflow Process.
	 *
	 * @return Actual Workflow Process Instance
	 */
	public CompletableFuture<X_AD_WF_Process> AD_WF_Process(X_AD_WF_EventAudit entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Process_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Process> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_ProcessDataLoader.DATALOADER_AD_WF_Process_BY_ID);
		return dataLoader.load(entity.getAD_WF_Process_ID());
	}


	/**
	 * Get Workflow Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	public CompletableFuture<X_AD_WF_Responsible> AD_WF_Responsible(X_AD_WF_EventAudit entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Responsible_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Responsible> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_ResponsibleDataLoader.DATALOADER_AD_WF_Responsible_BY_ID);
		return dataLoader.load(entity.getAD_WF_Responsible_ID());
	}

	public static Map<String, String> EVENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("PC", "50f93eb9-a224-4faf-8e3d-3d751df8860e"); // Process Created
			put("SC", "f7ade28a-ceb2-4ca8-af6a-2489f109e2b2"); // State Changed
			put("PX", "2bc42ab2-9683-4114-8a67-bf95df0794fd"); // Process Completed
		}
	};
	public CompletableFuture<MRefList_BH> EventType(X_AD_WF_EventAudit entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEventType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(EVENTTYPE_UUIDS_BY_VALUE.get(entity.getEventType()));
	}

	public static Map<String, String> WFSTATE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("ON", "79c0657d-e1c1-4662-8580-1819db98c456"); // Not Started
			put("OR", "6f40ec26-7f2b-48af-b711-2711462d14a2"); // Running
			put("OS", "5fa1df1a-94c6-4a25-b845-3778646130ef"); // Suspended
			put("CC", "e622243a-7242-417c-a8fb-c167a1dbecfd"); // Completed
			put("CA", "89ddf7c1-385d-4590-85c7-728e1c33016b"); // Aborted
			put("CT", "1f8d557d-9955-4285-aa92-d098d5ed7ca9"); // Terminated
		}
	};
	public CompletableFuture<MRefList_BH> WFState(X_AD_WF_EventAudit entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getWFState())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(WFSTATE_UUIDS_BY_VALUE.get(entity.getWFState()));
	}

}
