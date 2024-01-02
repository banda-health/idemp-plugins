package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Change;

/**
 * Generated Interface for A_Asset_Change - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Asset_ChangeInput extends I_A_Asset_Change {

	/**
	 * Set A_Accumdepreciation_A.
	 *
	 * @param A_Accumdepreciation_A A_Accumdepreciation_A
	 */
	void setA_Accumdepreciation_AInput(I_C_ValidCombinationInput A_Accumdepreciation_A);

	/**
	 * Get A_Accumdepreciation_A.
	 *
	 * @return A_Accumdepreciation_A
	 */
	I_C_ValidCombinationInput A_Accumdepreciation_A();

	/**
	 * Set A_Asset_A.
	 *
	 * @param A_Asset_A A_Asset_A
	 */
	void setA_Asset_AInput(I_C_ValidCombinationInput A_Asset_A);

	/**
	 * Get A_Asset_A.
	 *
	 * @return A_Asset_A
	 */
	I_C_ValidCombinationInput A_Asset_A();

	/**
	 * Set A_Asset_Addition.
	 *
	 * @param A_Asset_Addition A_Asset_Addition
	 */
	void setA_Asset_AdditionInput(I_A_Asset_AdditionInput A_Asset_Addition);

	/**
	 * Get A_Asset_Addition.
	 *
	 * @return A_Asset_Addition
	 */
	I_A_Asset_AdditionInput A_Asset_Addition();

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
	 * Set A_Asset_Retirement.
	 *
	 * @param A_Asset_Retirement Internally used asset is not longer used.
	 */
	void setA_Asset_RetirementInput(I_A_Asset_RetirementInput A_Asset_Retirement);

	/**
	 * Get A_Asset_Retirement.
	 *
	 * @return Internally used asset is not longer used.
	 */
	I_A_Asset_RetirementInput A_Asset_Retirement();

	/**
	 * Set A_Depreciation_A.
	 *
	 * @param A_Depreciation_A A_Depreciation_A
	 */
	void setA_Depreciation_AInput(I_C_ValidCombinationInput A_Depreciation_A);

	/**
	 * Get A_Depreciation_A.
	 *
	 * @return A_Depreciation_A
	 */
	I_C_ValidCombinationInput A_Depreciation_A();

	/**
	 * Set A_Depreciation_Manual_Period.
	 *
	 * @param A_Depreciation_Manual_Period A_Depreciation_Manual_Period
	 */
	void setA_Depreciation_Manual_PeriodInput(I_AD_Ref_ListInput A_Depreciation_Manual_Period);

	/**
	 * Get A_Depreciation_Manual_Period.
	 *
	 * @return A_Depreciation_Manual_Period
	 */
	I_AD_Ref_ListInput A_Depreciation_Manual_Period();

	/**
	 * Set A_Depreciation_Table_Header.
	 *
	 * @param A_Depreciation_Table_Header A_Depreciation_Table_Header
	 */
	void setA_Depreciation_Table_HeaderInput(I_A_Depreciation_Table_HeaderInput A_Depreciation_Table_Header);

	/**
	 * Get A_Depreciation_Table_Header.
	 *
	 * @return A_Depreciation_Table_Header
	 */
	I_A_Depreciation_Table_HeaderInput A_Depreciation_Table_Header();

	/**
	 * Set A_Disposal_Loss_A.
	 *
	 * @param A_Disposal_Loss_A A_Disposal_Loss_A
	 */
	void setA_Disposal_Loss_AInput(I_C_ValidCombinationInput A_Disposal_Loss_A);

	/**
	 * Get A_Disposal_Loss_A.
	 *
	 * @return A_Disposal_Loss_A
	 */
	I_C_ValidCombinationInput A_Disposal_Loss_A();

	/**
	 * Set A_Disposal_Revenue_A.
	 *
	 * @param A_Disposal_Revenue_A A_Disposal_Revenue_A
	 */
	void setA_Disposal_Revenue_AInput(I_C_ValidCombinationInput A_Disposal_Revenue_A);

	/**
	 * Get A_Disposal_Revenue_A.
	 *
	 * @return A_Disposal_Revenue_A
	 */
	I_C_ValidCombinationInput A_Disposal_Revenue_A();

	/**
	 * Set A_Parent_Asset.
	 *
	 * @param A_Parent_Asset A_Parent_Asset
	 */
	void setA_Parent_AssetInput(I_A_AssetInput A_Parent_Asset);

	/**
	 * Get A_Parent_Asset.
	 *
	 * @return A_Parent_Asset
	 */
	I_A_AssetInput A_Parent_Asset();

	/**
	 * Set A_Reval_Cal_Method.
	 *
	 * @param A_Reval_Cal_Method A_Reval_Cal_Method
	 */
	void setA_Reval_Cal_MethodInput(I_AD_Ref_ListInput A_Reval_Cal_Method);

	/**
	 * Get A_Reval_Cal_Method.
	 *
	 * @return A_Reval_Cal_Method
	 */
	I_AD_Ref_ListInput A_Reval_Cal_Method();

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
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput AD_User();

	/**
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchemaInput(I_C_AcctSchemaInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	I_C_AcctSchemaInput C_AcctSchema();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput C_BPartner();

	/**
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_LocationInput(I_C_BPartner_LocationInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	I_C_BPartner_LocationInput C_BPartner_Location();

	/**
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_LocationInput(I_C_LocationInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	I_C_LocationInput C_Location();

	/**
	 * Set C_ValidCombination.
	 *
	 * @param C_ValidCombination Valid Account Combination
	 */
	void setC_ValidCombinationInput(I_C_ValidCombinationInput C_ValidCombination);

	/**
	 * Get C_ValidCombination.
	 *
	 * @return Valid Account Combination
	 */
	I_C_ValidCombinationInput C_ValidCombination();

	/**
	 * Set ChangeType.
	 *
	 * @param ChangeType ChangeType
	 */
	void setChangeTypeInput(I_AD_Ref_ListInput ChangeType);

	/**
	 * Get ChangeType.
	 *
	 * @return ChangeType
	 */
	I_AD_Ref_ListInput ChangeType();

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
