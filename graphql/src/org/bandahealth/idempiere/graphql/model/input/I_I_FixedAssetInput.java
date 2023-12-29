package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_I_FixedAsset;

/**
 * Generated Interface for I_FixedAsset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_I_FixedAssetInput extends I_I_FixedAsset {

	/**
	 * Set A_Asset_Class.
	 *
	 * @param A_Asset_Class A_Asset_Class
	 */
	void setA_Asset_Class(I_A_Asset_ClassInput A_Asset_Class);

	/**
	 * Get A_Asset_Class.
	 *
	 * @return A_Asset_Class
	 */
	I_A_Asset_ClassInput getA_Asset_Class();

	/**
	 * Set A_Asset_Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	void setA_Asset_Group(I_A_Asset_GroupInput A_Asset_Group);

	/**
	 * Get A_Asset_Group.
	 *
	 * @return Group of Assets
	 */
	I_A_Asset_GroupInput getA_Asset_Group();

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
	 * Set A_Asset_Type.
	 *
	 * @param A_Asset_Type A_Asset_Type
	 */
	void setA_Asset_Type(I_A_Asset_TypeInput A_Asset_Type);

	/**
	 * Get A_Asset_Type.
	 *
	 * @return A_Asset_Type
	 */
	I_A_Asset_TypeInput getA_Asset_Type();

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
	 * Set C_BPartnerSR.
	 *
	 * @param C_BPartnerSR Business Partner (Agent or Sales Rep)
	 */
	void setC_BPartnerSR(I_C_BPartnerInput C_BPartnerSR);

	/**
	 * Get C_BPartnerSR.
	 *
	 * @return Business Partner (Agent or Sales Rep)
	 */
	I_C_BPartnerInput getC_BPartnerSR();

	/**
	 * Set C_City.
	 *
	 * @param C_City City
	 */
	void setC_City(I_C_CityInput C_City);

	/**
	 * Get C_City.
	 *
	 * @return City
	 */
	I_C_CityInput getC_City();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_Currency(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput getC_Currency();

	/**
	 * Set C_UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	void setC_UOM(I_C_UOMInput C_UOM);

	/**
	 * Get C_UOM.
	 *
	 * @return Unit of Measure
	 */
	I_C_UOMInput getC_UOM();

	/**
	 * Set DocAction_RL.
	 *
	 * @param DocAction_RL The targeted status of the document
	 */
	void setDocAction_RL(I_AD_Ref_ListInput DocAction_RL);

	/**
	 * Get DocAction_RL.
	 *
	 * @return The targeted status of the document
	 */
	I_AD_Ref_ListInput getDocAction_RL();

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
	 * Set M_Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	void setM_Locator(I_M_LocatorInput M_Locator);

	/**
	 * Get M_Locator.
	 *
	 * @return Warehouse Locator
	 */
	I_M_LocatorInput getM_Locator();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_Product(I_M_ProductInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	I_M_ProductInput getM_Product();
}
