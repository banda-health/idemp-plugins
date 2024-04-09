package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_InvoiceSchedule;

/**
 * Generated Interface for C_InvoiceSchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
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
	void setInvoiceFrequencyInput(I_AD_Ref_ListInput InvoiceFrequency);

	/**
	 * Get InvoiceFrequency.
	 *
	 * @return How often invoices will be generated
	 */
	I_AD_Ref_ListInput InvoiceFrequency();

	/**
	 * Set InvoiceWeekDay.
	 *
	 * @param InvoiceWeekDay Day to generate invoices
	 */
	void setInvoiceWeekDayInput(I_AD_Ref_ListInput InvoiceWeekDay);

	/**
	 * Get InvoiceWeekDay.
	 *
	 * @return Day to generate invoices
	 */
	I_AD_Ref_ListInput InvoiceWeekDay();

	/**
	 * Set InvoiceWeekDayCutoff.
	 *
	 * @param InvoiceWeekDayCutoff Last day in the week for shipments to be included
	 */
	void setInvoiceWeekDayCutoffInput(I_AD_Ref_ListInput InvoiceWeekDayCutoff);

	/**
	 * Get InvoiceWeekDayCutoff.
	 *
	 * @return Last day in the week for shipments to be included
	 */
	I_AD_Ref_ListInput InvoiceWeekDayCutoff();
}
