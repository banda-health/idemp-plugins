package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_PriceList;

/**
 * Generated Interface for M_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_PriceListInput extends I_M_PriceList {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set BasePriceList.
	 *
	 * @param BasePriceList Pricelist to be used, if product not found on this pricelist
	 */
	void setBasePriceListInput(I_M_PriceListInput BasePriceList);

	/**
	 * Get BasePriceList.
	 *
	 * @return Pricelist to be used, if product not found on this pricelist
	 */
	I_M_PriceListInput BasePriceList();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput C_Currency();

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
