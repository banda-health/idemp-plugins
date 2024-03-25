package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_ASP_Process_Para;

/**
 * Generated Interface for ASP_Process_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_ASP_Process_ParaInput extends I_ASP_Process_Para {

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
	 * Set ASP_Process.
	 *
	 * @param ASP_Process ASP_Process
	 */
	void setASP_ProcessInput(ForeignEntityInput ASP_Process);

	/**
	 * Get ASP_Process.
	 *
	 * @return ASP_Process
	 */
	ForeignEntityInput ASP_Process();

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
