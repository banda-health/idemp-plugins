package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MEntityType;
import org.compiere.model.MForm;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.MResource;
import org.compiere.model.MTask;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Block;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WF_Responsible;
import org.compiere.model.X_AD_Workflow;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_Node;
import org.eevolution.model.X_PP_Order_Workflow;

import java.sql.ResultSet;

/**
 * Generated Model for PP_Order_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_NodeInput extends X_PP_Order_Node implements I_PP_Order_NodeInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Form;
	private ForeignEntityInput mAD_Image;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process;
	private ForeignEntityInput mAD_Task;
	private ForeignEntityInput mAD_WF_Block;
	private ForeignEntityInput mAD_WF_Node;
	private ForeignEntityInput mAD_WF_Responsible;
	private ForeignEntityInput mAD_Window;
	private ForeignEntityInput mAD_Workflow;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mPP_Order;
	private ForeignEntityInput mPP_Order_Workflow;
	private ForeignEntityInput mS_Resource;
	private ForeignEntityInput mWorkflow;
	private I_AD_Ref_ListInput mAction;
	private I_AD_Ref_ListInput mDocAction;
	private I_AD_Ref_ListInput mDocStatus;
	private I_AD_Ref_ListInput mFinishMode;
	private I_AD_Ref_ListInput mJoinElement;
	private I_AD_Ref_ListInput mSplitElement;
	private I_AD_Ref_ListInput mStartMode;
	private I_AD_Ref_ListInput mSubflowExecution;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PP_Order_NodeInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_PP_Order_Node(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Action.
	 *
	 * @param Action Indicates the Action to be performed
	 */
	@JsonProperty("Action")
	public void setActionInput(I_AD_Ref_ListInput Action) {
		this.mAction = Action;
		MRefList_BH foreignEntity;
		if (Action != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Action.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAction(foreignEntity.getValue());
		} else {
			this.setAction(null);
		}
	}

	/**
	 * Get Action.
	 *
	 * @return Indicates the Action to be performed
	 */
	@JsonProperty("Action")
	public I_AD_Ref_ListInput Action() {
		return mAction;
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	@JsonProperty("AD_Column")
	public void setAD_ColumnInput(ForeignEntityInput AD_Column) {
		this.mAD_Column = AD_Column;
		MColumn foreignEntity;
		if (AD_Column != null &&
				(foreignEntity = new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
						.setParameters(AD_Column.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Column_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Column_ID(0);
		}
	}

	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	@JsonProperty("AD_Column")
	public ForeignEntityInput AD_Column() {
		return mAD_Column;
	}

	/**
	 * Set Special Form.
	 *
	 * @param AD_Form Special Form
	 */
	@JsonProperty("AD_Form")
	public void setAD_FormInput(ForeignEntityInput AD_Form) {
		this.mAD_Form = AD_Form;
		MForm foreignEntity;
		if (AD_Form != null &&
				(foreignEntity = new Query(getCtx(), "AD_Form", "AD_Form_UU=?", get_TrxName())
						.setParameters(AD_Form.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Form_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Form_ID(0);
		}
	}

	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	@JsonProperty("AD_Form")
	public ForeignEntityInput AD_Form() {
		return mAD_Form;
	}

	/**
	 * Set Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	@JsonProperty("AD_Image")
	public void setAD_ImageInput(ForeignEntityInput AD_Image) {
		this.mAD_Image = AD_Image;
		MImage foreignEntity;
		if (AD_Image != null &&
				(foreignEntity = new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
						.setParameters(AD_Image.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Image_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Image_ID(0);
		}
	}

	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	@JsonProperty("AD_Image")
	public ForeignEntityInput AD_Image() {
		return mAD_Image;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Process.
	 *
	 * @param AD_Process Process or Report
	 */
	@JsonProperty("AD_Process")
	public void setAD_ProcessInput(ForeignEntityInput AD_Process) {
		this.mAD_Process = AD_Process;
		MProcess_BH foreignEntity;
		if (AD_Process != null &&
				(foreignEntity = new Query(getCtx(), "AD_Process", "AD_Process_UU=?", get_TrxName())
						.setParameters(AD_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Process_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Process_ID(0);
		}
	}

	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	@JsonProperty("AD_Process")
	public ForeignEntityInput AD_Process() {
		return mAD_Process;
	}

	/**
	 * Set OS Task.
	 *
	 * @param AD_Task Operation System Task
	 */
	@JsonProperty("AD_Task")
	public void setAD_TaskInput(ForeignEntityInput AD_Task) {
		this.mAD_Task = AD_Task;
		MTask foreignEntity;
		if (AD_Task != null &&
				(foreignEntity = new Query(getCtx(), "AD_Task", "AD_Task_UU=?", get_TrxName())
						.setParameters(AD_Task.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Task_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Task_ID(0);
		}
	}

	/**
	 * Get OS Task.
	 *
	 * @return Operation System Task
	 */
	@JsonProperty("AD_Task")
	public ForeignEntityInput AD_Task() {
		return mAD_Task;
	}

	/**
	 * Set Workflow Block.
	 *
	 * @param AD_WF_Block Workflow Transaction Execution Block
	 */
	@JsonProperty("AD_WF_Block")
	public void setAD_WF_BlockInput(ForeignEntityInput AD_WF_Block) {
		this.mAD_WF_Block = AD_WF_Block;
		X_AD_WF_Block foreignEntity;
		if (AD_WF_Block != null &&
				(foreignEntity = new Query(getCtx(), "AD_WF_Block", "AD_WF_Block_UU=?", get_TrxName())
						.setParameters(AD_WF_Block.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WF_Block_ID(foreignEntity.get_ID());
		} else {
			super.setAD_WF_Block_ID(0);
		}
	}

	/**
	 * Get Workflow Block.
	 *
	 * @return Workflow Transaction Execution Block
	 */
	@JsonProperty("AD_WF_Block")
	public ForeignEntityInput AD_WF_Block() {
		return mAD_WF_Block;
	}

	/**
	 * Set Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	@JsonProperty("AD_WF_Node")
	public void setAD_WF_NodeInput(ForeignEntityInput AD_WF_Node) {
		this.mAD_WF_Node = AD_WF_Node;
		X_AD_WF_Node foreignEntity;
		if (AD_WF_Node != null &&
				(foreignEntity = new Query(getCtx(), "AD_WF_Node", "AD_WF_Node_UU=?", get_TrxName())
						.setParameters(AD_WF_Node.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WF_Node_ID(foreignEntity.get_ID());
		} else {
			super.setAD_WF_Node_ID(0);
		}
	}

	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	@JsonProperty("AD_WF_Node")
	public ForeignEntityInput AD_WF_Node() {
		return mAD_WF_Node;
	}

	/**
	 * Set Workflow Responsible.
	 *
	 * @param AD_WF_Responsible Responsible for Workflow Execution
	 */
	@JsonProperty("AD_WF_Responsible")
	public void setAD_WF_ResponsibleInput(ForeignEntityInput AD_WF_Responsible) {
		this.mAD_WF_Responsible = AD_WF_Responsible;
		X_AD_WF_Responsible foreignEntity;
		if (AD_WF_Responsible != null &&
				(foreignEntity = new Query(getCtx(), "AD_WF_Responsible", "AD_WF_Responsible_UU=?", get_TrxName())
						.setParameters(AD_WF_Responsible.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WF_Responsible_ID(foreignEntity.get_ID());
		} else {
			super.setAD_WF_Responsible_ID(0);
		}
	}

	/**
	 * Get Workflow Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	@JsonProperty("AD_WF_Responsible")
	public ForeignEntityInput AD_WF_Responsible() {
		return mAD_WF_Responsible;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public void setAD_WindowInput(ForeignEntityInput AD_Window) {
		this.mAD_Window = AD_Window;
		MWindow foreignEntity;
		if (AD_Window != null &&
				(foreignEntity = new Query(getCtx(), "AD_Window", "AD_Window_UU=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Window_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public ForeignEntityInput AD_Window() {
		return mAD_Window;
	}

	/**
	 * Set Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	@JsonProperty("AD_Workflow")
	public void setAD_WorkflowInput(ForeignEntityInput AD_Workflow) {
		this.mAD_Workflow = AD_Workflow;
		X_AD_Workflow foreignEntity;
		if (AD_Workflow != null &&
				(foreignEntity = new Query(getCtx(), "AD_Workflow", "AD_Workflow_UU=?", get_TrxName())
						.setParameters(AD_Workflow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Workflow_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Workflow_ID(0);
		}
	}

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	@JsonProperty("AD_Workflow")
	public ForeignEntityInput AD_Workflow() {
		return mAD_Workflow;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(I_AD_Ref_ListInput DocAction) {
		this.mDocAction = DocAction;
		MRefList_BH foreignEntity;
		if (DocAction != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocAction.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocAction(foreignEntity.getValue());
		} else {
			this.setDocAction(null);
		}
	}

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public I_AD_Ref_ListInput DocAction() {
		return mDocAction;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus The current status of the document
	 */
	@JsonProperty("DocStatus")
	public void setDocStatusInput(I_AD_Ref_ListInput DocStatus) {
		this.mDocStatus = DocStatus;
		MRefList_BH foreignEntity;
		if (DocStatus != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocStatus.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocStatus(foreignEntity.getValue());
		} else {
			this.setDocStatus(null);
		}
	}

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	@JsonProperty("DocStatus")
	public I_AD_Ref_ListInput DocStatus() {
		return mDocStatus;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEntityType(foreignEntity.getEntityType());
		} else {
			super.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set Finish Mode.
	 *
	 * @param FinishMode Workflow Activity Finish Mode
	 */
	@JsonProperty("FinishMode")
	public void setFinishModeInput(I_AD_Ref_ListInput FinishMode) {
		this.mFinishMode = FinishMode;
		MRefList_BH foreignEntity;
		if (FinishMode != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FinishMode.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFinishMode(foreignEntity.getValue());
		} else {
			this.setFinishMode(null);
		}
	}

	/**
	 * Get Finish Mode.
	 *
	 * @return Workflow Activity Finish Mode
	 */
	@JsonProperty("FinishMode")
	public I_AD_Ref_ListInput FinishMode() {
		return mFinishMode;
	}

	/**
	 * Set Join Element.
	 *
	 * @param JoinElement Semantics for multiple incoming Transitions
	 */
	@JsonProperty("JoinElement")
	public void setJoinElementInput(I_AD_Ref_ListInput JoinElement) {
		this.mJoinElement = JoinElement;
		MRefList_BH foreignEntity;
		if (JoinElement != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(JoinElement.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setJoinElement(foreignEntity.getValue());
		} else {
			this.setJoinElement(null);
		}
	}

	/**
	 * Get Join Element.
	 *
	 * @return Semantics for multiple incoming Transitions
	 */
	@JsonProperty("JoinElement")
	public I_AD_Ref_ListInput JoinElement() {
		return mJoinElement;
	}

	/**
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public void setPP_OrderInput(ForeignEntityInput PP_Order) {
		this.mPP_Order = PP_Order;
		X_PP_Order foreignEntity;
		if (get_ID() == 0 && PP_Order != null &&
				(foreignEntity = new Query(getCtx(), "PP_Order", "PP_Order_UU=?", get_TrxName())
						.setParameters(PP_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPP_Order_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public ForeignEntityInput PP_Order() {
		return mPP_Order;
	}
	/**
	 * Set Manufacturing Order Activity.
	 *
	 * @param PP_Order_Node_ID Workflow Node (activity), step or process
	 */

	public void setPP_Order_Node_ID(int PP_Order_Node_ID) {
		if (get_ID() == 0) {
			super.setPP_Order_Node_ID(PP_Order_Node_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPP_Order_Node_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPP_Order_Node_UU();
	}

	/**
	 * Set Manufacturing Order Workflow.
	 *
	 * @param PP_Order_Workflow Manufacturing Order Workflow
	 */
	@JsonProperty("PP_Order_Workflow")
	public void setPP_Order_WorkflowInput(ForeignEntityInput PP_Order_Workflow) {
		this.mPP_Order_Workflow = PP_Order_Workflow;
		X_PP_Order_Workflow foreignEntity;
		if (get_ID() == 0 && PP_Order_Workflow != null &&
				(foreignEntity = new Query(getCtx(), "PP_Order_Workflow", "PP_Order_Workflow_UU=?", get_TrxName())
						.setParameters(PP_Order_Workflow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPP_Order_Workflow_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Manufacturing Order Workflow.
	 *
	 * @return Manufacturing Order Workflow
	 */
	@JsonProperty("PP_Order_Workflow")
	public ForeignEntityInput PP_Order_Workflow() {
		return mPP_Order_Workflow;
	}

	/**
	 * Set Resource.
	 *
	 * @param S_Resource Resource
	 */
	@JsonProperty("S_Resource")
	public void setS_ResourceInput(ForeignEntityInput S_Resource) {
		this.mS_Resource = S_Resource;
		MResource foreignEntity;
		if (S_Resource != null &&
				(foreignEntity = new Query(getCtx(), "S_Resource", "S_Resource_UU=?", get_TrxName())
						.setParameters(S_Resource.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setS_Resource_ID(foreignEntity.get_ID());
		} else {
			super.setS_Resource_ID(0);
		}
	}

	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	@JsonProperty("S_Resource")
	public ForeignEntityInput S_Resource() {
		return mS_Resource;
	}

	/**
	 * Set Split Element.
	 *
	 * @param SplitElement Semantics for multiple outgoing Transitions
	 */
	@JsonProperty("SplitElement")
	public void setSplitElementInput(I_AD_Ref_ListInput SplitElement) {
		this.mSplitElement = SplitElement;
		MRefList_BH foreignEntity;
		if (SplitElement != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(SplitElement.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setSplitElement(foreignEntity.getValue());
		} else {
			this.setSplitElement(null);
		}
	}

	/**
	 * Get Split Element.
	 *
	 * @return Semantics for multiple outgoing Transitions
	 */
	@JsonProperty("SplitElement")
	public I_AD_Ref_ListInput SplitElement() {
		return mSplitElement;
	}

	/**
	 * Set Start Mode.
	 *
	 * @param StartMode Workflow Activity Start Mode 
	 */
	@JsonProperty("StartMode")
	public void setStartModeInput(I_AD_Ref_ListInput StartMode) {
		this.mStartMode = StartMode;
		MRefList_BH foreignEntity;
		if (StartMode != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(StartMode.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setStartMode(foreignEntity.getValue());
		} else {
			this.setStartMode(null);
		}
	}

	/**
	 * Get Start Mode.
	 *
	 * @return Workflow Activity Start Mode 
	 */
	@JsonProperty("StartMode")
	public I_AD_Ref_ListInput StartMode() {
		return mStartMode;
	}

	/**
	 * Set Subflow Execution.
	 *
	 * @param SubflowExecution Mode how the sub-workflow is executed
	 */
	@JsonProperty("SubflowExecution")
	public void setSubflowExecutionInput(I_AD_Ref_ListInput SubflowExecution) {
		this.mSubflowExecution = SubflowExecution;
		MRefList_BH foreignEntity;
		if (SubflowExecution != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(SubflowExecution.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setSubflowExecution(foreignEntity.getValue());
		} else {
			this.setSubflowExecution(null);
		}
	}

	/**
	 * Get Subflow Execution.
	 *
	 * @return Mode how the sub-workflow is executed
	 */
	@JsonProperty("SubflowExecution")
	public I_AD_Ref_ListInput SubflowExecution() {
		return mSubflowExecution;
	}

	/**
	 * Set Workflow.
	 *
	 * @param Workflow Workflow or tasks
	 */
	@JsonProperty("Workflow")
	public void setWorkflowInput(ForeignEntityInput Workflow) {
		this.mWorkflow = Workflow;
		X_AD_Workflow foreignEntity;
		if (Workflow != null &&
				(foreignEntity = new Query(getCtx(), "AD_Workflow", "AD_Workflow_UU=?", get_TrxName())
						.setParameters(Workflow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setWorkflow_ID(foreignEntity.get_ID());
		} else {
			super.setWorkflow_ID(0);
		}
	}

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or tasks
	 */
	@JsonProperty("Workflow")
	public ForeignEntityInput Workflow() {
		return mWorkflow;
	}
}
