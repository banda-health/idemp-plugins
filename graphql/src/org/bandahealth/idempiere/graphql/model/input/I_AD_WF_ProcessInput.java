package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WF_Process;

/**
 * Generated Interface for AD_WF_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_WF_ProcessInput extends I_AD_WF_Process {

	/**
	 * Set AD_Message.
	 *
	 * @param AD_Message System Message
	 */
	void setAD_Message(I_AD_MessageInput AD_Message);

	/**
	 * Get AD_Message.
	 *
	 * @return System Message
	 */
	I_AD_MessageInput getAD_Message();

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
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_Table(I_AD_TableInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	I_AD_TableInput getAD_Table();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_User(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput getAD_User();

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
	void setAD_WF_Responsible(I_AD_WF_ResponsibleInput AD_WF_Responsible);

	/**
	 * Get AD_WF_Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	I_AD_WF_ResponsibleInput getAD_WF_Responsible();

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
	 * Set WFState_RL.
	 *
	 * @param WFState_RL State of the execution of the workflow
	 */
	void setWFState_RL(I_AD_Ref_ListInput WFState_RL);

	/**
	 * Get WFState_RL.
	 *
	 * @return State of the execution of the workflow
	 */
	I_AD_Ref_ListInput getWFState_RL();
}
