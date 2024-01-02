package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_DunningLevel;

/**
 * Generated Interface for C_DunningLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_DunningLevelInput extends I_C_DunningLevel {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set C_Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	void setC_DunningInput(I_C_DunningInput C_Dunning);

	/**
	 * Get C_Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	I_C_DunningInput C_Dunning();

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
	 * Set C_PaymentTerm.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	void setC_PaymentTermInput(I_C_PaymentTermInput C_PaymentTerm);

	/**
	 * Get C_PaymentTerm.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	I_C_PaymentTermInput C_PaymentTerm();

	/**
	 * Set Dunning_PrintFormat.
	 *
	 * @param Dunning_PrintFormat Print Format for printing Dunning Letters
	 */
	void setDunning_PrintFormatInput(I_AD_PrintFormatInput Dunning_PrintFormat);

	/**
	 * Get Dunning_PrintFormat.
	 *
	 * @return Print Format for printing Dunning Letters
	 */
	I_AD_PrintFormatInput Dunning_PrintFormat();

	/**
	 * Set InvoiceCollectionType.
	 *
	 * @param InvoiceCollectionType Invoice Collection Status
	 */
	void setInvoiceCollectionTypeInput(I_AD_Ref_ListInput InvoiceCollectionType);

	/**
	 * Get InvoiceCollectionType.
	 *
	 * @return Invoice Collection Status
	 */
	I_AD_Ref_ListInput InvoiceCollectionType();
}
