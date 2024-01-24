package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_ASP_Tab;

/**
 * Generated Interface for ASP_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_ASP_TabInput extends I_ASP_Tab {

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
	 * Set AD_Tab.
	 *
	 * @param AD_Tab Tab within a Window
	 */
	void setAD_TabInput(ForeignEntityInput AD_Tab);

	/**
	 * Get AD_Tab.
	 *
	 * @return Tab within a Window
	 */
	ForeignEntityInput AD_Tab();

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
	 * Set ASP_Window.
	 *
	 * @param ASP_Window ASP_Window
	 */
	void setASP_WindowInput(ForeignEntityInput ASP_Window);

	/**
	 * Get ASP_Window.
	 *
	 * @return ASP_Window
	 */
	ForeignEntityInput ASP_Window();
}
