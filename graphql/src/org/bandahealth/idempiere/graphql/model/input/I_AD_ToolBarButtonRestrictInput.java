package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_ToolBarButtonRestrict;

/**
 * Generated Interface for AD_ToolBarButtonRestrict - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_AD_ToolBarButtonRestrictInput extends I_AD_ToolBarButtonRestrict {

	/**
	 * Set Action.
	 *
	 * @param Action Indicates the Action to be performed
	 */
	void setActionInput(ForeignEntityInput Action);

	/**
	 * Get Action.
	 *
	 * @return Indicates the Action to be performed
	 */
	ForeignEntityInput Action();

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
	 * Set AD_Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	void setAD_RoleInput(ForeignEntityInput AD_Role);

	/**
	 * Get AD_Role.
	 *
	 * @return Responsibility Role
	 */
	ForeignEntityInput AD_Role();

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
	 * Set AD_ToolBarButton.
	 *
	 * @param AD_ToolBarButton AD_ToolBarButton
	 */
	void setAD_ToolBarButtonInput(ForeignEntityInput AD_ToolBarButton);

	/**
	 * Get AD_ToolBarButton.
	 *
	 * @return AD_ToolBarButton
	 */
	ForeignEntityInput AD_ToolBarButton();

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
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_WindowInput(ForeignEntityInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	ForeignEntityInput AD_Window();
}
