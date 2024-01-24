package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_AllUsers_V;

/**
 * Generated Interface for AD_AllUsers_V - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_AllUsers_VInput extends I_AD_AllUsers_V {

	/**
	 * Set AD_AllClients_V.
	 *
	 * @param AD_AllClients_V AD_AllClients_V
	 */
	void setAD_AllClients_VInput(ForeignEntityInput AD_AllClients_V);

	/**
	 * Get AD_AllClients_V.
	 *
	 * @return AD_AllClients_V
	 */
	ForeignEntityInput AD_AllClients_V();

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
}
