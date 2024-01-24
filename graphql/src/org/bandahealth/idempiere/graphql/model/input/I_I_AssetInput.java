package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_I_Asset;

/**
 * Generated Interface for I_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_I_AssetInput extends I_I_Asset {

	/**
	 * Set A_Accumdepreciation_A.
	 *
	 * @param A_Accumdepreciation_A A_Accumdepreciation_A
	 */
	void setA_Accumdepreciation_AInput(ForeignEntityInput A_Accumdepreciation_A);

	/**
	 * Get A_Accumdepreciation_A.
	 *
	 * @return A_Accumdepreciation_A
	 */
	ForeignEntityInput A_Accumdepreciation_A();

	/**
	 * Set A_Asset_A.
	 *
	 * @param A_Asset_A A_Asset_A
	 */
	void setA_Asset_AInput(ForeignEntityInput A_Asset_A);

	/**
	 * Get A_Asset_A.
	 *
	 * @return A_Asset_A
	 */
	ForeignEntityInput A_Asset_A();

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
	 * Set A_Depreciation_A.
	 *
	 * @param A_Depreciation_A A_Depreciation_A
	 */
	void setA_Depreciation_AInput(ForeignEntityInput A_Depreciation_A);

	/**
	 * Get A_Depreciation_A.
	 *
	 * @return A_Depreciation_A
	 */
	ForeignEntityInput A_Depreciation_A();

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
	void setA_Depreciation_Table_HeaderInput(ForeignEntityInput A_Depreciation_Table_Header);

	/**
	 * Get A_Depreciation_Table_Header.
	 *
	 * @return A_Depreciation_Table_Header
	 */
	ForeignEntityInput A_Depreciation_Table_Header();

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
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_LocationInput(ForeignEntityInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	ForeignEntityInput C_BPartner_Location();

	/**
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_LocationInput(ForeignEntityInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	ForeignEntityInput C_Location();

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
	 * Set M_AttributeSetInstance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance);

	/**
	 * Get M_AttributeSetInstance.
	 *
	 * @return Product Attribute Set Instance
	 */
	ForeignEntityInput M_AttributeSetInstance();

	/**
	 * Set M_Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	void setM_LocatorInput(ForeignEntityInput M_Locator);

	/**
	 * Get M_Locator.
	 *
	 * @return Warehouse Locator
	 */
	ForeignEntityInput M_Locator();

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
