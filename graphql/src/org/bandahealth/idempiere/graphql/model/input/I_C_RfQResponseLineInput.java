package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_RfQResponseLine;

/**
 * Generated Interface for C_RfQResponseLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_RfQResponseLineInput extends I_C_RfQResponseLine {

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
	 * Set C_RfQLine.
	 *
	 * @param C_RfQLine Request for Quotation Line
	 */
	void setC_RfQLineInput(ForeignEntityInput C_RfQLine);

	/**
	 * Get C_RfQLine.
	 *
	 * @return Request for Quotation Line
	 */
	ForeignEntityInput C_RfQLine();

	/**
	 * Set C_RfQResponse.
	 *
	 * @param C_RfQResponse Request for Quotation Response from a potential Vendor
	 */
	void setC_RfQResponseInput(ForeignEntityInput C_RfQResponse);

	/**
	 * Get C_RfQResponse.
	 *
	 * @return Request for Quotation Response from a potential Vendor
	 */
	ForeignEntityInput C_RfQResponse();

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
