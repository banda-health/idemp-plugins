package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Element;

/**
 * Generated Interface for C_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_ElementInput extends I_C_Element {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_Tree.
	 *
	 * @param AD_Tree Identifies a Tree
	 */
	void setAD_Tree(I_AD_TreeInput AD_Tree);

	/**
	 * Get AD_Tree.
	 *
	 * @return Identifies a Tree
	 */
	I_AD_TreeInput getAD_Tree();

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
	 * Set ElementType_RL.
	 *
	 * @param ElementType_RL Element Type (account or user defined)
	 */
	void setElementType_RL(I_AD_Ref_ListInput ElementType_RL);

	/**
	 * Get ElementType_RL.
	 *
	 * @return Element Type (account or user defined)
	 */
	I_AD_Ref_ListInput getElementType_RL();
}
