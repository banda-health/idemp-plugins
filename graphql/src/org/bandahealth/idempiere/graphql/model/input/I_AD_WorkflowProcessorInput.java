package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WorkflowProcessor;

/**
 * Generated Interface for AD_WorkflowProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_WorkflowProcessorInput extends I_AD_WorkflowProcessor {

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
	 * Set AD_Schedule.
	 *
	 * @param AD_Schedule AD_Schedule
	 */
	void setAD_ScheduleInput(I_AD_ScheduleInput AD_Schedule);

	/**
	 * Get AD_Schedule.
	 *
	 * @return AD_Schedule
	 */
	I_AD_ScheduleInput AD_Schedule();

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
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	void setSupervisorInput(I_AD_UserInput Supervisor);

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	I_AD_UserInput Supervisor();
}
