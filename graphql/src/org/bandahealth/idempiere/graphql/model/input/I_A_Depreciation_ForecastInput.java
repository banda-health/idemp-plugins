package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Depreciation_Forecast;

/**
 * Generated Interface for A_Depreciation_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Depreciation_ForecastInput extends I_A_Depreciation_Forecast {

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
	 * Set A_End_Asset.
	 *
	 * @param A_End_Asset A_End_Asset
	 */
	void setA_End_Asset(I_A_AssetInput A_End_Asset);

	/**
	 * Get A_End_Asset.
	 *
	 * @return A_End_Asset
	 */
	I_A_AssetInput getA_End_Asset();

	/**
	 * Set A_Start_Asset.
	 *
	 * @param A_Start_Asset A_Start_Asset
	 */
	void setA_Start_Asset(I_A_AssetInput A_Start_Asset);

	/**
	 * Get A_Start_Asset.
	 *
	 * @return A_Start_Asset
	 */
	I_A_AssetInput getA_Start_Asset();

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
