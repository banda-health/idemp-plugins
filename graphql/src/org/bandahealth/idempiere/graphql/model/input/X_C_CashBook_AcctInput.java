package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCashBook;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_CashBook_Acct;
import org.compiere.util.Env;

/**
 * Generated Model for C_CashBook_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CashBook_AcctInput extends X_C_CashBook_Acct implements I_C_CashBook_AcctInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_C_AcctSchemaInput mC_AcctSchema;
	 private I_C_CashBookInput mC_CashBook;
	 private I_C_ValidCombinationInput mCB_Asset_A;
	 private I_C_ValidCombinationInput mCB_CashTransfer_A;
	 private I_C_ValidCombinationInput mCB_Differences_A;
	 private I_C_ValidCombinationInput mCB_Expense_A;
	 private I_C_ValidCombinationInput mCB_Receipt_A;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_CashBook_AcctInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(I_C_AcctSchemaInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (get_ID() == 0 &&C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctSchema_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public I_C_AcctSchemaInput C_AcctSchema() {
		return mC_AcctSchema;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_CashBook_Acct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_CashBook_Acct_UU();
	}

	/**
	 * Set Cash Book.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	@JsonProperty("C_CashBook")
	public void setC_CashBookInput(I_C_CashBookInput C_CashBook) {
		this.mC_CashBook = C_CashBook;
		MCashBook foreignEntity;
		if (get_ID() == 0 &&C_CashBook != null &&
				(foreignEntity = new Query(getCtx(), MCashBook.Table_Name, MCashBook.COLUMNNAME_C_CashBook_UU + "=?", get_TrxName())
						.setParameters(C_CashBook.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_CashBook_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Cash Book.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	@JsonProperty("C_CashBook")
	public I_C_CashBookInput C_CashBook() {
		return mC_CashBook;
	}

	/**
	 * Set Cash Book Asset.
	 *
	 * @param CB_Asset_A Cash Book Asset Account
	 */
	@JsonProperty("CB_Asset_A")
	public void setCB_Asset_AInput(I_C_ValidCombinationInput CB_Asset_A) {
		this.mCB_Asset_A = CB_Asset_A;
		MAccount foreignEntity;
		if (CB_Asset_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(CB_Asset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCB_Asset_Acct(foreignEntity.get_ID());
		} else {
			super.setCB_Asset_Acct(0);
		}
	}

	/**
	 * Get Cash Book Asset.
	 *
	 * @return Cash Book Asset Account
	 */
	@JsonProperty("CB_Asset_A")
	public I_C_ValidCombinationInput CB_Asset_A() {
		return mCB_Asset_A;
	}

	/**
	 * Set Cash Transfer.
	 *
	 * @param CB_CashTransfer_A Cash Transfer Clearing Account
	 */
	@JsonProperty("CB_CashTransfer_A")
	public void setCB_CashTransfer_AInput(I_C_ValidCombinationInput CB_CashTransfer_A) {
		this.mCB_CashTransfer_A = CB_CashTransfer_A;
		MAccount foreignEntity;
		if (CB_CashTransfer_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(CB_CashTransfer_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCB_CashTransfer_Acct(foreignEntity.get_ID());
		} else {
			super.setCB_CashTransfer_Acct(0);
		}
	}

	/**
	 * Get Cash Transfer.
	 *
	 * @return Cash Transfer Clearing Account
	 */
	@JsonProperty("CB_CashTransfer_A")
	public I_C_ValidCombinationInput CB_CashTransfer_A() {
		return mCB_CashTransfer_A;
	}

	/**
	 * Set Cash Book Differences.
	 *
	 * @param CB_Differences_A Cash Book Differences Account
	 */
	@JsonProperty("CB_Differences_A")
	public void setCB_Differences_AInput(I_C_ValidCombinationInput CB_Differences_A) {
		this.mCB_Differences_A = CB_Differences_A;
		MAccount foreignEntity;
		if (CB_Differences_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(CB_Differences_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCB_Differences_Acct(foreignEntity.get_ID());
		} else {
			super.setCB_Differences_Acct(0);
		}
	}

	/**
	 * Get Cash Book Differences.
	 *
	 * @return Cash Book Differences Account
	 */
	@JsonProperty("CB_Differences_A")
	public I_C_ValidCombinationInput CB_Differences_A() {
		return mCB_Differences_A;
	}

	/**
	 * Set Cash Book Expense.
	 *
	 * @param CB_Expense_A Cash Book Expense Account
	 */
	@JsonProperty("CB_Expense_A")
	public void setCB_Expense_AInput(I_C_ValidCombinationInput CB_Expense_A) {
		this.mCB_Expense_A = CB_Expense_A;
		MAccount foreignEntity;
		if (CB_Expense_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(CB_Expense_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCB_Expense_Acct(foreignEntity.get_ID());
		} else {
			super.setCB_Expense_Acct(0);
		}
	}

	/**
	 * Get Cash Book Expense.
	 *
	 * @return Cash Book Expense Account
	 */
	@JsonProperty("CB_Expense_A")
	public I_C_ValidCombinationInput CB_Expense_A() {
		return mCB_Expense_A;
	}

	/**
	 * Set Cash Book Receipt.
	 *
	 * @param CB_Receipt_A Cash Book Receipts Account
	 */
	@JsonProperty("CB_Receipt_A")
	public void setCB_Receipt_AInput(I_C_ValidCombinationInput CB_Receipt_A) {
		this.mCB_Receipt_A = CB_Receipt_A;
		MAccount foreignEntity;
		if (CB_Receipt_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(CB_Receipt_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCB_Receipt_Acct(foreignEntity.get_ID());
		} else {
			super.setCB_Receipt_Acct(0);
		}
	}

	/**
	 * Get Cash Book Receipt.
	 *
	 * @return Cash Book Receipts Account
	 */
	@JsonProperty("CB_Receipt_A")
	public I_C_ValidCombinationInput CB_Receipt_A() {
		return mCB_Receipt_A;
	}
}
