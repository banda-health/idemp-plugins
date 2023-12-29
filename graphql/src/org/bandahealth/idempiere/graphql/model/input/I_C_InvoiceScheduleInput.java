package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_InvoiceSchedule;

/**
 * Generated Interface for C_InvoiceSchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_InvoiceScheduleInput extends I_C_InvoiceSchedule {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

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
	 * Set InvoiceFrequency_RL.
	 *
	 * @param InvoiceFrequency_RL How often invoices will be generated
	 */
	void setInvoiceFrequency_RL(I_AD_Ref_ListInput InvoiceFrequency_RL);

	/**
	 * Get InvoiceFrequency_RL.
	 *
	 * @return How often invoices will be generated
	 */
	I_AD_Ref_ListInput getInvoiceFrequency_RL();

	/**
	 * Set InvoiceWeekDay_RL.
	 *
	 * @param InvoiceWeekDay_RL Day to generate invoices
	 */
	void setInvoiceWeekDay_RL(I_AD_Ref_ListInput InvoiceWeekDay_RL);

	/**
	 * Get InvoiceWeekDay_RL.
	 *
	 * @return Day to generate invoices
	 */
	I_AD_Ref_ListInput getInvoiceWeekDay_RL();

	/**
	 * Set InvoiceWeekDayCutoff_RL.
	 *
	 * @param InvoiceWeekDayCutoff_RL Last day in the week for shipments to be included
	 */
	void setInvoiceWeekDayCutoff_RL(I_AD_Ref_ListInput InvoiceWeekDayCutoff_RL);

	/**
	 * Get InvoiceWeekDayCutoff_RL.
	 *
	 * @return Last day in the week for shipments to be included
	 */
	I_AD_Ref_ListInput getInvoiceWeekDayCutoff_RL();
}
