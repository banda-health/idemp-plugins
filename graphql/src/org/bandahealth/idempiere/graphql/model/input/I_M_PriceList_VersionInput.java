package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_PriceList_Version;

/**
 * Generated Interface for M_PriceList_Version - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_PriceList_VersionInput extends I_M_PriceList_Version {

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
	 * Set M_DiscountSchema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	void setM_DiscountSchemaInput(ForeignEntityInput M_DiscountSchema);

	/**
	 * Get M_DiscountSchema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	ForeignEntityInput M_DiscountSchema();

	/**
	 * Set M_PriceList.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	void setM_PriceListInput(ForeignEntityInput M_PriceList);

	/**
	 * Get M_PriceList.
	 *
	 * @return Unique identifier of a Price List
	 */
	ForeignEntityInput M_PriceList();

	/**
	 * Set M_Pricelist_Version_Base.
	 *
	 * @param M_Pricelist_Version_Base Source for Price list calculations
	 */
	void setM_Pricelist_Version_BaseInput(ForeignEntityInput M_Pricelist_Version_Base);

	/**
	 * Get M_Pricelist_Version_Base.
	 *
	 * @return Source for Price list calculations
	 */
	ForeignEntityInput M_Pricelist_Version_Base();

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
}
