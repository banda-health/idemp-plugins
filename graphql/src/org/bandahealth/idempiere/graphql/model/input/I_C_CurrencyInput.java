package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Currency;

/**
 * Generated Interface for C_Currency - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_CurrencyInput extends I_C_Currency {

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
