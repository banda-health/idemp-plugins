package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_DunningLevel;

/**
 * Generated Interface for C_DunningLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_DunningLevelInput extends I_C_DunningLevel {

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
	 * Set C_Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	void setC_DunningInput(ForeignEntityInput C_Dunning);

	/**
	 * Get C_Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	ForeignEntityInput C_Dunning();

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
	 * Set C_PaymentTerm.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	void setC_PaymentTermInput(ForeignEntityInput C_PaymentTerm);

	/**
	 * Get C_PaymentTerm.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	ForeignEntityInput C_PaymentTerm();

	/**
	 * Set Dunning_PrintFormat.
	 *
	 * @param Dunning_PrintFormat Print Format for printing Dunning Letters
	 */
	void setDunning_PrintFormatInput(ForeignEntityInput Dunning_PrintFormat);

	/**
	 * Get Dunning_PrintFormat.
	 *
	 * @return Print Format for printing Dunning Letters
	 */
	ForeignEntityInput Dunning_PrintFormat();

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
