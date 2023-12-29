package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BPartner_Location;

/**
 * Generated Interface for C_BPartner_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_BPartner_LocationInput extends I_C_BPartner_Location {

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
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartner(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput getC_BPartner();

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
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_Location(I_C_LocationInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	I_C_LocationInput getC_Location();

	/**
	 * Set C_SalesRegion.
	 *
	 * @param C_SalesRegion Sales coverage region
	 */
	void setC_SalesRegion(I_C_SalesRegionInput C_SalesRegion);

	/**
	 * Get C_SalesRegion.
	 *
	 * @return Sales coverage region
	 */
	I_C_SalesRegionInput getC_SalesRegion();
}
