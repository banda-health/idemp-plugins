package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_WS_WebService_Para;

/**
 * Generated Interface for WS_WebService_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_WS_WebService_ParaInput extends I_WS_WebService_Para {

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
	 * Set ParameterType.
	 *
	 * @param ParameterType ParameterType
	 */
	void setParameterTypeInput(I_AD_Ref_ListInput ParameterType);

	/**
	 * Get ParameterType.
	 *
	 * @return ParameterType
	 */
	I_AD_Ref_ListInput ParameterType();

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
}
