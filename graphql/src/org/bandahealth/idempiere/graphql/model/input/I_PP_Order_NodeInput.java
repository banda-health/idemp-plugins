package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_Order_Node;

/**
 * Generated Interface for PP_Order_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PP_Order_NodeInput extends I_PP_Order_Node {

	/**
	 * Set Action_RL.
	 *
	 * @param Action_RL Indicates the Action to be performed
	 */
	void setAction_RL(I_AD_Ref_ListInput Action_RL);

	/**
	 * Get Action_RL.
	 *
	 * @return Indicates the Action to be performed
	 */
	I_AD_Ref_ListInput getAction_RL();

	/**
	 * Set AD_Column.
	 *
	 * @param AD_Column Column in the table
	 */
	void setAD_Column(I_AD_ColumnInput AD_Column);

	/**
	 * Get AD_Column.
	 *
	 * @return Column in the table
	 */
	I_AD_ColumnInput getAD_Column();

	/**
	 * Set AD_Form.
	 *
	 * @param AD_Form Special Form
	 */
	void setAD_Form(I_AD_FormInput AD_Form);

	/**
	 * Get AD_Form.
	 *
	 * @return Special Form
	 */
	I_AD_FormInput getAD_Form();

	/**
	 * Set AD_Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	void setAD_Image(I_AD_ImageInput AD_Image);

	/**
	 * Get AD_Image.
	 *
	 * @return Image or Icon
	 */
	I_AD_ImageInput getAD_Image();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_Process.
	 *
	 * @param AD_Process Process or Report
	 */
	void setAD_Process(I_AD_ProcessInput AD_Process);

	/**
	 * Get AD_Process.
	 *
	 * @return Process or Report
	 */
	I_AD_ProcessInput getAD_Process();

	/**
	 * Set AD_Task.
	 *
	 * @param AD_Task Operation System Task
	 */
	void setAD_Task(I_AD_TaskInput AD_Task);

	/**
	 * Get AD_Task.
	 *
	 * @return Operation System Task
	 */
	I_AD_TaskInput getAD_Task();

	/**
	 * Set AD_WF_Block.
	 *
	 * @param AD_WF_Block Workflow Transaction Execution Block
	 */
	void setAD_WF_Block(I_AD_WF_BlockInput AD_WF_Block);

	/**
	 * Get AD_WF_Block.
	 *
	 * @return Workflow Transaction Execution Block
	 */
	I_AD_WF_BlockInput getAD_WF_Block();

	/**
	 * Set AD_WF_Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	void setAD_WF_Node(I_AD_WF_NodeInput AD_WF_Node);

	/**
	 * Get AD_WF_Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	I_AD_WF_NodeInput getAD_WF_Node();

	/**
	 * Set AD_WF_Responsible.
	 *
	 * @param AD_WF_Responsible Responsible for Workflow Execution
	 */
	void setAD_WF_Responsible(I_AD_WF_ResponsibleInput AD_WF_Responsible);

	/**
	 * Get AD_WF_Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	I_AD_WF_ResponsibleInput getAD_WF_Responsible();

	/**
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_Window(I_AD_WindowInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	I_AD_WindowInput getAD_Window();

	/**
	 * Set AD_Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	void setAD_Workflow(I_AD_WorkflowInput AD_Workflow);

	/**
	 * Get AD_Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	I_AD_WorkflowInput getAD_Workflow();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartner(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput getC_BPartner();

	/**
	 * Set DocAction_RL.
	 *
	 * @param DocAction_RL The targeted status of the document
	 */
	void setDocAction_RL(I_AD_Ref_ListInput DocAction_RL);

	/**
	 * Get DocAction_RL.
	 *
	 * @return The targeted status of the document
	 */
	I_AD_Ref_ListInput getDocAction_RL();

	/**
	 * Set DocStatus_RL.
	 *
	 * @param DocStatus_RL The current status of the document
	 */
	void setDocStatus_RL(I_AD_Ref_ListInput DocStatus_RL);

	/**
	 * Get DocStatus_RL.
	 *
	 * @return The current status of the document
	 */
	I_AD_Ref_ListInput getDocStatus_RL();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput getAD_EntityType();

	/**
	 * Set FinishMode_RL.
	 *
	 * @param FinishMode_RL Workflow Activity Finish Mode
	 */
	void setFinishMode_RL(I_AD_Ref_ListInput FinishMode_RL);

	/**
	 * Get FinishMode_RL.
	 *
	 * @return Workflow Activity Finish Mode
	 */
	I_AD_Ref_ListInput getFinishMode_RL();

	/**
	 * Set JoinElement_RL.
	 *
	 * @param JoinElement_RL Semantics for multiple incoming Transitions
	 */
	void setJoinElement_RL(I_AD_Ref_ListInput JoinElement_RL);

	/**
	 * Get JoinElement_RL.
	 *
	 * @return Semantics for multiple incoming Transitions
	 */
	I_AD_Ref_ListInput getJoinElement_RL();

	/**
	 * Set PP_Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	void setPP_Order(I_PP_OrderInput PP_Order);

	/**
	 * Get PP_Order.
	 *
	 * @return Manufacturing Order
	 */
	I_PP_OrderInput getPP_Order();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set PP_Order_Workflow.
	 *
	 * @param PP_Order_Workflow PP_Order_Workflow
	 */
	void setPP_Order_Workflow(I_PP_Order_WorkflowInput PP_Order_Workflow);

	/**
	 * Get PP_Order_Workflow.
	 *
	 * @return PP_Order_Workflow
	 */
	I_PP_Order_WorkflowInput getPP_Order_Workflow();

	/**
	 * Set S_Resource.
	 *
	 * @param S_Resource Resource
	 */
	void setS_Resource(I_S_ResourceInput S_Resource);

	/**
	 * Get S_Resource.
	 *
	 * @return Resource
	 */
	I_S_ResourceInput getS_Resource();

	/**
	 * Set SplitElement_RL.
	 *
	 * @param SplitElement_RL Semantics for multiple outgoing Transitions
	 */
	void setSplitElement_RL(I_AD_Ref_ListInput SplitElement_RL);

	/**
	 * Get SplitElement_RL.
	 *
	 * @return Semantics for multiple outgoing Transitions
	 */
	I_AD_Ref_ListInput getSplitElement_RL();

	/**
	 * Set StartMode_RL.
	 *
	 * @param StartMode_RL Workflow Activity Start Mode 
	 */
	void setStartMode_RL(I_AD_Ref_ListInput StartMode_RL);

	/**
	 * Get StartMode_RL.
	 *
	 * @return Workflow Activity Start Mode 
	 */
	I_AD_Ref_ListInput getStartMode_RL();

	/**
	 * Set SubflowExecution_RL.
	 *
	 * @param SubflowExecution_RL Mode how the sub-workflow is executed
	 */
	void setSubflowExecution_RL(I_AD_Ref_ListInput SubflowExecution_RL);

	/**
	 * Get SubflowExecution_RL.
	 *
	 * @return Mode how the sub-workflow is executed
	 */
	I_AD_Ref_ListInput getSubflowExecution_RL();

	/**
	 * Set Workflow.
	 *
	 * @param Workflow Workflow or tasks
	 */
	void setWorkflow(I_AD_WorkflowInput Workflow);

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or tasks
	 */
	I_AD_WorkflowInput getWorkflow();
}
