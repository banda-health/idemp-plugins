package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_ASP_Process;

/**
 * Generated Interface for ASP_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_ASP_ProcessInput extends I_ASP_Process {

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
}
