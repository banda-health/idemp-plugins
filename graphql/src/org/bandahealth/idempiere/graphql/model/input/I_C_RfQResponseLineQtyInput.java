package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_RfQResponseLineQty;

/**
 * Generated Interface for C_RfQResponseLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_RfQResponseLineQtyInput extends I_C_RfQResponseLineQty {

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
	 * Set C_RfQLineQty.
	 *
	 * @param C_RfQLineQty Request for Quotation Line Quantity
	 */
	void setC_RfQLineQtyInput(ForeignEntityInput C_RfQLineQty);

	/**
	 * Get C_RfQLineQty.
	 *
	 * @return Request for Quotation Line Quantity
	 */
	ForeignEntityInput C_RfQLineQty();

	/**
	 * Set C_RfQResponseLine.
	 *
	 * @param C_RfQResponseLine Request for Quotation Response Line
	 */
	void setC_RfQResponseLineInput(ForeignEntityInput C_RfQResponseLine);

	/**
	 * Get C_RfQResponseLine.
	 *
	 * @return Request for Quotation Response Line
	 */
	ForeignEntityInput C_RfQResponseLine();

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
