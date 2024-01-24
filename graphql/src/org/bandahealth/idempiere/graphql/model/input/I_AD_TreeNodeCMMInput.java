package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_TreeNodeCMM;

/**
 * Generated Interface for AD_TreeNodeCMM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_TreeNodeCMMInput extends I_AD_TreeNodeCMM {

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
