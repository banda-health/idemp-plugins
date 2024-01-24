package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Reval_Index;

/**
 * Generated Interface for A_Asset_Reval_Index - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_A_Asset_Reval_IndexInput extends I_A_Asset_Reval_Index {

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
	 * Set A_Reval_Code.
	 *
	 * @param A_Reval_Code A_Reval_Code
	 */
	void setA_Reval_CodeInput(I_AD_Ref_ListInput A_Reval_Code);

	/**
	 * Get A_Reval_Code.
	 *
	 * @return A_Reval_Code
	 */
	I_AD_Ref_ListInput A_Reval_Code();

	/**
	 * Set A_Reval_Multiplier.
	 *
	 * @param A_Reval_Multiplier A_Reval_Multiplier
	 */
	void setA_Reval_MultiplierInput(I_AD_Ref_ListInput A_Reval_Multiplier);

	/**
	 * Get A_Reval_Multiplier.
	 *
	 * @return A_Reval_Multiplier
	 */
	I_AD_Ref_ListInput A_Reval_Multiplier();

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
}
