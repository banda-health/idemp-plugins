package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Info_Oth;

/**
 * Generated Interface for A_Asset_Info_Oth - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Asset_Info_OthInput extends I_A_Asset_Info_Oth {

	/**
	 * Set A_Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	void setA_AssetInput(I_A_AssetInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	I_A_AssetInput A_Asset();

	/**
	 * Set A_Asset_Info_Oth.
	 *
	 * @param A_Asset_Info_Oth A_Asset_Info_Oth
	 */
	void setA_Asset_Info_OthInput(I_A_Asset_Info_OthInput A_Asset_Info_Oth);

	/**
	 * Get A_Asset_Info_Oth.
	 *
	 * @return A_Asset_Info_Oth
	 */
	I_A_Asset_Info_OthInput A_Asset_Info_Oth();

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
