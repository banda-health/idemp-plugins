package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_WS_WebServiceMethod;

/**
 * Generated Interface for WS_WebServiceMethod - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_WS_WebServiceMethodInput extends I_WS_WebServiceMethod {

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
	 * Set WS_WebService.
	 *
	 * @param WS_WebService WS_WebService
	 */
	void setWS_WebServiceInput(ForeignEntityInput WS_WebService);

	/**
	 * Get WS_WebService.
	 *
	 * @return WS_WebService
	 */
	ForeignEntityInput WS_WebService();

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
