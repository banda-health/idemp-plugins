package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WF_Node;

/**
 * Generated Interface for AD_WF_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_WF_NodeInput extends I_AD_WF_Node {

	/**
	 * Set Action.
	 *
	 * @param Action Indicates the Action to be performed
	 */
	void setActionInput(I_AD_Ref_ListInput Action);

	/**
	 * Get Action.
	 *
	 * @return Indicates the Action to be performed
	 */
	I_AD_Ref_ListInput Action();

	/**
	 * Set AD_Column.
	 *
	 * @param AD_Column Column in the table
	 */
	void setAD_ColumnInput(I_AD_ColumnInput AD_Column);

	/**
	 * Get AD_Column.
	 *
	 * @return Column in the table
	 */
	I_AD_ColumnInput AD_Column();

	/**
	 * Set AD_CtxHelp.
	 *
	 * @param AD_CtxHelp AD_CtxHelp
	 */
	void setAD_CtxHelpInput(I_AD_CtxHelpInput AD_CtxHelp);

	/**
	 * Get AD_CtxHelp.
	 *
	 * @return AD_CtxHelp
	 */
	I_AD_CtxHelpInput AD_CtxHelp();

	/**
	 * Set AD_Form.
	 *
	 * @param AD_Form Special Form
	 */
	void setAD_FormInput(I_AD_FormInput AD_Form);

	/**
	 * Get AD_Form.
	 *
	 * @return Special Form
	 */
	I_AD_FormInput AD_Form();

	/**
	 * Set AD_Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	void setAD_ImageInput(I_AD_ImageInput AD_Image);

	/**
	 * Get AD_Image.
	 *
	 * @return Image or Icon
	 */
	I_AD_ImageInput AD_Image();

	/**
	 * Set AD_InfoWindow.
	 *
	 * @param AD_InfoWindow Info and search/select Window
	 */
	void setAD_InfoWindowInput(I_AD_InfoWindowInput AD_InfoWindow);

	/**
	 * Get AD_InfoWindow.
	 *
	 * @return Info and search/select Window
	 */
	I_AD_InfoWindowInput AD_InfoWindow();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set AD_Process.
	 *
	 * @param AD_Process Process or Report
	 */
	void setAD_ProcessInput(I_AD_ProcessInput AD_Process);

	/**
	 * Get AD_Process.
	 *
	 * @return Process or Report
	 */
	I_AD_ProcessInput AD_Process();

	/**
	 * Set AD_Task.
	 *
	 * @param AD_Task Operation System Task
	 */
	void setAD_TaskInput(I_AD_TaskInput AD_Task);

	/**
	 * Get AD_Task.
	 *
	 * @return Operation System Task
	 */
	I_AD_TaskInput AD_Task();

	/**
	 * Set AD_WF_Block.
	 *
	 * @param AD_WF_Block Workflow Transaction Execution Block
	 */
	void setAD_WF_BlockInput(I_AD_WF_BlockInput AD_WF_Block);

	/**
	 * Get AD_WF_Block.
	 *
	 * @return Workflow Transaction Execution Block
	 */
	I_AD_WF_BlockInput AD_WF_Block();

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
	 * Set AD_WF_Responsible.
	 *
	 * @param AD_WF_Responsible Responsible for Workflow Execution
	 */
	void setAD_WF_ResponsibleInput(I_AD_WF_ResponsibleInput AD_WF_Responsible);

	/**
	 * Get AD_WF_Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	I_AD_WF_ResponsibleInput AD_WF_Responsible();

	/**
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_WindowInput(I_AD_WindowInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	I_AD_WindowInput AD_Window();

	/**
	 * Set AD_Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	void setAD_WorkflowInput(I_AD_WorkflowInput AD_Workflow);

	/**
	 * Get AD_Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	I_AD_WorkflowInput AD_Workflow();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput C_BPartner();

	/**
	 * Set DocAction.
	 *
	 * @param DocAction The targeted status of the document
	 */
	void setDocActionInput(I_AD_Ref_ListInput DocAction);

	/**
	 * Get DocAction.
	 *
	 * @return The targeted status of the document
	 */
	I_AD_Ref_ListInput DocAction();

	/**
	 * Set DynPriorityUnit.
	 *
	 * @param DynPriorityUnit Change of priority when Activity is suspended waiting for user
	 */
	void setDynPriorityUnitInput(I_AD_Ref_ListInput DynPriorityUnit);

	/**
	 * Get DynPriorityUnit.
	 *
	 * @return Change of priority when Activity is suspended waiting for user
	 */
	I_AD_Ref_ListInput DynPriorityUnit();

	/**
	 * Set EMailRecipient.
	 *
	 * @param EMailRecipient Recipient of the EMail
	 */
	void setEMailRecipientInput(I_AD_Ref_ListInput EMailRecipient);

	/**
	 * Get EMailRecipient.
	 *
	 * @return Recipient of the EMail
	 */
	I_AD_Ref_ListInput EMailRecipient();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput AD_EntityType();

	/**
	 * Set FinishMode.
	 *
	 * @param FinishMode Workflow Activity Finish Mode
	 */
	void setFinishModeInput(I_AD_Ref_ListInput FinishMode);

	/**
	 * Get FinishMode.
	 *
	 * @return Workflow Activity Finish Mode
	 */
	I_AD_Ref_ListInput FinishMode();

	/**
	 * Set JoinElement.
	 *
	 * @param JoinElement Semantics for multiple incoming Transitions
	 */
	void setJoinElementInput(I_AD_Ref_ListInput JoinElement);

	/**
	 * Get JoinElement.
	 *
	 * @return Semantics for multiple incoming Transitions
	 */
	I_AD_Ref_ListInput JoinElement();

	/**
	 * Set R_MailText.
	 *
	 * @param R_MailText Text templates for mailings
	 */
	void setR_MailTextInput(I_R_MailTextInput R_MailText);

	/**
	 * Get R_MailText.
	 *
	 * @return Text templates for mailings
	 */
	I_R_MailTextInput R_MailText();

	/**
	 * Set S_Resource.
	 *
	 * @param S_Resource Resource
	 */
	void setS_ResourceInput(I_S_ResourceInput S_Resource);

	/**
	 * Get S_Resource.
	 *
	 * @return Resource
	 */
	I_S_ResourceInput S_Resource();

	/**
	 * Set SplitElement.
	 *
	 * @param SplitElement Semantics for multiple outgoing Transitions
	 */
	void setSplitElementInput(I_AD_Ref_ListInput SplitElement);

	/**
	 * Get SplitElement.
	 *
	 * @return Semantics for multiple outgoing Transitions
	 */
	I_AD_Ref_ListInput SplitElement();

	/**
	 * Set StartMode.
	 *
	 * @param StartMode Workflow Activity Start Mode 
	 */
	void setStartModeInput(I_AD_Ref_ListInput StartMode);

	/**
	 * Get StartMode.
	 *
	 * @return Workflow Activity Start Mode 
	 */
	I_AD_Ref_ListInput StartMode();

	/**
	 * Set SubflowExecution.
	 *
	 * @param SubflowExecution Mode how the sub-workflow is executed
	 */
	void setSubflowExecutionInput(I_AD_Ref_ListInput SubflowExecution);

	/**
	 * Get SubflowExecution.
	 *
	 * @return Mode how the sub-workflow is executed
	 */
	I_AD_Ref_ListInput SubflowExecution();

	/**
	 * Set Workflow.
	 *
	 * @param Workflow Workflow or tasks
	 */
	void setWorkflowInput(I_AD_WorkflowInput Workflow);

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or tasks
	 */
	I_AD_WorkflowInput Workflow();
}
