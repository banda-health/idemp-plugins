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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set CategoryType_RL.
	 *
	 * @param CategoryType_RL Source of the Journal with this category
	 */
	void setCategoryType_RL(I_AD_Ref_ListInput CategoryType_RL);

	/**
	 * Get CategoryType_RL.
	 *
	 * @return Source of the Journal with this category
	 */
	I_AD_Ref_ListInput getCategoryType_RL();

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
