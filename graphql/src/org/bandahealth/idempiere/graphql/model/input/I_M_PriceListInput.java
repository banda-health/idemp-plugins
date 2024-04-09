package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_PriceList;

/**
 * Generated Interface for M_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_PriceListInput extends I_M_PriceList {

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
	 * Set BasePriceList.
	 *
	 * @param BasePriceList Pricelist to be used, if product not found on this pricelist
	 */
	void setBasePriceListInput(ForeignEntityInput BasePriceList);

	/**
	 * Get BasePriceList.
	 *
	 * @return Pricelist to be used, if product not found on this pricelist
	 */
	ForeignEntityInput BasePriceList();

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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();
}
