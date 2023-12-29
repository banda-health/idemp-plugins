package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Region;

/**
 * Generated Interface for C_Region - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_RegionInput extends I_C_Region {

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
}
