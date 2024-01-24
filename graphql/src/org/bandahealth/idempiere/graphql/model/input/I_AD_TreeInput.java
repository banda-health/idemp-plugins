package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Tree;

/**
 * Generated Interface for AD_Tree - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_TreeInput extends I_AD_Tree {

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
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(ForeignEntityInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	ForeignEntityInput AD_Table();

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
	 * Set Parent_Column.
	 *
	 * @param Parent_Column The link column on the parent tab.
	 */
	void setParent_ColumnInput(ForeignEntityInput Parent_Column);

	/**
	 * Get Parent_Column.
	 *
	 * @return The link column on the parent tab.
	 */
	ForeignEntityInput Parent_Column();

	/**
	 * Set TreeType.
	 *
	 * @param TreeType Element this tree is built on (i.e Product, Business Partner)
	 */
	void setTreeTypeInput(I_AD_Ref_ListInput TreeType);

	/**
	 * Get TreeType.
	 *
	 * @return Element this tree is built on (i.e Product, Business Partner)
	 */
	I_AD_Ref_ListInput TreeType();
}
