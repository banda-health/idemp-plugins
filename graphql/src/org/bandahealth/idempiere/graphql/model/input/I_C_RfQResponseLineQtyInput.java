package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_RfQResponseLineQty;

/**
 * Generated Interface for C_RfQResponseLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_RfQResponseLineQtyInput extends I_C_RfQResponseLineQty {

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
}
