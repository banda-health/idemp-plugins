package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Currency;

/**
 * Generated Interface for C_Currency - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_CurrencyInput extends I_C_Currency {

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

	/**
	 * Column name CurrencyName
	 */
	static final String COLUMNNAME_CurrencyName = "CurrencyName";

	/**
	 * Set Currency Name.
	 *
	 * @param CurrencyName The name of the currency
	 */
	void setCurrencyName(String CurrencyName);

	/**
	 * Get Currency Name.
	 *
	 * @return The name of the currency
	 */
	String getCurrencyName();
}
