package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Info_Oth;

/**
 * Generated Interface for A_Asset_Info_Oth - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_A_Asset_Info_OthInput extends I_A_Asset_Info_Oth {

	/**
	 * Set A_Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	void setA_AssetInput(ForeignEntityInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	ForeignEntityInput A_Asset();

	/**
	 * Set A_Asset_Info_Oth.
	 *
	 * @param A_Asset_Info_Oth A_Asset_Info_Oth
	 */
	void setA_Asset_Info_OthInput(ForeignEntityInput A_Asset_Info_Oth);

	/**
	 * Get A_Asset_Info_Oth.
	 *
	 * @return A_Asset_Info_Oth
	 */
	ForeignEntityInput A_Asset_Info_Oth();

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
}
