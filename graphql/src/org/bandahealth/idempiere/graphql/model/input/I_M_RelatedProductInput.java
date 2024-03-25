package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_RelatedProduct;

/**
 * Generated Interface for M_RelatedProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_RelatedProductInput extends I_M_RelatedProduct {

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
	 * Set RelatedProduct.
	 *
	 * @param RelatedProduct Related Product
	 */
	void setRelatedProductInput(ForeignEntityInput RelatedProduct);

	/**
	 * Get RelatedProduct.
	 *
	 * @return Related Product
	 */
	ForeignEntityInput RelatedProduct();

	/**
	 * Set RelatedProductType.
	 *
	 * @param RelatedProductType RelatedProductType
	 */
	void setRelatedProductTypeInput(I_AD_Ref_ListInput RelatedProductType);

	/**
	 * Get RelatedProductType.
	 *
	 * @return RelatedProductType
	 */
	I_AD_Ref_ListInput RelatedProductType();
}
