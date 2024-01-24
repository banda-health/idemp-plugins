package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_RfQLineQty;

/**
 * Generated Interface for C_RfQLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_RfQLineQtyInput extends I_C_RfQLineQty {

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
	 * Set C_UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	void setC_UOMInput(ForeignEntityInput C_UOM);

	/**
	 * Get C_UOM.
	 *
	 * @return Unit of Measure
	 */
	ForeignEntityInput C_UOM();
}
