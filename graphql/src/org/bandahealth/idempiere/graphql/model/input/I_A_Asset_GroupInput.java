package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Group;

/**
 * Generated Interface for A_Asset_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Asset_GroupInput extends I_A_Asset_Group {

	/**
	 * Set A_Asset_Class.
	 *
	 * @param A_Asset_Class A_Asset_Class
	 */
	void setA_Asset_ClassInput(I_A_Asset_ClassInput A_Asset_Class);

	/**
	 * Get A_Asset_Class.
	 *
	 * @return A_Asset_Class
	 */
	I_A_Asset_ClassInput A_Asset_Class();

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
	 * Set A_Asset_Type.
	 *
	 * @param A_Asset_Type A_Asset_Type
	 */
	void setA_Asset_TypeInput(I_A_Asset_TypeInput A_Asset_Type);

	/**
	 * Get A_Asset_Type.
	 *
	 * @return A_Asset_Type
	 */
	I_A_Asset_TypeInput A_Asset_Type();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();
}
