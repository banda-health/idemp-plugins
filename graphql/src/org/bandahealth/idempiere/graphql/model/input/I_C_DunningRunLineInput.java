package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_DunningRunLine;

/**
 * Generated Interface for C_DunningRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_DunningRunLineInput extends I_C_DunningRunLine {

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
	 * Set C_DunningRunEntry.
	 *
	 * @param C_DunningRunEntry Dunning Run Entry
	 */
	void setC_DunningRunEntryInput(ForeignEntityInput C_DunningRunEntry);

	/**
	 * Get C_DunningRunEntry.
	 *
	 * @return Dunning Run Entry
	 */
	ForeignEntityInput C_DunningRunEntry();

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
	 * Set C_InvoicePaySchedule.
	 *
	 * @param C_InvoicePaySchedule Invoice Payment Schedule
	 */
	void setC_InvoicePayScheduleInput(ForeignEntityInput C_InvoicePaySchedule);

	/**
	 * Get C_InvoicePaySchedule.
	 *
	 * @return Invoice Payment Schedule
	 */
	ForeignEntityInput C_InvoicePaySchedule();

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
