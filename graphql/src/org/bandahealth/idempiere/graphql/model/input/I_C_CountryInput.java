package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Country;

/**
 * Generated Interface for C_Country - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_CountryInput extends I_C_Country {

	/**
	 * Set AD_Language_L.
	 *
	 * @param AD_Language_L Language for this entity
	 */
	void setAD_Language_L(I_AD_LanguageInput AD_Language_L);

	/**
	 * Get AD_Language_L.
	 *
	 * @return Language for this entity
	 */
	I_AD_LanguageInput getAD_Language_L();

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
}
