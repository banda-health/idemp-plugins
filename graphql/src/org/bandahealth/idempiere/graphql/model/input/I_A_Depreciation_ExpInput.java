package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Depreciation_Exp;

/**
 * Generated Interface for A_Depreciation_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_A_Depreciation_ExpInput extends I_A_Depreciation_Exp {

	/**
	 * Set A_Account_Number_A.
	 *
	 * @param A_Account_Number_A A_Account_Number_A
	 */
	void setA_Account_Number_AInput(ForeignEntityInput A_Account_Number_A);

	/**
	 * Get A_Account_Number_A.
	 *
	 * @return A_Account_Number_A
	 */
	ForeignEntityInput A_Account_Number_A();

	/**
	 * Set A_Asset_Addition.
	 *
	 * @param A_Asset_Addition A_Asset_Addition
	 */
	void setA_Asset_AdditionInput(ForeignEntityInput A_Asset_Addition);

	/**
	 * Get A_Asset_Addition.
	 *
	 * @return A_Asset_Addition
	 */
	ForeignEntityInput A_Asset_Addition();

	/**
	 * Set A_Asset_Disposed.
	 *
	 * @param A_Asset_Disposed A_Asset_Disposed
	 */
	void setA_Asset_DisposedInput(ForeignEntityInput A_Asset_Disposed);

	/**
	 * Get A_Asset_Disposed.
	 *
	 * @return A_Asset_Disposed
	 */
	ForeignEntityInput A_Asset_Disposed();

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
	 * Set A_Depreciation_Entry.
	 *
	 * @param A_Depreciation_Entry A_Depreciation_Entry
	 */
	void setA_Depreciation_EntryInput(ForeignEntityInput A_Depreciation_Entry);

	/**
	 * Get A_Depreciation_Entry.
	 *
	 * @return A_Depreciation_Entry
	 */
	ForeignEntityInput A_Depreciation_Entry();

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
	 * Set A_Entry_Type.
	 *
	 * @param A_Entry_Type A_Entry_Type
	 */
	void setA_Entry_TypeInput(I_AD_Ref_ListInput A_Entry_Type);

	/**
	 * Get A_Entry_Type.
	 *
	 * @return A_Entry_Type
	 */
	I_AD_Ref_ListInput A_Entry_Type();

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
	 * Set CR_Account.
	 *
	 * @param CR_Account Account used
	 */
	void setCR_AccountInput(ForeignEntityInput CR_Account);

	/**
	 * Get CR_Account.
	 *
	 * @return Account used
	 */
	ForeignEntityInput CR_Account();

	/**
	 * Set DR_Account.
	 *
	 * @param DR_Account Account used
	 */
	void setDR_AccountInput(ForeignEntityInput DR_Account);

	/**
	 * Get DR_Account.
	 *
	 * @return Account used
	 */
	ForeignEntityInput DR_Account();

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
