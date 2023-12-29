package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MEntityType;
import org.compiere.model.MForm;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MResource;
import org.compiere.model.MTask;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Block;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WF_Responsible;
import org.compiere.model.X_AD_Workflow;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_Node;
import org.eevolution.model.X_PP_Order_Workflow;

/**
 * Generated Model for PP_Order_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_NodeInput extends X_PP_Order_Node implements I_PP_Order_NodeInput {

	 private I_AD_ColumnInput AD_Column;
	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_FormInput AD_Form;
	 private I_AD_ImageInput AD_Image;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_ProcessInput AD_Process;
	 private I_AD_Ref_ListInput Action_RL;
	 private I_AD_Ref_ListInput DocAction_RL;
	 private I_AD_Ref_ListInput DocStatus_RL;
	 private I_AD_Ref_ListInput FinishMode_RL;
	 private I_AD_Ref_ListInput JoinElement_RL;
	 private I_AD_Ref_ListInput SplitElement_RL;
	 private I_AD_Ref_ListInput StartMode_RL;
	 private I_AD_Ref_ListInput SubflowExecution_RL;
	 private I_AD_TaskInput AD_Task;
	 private I_AD_WF_BlockInput AD_WF_Block;
	 private I_AD_WF_NodeInput AD_WF_Node;
	 private I_AD_WF_ResponsibleInput AD_WF_Responsible;
	 private I_AD_WindowInput AD_Window;
	 private I_AD_WorkflowInput AD_Workflow;
	 private I_AD_WorkflowInput Workflow;
	 private I_C_BPartnerInput C_BPartner;
	 private I_PP_OrderInput PP_Order;
	 private I_PP_Order_WorkflowInput PP_Order_Workflow;
	 private I_S_ResourceInput S_Resource;

	/**
	 * Standard constructor
	 */
	public X_PP_Order_NodeInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Action.
	 *
	 * @param Action_RL Indicates the Action to be performed
	 */
	public void setAction_RL(I_AD_Ref_ListInput Action_RL) {
		this.Action_RL = Action_RL;
		MRefList foreignEntity;
		if (Action_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Action_RL.getID())
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
	public I_AD_Ref_ListInput getAction_RL() {
		return Action_RL;
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	public void setAD_Column(I_AD_ColumnInput AD_Column) {
		this.AD_Column = AD_Column;
		MColumn foreignEntity;
		if (AD_Column != null &&
				(foreignEntity = new Query(getCtx(), MColumn.Table_Name, MColumn.COLUMNNAME_AD_Column_UU + "=?", get_TrxName())
						.setParameters(AD_Column.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Column_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Column_ID(0);
		}
	}

	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public I_AD_ColumnInput getAD_Column() {
		return AD_Column;
	}

	/**
	 * Set Special Form.
	 *
	 * @param AD_Form Special Form
	 */
	public void setAD_Form(I_AD_FormInput AD_Form) {
		this.AD_Form = AD_Form;
		MForm foreignEntity;
		if (AD_Form != null &&
				(foreignEntity = new Query(getCtx(), MForm.Table_Name, MForm.COLUMNNAME_AD_Form_UU + "=?", get_TrxName())
						.setParameters(AD_Form.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Form_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Form_ID(0);
		}
	}

	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	public I_AD_FormInput getAD_Form() {
		return AD_Form;
	}

	/**
	 * Set Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	public void setAD_Image(I_AD_ImageInput AD_Image) {
		this.AD_Image = AD_Image;
		MImage foreignEntity;
		if (AD_Image != null &&
				(foreignEntity = new Query(getCtx(), MImage.Table_Name, MImage.COLUMNNAME_AD_Image_UU + "=?", get_TrxName())
						.setParameters(AD_Image.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Image_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Image_ID(0);
		}
	}

	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	public I_AD_ImageInput getAD_Image() {
		return AD_Image;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Process.
	 *
	 * @param AD_Process Process or Report
	 */
	public void setAD_Process(I_AD_ProcessInput AD_Process) {
		this.AD_Process = AD_Process;
		MProcess_BH foreignEntity;
		if (AD_Process != null &&
				(foreignEntity = new Query(getCtx(), MProcess_BH.Table_Name, MProcess_BH.COLUMNNAME_AD_Process_UU + "=?", get_TrxName())
						.setParameters(AD_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Process_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Process_ID(0);
		}
	}

	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public I_AD_ProcessInput getAD_Process() {
		return AD_Process;
	}

	/**
	 * Set OS Task.
	 *
	 * @param AD_Task Operation System Task
	 */
	public void setAD_Task(I_AD_TaskInput AD_Task) {
		this.AD_Task = AD_Task;
		MTask foreignEntity;
		if (AD_Task != null &&
				(foreignEntity = new Query(getCtx(), MTask.Table_Name, MTask.COLUMNNAME_AD_Task_UU + "=?", get_TrxName())
						.setParameters(AD_Task.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Task_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Task_ID(0);
		}
	}

	/**
	 * Get OS Task.
	 *
	 * @return Operation System Task
	 */
	public I_AD_TaskInput getAD_Task() {
		return AD_Task;
	}

	/**
	 * Set Workflow Block.
	 *
	 * @param AD_WF_Block Workflow Transaction Execution Block
	 */
	public void setAD_WF_Block(I_AD_WF_BlockInput AD_WF_Block) {
		this.AD_WF_Block = AD_WF_Block;
		X_AD_WF_Block foreignEntity;
		if (AD_WF_Block != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Block.Table_Name, X_AD_WF_Block.COLUMNNAME_AD_WF_Block_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Block.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_WF_Block_ID(foreignEntity.get_ID());
		} else {
			this.setAD_WF_Block_ID(0);
		}
	}

	/**
	 * Get Workflow Block.
	 *
	 * @return Workflow Transaction Execution Block
	 */
	public I_AD_WF_BlockInput getAD_WF_Block() {
		return AD_WF_Block;
	}

	/**
	 * Set Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	public void setAD_WF_Node(I_AD_WF_NodeInput AD_WF_Node) {
		this.AD_WF_Node = AD_WF_Node;
		X_AD_WF_Node foreignEntity;
		if (AD_WF_Node != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Node.Table_Name, X_AD_WF_Node.COLUMNNAME_AD_WF_Node_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Node.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_WF_Node_ID(foreignEntity.get_ID());
		} else {
			this.setAD_WF_Node_ID(0);
		}
	}

	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public I_AD_WF_NodeInput getAD_WF_Node() {
		return AD_WF_Node;
	}

	/**
	 * Set Workflow Responsible.
	 *
	 * @param AD_WF_Responsible Responsible for Workflow Execution
	 */
	public void setAD_WF_Responsible(I_AD_WF_ResponsibleInput AD_WF_Responsible) {
		this.AD_WF_Responsible = AD_WF_Responsible;
		X_AD_WF_Responsible foreignEntity;
		if (AD_WF_Responsible != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Responsible.Table_Name, X_AD_WF_Responsible.COLUMNNAME_AD_WF_Responsible_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Responsible.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_WF_Responsible_ID(foreignEntity.get_ID());
		} else {
			this.setAD_WF_Responsible_ID(0);
		}
	}

	/**
	 * Get Workflow Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	public I_AD_WF_ResponsibleInput getAD_WF_Responsible() {
		return AD_WF_Responsible;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	public void setAD_Window(I_AD_WindowInput AD_Window) {
		this.AD_Window = AD_Window;
		MWindow foreignEntity;
		if (AD_Window != null &&
				(foreignEntity = new Query(getCtx(), MWindow.Table_Name, MWindow.COLUMNNAME_AD_Window_UU + "=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Window_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public I_AD_WindowInput getAD_Window() {
		return AD_Window;
	}

	/**
	 * Set Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	public void setAD_Workflow(I_AD_WorkflowInput AD_Workflow) {
		this.AD_Workflow = AD_Workflow;
		X_AD_Workflow foreignEntity;
		if (AD_Workflow != null &&
				(foreignEntity = new Query(getCtx(), X_AD_Workflow.Table_Name, X_AD_Workflow.COLUMNNAME_AD_Workflow_UU + "=?", get_TrxName())
						.setParameters(AD_Workflow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Workflow_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Workflow_ID(0);
		}
	}

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public I_AD_WorkflowInput getAD_Workflow() {
		return AD_Workflow;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction_RL The targeted status of the document
	 */
	public void setDocAction_RL(I_AD_Ref_ListInput DocAction_RL) {
		this.DocAction_RL = DocAction_RL;
		MRefList foreignEntity;
		if (DocAction_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocAction_RL.getID())
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
	public I_AD_Ref_ListInput getDocAction_RL() {
		return DocAction_RL;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus_RL The current status of the document
	 */
	public void setDocStatus_RL(I_AD_Ref_ListInput DocStatus_RL) {
		this.DocStatus_RL = DocStatus_RL;
		MRefList foreignEntity;
		if (DocStatus_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocStatus_RL.getID())
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
	public I_AD_Ref_ListInput getDocStatus_RL() {
		return DocStatus_RL;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	public void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType) {
		this.AD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEntityType(foreignEntity.get_ID());
		} else {
			this.setEntityType(0);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public I_AD_EntityTypeInput getAD_EntityType() {
		return AD_EntityType;
	}

	/**
	 * Set Finish Mode.
	 *
	 * @param FinishMode_RL Workflow Activity Finish Mode
	 */
	public void setFinishMode_RL(I_AD_Ref_ListInput FinishMode_RL) {
		this.FinishMode_RL = FinishMode_RL;
		MRefList foreignEntity;
		if (FinishMode_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FinishMode_RL.getID())
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
	public I_AD_Ref_ListInput getFinishMode_RL() {
		return FinishMode_RL;
	}

	/**
	 * Set Join Element.
	 *
	 * @param JoinElement_RL Semantics for multiple incoming Transitions
	 */
	public void setJoinElement_RL(I_AD_Ref_ListInput JoinElement_RL) {
		this.JoinElement_RL = JoinElement_RL;
		MRefList foreignEntity;
		if (JoinElement_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(JoinElement_RL.getID())
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
	public I_AD_Ref_ListInput getJoinElement_RL() {
		return JoinElement_RL;
	}

	/**
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	public void setPP_Order(I_PP_OrderInput PP_Order) {
		this.PP_Order = PP_Order;
		X_PP_Order foreignEntity;
		if (get_ID() == 0 &&PP_Order != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order.Table_Name, X_PP_Order.COLUMNNAME_PP_Order_UU + "=?", get_TrxName())
						.setParameters(PP_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPP_Order_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	public I_PP_OrderInput getPP_Order() {
		return PP_Order;
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
	public void setPP_Order_Workflow(I_PP_Order_WorkflowInput PP_Order_Workflow) {
		this.PP_Order_Workflow = PP_Order_Workflow;
		X_PP_Order_Workflow foreignEntity;
		if (get_ID() == 0 &&PP_Order_Workflow != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order_Workflow.Table_Name, X_PP_Order_Workflow.COLUMNNAME_PP_Order_Workflow_UU + "=?", get_TrxName())
						.setParameters(PP_Order_Workflow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPP_Order_Workflow_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Manufacturing Order Workflow.
	 *
	 * @return Manufacturing Order Workflow
	 */
	public I_PP_Order_WorkflowInput getPP_Order_Workflow() {
		return PP_Order_Workflow;
	}

	/**
	 * Set Resource.
	 *
	 * @param S_Resource Resource
	 */
	public void setS_Resource(I_S_ResourceInput S_Resource) {
		this.S_Resource = S_Resource;
		MResource foreignEntity;
		if (S_Resource != null &&
				(foreignEntity = new Query(getCtx(), MResource.Table_Name, MResource.COLUMNNAME_S_Resource_UU + "=?", get_TrxName())
						.setParameters(S_Resource.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setS_Resource_ID(foreignEntity.get_ID());
		} else {
			this.setS_Resource_ID(0);
		}
	}

	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public I_S_ResourceInput getS_Resource() {
		return S_Resource;
	}

	/**
	 * Set Split Element.
	 *
	 * @param SplitElement_RL Semantics for multiple outgoing Transitions
	 */
	public void setSplitElement_RL(I_AD_Ref_ListInput SplitElement_RL) {
		this.SplitElement_RL = SplitElement_RL;
		MRefList foreignEntity;
		if (SplitElement_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(SplitElement_RL.getID())
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
	public I_AD_Ref_ListInput getSplitElement_RL() {
		return SplitElement_RL;
	}

	/**
	 * Set Start Mode.
	 *
	 * @param StartMode_RL Workflow Activity Start Mode 
	 */
	public void setStartMode_RL(I_AD_Ref_ListInput StartMode_RL) {
		this.StartMode_RL = StartMode_RL;
		MRefList foreignEntity;
		if (StartMode_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(StartMode_RL.getID())
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
	public I_AD_Ref_ListInput getStartMode_RL() {
		return StartMode_RL;
	}

	/**
	 * Set Subflow Execution.
	 *
	 * @param SubflowExecution_RL Mode how the sub-workflow is executed
	 */
	public void setSubflowExecution_RL(I_AD_Ref_ListInput SubflowExecution_RL) {
		this.SubflowExecution_RL = SubflowExecution_RL;
		MRefList foreignEntity;
		if (SubflowExecution_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(SubflowExecution_RL.getID())
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
	public I_AD_Ref_ListInput getSubflowExecution_RL() {
		return SubflowExecution_RL;
	}

	/**
	 * Set Workflow.
	 *
	 * @param Workflow Workflow or tasks
	 */
	public void setWorkflow(I_AD_WorkflowInput Workflow) {
		this.Workflow = Workflow;
		X_AD_Workflow foreignEntity;
		if (Workflow != null &&
				(foreignEntity = new Query(getCtx(), X_AD_Workflow.Table_Name, X_AD_Workflow.COLUMNNAME_AD_Workflow_UU + "=?", get_TrxName())
						.setParameters(Workflow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setWorkflow_ID(foreignEntity.get_ID());
		} else {
			this.setWorkflow_ID(0);
		}
	}

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or tasks
	 */
	public I_AD_WorkflowInput getWorkflow() {
		return Workflow;
	}
}
