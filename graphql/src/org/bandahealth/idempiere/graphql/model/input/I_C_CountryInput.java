package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Country;

/**
 * Generated Interface for C_Country - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_CountryInput extends I_C_Country {

	/**
	 * Set AD_Language.
	 *
	 * @param AD_Language Language for this entity
	 */
	void setAD_LanguageInput(ForeignEntityInput AD_Language);

	/**
	 * Get AD_Language.
	 *
	 * @return Language for this entity
	 */
	ForeignEntityInput AD_Language();

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
}
