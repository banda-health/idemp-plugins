package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Depreciation_Table_Detail;

/**
 * Generated Interface for A_Depreciation_Table_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_A_Depreciation_Table_DetailInput extends I_A_Depreciation_Table_Detail {

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
