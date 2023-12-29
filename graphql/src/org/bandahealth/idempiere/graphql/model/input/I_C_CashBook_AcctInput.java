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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchema(I_C_AcctSchemaInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	I_C_AcctSchemaInput getC_AcctSchema();

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
	void setC_CashBook(I_C_CashBookInput C_CashBook);

	/**
	 * Get C_CashBook.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	I_C_CashBookInput getC_CashBook();

	/**
	 * Set CB_Asset_A.
	 *
	 * @param CB_Asset_A Cash Book Asset Account
	 */
	void setCB_Asset_A(I_C_ValidCombinationInput CB_Asset_A);

	/**
	 * Get CB_Asset_A.
	 *
	 * @return Cash Book Asset Account
	 */
	I_C_ValidCombinationInput getCB_Asset_A();

	/**
	 * Set CB_CashTransfer_A.
	 *
	 * @param CB_CashTransfer_A Cash Transfer Clearing Account
	 */
	void setCB_CashTransfer_A(I_C_ValidCombinationInput CB_CashTransfer_A);

	/**
	 * Get CB_CashTransfer_A.
	 *
	 * @return Cash Transfer Clearing Account
	 */
	I_C_ValidCombinationInput getCB_CashTransfer_A();

	/**
	 * Set CB_Differences_A.
	 *
	 * @param CB_Differences_A Cash Book Differences Account
	 */
	void setCB_Differences_A(I_C_ValidCombinationInput CB_Differences_A);

	/**
	 * Get CB_Differences_A.
	 *
	 * @return Cash Book Differences Account
	 */
	I_C_ValidCombinationInput getCB_Differences_A();

	/**
	 * Set CB_Expense_A.
	 *
	 * @param CB_Expense_A Cash Book Expense Account
	 */
	void setCB_Expense_A(I_C_ValidCombinationInput CB_Expense_A);

	/**
	 * Get CB_Expense_A.
	 *
	 * @return Cash Book Expense Account
	 */
	I_C_ValidCombinationInput getCB_Expense_A();

	/**
	 * Set CB_Receipt_A.
	 *
	 * @param CB_Receipt_A Cash Book Receipts Account
	 */
	void setCB_Receipt_A(I_C_ValidCombinationInput CB_Receipt_A);

	/**
	 * Get CB_Receipt_A.
	 *
	 * @return Cash Book Receipts Account
	 */
	I_C_ValidCombinationInput getCB_Receipt_A();
}
