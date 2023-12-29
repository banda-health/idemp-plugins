package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Depreciation_Workfile;

/**
 * Generated Interface for A_Depreciation_Workfile - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Depreciation_WorkfileInput extends I_A_Depreciation_Workfile {

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
	 * Set A_FundingMode.
	 *
	 * @param A_FundingMode A_FundingMode
	 */
	void setA_FundingMode(I_A_FundingModeInput A_FundingMode);

	/**
	 * Get A_FundingMode.
	 *
	 * @return A_FundingMode
	 */
	I_A_FundingModeInput getA_FundingMode();

	/**
	 * Set A_Tip_Finantare_RL.
	 *
	 * @param A_Tip_Finantare_RL Financing Type
	 */
	void setA_Tip_Finantare_RL(I_AD_Ref_ListInput A_Tip_Finantare_RL);

	/**
	 * Get A_Tip_Finantare_RL.
	 *
	 * @return Financing Type
	 */
	I_AD_Ref_ListInput getA_Tip_Finantare_RL();

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
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchema(I_C_AcctSchemaInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	I_C_AcctSchemaInput getC_AcctSchema();

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
