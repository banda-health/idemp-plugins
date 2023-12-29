package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Split;

/**
 * Generated Interface for A_Asset_Split - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Asset_SplitInput extends I_A_Asset_Split {

	/**
	 * Set A_Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	void setA_Asset(I_A_AssetInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	I_A_AssetInput getA_Asset();

	/**
	 * Set A_Asset_To.
	 *
	 * @param A_Asset_To A_Asset_To
	 */
	void setA_Asset_To(I_A_AssetInput A_Asset_To);

	/**
	 * Get A_Asset_To.
	 *
	 * @return A_Asset_To
	 */
	I_A_AssetInput getA_Asset_To();

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
	 * Set A_Split_Type_RL.
	 *
	 * @param A_Split_Type_RL A_Split_Type_RL
	 */
	void setA_Split_Type_RL(I_AD_Ref_ListInput A_Split_Type_RL);

	/**
	 * Get A_Split_Type_RL.
	 *
	 * @return A_Split_Type_RL
	 */
	I_AD_Ref_ListInput getA_Split_Type_RL();

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

	/**
	 * Set C_Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	void setC_Period(I_C_PeriodInput C_Period);

	/**
	 * Get C_Period.
	 *
	 * @return Period of the Calendar
	 */
	I_C_PeriodInput getC_Period();

	/**
	 * Set PostingType_RL.
	 *
	 * @param PostingType_RL The type of posted amount for the transaction
	 */
	void setPostingType_RL(I_AD_Ref_ListInput PostingType_RL);

	/**
	 * Get PostingType_RL.
	 *
	 * @return The type of posted amount for the transaction
	 */
	I_AD_Ref_ListInput getPostingType_RL();
}
