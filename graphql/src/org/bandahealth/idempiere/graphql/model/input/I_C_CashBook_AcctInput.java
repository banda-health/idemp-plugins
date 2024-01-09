package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_CashBook_Acct;

/**
 * Generated Interface for C_CashBook_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_CashBook_AcctInput extends I_C_CashBook_Acct {

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
	 * Set C_CashBook.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	void setC_CashBookInput(ForeignEntityInput C_CashBook);

	/**
	 * Get C_CashBook.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	ForeignEntityInput C_CashBook();

	/**
	 * Set CB_Asset_A.
	 *
	 * @param CB_Asset_A Cash Book Asset Account
	 */
	void setCB_Asset_AInput(ForeignEntityInput CB_Asset_A);

	/**
	 * Get CB_Asset_A.
	 *
	 * @return Cash Book Asset Account
	 */
	ForeignEntityInput CB_Asset_A();

	/**
	 * Set CB_CashTransfer_A.
	 *
	 * @param CB_CashTransfer_A Cash Transfer Clearing Account
	 */
	void setCB_CashTransfer_AInput(ForeignEntityInput CB_CashTransfer_A);

	/**
	 * Get CB_CashTransfer_A.
	 *
	 * @return Cash Transfer Clearing Account
	 */
	ForeignEntityInput CB_CashTransfer_A();

	/**
	 * Set CB_Differences_A.
	 *
	 * @param CB_Differences_A Cash Book Differences Account
	 */
	void setCB_Differences_AInput(ForeignEntityInput CB_Differences_A);

	/**
	 * Get CB_Differences_A.
	 *
	 * @return Cash Book Differences Account
	 */
	ForeignEntityInput CB_Differences_A();

	/**
	 * Set CB_Expense_A.
	 *
	 * @param CB_Expense_A Cash Book Expense Account
	 */
	void setCB_Expense_AInput(ForeignEntityInput CB_Expense_A);

	/**
	 * Get CB_Expense_A.
	 *
	 * @return Cash Book Expense Account
	 */
	ForeignEntityInput CB_Expense_A();

	/**
	 * Set CB_Receipt_A.
	 *
	 * @param CB_Receipt_A Cash Book Receipts Account
	 */
	void setCB_Receipt_AInput(ForeignEntityInput CB_Receipt_A);

	/**
	 * Get CB_Receipt_A.
	 *
	 * @return Cash Book Receipts Account
	 */
	ForeignEntityInput CB_Receipt_A();
}
