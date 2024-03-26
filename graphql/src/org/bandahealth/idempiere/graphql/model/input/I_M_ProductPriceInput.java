package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ProductPrice;

/**
 * Generated Interface for M_ProductPrice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_ProductPriceInput extends I_M_ProductPrice {

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
	 * Set M_PriceList_Version.
	 *
	 * @param M_PriceList_Version Identifies a unique instance of a Price List
	 */
	void setM_PriceList_VersionInput(ForeignEntityInput M_PriceList_Version);

	/**
	 * Get M_PriceList_Version.
	 *
	 * @return Identifies a unique instance of a Price List
	 */
	ForeignEntityInput M_PriceList_Version();

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
}
