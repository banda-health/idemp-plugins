package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_GL_Category;

/**
 * Generated Interface for GL_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_GL_CategoryInput extends I_GL_Category {

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
	 * Set CategoryType.
	 *
	 * @param CategoryType Source of the Journal with this category
	 */
	void setCategoryTypeInput(I_AD_Ref_ListInput CategoryType);

	/**
	 * Get CategoryType.
	 *
	 * @return Source of the Journal with this category
	 */
	I_AD_Ref_ListInput CategoryType();

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
}
