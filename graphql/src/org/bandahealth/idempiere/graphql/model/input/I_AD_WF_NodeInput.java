package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WF_Node;

/**
 * Generated Interface for AD_WF_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
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
	void setAD_ColumnInput(ForeignEntityInput AD_Column);

	/**
	 * Get AD_Column.
	 *
	 * @return Column in the table
	 */
	ForeignEntityInput AD_Column();

	/**
	 * Set AD_CtxHelp.
	 *
	 * @param AD_CtxHelp AD_CtxHelp
	 */
	void setAD_CtxHelpInput(ForeignEntityInput AD_CtxHelp);

	/**
	 * Get AD_CtxHelp.
	 *
	 * @return AD_CtxHelp
	 */
	ForeignEntityInput AD_CtxHelp();

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
	 * Set AD_InfoWindow.
	 *
	 * @param AD_InfoWindow Info and search/select Window
	 */
	void setAD_InfoWindowInput(ForeignEntityInput AD_InfoWindow);

	/**
	 * Get AD_InfoWindow.
	 *
	 * @return Info and search/select Window
	 */
	ForeignEntityInput AD_InfoWindow();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
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
	void setR_MailTextInput(ForeignEntityInput R_MailText);

	/**
	 * Get R_MailText.
	 *
	 * @return Text templates for mailings
	 */
	ForeignEntityInput R_MailText();

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
	void setWorkflowInput(ForeignEntityInput Workflow);

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or tasks
	 */
	ForeignEntityInput Workflow();
}
