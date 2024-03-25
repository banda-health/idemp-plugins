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
