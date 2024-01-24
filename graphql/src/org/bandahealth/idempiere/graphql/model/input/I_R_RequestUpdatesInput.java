package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_RequestUpdates;

/**
 * Generated Interface for R_RequestUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_R_RequestUpdatesInput extends I_R_RequestUpdates {

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
	 * Set R_Request.
	 *
	 * @param R_Request Request from a Business Partner or Prospect
	 */
	void setR_RequestInput(ForeignEntityInput R_Request);

	/**
	 * Get R_Request.
	 *
	 * @return Request from a Business Partner or Prospect
	 */
	ForeignEntityInput R_Request();

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
