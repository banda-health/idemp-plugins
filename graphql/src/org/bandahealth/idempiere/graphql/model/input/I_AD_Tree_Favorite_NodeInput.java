package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Tree_Favorite_Node;

/**
 * Generated Interface for AD_Tree_Favorite_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_Tree_Favorite_NodeInput extends I_AD_Tree_Favorite_Node {

	/**
	 * Set AD_Menu.
	 *
	 * @param AD_Menu Identifies a Menu
	 */
	void setAD_MenuInput(ForeignEntityInput AD_Menu);

	/**
	 * Get AD_Menu.
	 *
	 * @return Identifies a Menu
	 */
	ForeignEntityInput AD_Menu();

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
	 * Set AD_Tree_Favorite.
	 *
	 * @param AD_Tree_Favorite AD_Tree_Favorite
	 */
	void setAD_Tree_FavoriteInput(ForeignEntityInput AD_Tree_Favorite);

	/**
	 * Get AD_Tree_Favorite.
	 *
	 * @return AD_Tree_Favorite
	 */
	ForeignEntityInput AD_Tree_Favorite();

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

	/**
	 * Set Parent.
	 *
	 * @param Parent Parent of Entity
	 */
	void setParentInput(ForeignEntityInput Parent);

	/**
	 * Get Parent.
	 *
	 * @return Parent of Entity
	 */
	ForeignEntityInput Parent();
}
