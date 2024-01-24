package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Location;

/**
 * Generated Interface for C_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_LocationInput extends I_C_Location {

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
	 * Set C_AddressValidation.
	 *
	 * @param C_AddressValidation C_AddressValidation
	 */
	void setC_AddressValidationInput(ForeignEntityInput C_AddressValidation);

	/**
	 * Get C_AddressValidation.
	 *
	 * @return C_AddressValidation
	 */
	ForeignEntityInput C_AddressValidation();

	/**
	 * Set C_City.
	 *
	 * @param C_City City
	 */
	void setC_CityInput(ForeignEntityInput C_City);

	/**
	 * Get C_City.
	 *
	 * @return City
	 */
	ForeignEntityInput C_City();

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
	 * Set C_Region.
	 *
	 * @param C_Region Identifies a geographical Region
	 */
	void setC_RegionInput(ForeignEntityInput C_Region);

	/**
	 * Get C_Region.
	 *
	 * @return Identifies a geographical Region
	 */
	ForeignEntityInput C_Region();
}
