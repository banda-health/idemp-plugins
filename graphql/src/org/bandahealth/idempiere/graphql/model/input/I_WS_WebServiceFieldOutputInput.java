package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_WS_WebServiceFieldOutput;

/**
 * Generated Interface for WS_WebServiceFieldOutput - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_WS_WebServiceFieldOutputInput extends I_WS_WebServiceFieldOutput {

	/**
	 * Set AD_Column.
	 *
	 * @param AD_Column Column in the table
	 */
	void setAD_ColumnInput(ForeignEntityInput AD_Column);

	/**
	 * Get AD_Column.
	 *
	 * @return Column in the table
	 */
	ForeignEntityInput AD_Column();

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
