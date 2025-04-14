package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_DunningLevel;

/**
 * Generated Interface for C_DunningLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_DunningLevelInput extends I_C_DunningLevel {

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
	void setInvoiceCollectionTypeInput(ForeignEntityInput InvoiceCollectionType);

	/**
	 * Get InvoiceCollectionType.
	 *
	 * @return Invoice Collection Status
	 */
	ForeignEntityInput InvoiceCollectionType();
}
