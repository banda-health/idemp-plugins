package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Recurring;

/**
 * Generated Interface for C_Recurring - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_RecurringInput extends I_C_Recurring {

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
	 * Set C_RecurringGroup.
	 *
	 * @param C_RecurringGroup C_RecurringGroup
	 */
	void setC_RecurringGroupInput(ForeignEntityInput C_RecurringGroup);

	/**
	 * Get C_RecurringGroup.
	 *
	 * @return C_RecurringGroup
	 */
	ForeignEntityInput C_RecurringGroup();

	/**
	 * Set FrequencyType.
	 *
	 * @param FrequencyType Frequency of event
	 */
	void setFrequencyTypeInput(I_AD_Ref_ListInput FrequencyType);

	/**
	 * Get FrequencyType.
	 *
	 * @return Frequency of event
	 */
	I_AD_Ref_ListInput FrequencyType();

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

	/**
	 * Set RecurringType.
	 *
	 * @param RecurringType Type of Recurring Document
	 */
	void setRecurringTypeInput(I_AD_Ref_ListInput RecurringType);

	/**
	 * Get RecurringType.
	 *
	 * @return Type of Recurring Document
	 */
	I_AD_Ref_ListInput RecurringType();
}
