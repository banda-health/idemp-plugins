package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_PaySelectionCheck;

/**
 * Generated Interface for C_PaySelectionCheck - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_PaySelectionCheckInput extends I_C_PaySelectionCheck {

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
	 * Set C_BP_BankAccount.
	 *
	 * @param C_BP_BankAccount Bank Account of the Business Partner
	 */
	void setC_BP_BankAccountInput(ForeignEntityInput C_BP_BankAccount);

	/**
	 * Get C_BP_BankAccount.
	 *
	 * @return Bank Account of the Business Partner
	 */
	ForeignEntityInput C_BP_BankAccount();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

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
	void setPaymentRuleInput(ForeignEntityInput PaymentRule);

	/**
	 * Get PaymentRule.
	 *
	 * @return How you pay the invoice
	 */
	ForeignEntityInput PaymentRule();
}
