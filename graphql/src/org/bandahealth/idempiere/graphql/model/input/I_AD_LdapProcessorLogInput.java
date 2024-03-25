package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_LdapProcessorLog;

/**
 * Generated Interface for AD_LdapProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_LdapProcessorLogInput extends I_AD_LdapProcessorLog {

	/**
	 * Set AD_LdapProcessor.
	 *
	 * @param AD_LdapProcessor LDAP Server to authenticate and authorize external systems based on iDempiere
	 */
	void setAD_LdapProcessorInput(ForeignEntityInput AD_LdapProcessor);

	/**
	 * Get AD_LdapProcessor.
	 *
	 * @return LDAP Server to authenticate and authorize external systems based on iDempiere
	 */
	ForeignEntityInput AD_LdapProcessor();

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
}
