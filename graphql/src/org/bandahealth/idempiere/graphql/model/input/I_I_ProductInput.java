package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_I_Product;

/**
 * Generated Interface for I_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_I_ProductInput extends I_I_Product {

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
	 * Set M_AttributeSet.
	 *
	 * @param M_AttributeSet Product Attribute Set
	 */
	void setM_AttributeSetInput(ForeignEntityInput M_AttributeSet);

	/**
	 * Get M_AttributeSet.
	 *
	 * @return Product Attribute Set
	 */
	ForeignEntityInput M_AttributeSet();

	/**
	 * Set M_Product_Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	void setM_Product_CategoryInput(ForeignEntityInput M_Product_Category);

	/**
	 * Get M_Product_Category.
	 *
	 * @return Category of a Product
	 */
	ForeignEntityInput M_Product_Category();

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
	 * Set ProductType.
	 *
	 * @param ProductType Type of product
	 */
	void setProductTypeInput(I_AD_Ref_ListInput ProductType);

	/**
	 * Get ProductType.
	 *
	 * @return Type of product
	 */
	I_AD_Ref_ListInput ProductType();
}
