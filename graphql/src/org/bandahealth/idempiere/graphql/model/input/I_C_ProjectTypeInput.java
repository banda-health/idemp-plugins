package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ProjectType;

/**
 * Generated Interface for C_ProjectType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_ProjectTypeInput extends I_C_ProjectType {

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
	 * Set ProjectCategory.
	 *
	 * @param ProjectCategory Project Category
	 */
	void setProjectCategoryInput(I_AD_Ref_ListInput ProjectCategory);

	/**
	 * Get ProjectCategory.
	 *
	 * @return Project Category
	 */
	I_AD_Ref_ListInput ProjectCategory();
}
