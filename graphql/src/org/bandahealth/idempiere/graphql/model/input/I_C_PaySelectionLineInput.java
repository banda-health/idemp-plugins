package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_PaySelectionLine;

/**
 * Generated Interface for C_PaySelectionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_PaySelectionLineInput extends I_C_PaySelectionLine {

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
	 * Set C_PaySelection.
	 *
	 * @param C_PaySelection Payment Selection
	 */
	void setC_PaySelectionInput(ForeignEntityInput C_PaySelection);

	/**
	 * Get C_PaySelection.
	 *
	 * @return Payment Selection
	 */
	ForeignEntityInput C_PaySelection();

	/**
	 * Set C_PaySelectionCheck.
	 *
	 * @param C_PaySelectionCheck Payment Selection Check
	 */
	void setC_PaySelectionCheckInput(ForeignEntityInput C_PaySelectionCheck);

	/**
	 * Get C_PaySelectionCheck.
	 *
	 * @return Payment Selection Check
	 */
	ForeignEntityInput C_PaySelectionCheck();

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
	 * Set PaymentRule.
	 *
	 * @param PaymentRule How you pay the invoice
	 */
	void setPaymentRuleInput(I_AD_Ref_ListInput PaymentRule);

	/**
	 * Get PaymentRule.
	 *
	 * @return How you pay the invoice
	 */
	I_AD_Ref_ListInput PaymentRule();
}
