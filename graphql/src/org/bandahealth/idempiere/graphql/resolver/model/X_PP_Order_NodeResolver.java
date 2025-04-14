package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FormDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TaskDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_BlockDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_NodeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ResponsibleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Order_Node_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Order_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MEntityType;
import org.compiere.model.MForm;
import org.compiere.model.MImage;
import org.compiere.model.MResource;
import org.compiere.model.MTask;
import org.compiere.model.MWindow;
import org.compiere.model.PO;
import org.compiere.model.X_AD_WF_Block;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WF_Responsible;
import org.compiere.model.X_AD_Workflow;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_Node;
import org.eevolution.model.X_PP_Order_Workflow;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PP_Order_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PP_Order_NodeResolver extends POResolver<X_PP_Order_Node> implements GraphQLResolver<X_PP_Order_Node> {


	public static Map<String, String> ACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Z", "8ef4a18d-9f67-434b-8f83-067fade09bc8"); // Wait (Sleep)
			put("C", "59eede55-ead5-4a13-96c5-e0a712afff81"); // User Choice
			put("F", "88a81162-95de-4ec6-b100-a283296be057"); // Sub Workflow
			put("V", "f8b72207-17c2-4ecf-9cd4-50a16758a17e"); // Set Variable
			put("W", "73a291eb-e6ec-4708-9f26-2fb95c1d417b"); // User Window
			put("X", "fd67ca8e-2076-4ba0-9607-2fcafba2eded"); // User Form
			put("T", "5195d723-cadc-4c3e-95b4-32d8df931ac6"); // Apps Task
			put("R", "221219e5-eed5-46bb-903b-87870578ca32"); // Apps Report
			put("P", "15681176-2ff7-4433-8eef-47048a97b2c1"); // Apps Process
			put("D", "ca24d80e-62d2-48de-b00a-0834a7dc1317"); // Document Action
			put("M", "0ceb65e4-9e53-4ffb-a320-5d0d52865d41"); // EMail
			put("B", "f95b359f-f513-4525-9e53-5772f3d60d0b"); // User Workbench
			put("I", "eaf4fa91-3fa3-47f9-9b7f-6ac5b475da68"); // User Info
		}
	};
	public CompletableFuture<MRefList_BH> Action(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ACTION_UUIDS_BY_VALUE.get(entity.getAction()));
	}


	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	public CompletableFuture<MForm> AD_Form(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Form_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MForm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_FormDataLoader.DATALOADER_AD_Form_BY_ID);
		return dataLoader.load(entity.getAD_Form_ID());
	}


	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	public CompletableFuture<MImage> AD_Image(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Image_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MImage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImageDataLoader.DATALOADER_AD_Image_BY_ID);
		return dataLoader.load(entity.getAD_Image_ID());
	}


	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public CompletableFuture<MProcess_BH> AD_Process(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_ID);
		return dataLoader.load(entity.getAD_Process_ID());
	}


	/**
	 * Get OS Task.
	 *
	 * @return Operation System Task
	 */
	public CompletableFuture<MTask> AD_Task(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Task_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTask> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TaskDataLoader.DATALOADER_AD_Task_BY_ID);
		return dataLoader.load(entity.getAD_Task_ID());
	}


	/**
	 * Get Workflow Block.
	 *
	 * @return Workflow Transaction Execution Block
	 */
	public CompletableFuture<X_AD_WF_Block> AD_WF_Block(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Block_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Block> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_BlockDataLoader.DATALOADER_AD_WF_Block_BY_ID);
		return dataLoader.load(entity.getAD_WF_Block_ID());
	}


	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public CompletableFuture<X_AD_WF_Node> AD_WF_Node(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Node_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Node> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_NodeDataLoader.DATALOADER_AD_WF_Node_BY_ID);
		return dataLoader.load(entity.getAD_WF_Node_ID());
	}


	/**
	 * Get Workflow Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	public CompletableFuture<X_AD_WF_Responsible> AD_WF_Responsible(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Responsible_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Responsible> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_ResponsibleDataLoader.DATALOADER_AD_WF_Responsible_BY_ID);
		return dataLoader.load(entity.getAD_WF_Responsible_ID());
	}


	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public CompletableFuture<MWindow> AD_Window(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.DATALOADER_AD_Window_BY_ID);
		return dataLoader.load(entity.getAD_Window_ID());
	}


	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public CompletableFuture<X_AD_Workflow> AD_Workflow(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workflow_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.DATALOADER_AD_Workflow_BY_ID);
		return dataLoader.load(entity.getAD_Workflow_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PP_Order_Node_TrlDataLoader.DATALOADER_PP_Order_Node_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(X_PP_Order_Node.COLUMNNAME_Description) :
						entity.getDescription());
	}

	public static Map<String, String> DOCACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("CO", "74a9fe55-28e4-4d3b-98aa-02ad6d1a12da"); // Complete
			put("AP", "f80665a4-0db1-4609-be56-5d69b762d169"); // Approve
			put("RJ", "8fffbfd1-560a-4a78-9181-e5b76bbb3354"); // Reject
			put("PO", "0fe1c0e9-2ca1-48f2-837b-a4ff16c629d9"); // Post
			put("VO", "930f9be7-85bc-4002-83a6-fe4e1b8cfce3"); // Void
			put("CL", "d0a6de04-9c59-4d37-998d-f8070db820b0"); // Close
			put("RC", "597e3e98-f1cd-4157-885a-1fae6424a3a6"); // Reverse - Correct
			put("RA", "1a3904b9-86bc-4831-a4af-0281dcafa8f8"); // Reverse - Accrual
			put("IN", "69ff146b-fe0e-44a0-98d1-80b2f7958edf"); // Invalidate
			put("RE", "c8f55635-67a3-42ae-b626-2064acb2e260"); // Re-activate
			put("--", "ea523fb8-e21b-4a77-a657-6f5a7d12a591"); // <None>
			put("PR", "b6f04b4b-6034-4490-83ed-d0f4f9cb5f76"); // Prepare
			put("XL", "b2d93bde-a7e7-43f0-9b1c-82527992f6d5"); // Unlock
			put("WC", "2143c53d-f6a6-4da6-8fe6-4ce4b6dacac0"); // Wait Complete
		}
	};
	public CompletableFuture<MRefList_BH> DocAction(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCACTION_UUIDS_BY_VALUE.get(entity.getDocAction()));
	}

	public static Map<String, String> DOCSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DR", "d27f8a6b-e8b5-4fea-a6b2-3e7049c473ec"); // Drafted
			put("CO", "50702660-bbfc-422a-8acc-5ed3a2dce204"); // Completed
			put("AP", "a838dad1-b7fc-4b26-9d80-d45f2d8484c5"); // Approved
			put("NA", "c8c414ee-3e4e-480b-aa0e-bc6c1d100bd2"); // Not Approved
			put("VO", "d35dfd1d-1eb2-46ef-ab2f-23973d68a570"); // Voided
			put("IN", "c2d506ba-1916-4ca2-abde-da3127c11d77"); // Invalid
			put("RE", "029a78cf-d45c-4fb2-a6c9-fb92c2311af6"); // Reversed
			put("CL", "ab9df095-8aa8-4338-98b6-4b09ab9d459e"); // Closed
			put("??", "0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2"); // Unknown
			put("IP", "9f864275-6135-452f-a5a7-9377d9ed32bc"); // In Progress
			put("WP", "4a9871d9-ec70-489f-aca5-05adb7e61df9"); // Waiting Payment
			put("WC", "56264c44-b530-4a53-b07b-6fb203ff61a6"); // Waiting Confirmation
		}
	};
	public CompletableFuture<MRefList_BH> DocStatus(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCSTATUS_UUIDS_BY_VALUE.get(entity.getDocStatus()));
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
	public CompletableFuture<MEntityType> AD_EntityType(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	public static Map<String, String> FINISHMODE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "75f0266b-88f1-409c-bbab-a6e3aac2ed6a"); // Automatic
			put("M", "4c311a91-6f6e-47c0-9e48-cce7b415044f"); // Manual
		}
	};
	public CompletableFuture<MRefList_BH> FinishMode(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFinishMode())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FINISHMODE_UUIDS_BY_VALUE.get(entity.getFinishMode()));
	}

	/**
	 * Get Comment/Help.
	 *
	 * @return Comment or Hint
	 */
	public CompletableFuture<String> Help(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getHelp);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PP_Order_Node_TrlDataLoader.DATALOADER_PP_Order_Node_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(X_PP_Order_Node.COLUMNNAME_Help) :
						entity.getHelp());
	}

	public Boolean IsCentrallyMaintained(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		return entity.isCentrallyMaintained();
	}

	public Boolean IsMilestone(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		return entity.isMilestone();
	}

	public Boolean IsSubcontracting(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		return entity.isSubcontracting();
	}

	public static Map<String, String> JOINELEMENT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "7d07cf62-b385-4d2d-a596-27ce10dd3726"); // AND
			put("X", "6b126336-1c5b-4970-b68b-671585e2fb95"); // XOR
		}
	};
	public CompletableFuture<MRefList_BH> JoinElement(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getJoinElement())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(JOINELEMENT_UUIDS_BY_VALUE.get(entity.getJoinElement()));
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PP_Order_Node_TrlDataLoader.DATALOADER_PP_Order_Node_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(X_PP_Order_Node.COLUMNNAME_Name) :
						entity.getName());
	}


	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	public CompletableFuture<X_PP_Order> PP_Order(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_PP_Order> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_OrderDataLoader.DATALOADER_PP_Order_BY_ID);
		return dataLoader.load(entity.getPP_Order_ID());
	}


	/**
	 * Get Manufacturing Order Workflow.
	 *
	 * @return Manufacturing Order Workflow
	 */
	public CompletableFuture<X_PP_Order_Workflow> PP_Order_Workflow(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_Workflow_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_PP_Order_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Order_WorkflowDataLoader.DATALOADER_PP_Order_Workflow_BY_ID);
		return dataLoader.load(entity.getPP_Order_Workflow_ID());
	}


	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public CompletableFuture<MResource> S_Resource(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getS_Resource_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MResource> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ResourceDataLoader.DATALOADER_S_Resource_BY_ID);
		return dataLoader.load(entity.getS_Resource_ID());
	}

	public static Map<String, String> SPLITELEMENT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "7d07cf62-b385-4d2d-a596-27ce10dd3726"); // AND
			put("X", "6b126336-1c5b-4970-b68b-671585e2fb95"); // XOR
		}
	};
	public CompletableFuture<MRefList_BH> SplitElement(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getSplitElement())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(SPLITELEMENT_UUIDS_BY_VALUE.get(entity.getSplitElement()));
	}

	public static Map<String, String> STARTMODE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "75f0266b-88f1-409c-bbab-a6e3aac2ed6a"); // Automatic
			put("M", "4c311a91-6f6e-47c0-9e48-cce7b415044f"); // Manual
		}
	};
	public CompletableFuture<MRefList_BH> StartMode(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getStartMode())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(STARTMODE_UUIDS_BY_VALUE.get(entity.getStartMode()));
	}

	public static Map<String, String> SUBFLOWEXECUTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "87643e66-85b7-497e-840a-ed604d269801"); // Asynchronously
			put("S", "1583b819-da0c-4fdf-99e6-4567b756ac56"); // Synchronously
		}
	};
	public CompletableFuture<MRefList_BH> SubflowExecution(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getSubflowExecution())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(SUBFLOWEXECUTION_UUIDS_BY_VALUE.get(entity.getSubflowExecution()));
	}


	/**
	 * Get Workflow.
	 *
	 * @return Workflow or tasks
	 */
	public CompletableFuture<X_AD_Workflow> Workflow(X_PP_Order_Node entity, DataFetchingEnvironment environment) {
		if (entity.getWorkflow_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.DATALOADER_AD_Workflow_BY_ID);
		return dataLoader.load(entity.getWorkflow_ID());
	}

}
