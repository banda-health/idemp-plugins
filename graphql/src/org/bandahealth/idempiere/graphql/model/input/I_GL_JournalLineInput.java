package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_GL_JournalLine;

/**
 * Generated Interface for GL_JournalLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_GL_JournalLineInput extends I_GL_JournalLine {

	/**
	 * Set A_Asset_Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	void setA_Asset_GroupInput(ForeignEntityInput A_Asset_Group);

	/**
	 * Get A_Asset_Group.
	 *
	 * @return Group of Assets
	 */
	ForeignEntityInput A_Asset_Group();

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
	 * Set Account.
	 *
	 * @param Account Account used
	 */
	void setAccountInput(ForeignEntityInput Account);

	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	ForeignEntityInput Account();

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
	 * Set Alias_ValidCombination.
	 *
	 * @param Alias_ValidCombination Valid Account Alias List
	 */
	void setAlias_ValidCombinationInput(ForeignEntityInput Alias_ValidCombination);

	/**
	 * Get Alias_ValidCombination.
	 *
	 * @return Valid Account Alias List
	 */
	ForeignEntityInput Alias_ValidCombination();

	/**
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_ActivityInput(ForeignEntityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	ForeignEntityInput C_Activity();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_CampaignInput(ForeignEntityInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	ForeignEntityInput C_Campaign();

	/**
	 * Set C_ConversionType.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	void setC_ConversionTypeInput(ForeignEntityInput C_ConversionType);

	/**
	 * Get C_ConversionType.
	 *
	 * @return Currency Conversion Rate Type
	 */
	ForeignEntityInput C_ConversionType();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(ForeignEntityInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	ForeignEntityInput C_Currency();

	/**
	 * Set C_LocFrom.
	 *
	 * @param C_LocFrom Location that inventory was moved from
	 */
	void setC_LocFromInput(ForeignEntityInput C_LocFrom);

	/**
	 * Get C_LocFrom.
	 *
	 * @return Location that inventory was moved from
	 */
	ForeignEntityInput C_LocFrom();

	/**
	 * Set C_LocTo.
	 *
	 * @param C_LocTo Location that inventory was moved to
	 */
	void setC_LocToInput(ForeignEntityInput C_LocTo);

	/**
	 * Get C_LocTo.
	 *
	 * @return Location that inventory was moved to
	 */
	ForeignEntityInput C_LocTo();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_ProjectInput(ForeignEntityInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	ForeignEntityInput C_Project();

	/**
	 * Set C_SalesRegion.
	 *
	 * @param C_SalesRegion Sales coverage region
	 */
	void setC_SalesRegionInput(ForeignEntityInput C_SalesRegion);

	/**
	 * Get C_SalesRegion.
	 *
	 * @return Sales coverage region
	 */
	ForeignEntityInput C_SalesRegion();

	/**
	 * Set C_SubAcct.
	 *
	 * @param C_SubAcct Sub account for Element Value
	 */
	void setC_SubAcctInput(ForeignEntityInput C_SubAcct);

	/**
	 * Get C_SubAcct.
	 *
	 * @return Sub account for Element Value
	 */
	ForeignEntityInput C_SubAcct();

	/**
	 * Set C_UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	void setC_UOMInput(ForeignEntityInput C_UOM);

	/**
	 * Get C_UOM.
	 *
	 * @return Unit of Measure
	 */
	ForeignEntityInput C_UOM();

	/**
	 * Set C_ValidCombination.
	 *
	 * @param C_ValidCombination Valid Account Combination
	 */
	void setC_ValidCombinationInput(ForeignEntityInput C_ValidCombination);

	/**
	 * Get C_ValidCombination.
	 *
	 * @return Valid Account Combination
	 */
	ForeignEntityInput C_ValidCombination();

	/**
	 * Set GL_Journal.
	 *
	 * @param GL_Journal General Ledger Journal
	 */
	void setGL_JournalInput(ForeignEntityInput GL_Journal);

	/**
	 * Get GL_Journal.
	 *
	 * @return General Ledger Journal
	 */
	ForeignEntityInput GL_Journal();

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
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(ForeignEntityInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	ForeignEntityInput M_Product();

	/**
	 * Set User1.
	 *
	 * @param User1 User defined list element #1
	 */
	void setUser1Input(ForeignEntityInput User1);

	/**
	 * Get User1.
	 *
	 * @return User defined list element #1
	 */
	ForeignEntityInput User1();

	/**
	 * Set User2.
	 *
	 * @param User2 User defined list element #2
	 */
	void setUser2Input(ForeignEntityInput User2);

	/**
	 * Get User2.
	 *
	 * @return User defined list element #2
	 */
	ForeignEntityInput User2();
}
