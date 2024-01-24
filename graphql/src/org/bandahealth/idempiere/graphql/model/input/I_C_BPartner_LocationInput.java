package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BPartner_Location;

/**
 * Generated Interface for C_BPartner_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_BPartner_LocationInput extends I_C_BPartner_Location {

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
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

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
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_LocationInput(ForeignEntityInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	ForeignEntityInput C_Location();

	/**
	 * Set C_SalesRegion.
	 *
	 * @param C_SalesRegion Sales coverage region
	 */
	void setC_SalesRegionInput(ForeignEntityInput C_SalesRegion);

	/**
	 * Get C_SalesRegion.
	 *
	 * @return Sales coverage region
	 */
	ForeignEntityInput C_SalesRegion();
}
