package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Depreciation_Exp;

/**
 * Generated Interface for A_Depreciation_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Depreciation_ExpInput extends I_A_Depreciation_Exp {

	/**
	 * Set A_Account_Number_A.
	 *
	 * @param A_Account_Number_A A_Account_Number_A
	 */
	void setA_Account_Number_A(I_C_ValidCombinationInput A_Account_Number_A);

	/**
	 * Get A_Account_Number_A.
	 *
	 * @return A_Account_Number_A
	 */
	I_C_ValidCombinationInput getA_Account_Number_A();

	/**
	 * Set A_Asset_Addition.
	 *
	 * @param A_Asset_Addition A_Asset_Addition
	 */
	void setA_Asset_Addition(I_A_Asset_AdditionInput A_Asset_Addition);

	/**
	 * Get A_Asset_Addition.
	 *
	 * @return A_Asset_Addition
	 */
	I_A_Asset_AdditionInput getA_Asset_Addition();

	/**
	 * Set A_Asset_Disposed.
	 *
	 * @param A_Asset_Disposed A_Asset_Disposed
	 */
	void setA_Asset_Disposed(I_A_Asset_DisposedInput A_Asset_Disposed);

	/**
	 * Get A_Asset_Disposed.
	 *
	 * @return A_Asset_Disposed
	 */
	I_A_Asset_DisposedInput getA_Asset_Disposed();

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
	 * Set A_Depreciation_Entry.
	 *
	 * @param A_Depreciation_Entry A_Depreciation_Entry
	 */
	void setA_Depreciation_Entry(I_A_Depreciation_EntryInput A_Depreciation_Entry);

	/**
	 * Get A_Depreciation_Entry.
	 *
	 * @return A_Depreciation_Entry
	 */
	I_A_Depreciation_EntryInput getA_Depreciation_Entry();

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
	 * Set A_Entry_Type_RL.
	 *
	 * @param A_Entry_Type_RL A_Entry_Type_RL
	 */
	void setA_Entry_Type_RL(I_AD_Ref_ListInput A_Entry_Type_RL);

	/**
	 * Get A_Entry_Type_RL.
	 *
	 * @return A_Entry_Type_RL
	 */
	I_AD_Ref_ListInput getA_Entry_Type_RL();

	/**
	 * Set A_Period_RL.
	 *
	 * @param A_Period_RL A_Period_RL
	 */
	void setA_Period_RL(I_AD_Ref_ListInput A_Period_RL);

	/**
	 * Get A_Period_RL.
	 *
	 * @return A_Period_RL
	 */
	I_AD_Ref_ListInput getA_Period_RL();

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
	 * Set CR_Account.
	 *
	 * @param CR_Account Account used
	 */
	void setCR_Account(I_C_ValidCombinationInput CR_Account);

	/**
	 * Get CR_Account.
	 *
	 * @return Account used
	 */
	I_C_ValidCombinationInput getCR_Account();

	/**
	 * Set DR_Account.
	 *
	 * @param DR_Account Account used
	 */
	void setDR_Account(I_C_ValidCombinationInput DR_Account);

	/**
	 * Get DR_Account.
	 *
	 * @return Account used
	 */
	I_C_ValidCombinationInput getDR_Account();

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
