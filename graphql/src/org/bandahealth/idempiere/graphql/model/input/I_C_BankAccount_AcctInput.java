package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BankAccount_Acct;

/**
 * Generated Interface for C_BankAccount_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_BankAccount_AcctInput extends I_C_BankAccount_Acct {

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
	 * Set B_Asset_A.
	 *
	 * @param B_Asset_A Bank Asset Account
	 */
	void setB_Asset_AInput(ForeignEntityInput B_Asset_A);

	/**
	 * Get B_Asset_A.
	 *
	 * @return Bank Asset Account
	 */
	ForeignEntityInput B_Asset_A();

	/**
	 * Set B_InterestExp_A.
	 *
	 * @param B_InterestExp_A Bank Interest Expense Account
	 */
	void setB_InterestExp_AInput(ForeignEntityInput B_InterestExp_A);

	/**
	 * Get B_InterestExp_A.
	 *
	 * @return Bank Interest Expense Account
	 */
	ForeignEntityInput B_InterestExp_A();

	/**
	 * Set B_InterestRev_A.
	 *
	 * @param B_InterestRev_A Bank Interest Revenue Account
	 */
	void setB_InterestRev_AInput(ForeignEntityInput B_InterestRev_A);

	/**
	 * Get B_InterestRev_A.
	 *
	 * @return Bank Interest Revenue Account
	 */
	ForeignEntityInput B_InterestRev_A();

	/**
	 * Set B_InTransit_A.
	 *
	 * @param B_InTransit_A Bank In Transit Account
	 */
	void setB_InTransit_AInput(ForeignEntityInput B_InTransit_A);

	/**
	 * Get B_InTransit_A.
	 *
	 * @return Bank In Transit Account
	 */
	ForeignEntityInput B_InTransit_A();

	/**
	 * Set B_PaymentSelect_A.
	 *
	 * @param B_PaymentSelect_A AP Payment Selection Clearing Account
	 */
	void setB_PaymentSelect_AInput(ForeignEntityInput B_PaymentSelect_A);

	/**
	 * Get B_PaymentSelect_A.
	 *
	 * @return AP Payment Selection Clearing Account
	 */
	ForeignEntityInput B_PaymentSelect_A();

	/**
	 * Set B_UnallocatedCash_A.
	 *
	 * @param B_UnallocatedCash_A Unallocated Cash Clearing Account
	 */
	void setB_UnallocatedCash_AInput(ForeignEntityInput B_UnallocatedCash_A);

	/**
	 * Get B_UnallocatedCash_A.
	 *
	 * @return Unallocated Cash Clearing Account
	 */
	ForeignEntityInput B_UnallocatedCash_A();

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
	 * Set C_BankAccount.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	void setC_BankAccountInput(ForeignEntityInput C_BankAccount);

	/**
	 * Get C_BankAccount.
	 *
	 * @return Account at the Bank
	 */
	ForeignEntityInput C_BankAccount();
}
