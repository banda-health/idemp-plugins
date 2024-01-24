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
	 * Set A_End_Asset.
	 *
	 * @param A_End_Asset A_End_Asset
	 */
	void setA_End_AssetInput(ForeignEntityInput A_End_Asset);

	/**
	 * Get A_End_Asset.
	 *
	 * @return A_End_Asset
	 */
	ForeignEntityInput A_End_Asset();

	/**
	 * Set A_Start_Asset.
	 *
	 * @param A_Start_Asset A_Start_Asset
	 */
	void setA_Start_AssetInput(ForeignEntityInput A_Start_Asset);

	/**
	 * Get A_Start_Asset.
	 *
	 * @return A_Start_Asset
	 */
	ForeignEntityInput A_Start_Asset();

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
