package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Window_Access;

/**
 * Generated Interface for AD_Window_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_Window_AccessInput extends I_AD_Window_Access {

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
	 * Column name BH_CanDeactivate
	 */
	static final String COLUMNNAME_BH_CanDeactivate = "BH_CanDeactivate";

	/**
	 * Set Can Deactivate.
	 *
	 * @param BH_CanDeactivate Can Deactivate
	 */
	void setBH_CanDeactivate(boolean BH_CanDeactivate);

	/**
	 * Get Can Deactivate.
	 *
	 * @return Can Deactivate
	 */
	boolean isBH_CanDeactivate();
}
