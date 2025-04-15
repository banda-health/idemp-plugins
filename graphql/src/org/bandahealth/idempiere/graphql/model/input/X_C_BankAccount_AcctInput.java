package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_BankAccount_Acct;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_BankAccount_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BankAccount_AcctInput extends X_C_BankAccount_Acct implements I_C_BankAccount_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mB_Asset_A;
	private ForeignEntityInput mB_InTransit_A;
	private ForeignEntityInput mB_InterestExp_A;
	private ForeignEntityInput mB_InterestRev_A;
	private ForeignEntityInput mB_PaymentSelect_A;
	private ForeignEntityInput mB_UnallocatedCash_A;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_BankAccount;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_BankAccount_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_BankAccount_AcctInput(@JsonProperty("UU") String UU) {
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
	 * Set Bank Asset.
	 *
	 * @param B_Asset_A Bank Asset Account
	 */
	@JsonProperty("B_Asset_A")
	public void setB_Asset_AInput(ForeignEntityInput B_Asset_A) {
		this.mB_Asset_A = B_Asset_A;
		if (B_Asset_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(B_Asset_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setB_Asset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + B_Asset_A.getUU());
			}
		} else {
			this.setB_Asset_Acct(0);
		}
	}

	/**
	 * Get Bank Asset.
	 *
	 * @return Bank Asset Account
	 */
	@JsonProperty("B_Asset_A")
	public ForeignEntityInput B_Asset_A() {
		return mB_Asset_A;
	}

	/**
	 * Set Bank Interest Expense.
	 *
	 * @param B_InterestExp_A Bank Interest Expense Account
	 */
	@JsonProperty("B_InterestExp_A")
	public void setB_InterestExp_AInput(ForeignEntityInput B_InterestExp_A) {
		this.mB_InterestExp_A = B_InterestExp_A;
		if (B_InterestExp_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(B_InterestExp_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setB_InterestExp_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + B_InterestExp_A.getUU());
			}
		} else {
			this.setB_InterestExp_Acct(0);
		}
	}

	/**
	 * Get Bank Interest Expense.
	 *
	 * @return Bank Interest Expense Account
	 */
	@JsonProperty("B_InterestExp_A")
	public ForeignEntityInput B_InterestExp_A() {
		return mB_InterestExp_A;
	}

	/**
	 * Set Bank Interest Revenue.
	 *
	 * @param B_InterestRev_A Bank Interest Revenue Account
	 */
	@JsonProperty("B_InterestRev_A")
	public void setB_InterestRev_AInput(ForeignEntityInput B_InterestRev_A) {
		this.mB_InterestRev_A = B_InterestRev_A;
		if (B_InterestRev_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(B_InterestRev_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setB_InterestRev_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + B_InterestRev_A.getUU());
			}
		} else {
			this.setB_InterestRev_Acct(0);
		}
	}

	/**
	 * Get Bank Interest Revenue.
	 *
	 * @return Bank Interest Revenue Account
	 */
	@JsonProperty("B_InterestRev_A")
	public ForeignEntityInput B_InterestRev_A() {
		return mB_InterestRev_A;
	}

	/**
	 * Set Bank In Transit.
	 *
	 * @param B_InTransit_A Bank In Transit Account
	 */
	@JsonProperty("B_InTransit_A")
	public void setB_InTransit_AInput(ForeignEntityInput B_InTransit_A) {
		this.mB_InTransit_A = B_InTransit_A;
		if (B_InTransit_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(B_InTransit_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setB_InTransit_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + B_InTransit_A.getUU());
			}
		} else {
			this.setB_InTransit_Acct(0);
		}
	}

	/**
	 * Get Bank In Transit.
	 *
	 * @return Bank In Transit Account
	 */
	@JsonProperty("B_InTransit_A")
	public ForeignEntityInput B_InTransit_A() {
		return mB_InTransit_A;
	}

	/**
	 * Set Payment Selection.
	 *
	 * @param B_PaymentSelect_A AP Payment Selection Clearing Account
	 */
	@JsonProperty("B_PaymentSelect_A")
	public void setB_PaymentSelect_AInput(ForeignEntityInput B_PaymentSelect_A) {
		this.mB_PaymentSelect_A = B_PaymentSelect_A;
		if (B_PaymentSelect_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(B_PaymentSelect_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setB_PaymentSelect_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + B_PaymentSelect_A.getUU());
			}
		} else {
			this.setB_PaymentSelect_Acct(0);
		}
	}

	/**
	 * Get Payment Selection.
	 *
	 * @return AP Payment Selection Clearing Account
	 */
	@JsonProperty("B_PaymentSelect_A")
	public ForeignEntityInput B_PaymentSelect_A() {
		return mB_PaymentSelect_A;
	}

	/**
	 * Set Unallocated Cash.
	 *
	 * @param B_UnallocatedCash_A Unallocated Cash Clearing Account
	 */
	@JsonProperty("B_UnallocatedCash_A")
	public void setB_UnallocatedCash_AInput(ForeignEntityInput B_UnallocatedCash_A) {
		this.mB_UnallocatedCash_A = B_UnallocatedCash_A;
		if (B_UnallocatedCash_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(B_UnallocatedCash_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setB_UnallocatedCash_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + B_UnallocatedCash_A.getUU());
			}
		} else {
			this.setB_UnallocatedCash_Acct(0);
		}
	}

	/**
	 * Get Unallocated Cash.
	 *
	 * @return Unallocated Cash Clearing Account
	 */
	@JsonProperty("B_UnallocatedCash_A")
	public ForeignEntityInput B_UnallocatedCash_A() {
		return mB_UnallocatedCash_A;
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
		setC_BankAccount_Acct_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_BankAccount_Acct_UU();
	}

	/**
	 * Set Bank Account.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	@JsonProperty("C_BankAccount")
	public void setC_BankAccountInput(ForeignEntityInput C_BankAccount) {
		this.mC_BankAccount = C_BankAccount;
		if (get_ID() != 0) {
			return;
		}
		if (C_BankAccount != null) {
			// Since an entity was passed, make sure it's in the DB
			MBankAccount_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
							.setParameters(C_BankAccount.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankAccount with UU " + C_BankAccount.getUU());
			}
		} else {
			this.setC_BankAccount_ID(0);
		}
	}

	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	@JsonProperty("C_BankAccount")
	public ForeignEntityInput C_BankAccount() {
		return mC_BankAccount;
	}
}
