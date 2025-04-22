package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_InvoiceSchedule;

/**
 * Generated Interface for C_InvoiceSchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_InvoiceScheduleInput extends I_C_InvoiceSchedule {

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
	 * Set InvoiceFrequency.
	 *
	 * @param InvoiceFrequency How often invoices will be generated
	 */
	void setInvoiceFrequencyInput(ForeignEntityInput InvoiceFrequency);

	/**
	 * Get InvoiceFrequency.
	 *
	 * @return How often invoices will be generated
	 */
	ForeignEntityInput InvoiceFrequency();

	/**
	 * Set InvoiceWeekDay.
	 *
	 * @param InvoiceWeekDay Day to generate invoices
	 */
	void setInvoiceWeekDayInput(ForeignEntityInput InvoiceWeekDay);

	/**
	 * Get InvoiceWeekDay.
	 *
	 * @return Day to generate invoices
	 */
	ForeignEntityInput InvoiceWeekDay();

	/**
	 * Set InvoiceWeekDayCutoff.
	 *
	 * @param InvoiceWeekDayCutoff Last day in the week for shipments to be included
	 */
	void setInvoiceWeekDayCutoffInput(ForeignEntityInput InvoiceWeekDayCutoff);

	/**
	 * Get InvoiceWeekDayCutoff.
	 *
	 * @return Last day in the week for shipments to be included
	 */
	ForeignEntityInput InvoiceWeekDayCutoff();
}
