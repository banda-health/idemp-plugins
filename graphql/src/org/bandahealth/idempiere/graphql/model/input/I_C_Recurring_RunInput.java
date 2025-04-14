package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Recurring_Run;

/**
 * Generated Interface for C_Recurring_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_Recurring_RunInput extends I_C_Recurring_Run {

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

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_ProjectInput(ForeignEntityInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	ForeignEntityInput C_Project();

	/**
	 * Set C_Recurring.
	 *
	 * @param C_Recurring Recurring Document
	 */
	void setC_RecurringInput(ForeignEntityInput C_Recurring);

	/**
	 * Get C_Recurring.
	 *
	 * @return Recurring Document
	 */
	ForeignEntityInput C_Recurring();

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

	/**
	 * Set GL_JournalBatch.
	 *
	 * @param GL_JournalBatch General Ledger Journal Batch
	 */
	void setGL_JournalBatchInput(ForeignEntityInput GL_JournalBatch);

	/**
	 * Get GL_JournalBatch.
	 *
	 * @return General Ledger Journal Batch
	 */
	ForeignEntityInput GL_JournalBatch();
}
