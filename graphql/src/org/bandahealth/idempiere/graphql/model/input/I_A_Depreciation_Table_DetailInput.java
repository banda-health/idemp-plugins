package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Depreciation_Table_Detail;

/**
 * Generated Interface for A_Depreciation_Table_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
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
	 * Set A_Table_Rate_Type_RL.
	 *
	 * @param A_Table_Rate_Type_RL A_Table_Rate_Type_RL
	 */
	void setA_Table_Rate_Type_RL(I_AD_Ref_ListInput A_Table_Rate_Type_RL);

	/**
	 * Get A_Table_Rate_Type_RL.
	 *
	 * @return A_Table_Rate_Type_RL
	 */
	I_AD_Ref_ListInput getA_Table_Rate_Type_RL();

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
}
