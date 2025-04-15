package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_Order_Node;

/**
 * Generated Interface for PP_Order_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_PP_Order_NodeInput extends I_PP_Order_Node {

	/**
	 * Set Action.
	 *
	 * @param Action Indicates the Action to be performed
	 */
	void setActionInput(ForeignEntityInput Action);

	/**
	 * Get Action.
	 *
	 * @return Indicates the Action to be performed
	 */
	ForeignEntityInput Action();

	/**
	 * Set AD_Column.
	 *
	 * @param AD_Column Column in the table
	 */
	void setAD_ColumnInput(ForeignEntityInput AD_Column);

	/**
	 * Get AD_Column.
	 *
	 * @return Column in the table
	 */
	ForeignEntityInput AD_Column();

	/**
	 * Set AD_Form.
	 *
	 * @param AD_Form Special Form
	 */
	void setAD_FormInput(ForeignEntityInput AD_Form);

	/**
	 * Get AD_Form.
	 *
	 * @return Special Form
	 */
	ForeignEntityInput AD_Form();

	/**
	 * Set AD_Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	void setAD_ImageInput(ForeignEntityInput AD_Image);

	/**
	 * Get AD_Image.
	 *
	 * @return Image or Icon
	 */
	ForeignEntityInput AD_Image();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set AD_Process.
	 *
	 * @param AD_Process Process or Report
	 */
	void setAD_ProcessInput(ForeignEntityInput AD_Process);

	/**
	 * Get AD_Process.
	 *
	 * @return Process or Report
	 */
	ForeignEntityInput AD_Process();

	/**
	 * Set AD_Task.
	 *
	 * @param AD_Task Operation System Task
	 */
	void setAD_TaskInput(ForeignEntityInput AD_Task);

	/**
	 * Get AD_Task.
	 *
	 * @return Operation System Task
	 */
	ForeignEntityInput AD_Task();

	/**
	 * Set AD_WF_Block.
	 *
	 * @param AD_WF_Block Workflow Transaction Execution Block
	 */
	void setAD_WF_BlockInput(ForeignEntityInput AD_WF_Block);

	/**
	 * Get AD_WF_Block.
	 *
	 * @return Workflow Transaction Execution Block
	 */
	ForeignEntityInput AD_WF_Block();

	/**
	 * Set AD_WF_Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	void setAD_WF_NodeInput(ForeignEntityInput AD_WF_Node);

	/**
	 * Get AD_WF_Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	ForeignEntityInput AD_WF_Node();

	/**
	 * Set AD_WF_Responsible.
	 *
	 * @param AD_WF_Responsible Responsible for Workflow Execution
	 */
	void setAD_WF_ResponsibleInput(ForeignEntityInput AD_WF_Responsible);

	/**
	 * Get AD_WF_Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	ForeignEntityInput AD_WF_Responsible();

	/**
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_WindowInput(ForeignEntityInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	ForeignEntityInput AD_Window();

	/**
	 * Set AD_Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	void setAD_WorkflowInput(ForeignEntityInput AD_Workflow);

	/**
	 * Get AD_Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	ForeignEntityInput AD_Workflow();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set DocAction.
	 *
	 * @param DocAction The targeted status of the document
	 */
	void setDocActionInput(ForeignEntityInput DocAction);

	/**
	 * Get DocAction.
	 *
	 * @return The targeted status of the document
	 */
	ForeignEntityInput DocAction();

	/**
	 * Set DocStatus.
	 *
	 * @param DocStatus The current status of the document
	 */
	void setDocStatusInput(ForeignEntityInput DocStatus);

	/**
	 * Get DocStatus.
	 *
	 * @return The current status of the document
	 */
	ForeignEntityInput DocStatus();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	ForeignEntityInput AD_EntityType();

	/**
	 * Set FinishMode.
	 *
	 * @param FinishMode Workflow Activity Finish Mode
	 */
	void setFinishModeInput(ForeignEntityInput FinishMode);

	/**
	 * Get FinishMode.
	 *
	 * @return Workflow Activity Finish Mode
	 */
	ForeignEntityInput FinishMode();

	/**
	 * Set JoinElement.
	 *
	 * @param JoinElement Semantics for multiple incoming Transitions
	 */
	void setJoinElementInput(ForeignEntityInput JoinElement);

	/**
	 * Get JoinElement.
	 *
	 * @return Semantics for multiple incoming Transitions
	 */
	ForeignEntityInput JoinElement();

	/**
	 * Set PP_Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	void setPP_OrderInput(ForeignEntityInput PP_Order);

	/**
	 * Get PP_Order.
	 *
	 * @return Manufacturing Order
	 */
	ForeignEntityInput PP_Order();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

	/**
	 * Set PP_Order_Workflow.
	 *
	 * @param PP_Order_Workflow PP_Order_Workflow
	 */
	void setPP_Order_WorkflowInput(ForeignEntityInput PP_Order_Workflow);

	/**
	 * Get PP_Order_Workflow.
	 *
	 * @return PP_Order_Workflow
	 */
	ForeignEntityInput PP_Order_Workflow();

	/**
	 * Set S_Resource.
	 *
	 * @param S_Resource Resource
	 */
	void setS_ResourceInput(ForeignEntityInput S_Resource);

	/**
	 * Get S_Resource.
	 *
	 * @return Resource
	 */
	ForeignEntityInput S_Resource();

	/**
	 * Set SplitElement.
	 *
	 * @param SplitElement Semantics for multiple outgoing Transitions
	 */
	void setSplitElementInput(ForeignEntityInput SplitElement);

	/**
	 * Get SplitElement.
	 *
	 * @return Semantics for multiple outgoing Transitions
	 */
	ForeignEntityInput SplitElement();

	/**
	 * Set StartMode.
	 *
	 * @param StartMode Workflow Activity Start Mode 
	 */
	void setStartModeInput(ForeignEntityInput StartMode);

	/**
	 * Get StartMode.
	 *
	 * @return Workflow Activity Start Mode 
	 */
	ForeignEntityInput StartMode();

	/**
	 * Set SubflowExecution.
	 *
	 * @param SubflowExecution Mode how the sub-workflow is executed
	 */
	void setSubflowExecutionInput(ForeignEntityInput SubflowExecution);

	/**
	 * Get SubflowExecution.
	 *
	 * @return Mode how the sub-workflow is executed
	 */
	ForeignEntityInput SubflowExecution();

	/**
	 * Set Workflow.
	 *
	 * @param Workflow Workflow or tasks
	 */
	void setWorkflowInput(ForeignEntityInput Workflow);

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or tasks
	 */
	ForeignEntityInput Workflow();
}
