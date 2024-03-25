package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_ASP_ClientException;

/**
 * Generated Interface for ASP_ClientException - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_ASP_ClientExceptionInput extends I_ASP_ClientException {

	/**
	 * Set AD_Field.
	 *
	 * @param AD_Field Field on a database table
	 */
	void setAD_FieldInput(ForeignEntityInput AD_Field);

	/**
	 * Get AD_Field.
	 *
	 * @return Field on a database table
	 */
	ForeignEntityInput AD_Field();

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
	 * Set AD_Process_Para.
	 *
	 * @param AD_Process_Para AD_Process_Para
	 */
	void setAD_Process_ParaInput(ForeignEntityInput AD_Process_Para);

	/**
	 * Get AD_Process_Para.
	 *
	 * @return AD_Process_Para
	 */
	ForeignEntityInput AD_Process_Para();

	/**
	 * Set AD_Tab.
	 *
	 * @param AD_Tab Tab within a Window
	 */
	void setAD_TabInput(ForeignEntityInput AD_Tab);

	/**
	 * Get AD_Tab.
	 *
	 * @return Tab within a Window
	 */
	ForeignEntityInput AD_Tab();

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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();

	/**
	 * Set ASP_Status.
	 *
	 * @param ASP_Status ASP_Status
	 */
	void setASP_StatusInput(I_AD_Ref_ListInput ASP_Status);

	/**
	 * Get ASP_Status.
	 *
	 * @return ASP_Status
	 */
	I_AD_Ref_ListInput ASP_Status();
}
