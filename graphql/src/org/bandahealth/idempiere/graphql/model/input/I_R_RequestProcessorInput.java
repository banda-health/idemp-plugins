package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_RequestProcessor;

/**
 * Generated Interface for R_RequestProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_R_RequestProcessorInput extends I_R_RequestProcessor {

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
	 * Set R_RequestType.
	 *
	 * @param R_RequestType Type of request (e.g. Inquiry, Complaint, ..)
	 */
	void setR_RequestTypeInput(ForeignEntityInput R_RequestType);

	/**
	 * Get R_RequestType.
	 *
	 * @return Type of request (e.g. Inquiry, Complaint, ..)
	 */
	ForeignEntityInput R_RequestType();

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
