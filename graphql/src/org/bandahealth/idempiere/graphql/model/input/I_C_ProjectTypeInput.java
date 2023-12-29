package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ProjectType;

/**
 * Generated Interface for C_ProjectType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_ProjectTypeInput extends I_C_ProjectType {

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
	 * Set ProjectCategory_RL.
	 *
	 * @param ProjectCategory_RL Project Category
	 */
	void setProjectCategory_RL(I_AD_Ref_ListInput ProjectCategory_RL);

	/**
	 * Get ProjectCategory_RL.
	 *
	 * @return Project Category
	 */
	I_AD_Ref_ListInput getProjectCategory_RL();
}
