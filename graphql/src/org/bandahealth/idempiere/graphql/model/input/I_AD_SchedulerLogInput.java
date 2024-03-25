package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_SchedulerLog;

/**
 * Generated Interface for AD_SchedulerLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_SchedulerLogInput extends I_AD_SchedulerLog {

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
	 * Set AD_Scheduler.
	 *
	 * @param AD_Scheduler Schedule Processes
	 */
	void setAD_SchedulerInput(ForeignEntityInput AD_Scheduler);

	/**
	 * Get AD_Scheduler.
	 *
	 * @return Schedule Processes
	 */
	ForeignEntityInput AD_Scheduler();

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
}
