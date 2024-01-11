package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_WS_WebServiceType;

/**
 * Generated Interface for WS_WebServiceType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_WS_WebServiceTypeInput extends I_WS_WebServiceType {

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
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(ForeignEntityInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	ForeignEntityInput AD_Table();

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
	 * Set WS_WebServiceMethod.
	 *
	 * @param WS_WebServiceMethod WS_WebServiceMethod
	 */
	void setWS_WebServiceMethodInput(ForeignEntityInput WS_WebServiceMethod);

	/**
	 * Get WS_WebServiceMethod.
	 *
	 * @return WS_WebServiceMethod
	 */
	ForeignEntityInput WS_WebServiceMethod();

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
