package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Depreciation_Build;

/**
 * Generated Interface for A_Depreciation_Build - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_A_Depreciation_BuildInput extends I_A_Depreciation_Build {

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
	 * Set C_Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	void setC_PeriodInput(ForeignEntityInput C_Period);

	/**
	 * Get C_Period.
	 *
	 * @return Period of the Calendar
	 */
	ForeignEntityInput C_Period();

	/**
	 * Set PostingType.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	void setPostingTypeInput(ForeignEntityInput PostingType);

	/**
	 * Get PostingType.
	 *
	 * @return The type of posted amount for the transaction
	 */
	ForeignEntityInput PostingType();
}
