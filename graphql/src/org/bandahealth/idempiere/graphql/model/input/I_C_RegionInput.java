package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Region;

/**
 * Generated Interface for C_Region - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_RegionInput extends I_C_Region {

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
}
