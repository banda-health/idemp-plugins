package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_UserDef_Info;

/**
 * Generated Interface for AD_UserDef_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_AD_UserDef_InfoInput extends I_AD_UserDef_Info {

	/**
	 * Set AD_InfoWindow.
	 *
	 * @param AD_InfoWindow Info and search/select Window
	 */
	void setAD_InfoWindowInput(ForeignEntityInput AD_InfoWindow);

	/**
	 * Get AD_InfoWindow.
	 *
	 * @return Info and search/select Window
	 */
	ForeignEntityInput AD_InfoWindow();

	/**
	 * Set AD_Language.
	 *
	 * @param AD_Language Language for this entity
	 */
	void setAD_LanguageInput(ForeignEntityInput AD_Language);

	/**
	 * Get AD_Language.
	 *
	 * @return Language for this entity
	 */
	ForeignEntityInput AD_Language();

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
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();

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

	/**
	 * Set IsShowInDashboard.
	 *
	 * @param IsShowInDashboard Show the dashlet in the dashboard
	 */
	void setIsShowInDashboardInput(ForeignEntityInput IsShowInDashboard);

	/**
	 * Get IsShowInDashboard.
	 *
	 * @return Show the dashlet in the dashboard
	 */
	ForeignEntityInput IsShowInDashboard();

	/**
	 * Set PO_Window.
	 *
	 * @param PO_Window Purchase Order Window
	 */
	void setPO_WindowInput(ForeignEntityInput PO_Window);

	/**
	 * Get PO_Window.
	 *
	 * @return Purchase Order Window
	 */
	ForeignEntityInput PO_Window();
}
