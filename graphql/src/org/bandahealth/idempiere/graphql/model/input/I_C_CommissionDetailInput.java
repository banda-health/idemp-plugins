package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_CommissionDetail;

/**
 * Generated Interface for C_CommissionDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_CommissionDetailInput extends I_C_CommissionDetail {

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
	 * Set C_CommissionAmt.
	 *
	 * @param C_CommissionAmt Generated Commission Amount 
	 */
	void setC_CommissionAmtInput(ForeignEntityInput C_CommissionAmt);

	/**
	 * Get C_CommissionAmt.
	 *
	 * @return Generated Commission Amount 
	 */
	ForeignEntityInput C_CommissionAmt();

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
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(ForeignEntityInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	ForeignEntityInput C_Currency();

	/**
	 * Set C_InvoiceLine.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	void setC_InvoiceLineInput(ForeignEntityInput C_InvoiceLine);

	/**
	 * Get C_InvoiceLine.
	 *
	 * @return Invoice Detail Line
	 */
	ForeignEntityInput C_InvoiceLine();

	/**
	 * Set C_OrderLine.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	void setC_OrderLineInput(ForeignEntityInput C_OrderLine);

	/**
	 * Get C_OrderLine.
	 *
	 * @return Sales Order Line
	 */
	ForeignEntityInput C_OrderLine();
}
