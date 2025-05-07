package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Depreciation_Table_Header;

/**
 * Generated Interface for A_Depreciation_Table_Header - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_A_Depreciation_Table_HeaderInput extends I_A_Depreciation_Table_Header {

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
	 * Set A_Table_Rate_Type.
	 *
	 * @param A_Table_Rate_Type A_Table_Rate_Type
	 */
	void setA_Table_Rate_TypeInput(ForeignEntityInput A_Table_Rate_Type);

	/**
	 * Get A_Table_Rate_Type.
	 *
	 * @return A_Table_Rate_Type
	 */
	ForeignEntityInput A_Table_Rate_Type();

	/**
	 * Set A_Term.
	 *
	 * @param A_Term A_Term
	 */
	void setA_TermInput(ForeignEntityInput A_Term);

	/**
	 * Get A_Term.
	 *
	 * @return A_Term
	 */
	ForeignEntityInput A_Term();

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
