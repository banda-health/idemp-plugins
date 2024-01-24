package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_U_WebMenu;

/**
 * Generated Interface for U_WebMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_U_WebMenuInput extends I_U_WebMenu {

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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();
}
