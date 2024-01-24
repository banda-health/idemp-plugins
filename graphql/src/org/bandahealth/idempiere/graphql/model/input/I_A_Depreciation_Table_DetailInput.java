package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Depreciation_Table_Detail;

/**
 * Generated Interface for A_Depreciation_Table_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_A_Depreciation_Table_DetailInput extends I_A_Depreciation_Table_Detail {

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
