package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BP_Customer_Acct;

/**
 * Generated Interface for C_BP_Customer_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_BP_Customer_AcctInput extends I_C_BP_Customer_Acct {

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
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	ForeignEntityInput C_AcctSchema();

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
	 * Set C_Prepayment_A.
	 *
	 * @param C_Prepayment_A Account for customer prepayments
	 */
	void setC_Prepayment_AInput(ForeignEntityInput C_Prepayment_A);

	/**
	 * Get C_Prepayment_A.
	 *
	 * @return Account for customer prepayments
	 */
	ForeignEntityInput C_Prepayment_A();

	/**
	 * Set C_Receivable_A.
	 *
	 * @param C_Receivable_A Account for Customer Receivables
	 */
	void setC_Receivable_AInput(ForeignEntityInput C_Receivable_A);

	/**
	 * Get C_Receivable_A.
	 *
	 * @return Account for Customer Receivables
	 */
	ForeignEntityInput C_Receivable_A();

	/**
	 * Set C_Receivable_Services_A.
	 *
	 * @param C_Receivable_Services_A Customer Accounts Receivables Services Account
	 */
	void setC_Receivable_Services_AInput(ForeignEntityInput C_Receivable_Services_A);

	/**
	 * Get C_Receivable_Services_A.
	 *
	 * @return Customer Accounts Receivables Services Account
	 */
	ForeignEntityInput C_Receivable_Services_A();
}
