package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WorkflowProcessor;

/**
 * Generated Interface for AD_WorkflowProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_AD_WorkflowProcessorInput extends I_AD_WorkflowProcessor {

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
	 * Set AD_Schedule.
	 *
	 * @param AD_Schedule AD_Schedule
	 */
	void setAD_ScheduleInput(ForeignEntityInput AD_Schedule);

	/**
	 * Get AD_Schedule.
	 *
	 * @return AD_Schedule
	 */
	ForeignEntityInput AD_Schedule();

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
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	void setSupervisorInput(ForeignEntityInput Supervisor);

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	ForeignEntityInput Supervisor();
}
