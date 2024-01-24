package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_U_RoleMenu;

/**
 * Generated Interface for U_RoleMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_U_RoleMenuInput extends I_U_RoleMenu {

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
	 * Set U_WebMenu.
	 *
	 * @param U_WebMenu U_WebMenu
	 */
	void setU_WebMenuInput(ForeignEntityInput U_WebMenu);

	/**
	 * Get U_WebMenu.
	 *
	 * @return U_WebMenu
	 */
	ForeignEntityInput U_WebMenu();
}
