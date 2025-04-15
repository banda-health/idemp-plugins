package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_AllUsers_V;

/**
 * Generated Interface for AD_AllUsers_V - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

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
