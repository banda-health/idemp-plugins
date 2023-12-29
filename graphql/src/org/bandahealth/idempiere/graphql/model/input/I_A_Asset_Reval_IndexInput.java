package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Reval_Index;

/**
 * Generated Interface for A_Asset_Reval_Index - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
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
	 * Set A_Reval_Code_RL.
	 *
	 * @param A_Reval_Code_RL A_Reval_Code_RL
	 */
	void setA_Reval_Code_RL(I_AD_Ref_ListInput A_Reval_Code_RL);

	/**
	 * Get A_Reval_Code_RL.
	 *
	 * @return A_Reval_Code_RL
	 */
	I_AD_Ref_ListInput getA_Reval_Code_RL();

	/**
	 * Set A_Reval_Multiplier_RL.
	 *
	 * @param A_Reval_Multiplier_RL A_Reval_Multiplier_RL
	 */
	void setA_Reval_Multiplier_RL(I_AD_Ref_ListInput A_Reval_Multiplier_RL);

	/**
	 * Get A_Reval_Multiplier_RL.
	 *
	 * @return A_Reval_Multiplier_RL
	 */
	I_AD_Ref_ListInput getA_Reval_Multiplier_RL();

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
