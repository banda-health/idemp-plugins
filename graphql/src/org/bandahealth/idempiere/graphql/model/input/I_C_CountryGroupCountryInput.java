package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_CountryGroupCountry;

/**
 * Generated Interface for C_CountryGroupCountry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_CountryGroupCountryInput extends I_C_CountryGroupCountry {

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
	 * Set C_Country.
	 *
	 * @param C_Country Country 
	 */
	void setC_CountryInput(ForeignEntityInput C_Country);

	/**
	 * Get C_Country.
	 *
	 * @return Country 
	 */
	ForeignEntityInput C_Country();

	/**
	 * Set C_CountryGroup.
	 *
	 * @param C_CountryGroup C_CountryGroup
	 */
	void setC_CountryGroupInput(ForeignEntityInput C_CountryGroup);

	/**
	 * Get C_CountryGroup.
	 *
	 * @return C_CountryGroup
	 */
	ForeignEntityInput C_CountryGroup();

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
