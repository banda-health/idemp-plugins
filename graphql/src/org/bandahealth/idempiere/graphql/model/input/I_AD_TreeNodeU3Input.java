package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_TreeNodeU3;

/**
 * Generated Interface for AD_TreeNodeU3 - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_TreeNodeU3Input extends I_AD_TreeNodeU3 {

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
	 * Set AD_Tree.
	 *
	 * @param AD_Tree Identifies a Tree
	 */
	void setAD_TreeInput(ForeignEntityInput AD_Tree);

	/**
	 * Get AD_Tree.
	 *
	 * @return Identifies a Tree
	 */
	ForeignEntityInput AD_Tree();

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
