package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Location;

/**
 * Generated Interface for C_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_LocationInput extends I_C_Location {

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
	 * Set C_AddressValidation.
	 *
	 * @param C_AddressValidation C_AddressValidation
	 */
	void setC_AddressValidation(I_C_AddressValidationInput C_AddressValidation);

	/**
	 * Get C_AddressValidation.
	 *
	 * @return C_AddressValidation
	 */
	I_C_AddressValidationInput getC_AddressValidation();

	/**
	 * Set C_City.
	 *
	 * @param C_City City
	 */
	void setC_City(I_C_CityInput C_City);

	/**
	 * Get C_City.
	 *
	 * @return City
	 */
	I_C_CityInput getC_City();

	/**
	 * Set C_Country.
	 *
	 * @param C_Country Country 
	 */
	void setC_Country(I_C_CountryInput C_Country);

	/**
	 * Get C_Country.
	 *
	 * @return Country 
	 */
	I_C_CountryInput getC_Country();

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
	 * Set C_Region.
	 *
	 * @param C_Region Identifies a geographical Region
	 */
	void setC_Region(I_C_RegionInput C_Region);

	/**
	 * Get C_Region.
	 *
	 * @return Identifies a geographical Region
	 */
	I_C_RegionInput getC_Region();
}
