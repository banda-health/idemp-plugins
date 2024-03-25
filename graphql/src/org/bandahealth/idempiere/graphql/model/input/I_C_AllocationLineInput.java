package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_AllocationLine;

/**
 * Generated Interface for C_AllocationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_AllocationLineInput extends I_C_AllocationLine {

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
	 * Set C_AllocationHdr.
	 *
	 * @param C_AllocationHdr Payment allocation
	 */
	void setC_AllocationHdrInput(ForeignEntityInput C_AllocationHdr);

	/**
	 * Get C_AllocationHdr.
	 *
	 * @return Payment allocation
	 */
	ForeignEntityInput C_AllocationHdr();

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
	 * Set C_BankTransfer.
	 *
	 * @param C_BankTransfer Bank Transfer
	 */
	void setC_BankTransferInput(ForeignEntityInput C_BankTransfer);

	/**
	 * Get C_BankTransfer.
	 *
	 * @return Bank Transfer
	 */
	ForeignEntityInput C_BankTransfer();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set C_CashLine.
	 *
	 * @param C_CashLine Cash Journal Line
	 */
	void setC_CashLineInput(ForeignEntityInput C_CashLine);

	/**
	 * Get C_CashLine.
	 *
	 * @return Cash Journal Line
	 */
	ForeignEntityInput C_CashLine();

	/**
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_ChargeInput(ForeignEntityInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	ForeignEntityInput C_Charge();

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
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_OrderInput(ForeignEntityInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	ForeignEntityInput C_Order();

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
}
