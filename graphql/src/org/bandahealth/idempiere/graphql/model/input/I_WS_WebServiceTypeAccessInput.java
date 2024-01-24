package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_WS_WebServiceTypeAccess;

/**
 * Generated Interface for WS_WebServiceTypeAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_WS_WebServiceTypeAccessInput extends I_WS_WebServiceTypeAccess {

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
	 * Set AD_Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	void setAD_RoleInput(ForeignEntityInput AD_Role);

	/**
	 * Get AD_Role.
	 *
	 * @return Responsibility Role
	 */
	ForeignEntityInput AD_Role();

	/**
	 * Set WS_WebServiceType.
	 *
	 * @param WS_WebServiceType WS_WebServiceType
	 */
	void setWS_WebServiceTypeInput(ForeignEntityInput WS_WebServiceType);

	/**
	 * Get WS_WebServiceType.
	 *
	 * @return WS_WebServiceType
	 */
	ForeignEntityInput WS_WebServiceType();

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
