package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Reval_Index;

/**
 * Generated Interface for A_Asset_Reval_Index - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_A_Asset_Reval_IndexInput extends I_A_Asset_Reval_Index {

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
	 * Set A_Reval_Code.
	 *
	 * @param A_Reval_Code A_Reval_Code
	 */
	void setA_Reval_CodeInput(ForeignEntityInput A_Reval_Code);

	/**
	 * Get A_Reval_Code.
	 *
	 * @return A_Reval_Code
	 */
	ForeignEntityInput A_Reval_Code();

	/**
	 * Set A_Reval_Multiplier.
	 *
	 * @param A_Reval_Multiplier A_Reval_Multiplier
	 */
	void setA_Reval_MultiplierInput(ForeignEntityInput A_Reval_Multiplier);

	/**
	 * Get A_Reval_Multiplier.
	 *
	 * @return A_Reval_Multiplier
	 */
	ForeignEntityInput A_Reval_Multiplier();

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
