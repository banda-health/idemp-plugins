package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_GL_Category;

/**
 * Generated Interface for GL_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_GL_CategoryInput extends I_GL_Category {

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
	 * Set CategoryType.
	 *
	 * @param CategoryType Source of the Journal with this category
	 */
	void setCategoryTypeInput(ForeignEntityInput CategoryType);

	/**
	 * Get CategoryType.
	 *
	 * @return Source of the Journal with this category
	 */
	ForeignEntityInput CategoryType();

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
}
