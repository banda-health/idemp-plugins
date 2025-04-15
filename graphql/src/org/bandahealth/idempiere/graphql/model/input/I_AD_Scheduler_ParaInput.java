package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Scheduler_Para;

/**
 * Generated Interface for AD_Scheduler_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_Scheduler_ParaInput extends I_AD_Scheduler_Para {

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
}
