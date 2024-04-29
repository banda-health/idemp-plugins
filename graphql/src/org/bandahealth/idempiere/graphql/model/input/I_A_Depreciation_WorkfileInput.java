package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Depreciation_Workfile;

/**
 * Generated Interface for A_Depreciation_Workfile - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_A_Depreciation_WorkfileInput extends I_A_Depreciation_Workfile {

	/**
	 * Set A_Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	void setA_AssetInput(ForeignEntityInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	ForeignEntityInput A_Asset();

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
	 * Set A_FundingMode.
	 *
	 * @param A_FundingMode A_FundingMode
	 */
	void setA_FundingModeInput(ForeignEntityInput A_FundingMode);

	/**
	 * Get A_FundingMode.
	 *
	 * @return A_FundingMode
	 */
	ForeignEntityInput A_FundingMode();

	/**
	 * Set A_Tip_Finantare.
	 *
	 * @param A_Tip_Finantare Financing Type
	 */
	void setA_Tip_FinantareInput(ForeignEntityInput A_Tip_Finantare);

	/**
	 * Get A_Tip_Finantare.
	 *
	 * @return Financing Type
	 */
	ForeignEntityInput A_Tip_Finantare();

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
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	ForeignEntityInput C_AcctSchema();

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
