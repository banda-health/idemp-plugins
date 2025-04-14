package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Tree;

/**
 * Generated Interface for AD_Tree - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_AD_TreeInput extends I_AD_Tree {

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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

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
	void setTreeTypeInput(ForeignEntityInput TreeType);

	/**
	 * Get TreeType.
	 *
	 * @return Element this tree is built on (i.e Product, Business Partner)
	 */
	ForeignEntityInput TreeType();
}
