package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ProjectType;

/**
 * Generated Interface for C_ProjectType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_ProjectTypeInput extends I_C_ProjectType {

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
	 * Set ProjectCategory.
	 *
	 * @param ProjectCategory Project Category
	 */
	void setProjectCategoryInput(ForeignEntityInput ProjectCategory);

	/**
	 * Get ProjectCategory.
	 *
	 * @return Project Category
	 */
	ForeignEntityInput ProjectCategory();
}
