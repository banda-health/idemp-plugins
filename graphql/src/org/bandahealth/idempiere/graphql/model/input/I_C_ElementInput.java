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

	/**
	 * Set ElementType.
	 *
	 * @param ElementType Element Type (account or user defined)
	 */
	void setElementTypeInput(I_AD_Ref_ListInput ElementType);

	/**
	 * Get ElementType.
	 *
	 * @return Element Type (account or user defined)
	 */
	I_AD_Ref_ListInput ElementType();
}
