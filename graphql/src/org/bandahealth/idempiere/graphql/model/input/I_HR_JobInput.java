package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_HR_Job;

/**
 * Generated Interface for HR_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_HR_JobInput extends I_HR_Job {

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
	 * Set HR_Department.
	 *
	 * @param HR_Department HR_Department
	 */
	void setHR_DepartmentInput(ForeignEntityInput HR_Department);

	/**
	 * Get HR_Department.
	 *
	 * @return HR_Department
	 */
	ForeignEntityInput HR_Department();

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
	 * Set Next_Job.
	 *
	 * @param Next_Job Next_Job
	 */
	void setNext_JobInput(ForeignEntityInput Next_Job);

	/**
	 * Get Next_Job.
	 *
	 * @return Next_Job
	 */
	ForeignEntityInput Next_Job();

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
