package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_CtxHelpDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FormDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoWindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TaskDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_BlockDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_Node_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ResponsibleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_MailTextDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MCtxHelp;
import org.compiere.model.MEntityType;
import org.compiere.model.MForm;
import org.compiere.model.MImage;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MMailText;
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

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_WF_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_WF_NodeResolver extends POResolver<X_AD_WF_Node> implements GraphQLResolver<X_AD_WF_Node> {


	static Map<String, String> ACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Z", "8ef4a18d-9f67-434b-8f83-067fade09bc8");
			put("C", "59eede55-ead5-4a13-96c5-e0a712afff81");
			put("F", "88a81162-95de-4ec6-b100-a283296be057");
			put("V", "f8b72207-17c2-4ecf-9cd4-50a16758a17e");
			put("W", "73a291eb-e6ec-4708-9f26-2fb95c1d417b");
			put("X", "fd67ca8e-2076-4ba0-9607-2fcafba2eded");
			put("T", "5195d723-cadc-4c3e-95b4-32d8df931ac6");
			put("R", "221219e5-eed5-46bb-903b-87870578ca32");
			put("P", "15681176-2ff7-4433-8eef-47048a97b2c1");
			put("D", "ca24d80e-62d2-48de-b00a-0834a7dc1317");
			put("M", "0ceb65e4-9e53-4ffb-a320-5d0d52865d41");
			put("B", "f95b359f-f513-4525-9e53-5772f3d60d0b");
			put("I", "eaf4fa91-3fa3-47f9-9b7f-6ac5b475da68");
		}
	};
	public CompletableFuture<MRefList_BH> Action(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ACTION_UUIDS_BY_VALUE.get(entity.getAction()));
	}


	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Context Help.
	 *
	 * @return Context Help
	 */
	public CompletableFuture<MCtxHelp> AD_CtxHelp(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_CtxHelp_ID() <= 0) {
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
	public CompletableFuture<MForm> AD_Form(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Form_ID() <= 0) {
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
	public CompletableFuture<MImage> AD_Image(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Image_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MImage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImageDataLoader.DATALOADER_AD_Image_BY_ID);
		return dataLoader.load(entity.getAD_Image_ID());
	}


	/**
	 * Get Info Window.
	 *
	 * @return Info and search/select Window
	 */
	public CompletableFuture<MInfoWindow> AD_InfoWindow(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_InfoWindow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInfoWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_InfoWindowDataLoader.DATALOADER_AD_InfoWindow_BY_ID);
		return dataLoader.load(entity.getAD_InfoWindow_ID());
	}


	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public CompletableFuture<MProcess_BH> AD_Process(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_ID() <= 0) {
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
	public CompletableFuture<MTask> AD_Task(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Task_ID() <= 0) {
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
	public CompletableFuture<X_AD_WF_Block> AD_WF_Block(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Block_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Block> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_BlockDataLoader.DATALOADER_AD_WF_Block_BY_ID);
		return dataLoader.load(entity.getAD_WF_Block_ID());
	}


	/**
	 * Get Workflow Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	public CompletableFuture<X_AD_WF_Responsible> AD_WF_Responsible(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Responsible_ID() <= 0) {
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
	public CompletableFuture<MWindow> AD_Window(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() <= 0) {
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
	public CompletableFuture<X_AD_Workflow> AD_Workflow(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workflow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.DATALOADER_AD_Workflow_BY_ID);
		return dataLoader.load(entity.getAD_Workflow_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
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
	public CompletableFuture<String> Description(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WF_Node_TrlDataLoader.DATALOADER_AD_WF_Node_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_AD_WF_Node.COLUMNNAME_Description));
	}

	static Map<String, String> DOCACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("CO", "74a9fe55-28e4-4d3b-98aa-02ad6d1a12da");
			put("AP", "f80665a4-0db1-4609-be56-5d69b762d169");
			put("RJ", "8fffbfd1-560a-4a78-9181-e5b76bbb3354");
			put("PO", "0fe1c0e9-2ca1-48f2-837b-a4ff16c629d9");
			put("VO", "930f9be7-85bc-4002-83a6-fe4e1b8cfce3");
			put("CL", "d0a6de04-9c59-4d37-998d-f8070db820b0");
			put("RC", "597e3e98-f1cd-4157-885a-1fae6424a3a6");
			put("RA", "1a3904b9-86bc-4831-a4af-0281dcafa8f8");
			put("IN", "69ff146b-fe0e-44a0-98d1-80b2f7958edf");
			put("RE", "c8f55635-67a3-42ae-b626-2064acb2e260");
			put("--", "ea523fb8-e21b-4a77-a657-6f5a7d12a591");
			put("PR", "b6f04b4b-6034-4490-83ed-d0f4f9cb5f76");
			put("XL", "b2d93bde-a7e7-43f0-9b1c-82527992f6d5");
			put("WC", "2143c53d-f6a6-4da6-8fe6-4ce4b6dacac0");
		}
	};
	public CompletableFuture<MRefList_BH> DocAction(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(DOCACTION_UUIDS_BY_VALUE.get(entity.getDocAction()));
	}

	static Map<String, String> DYNPRIORITYUNIT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("M", "80320e2a-1a3c-462f-9af1-09c0af1aab5f");
			put("H", "817d1ba9-4dbe-4105-8ca5-61cf554ac837");
			put("D", "6360c9c7-dbf3-4b2f-bd8b-3465a7fde7a7");
		}
	};
	public CompletableFuture<MRefList_BH> DynPriorityUnit(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDynPriorityUnit())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(DYNPRIORITYUNIT_UUIDS_BY_VALUE.get(entity.getDynPriorityUnit()));
	}

	static Map<String, String> EMAILRECIPIENT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("D", "2cd91171-9693-4710-9b92-b1f7f6660d07");
			put("B", "e8012ebf-8ec4-4e0d-99c7-1fe01cfd629f");
			put("R", "baf88c37-8379-4722-b228-b1b15858ea00");
		}
	};
	public CompletableFuture<MRefList_BH> EMailRecipient(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEMailRecipient())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(EMAILRECIPIENT_UUIDS_BY_VALUE.get(entity.getEMailRecipient()));
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
	public CompletableFuture<MEntityType> AD_EntityType(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	static Map<String, String> FINISHMODE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "75f0266b-88f1-409c-bbab-a6e3aac2ed6a");
			put("M", "4c311a91-6f6e-47c0-9e48-cce7b415044f");
		}
	};
	public CompletableFuture<MRefList_BH> FinishMode(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFinishMode())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(FINISHMODE_UUIDS_BY_VALUE.get(entity.getFinishMode()));
	}

	/**
	 * Get Comment/Help.
	 *
	 * @return Comment or Hint
	 */
	public CompletableFuture<String> Help(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getHelp);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WF_Node_TrlDataLoader.DATALOADER_AD_WF_Node_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_AD_WF_Node.COLUMNNAME_Help));
	}

	public Boolean IsCentrallyMaintained(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		return entity.isCentrallyMaintained();
	}

	public Boolean IsMilestone(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		return entity.isMilestone();
	}

	public Boolean IsSubcontracting(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		return entity.isSubcontracting();
	}

	static Map<String, String> JOINELEMENT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "7d07cf62-b385-4d2d-a596-27ce10dd3726");
			put("X", "6b126336-1c5b-4970-b68b-671585e2fb95");
		}
	};
	public CompletableFuture<MRefList_BH> JoinElement(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getJoinElement())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(JOINELEMENT_UUIDS_BY_VALUE.get(entity.getJoinElement()));
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WF_Node_TrlDataLoader.DATALOADER_AD_WF_Node_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_AD_WF_Node.COLUMNNAME_Name));
	}


	/**
	 * Get Mail Template.
	 *
	 * @return Text templates for mailings
	 */
	public CompletableFuture<MMailText> R_MailText(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getR_MailText_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMailText> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_MailTextDataLoader.DATALOADER_R_MailText_BY_ID);
		return dataLoader.load(entity.getR_MailText_ID());
	}


	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public CompletableFuture<MResource> S_Resource(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getS_Resource_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MResource> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ResourceDataLoader.DATALOADER_S_Resource_BY_ID);
		return dataLoader.load(entity.getS_Resource_ID());
	}

	static Map<String, String> SPLITELEMENT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "7d07cf62-b385-4d2d-a596-27ce10dd3726");
			put("X", "6b126336-1c5b-4970-b68b-671585e2fb95");
		}
	};
	public CompletableFuture<MRefList_BH> SplitElement(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getSplitElement())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(SPLITELEMENT_UUIDS_BY_VALUE.get(entity.getSplitElement()));
	}

	static Map<String, String> STARTMODE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "75f0266b-88f1-409c-bbab-a6e3aac2ed6a");
			put("M", "4c311a91-6f6e-47c0-9e48-cce7b415044f");
		}
	};
	public CompletableFuture<MRefList_BH> StartMode(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getStartMode())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(STARTMODE_UUIDS_BY_VALUE.get(entity.getStartMode()));
	}

	static Map<String, String> SUBFLOWEXECUTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "87643e66-85b7-497e-840a-ed604d269801");
			put("S", "1583b819-da0c-4fdf-99e6-4567b756ac56");
		}
	};
	public CompletableFuture<MRefList_BH> SubflowExecution(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getSubflowExecution())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(SUBFLOWEXECUTION_UUIDS_BY_VALUE.get(entity.getSubflowExecution()));
	}


	/**
	 * Get Workflow.
	 *
	 * @return Workflow or tasks
	 */
	public CompletableFuture<X_AD_Workflow> Workflow(X_AD_WF_Node entity, DataFetchingEnvironment environment) {
		if (entity.getWorkflow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.DATALOADER_AD_Workflow_BY_ID);
		return dataLoader.load(entity.getWorkflow_ID());
	}

}
