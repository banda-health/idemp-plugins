package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_LdapAccess;

/**
 * Generated Interface for AD_LdapAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_LdapAccessInput extends I_AD_LdapAccess {

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
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();

	/**
	 * Set R_InterestArea.
	 *
	 * @param R_InterestArea Interest Area or Topic
	 */
	void setR_InterestAreaInput(ForeignEntityInput R_InterestArea);

	/**
	 * Get R_InterestArea.
	 *
	 * @return Interest Area or Topic
	 */
	ForeignEntityInput R_InterestArea();
}
