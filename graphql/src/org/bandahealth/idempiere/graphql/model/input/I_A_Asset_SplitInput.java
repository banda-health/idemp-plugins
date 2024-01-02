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
	void setA_AssetInput(I_A_AssetInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	I_A_AssetInput A_Asset();

	/**
	 * Set A_Asset_To.
	 *
	 * @param A_Asset_To A_Asset_To
	 */
	void setA_Asset_ToInput(I_A_AssetInput A_Asset_To);

	/**
	 * Get A_Asset_To.
	 *
	 * @return A_Asset_To
	 */
	I_A_AssetInput A_Asset_To();

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
	 * Set A_Split_Type.
	 *
	 * @param A_Split_Type A_Split_Type
	 */
	void setA_Split_TypeInput(I_AD_Ref_ListInput A_Split_Type);

	/**
	 * Get A_Split_Type.
	 *
	 * @return A_Split_Type
	 */
	I_AD_Ref_ListInput A_Split_Type();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set C_Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	void setC_PeriodInput(I_C_PeriodInput C_Period);

	/**
	 * Get C_Period.
	 *
	 * @return Period of the Calendar
	 */
	I_C_PeriodInput C_Period();

	/**
	 * Set PostingType.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	void setPostingTypeInput(I_AD_Ref_ListInput PostingType);

	/**
	 * Get PostingType.
	 *
	 * @return The type of posted amount for the transaction
	 */
	I_AD_Ref_ListInput PostingType();
}
