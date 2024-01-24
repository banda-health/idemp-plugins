package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_MessageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ResponsibleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MTable;
import org.compiere.model.X_AD_WF_Process;
import org.compiere.model.X_AD_WF_Responsible;
import org.compiere.model.X_AD_Workflow;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_WF_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ProcessResolver extends POResolver<X_AD_WF_Process> implements GraphQLResolver<X_AD_WF_Process> {



	/**
	 * Get Message.
	 *
	 * @return System Message
	 */
	public CompletableFuture<MMessage_BH> AD_Message(X_AD_WF_Process entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Message_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMessage_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_MessageDataLoader.DATALOADER_AD_Message_BY_ID);
		return dataLoader.load(entity.getAD_Message_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(X_AD_WF_Process entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
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
	public CompletableFuture<MUser_BH> AD_User(X_AD_WF_Process entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Workflow Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	public CompletableFuture<X_AD_WF_Responsible> AD_WF_Responsible(X_AD_WF_Process entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Responsible_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Responsible> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_ResponsibleDataLoader.DATALOADER_AD_WF_Responsible_BY_ID);
		return dataLoader.load(entity.getAD_WF_Responsible_ID());
	}


	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public CompletableFuture<X_AD_Workflow> AD_Workflow(X_AD_WF_Process entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workflow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.DATALOADER_AD_Workflow_BY_ID);
		return dataLoader.load(entity.getAD_Workflow_ID());
	}

	public Boolean Processed(X_AD_WF_Process entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_AD_WF_Process entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	static Map<String, String> WFSTATE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("ON", "79c0657d-e1c1-4662-8580-1819db98c456");
			put("OR", "6f40ec26-7f2b-48af-b711-2711462d14a2");
			put("OS", "5fa1df1a-94c6-4a25-b845-3778646130ef");
			put("CC", "e622243a-7242-417c-a8fb-c167a1dbecfd");
			put("CA", "89ddf7c1-385d-4590-85c7-728e1c33016b");
			put("CT", "1f8d557d-9955-4285-aa92-d098d5ed7ca9");
		}
	};
	public CompletableFuture<MRefList_BH> WFState(X_AD_WF_Process entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getWFState())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(WFSTATE_UUIDS_BY_VALUE.get(entity.getWFState()));
	}

}
