package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Depreciation_Table_Header;

/**
 * Generated Interface for A_Depreciation_Table_Header - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Depreciation_Table_HeaderInput extends I_A_Depreciation_Table_Header {

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
	 * Set A_Table_Rate_Type.
	 *
	 * @param A_Table_Rate_Type A_Table_Rate_Type
	 */
	void setA_Table_Rate_TypeInput(I_AD_Ref_ListInput A_Table_Rate_Type);

	/**
	 * Get A_Table_Rate_Type.
	 *
	 * @return A_Table_Rate_Type
	 */
	I_AD_Ref_ListInput A_Table_Rate_Type();

	/**
	 * Set A_Term.
	 *
	 * @param A_Term A_Term
	 */
	void setA_TermInput(I_AD_Ref_ListInput A_Term);

	/**
	 * Get A_Term.
	 *
	 * @return A_Term
	 */
	I_AD_Ref_ListInput A_Term();

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
