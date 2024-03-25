package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_U_WebMenu;

/**
 * Generated Interface for U_WebMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_U_WebMenuInput extends I_U_WebMenu {

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
	 * Set ParentMenu.
	 *
	 * @param ParentMenu ParentMenu
	 */
	void setParentMenuInput(ForeignEntityInput ParentMenu);

	/**
	 * Get ParentMenu.
	 *
	 * @return ParentMenu
	 */
	ForeignEntityInput ParentMenu();

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
