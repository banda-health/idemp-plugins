package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_ASP_Task;

/**
 * Generated Interface for ASP_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_ASP_TaskInput extends I_ASP_Task {

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
	 * Set ASP_Level.
	 *
	 * @param ASP_Level ASP_Level
	 */
	void setASP_LevelInput(ForeignEntityInput ASP_Level);

	/**
	 * Get ASP_Level.
	 *
	 * @return ASP_Level
	 */
	ForeignEntityInput ASP_Level();

	/**
	 * Set ASP_Status.
	 *
	 * @param ASP_Status ASP_Status
	 */
	void setASP_StatusInput(ForeignEntityInput ASP_Status);

	/**
	 * Get ASP_Status.
	 *
	 * @return ASP_Status
	 */
	ForeignEntityInput ASP_Status();

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
