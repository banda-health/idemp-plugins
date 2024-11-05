package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_Group_Acct;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_BP_Group_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BP_Group_AcctInput extends X_C_BP_Group_Acct implements I_C_BP_Group_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_BP_Group;
	private ForeignEntityInput mC_Prepayment_A;
	private ForeignEntityInput mC_Receivable_A;
	private ForeignEntityInput mC_Receivable_Services_A;
	private ForeignEntityInput mNotInvoicedReceipts_A;
	private ForeignEntityInput mPayDiscount_Exp_A;
	private ForeignEntityInput mPayDiscount_Rev_A;
	private ForeignEntityInput mUnEarnedRevenue_A;
	private ForeignEntityInput mV_Liability_A;
	private ForeignEntityInput mV_Liability_Services_A;
	private ForeignEntityInput mV_Prepayment_A;
	private ForeignEntityInput mWriteOff_A;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_BP_Group_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_BP_Group_AcctInput(@JsonProperty("UU") String UU) {
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
		setC_BP_Group_Acct_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_BP_Group_Acct_UU();
	}

	/**
	 * Set Business Partner Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public void setC_BP_GroupInput(ForeignEntityInput C_BP_Group) {
		this.mC_BP_Group = C_BP_Group;
		if (get_ID() != 0) {
			return;
		}
		if (C_BP_Group != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPGroup_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BP_Group", "C_BP_Group_UU=?", get_TrxName())
							.setParameters(C_BP_Group.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BP_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BP_Group with UU " + C_BP_Group.getUU());
			}
		} else {
			this.setC_BP_Group_ID(0);
		}
	}

	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public ForeignEntityInput C_BP_Group() {
		return mC_BP_Group;
	}

	/**
	 * Set Customer Prepayment.
	 *
	 * @param C_Prepayment_A Account for customer prepayments
	 */
	@JsonProperty("C_Prepayment_A")
	public void setC_Prepayment_AInput(ForeignEntityInput C_Prepayment_A) {
		this.mC_Prepayment_A = C_Prepayment_A;
		if (C_Prepayment_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(C_Prepayment_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Prepayment_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + C_Prepayment_A.getUU());
			}
		} else {
			this.setC_Prepayment_Acct(0);
		}
	}

	/**
	 * Get Customer Prepayment.
	 *
	 * @return Account for customer prepayments
	 */
	@JsonProperty("C_Prepayment_A")
	public ForeignEntityInput C_Prepayment_A() {
		return mC_Prepayment_A;
	}

	/**
	 * Set Customer Receivables.
	 *
	 * @param C_Receivable_A Account for Customer Receivables
	 */
	@JsonProperty("C_Receivable_A")
	public void setC_Receivable_AInput(ForeignEntityInput C_Receivable_A) {
		this.mC_Receivable_A = C_Receivable_A;
		if (C_Receivable_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(C_Receivable_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Receivable_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + C_Receivable_A.getUU());
			}
		} else {
			this.setC_Receivable_Acct(0);
		}
	}

	/**
	 * Get Customer Receivables.
	 *
	 * @return Account for Customer Receivables
	 */
	@JsonProperty("C_Receivable_A")
	public ForeignEntityInput C_Receivable_A() {
		return mC_Receivable_A;
	}

	/**
	 * Set Receivable Services.
	 *
	 * @param C_Receivable_Services_A Customer Accounts Receivables Services Account
	 */
	@JsonProperty("C_Receivable_Services_A")
	public void setC_Receivable_Services_AInput(ForeignEntityInput C_Receivable_Services_A) {
		this.mC_Receivable_Services_A = C_Receivable_Services_A;
		if (C_Receivable_Services_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(C_Receivable_Services_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Receivable_Services_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + C_Receivable_Services_A.getUU());
			}
		} else {
			this.setC_Receivable_Services_Acct(0);
		}
	}

	/**
	 * Get Receivable Services.
	 *
	 * @return Customer Accounts Receivables Services Account
	 */
	@JsonProperty("C_Receivable_Services_A")
	public ForeignEntityInput C_Receivable_Services_A() {
		return mC_Receivable_Services_A;
	}

	/**
	 * Set Not-invoiced Receipts.
	 *
	 * @param NotInvoicedReceipts_A Account for not-invoiced Material Receipts
	 */
	@JsonProperty("NotInvoicedReceipts_A")
	public void setNotInvoicedReceipts_AInput(ForeignEntityInput NotInvoicedReceipts_A) {
		this.mNotInvoicedReceipts_A = NotInvoicedReceipts_A;
		if (NotInvoicedReceipts_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(NotInvoicedReceipts_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setNotInvoicedReceipts_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + NotInvoicedReceipts_A.getUU());
			}
		} else {
			this.setNotInvoicedReceipts_Acct(0);
		}
	}

	/**
	 * Get Not-invoiced Receipts.
	 *
	 * @return Account for not-invoiced Material Receipts
	 */
	@JsonProperty("NotInvoicedReceipts_A")
	public ForeignEntityInput NotInvoicedReceipts_A() {
		return mNotInvoicedReceipts_A;
	}

	/**
	 * Set Payment Discount Expense.
	 *
	 * @param PayDiscount_Exp_A Payment Discount Expense Account
	 */
	@JsonProperty("PayDiscount_Exp_A")
	public void setPayDiscount_Exp_AInput(ForeignEntityInput PayDiscount_Exp_A) {
		this.mPayDiscount_Exp_A = PayDiscount_Exp_A;
		if (PayDiscount_Exp_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(PayDiscount_Exp_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPayDiscount_Exp_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + PayDiscount_Exp_A.getUU());
			}
		} else {
			this.setPayDiscount_Exp_Acct(0);
		}
	}

	/**
	 * Get Payment Discount Expense.
	 *
	 * @return Payment Discount Expense Account
	 */
	@JsonProperty("PayDiscount_Exp_A")
	public ForeignEntityInput PayDiscount_Exp_A() {
		return mPayDiscount_Exp_A;
	}

	/**
	 * Set Payment Discount Revenue.
	 *
	 * @param PayDiscount_Rev_A Payment Discount Revenue Account
	 */
	@JsonProperty("PayDiscount_Rev_A")
	public void setPayDiscount_Rev_AInput(ForeignEntityInput PayDiscount_Rev_A) {
		this.mPayDiscount_Rev_A = PayDiscount_Rev_A;
		if (PayDiscount_Rev_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(PayDiscount_Rev_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPayDiscount_Rev_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + PayDiscount_Rev_A.getUU());
			}
		} else {
			this.setPayDiscount_Rev_Acct(0);
		}
	}

	/**
	 * Get Payment Discount Revenue.
	 *
	 * @return Payment Discount Revenue Account
	 */
	@JsonProperty("PayDiscount_Rev_A")
	public ForeignEntityInput PayDiscount_Rev_A() {
		return mPayDiscount_Rev_A;
	}

	/**
	 * Set Unearned Revenue.
	 *
	 * @param UnEarnedRevenue_A Account for unearned revenue
	 */
	@JsonProperty("UnEarnedRevenue_A")
	public void setUnEarnedRevenue_AInput(ForeignEntityInput UnEarnedRevenue_A) {
		this.mUnEarnedRevenue_A = UnEarnedRevenue_A;
		if (UnEarnedRevenue_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(UnEarnedRevenue_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setUnEarnedRevenue_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + UnEarnedRevenue_A.getUU());
			}
		} else {
			this.setUnEarnedRevenue_Acct(0);
		}
	}

	/**
	 * Get Unearned Revenue.
	 *
	 * @return Account for unearned revenue
	 */
	@JsonProperty("UnEarnedRevenue_A")
	public ForeignEntityInput UnEarnedRevenue_A() {
		return mUnEarnedRevenue_A;
	}

	/**
	 * Set Vendor Liability.
	 *
	 * @param V_Liability_A Account for Vendor Liability
	 */
	@JsonProperty("V_Liability_A")
	public void setV_Liability_AInput(ForeignEntityInput V_Liability_A) {
		this.mV_Liability_A = V_Liability_A;
		if (V_Liability_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(V_Liability_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setV_Liability_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + V_Liability_A.getUU());
			}
		} else {
			this.setV_Liability_Acct(0);
		}
	}

	/**
	 * Get Vendor Liability.
	 *
	 * @return Account for Vendor Liability
	 */
	@JsonProperty("V_Liability_A")
	public ForeignEntityInput V_Liability_A() {
		return mV_Liability_A;
	}

	/**
	 * Set Vendor Service Liability.
	 *
	 * @param V_Liability_Services_A Account for Vendor Service Liability
	 */
	@JsonProperty("V_Liability_Services_A")
	public void setV_Liability_Services_AInput(ForeignEntityInput V_Liability_Services_A) {
		this.mV_Liability_Services_A = V_Liability_Services_A;
		if (V_Liability_Services_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(V_Liability_Services_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setV_Liability_Services_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + V_Liability_Services_A.getUU());
			}
		} else {
			this.setV_Liability_Services_Acct(0);
		}
	}

	/**
	 * Get Vendor Service Liability.
	 *
	 * @return Account for Vendor Service Liability
	 */
	@JsonProperty("V_Liability_Services_A")
	public ForeignEntityInput V_Liability_Services_A() {
		return mV_Liability_Services_A;
	}

	/**
	 * Set Vendor Prepayment.
	 *
	 * @param V_Prepayment_A Account for Vendor Prepayments
	 */
	@JsonProperty("V_Prepayment_A")
	public void setV_Prepayment_AInput(ForeignEntityInput V_Prepayment_A) {
		this.mV_Prepayment_A = V_Prepayment_A;
		if (V_Prepayment_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(V_Prepayment_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setV_Prepayment_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + V_Prepayment_A.getUU());
			}
		} else {
			this.setV_Prepayment_Acct(0);
		}
	}

	/**
	 * Get Vendor Prepayment.
	 *
	 * @return Account for Vendor Prepayments
	 */
	@JsonProperty("V_Prepayment_A")
	public ForeignEntityInput V_Prepayment_A() {
		return mV_Prepayment_A;
	}

	/**
	 * Set Write-off.
	 *
	 * @param WriteOff_A Account for Receivables write-off
	 */
	@JsonProperty("WriteOff_A")
	public void setWriteOff_AInput(ForeignEntityInput WriteOff_A) {
		this.mWriteOff_A = WriteOff_A;
		if (WriteOff_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(WriteOff_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setWriteOff_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + WriteOff_A.getUU());
			}
		} else {
			this.setWriteOff_Acct(0);
		}
	}

	/**
	 * Get Write-off.
	 *
	 * @return Account for Receivables write-off
	 */
	@JsonProperty("WriteOff_A")
	public ForeignEntityInput WriteOff_A() {
		return mWriteOff_A;
	}
}
