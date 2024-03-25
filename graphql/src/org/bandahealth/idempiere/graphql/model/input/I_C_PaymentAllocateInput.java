package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_PaymentAllocate;

/**
 * Generated Interface for C_PaymentAllocate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_PaymentAllocateInput extends I_C_PaymentAllocate {

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
	 * Set C_AllocationLine.
	 *
	 * @param C_AllocationLine Allocation Line
	 */
	void setC_AllocationLineInput(ForeignEntityInput C_AllocationLine);

	/**
	 * Get C_AllocationLine.
	 *
	 * @return Allocation Line
	 */
	ForeignEntityInput C_AllocationLine();

	/**
	 * Set C_Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	void setC_InvoiceInput(ForeignEntityInput C_Invoice);

	/**
	 * Get C_Invoice.
	 *
	 * @return Invoice Identifier
	 */
	ForeignEntityInput C_Invoice();

	/**
	 * Set C_Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	void setC_PaymentInput(ForeignEntityInput C_Payment);

	/**
	 * Get C_Payment.
	 *
	 * @return Payment identifier
	 */
	ForeignEntityInput C_Payment();

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
