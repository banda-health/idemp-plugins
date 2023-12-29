package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Tree;

/**
 * Generated Interface for AD_Tree - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_TreeInput extends I_AD_Tree {

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
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_Table(I_AD_TableInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	I_AD_TableInput getAD_Table();

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
	void setParent_Column(I_AD_ColumnInput Parent_Column);

	/**
	 * Get Parent_Column.
	 *
	 * @return The link column on the parent tab.
	 */
	I_AD_ColumnInput getParent_Column();

	/**
	 * Set TreeType_RL.
	 *
	 * @param TreeType_RL Element this tree is built on (i.e Product, Business Partner)
	 */
	void setTreeType_RL(I_AD_Ref_ListInput TreeType_RL);

	/**
	 * Get TreeType_RL.
	 *
	 * @return Element this tree is built on (i.e Product, Business Partner)
	 */
	I_AD_Ref_ListInput getTreeType_RL();
}
