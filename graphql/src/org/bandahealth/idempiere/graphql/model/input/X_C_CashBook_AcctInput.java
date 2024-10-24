package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCashBook;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_CashBook_Acct;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_CashBook_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CashBook_AcctInput extends X_C_CashBook_Acct implements I_C_CashBook_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mCB_Asset_A;
	private ForeignEntityInput mCB_CashTransfer_A;
	private ForeignEntityInput mCB_Differences_A;
	private ForeignEntityInput mCB_Expense_A;
	private ForeignEntityInput mCB_Receipt_A;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_CashBook;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_CashBook_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_CashBook_AcctInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		if (get_ID() != 0) {
			return;
		}
		if (C_AcctSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MAcctSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UU " + C_AcctSchema.getUU());
			}
		} else {
			this.setC_AcctSchema_ID(0);
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public ForeignEntityInput C_AcctSchema() {
		return mC_AcctSchema;
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_CashBook_Acct_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_CashBook_Acct_UU();
	}

	/**
	 * Set Cash Book.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	@JsonProperty("C_CashBook")
	public void setC_CashBookInput(ForeignEntityInput C_CashBook) {
		this.mC_CashBook = C_CashBook;
		if (get_ID() != 0) {
			return;
		}
		if (C_CashBook != null) {
			// Since an entity was passed, make sure it's in the DB
			MCashBook foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CashBook", "C_CashBook_UU=?", get_TrxName())
							.setParameters(C_CashBook.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_CashBook_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CashBook with UU " + C_CashBook.getUU());
			}
		} else {
			this.setC_CashBook_ID(0);
		}
	}

	/**
	 * Get Cash Book.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	@JsonProperty("C_CashBook")
	public ForeignEntityInput C_CashBook() {
		return mC_CashBook;
	}

	/**
	 * Set Cash Book Asset.
	 *
	 * @param CB_Asset_A Cash Book Asset Account
	 */
	@JsonProperty("CB_Asset_A")
	public void setCB_Asset_AInput(ForeignEntityInput CB_Asset_A) {
		this.mCB_Asset_A = CB_Asset_A;
		if (CB_Asset_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(CB_Asset_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setCB_Asset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + CB_Asset_A.getUU());
			}
		} else {
			this.setCB_Asset_Acct(0);
		}
	}

	/**
	 * Get Cash Book Asset.
	 *
	 * @return Cash Book Asset Account
	 */
	@JsonProperty("CB_Asset_A")
	public ForeignEntityInput CB_Asset_A() {
		return mCB_Asset_A;
	}

	/**
	 * Set Cash Transfer.
	 *
	 * @param CB_CashTransfer_A Cash Transfer Clearing Account
	 */
	@JsonProperty("CB_CashTransfer_A")
	public void setCB_CashTransfer_AInput(ForeignEntityInput CB_CashTransfer_A) {
		this.mCB_CashTransfer_A = CB_CashTransfer_A;
		if (CB_CashTransfer_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(CB_CashTransfer_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setCB_CashTransfer_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + CB_CashTransfer_A.getUU());
			}
		} else {
			this.setCB_CashTransfer_Acct(0);
		}
	}

	/**
	 * Get Cash Transfer.
	 *
	 * @return Cash Transfer Clearing Account
	 */
	@JsonProperty("CB_CashTransfer_A")
	public ForeignEntityInput CB_CashTransfer_A() {
		return mCB_CashTransfer_A;
	}

	/**
	 * Set Cash Book Differences.
	 *
	 * @param CB_Differences_A Cash Book Differences Account
	 */
	@JsonProperty("CB_Differences_A")
	public void setCB_Differences_AInput(ForeignEntityInput CB_Differences_A) {
		this.mCB_Differences_A = CB_Differences_A;
		if (CB_Differences_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(CB_Differences_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setCB_Differences_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + CB_Differences_A.getUU());
			}
		} else {
			this.setCB_Differences_Acct(0);
		}
	}

	/**
	 * Get Cash Book Differences.
	 *
	 * @return Cash Book Differences Account
	 */
	@JsonProperty("CB_Differences_A")
	public ForeignEntityInput CB_Differences_A() {
		return mCB_Differences_A;
	}

	/**
	 * Set Cash Book Expense.
	 *
	 * @param CB_Expense_A Cash Book Expense Account
	 */
	@JsonProperty("CB_Expense_A")
	public void setCB_Expense_AInput(ForeignEntityInput CB_Expense_A) {
		this.mCB_Expense_A = CB_Expense_A;
		if (CB_Expense_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(CB_Expense_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setCB_Expense_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + CB_Expense_A.getUU());
			}
		} else {
			this.setCB_Expense_Acct(0);
		}
	}

	/**
	 * Get Cash Book Expense.
	 *
	 * @return Cash Book Expense Account
	 */
	@JsonProperty("CB_Expense_A")
	public ForeignEntityInput CB_Expense_A() {
		return mCB_Expense_A;
	}

	/**
	 * Set Cash Book Receipt.
	 *
	 * @param CB_Receipt_A Cash Book Receipts Account
	 */
	@JsonProperty("CB_Receipt_A")
	public void setCB_Receipt_AInput(ForeignEntityInput CB_Receipt_A) {
		this.mCB_Receipt_A = CB_Receipt_A;
		if (CB_Receipt_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(CB_Receipt_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setCB_Receipt_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + CB_Receipt_A.getUU());
			}
		} else {
			this.setCB_Receipt_Acct(0);
		}
	}

	/**
	 * Get Cash Book Receipt.
	 *
	 * @return Cash Book Receipts Account
	 */
	@JsonProperty("CB_Receipt_A")
	public ForeignEntityInput CB_Receipt_A() {
		return mCB_Receipt_A;
	}
}
