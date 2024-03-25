package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAcctSchemaDefault;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_AcctSchema_Default - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AcctSchema_DefaultInput extends MAcctSchemaDefault implements I_C_AcctSchema_DefaultInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mB_Asset_A;
	private ForeignEntityInput mB_InTransit_A;
	private ForeignEntityInput mB_InterestExp_A;
	private ForeignEntityInput mB_InterestRev_A;
	private ForeignEntityInput mB_PaymentSelect_A;
	private ForeignEntityInput mB_UnallocatedCash_A;
	private ForeignEntityInput mCB_Asset_A;
	private ForeignEntityInput mCB_CashTransfer_A;
	private ForeignEntityInput mCB_Differences_A;
	private ForeignEntityInput mCB_Expense_A;
	private ForeignEntityInput mCB_Receipt_A;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_Prepayment_A;
	private ForeignEntityInput mC_Receivable_A;
	private ForeignEntityInput mC_Receivable_Services_A;
	private ForeignEntityInput mCh_Expense_A;
	private ForeignEntityInput mNotInvoicedReceipts_A;
	private ForeignEntityInput mPJ_Asset_A;
	private ForeignEntityInput mPJ_WIP_A;
	private ForeignEntityInput mP_Asset_A;
	private ForeignEntityInput mP_AverageCostVariance_A;
	private ForeignEntityInput mP_COGS_A;
	private ForeignEntityInput mP_CostAdjustment_A;
	private ForeignEntityInput mP_Expense_A;
	private ForeignEntityInput mP_InventoryClearing_A;
	private ForeignEntityInput mP_InvoicePriceVariance_A;
	private ForeignEntityInput mP_LandedCostClearing_A;
	private ForeignEntityInput mP_PurchasePriceVariance_A;
	private ForeignEntityInput mP_RateVariance_A;
	private ForeignEntityInput mP_Revenue_A;
	private ForeignEntityInput mP_TradeDiscountGrant_A;
	private ForeignEntityInput mP_TradeDiscountRec_A;
	private ForeignEntityInput mPayDiscount_Exp_A;
	private ForeignEntityInput mPayDiscount_Rev_A;
	private ForeignEntityInput mRealizedGain_A;
	private ForeignEntityInput mRealizedLoss_A;
	private ForeignEntityInput mT_Credit_A;
	private ForeignEntityInput mT_Due_A;
	private ForeignEntityInput mT_Expense_A;
	private ForeignEntityInput mUnEarnedRevenue_A;
	private ForeignEntityInput mUnrealizedGain_A;
	private ForeignEntityInput mUnrealizedLoss_A;
	private ForeignEntityInput mV_Liability_A;
	private ForeignEntityInput mV_Liability_Services_A;
	private ForeignEntityInput mV_Prepayment_A;
	private ForeignEntityInput mW_Differences_A;
	private ForeignEntityInput mWriteOff_A;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_AcctSchema_Default_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_AcctSchema_DefaultInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MAcctSchemaDefault(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
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
							.setParameters(B_Asset_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setB_Asset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + B_Asset_A.getUUID());
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
							.setParameters(B_InterestExp_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setB_InterestExp_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + B_InterestExp_A.getUUID());
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
							.setParameters(B_InterestRev_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setB_InterestRev_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + B_InterestRev_A.getUUID());
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
							.setParameters(B_InTransit_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setB_InTransit_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + B_InTransit_A.getUUID());
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
							.setParameters(B_PaymentSelect_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setB_PaymentSelect_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + B_PaymentSelect_A.getUUID());
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
							.setParameters(B_UnallocatedCash_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setB_UnallocatedCash_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + B_UnallocatedCash_A.getUUID());
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_AcctSchema_Default_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_AcctSchema_Default_UU();
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
							.setParameters(C_AcctSchema.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UUID " + C_AcctSchema.getUUID());
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
							.setParameters(C_Prepayment_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Prepayment_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + C_Prepayment_A.getUUID());
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
							.setParameters(C_Receivable_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Receivable_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + C_Receivable_A.getUUID());
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
							.setParameters(C_Receivable_Services_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Receivable_Services_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + C_Receivable_Services_A.getUUID());
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
							.setParameters(CB_Asset_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCB_Asset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + CB_Asset_A.getUUID());
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
							.setParameters(CB_CashTransfer_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCB_CashTransfer_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + CB_CashTransfer_A.getUUID());
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
							.setParameters(CB_Differences_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCB_Differences_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + CB_Differences_A.getUUID());
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
							.setParameters(CB_Expense_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCB_Expense_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + CB_Expense_A.getUUID());
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
							.setParameters(CB_Receipt_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCB_Receipt_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + CB_Receipt_A.getUUID());
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

	/**
	 * Set Charge Account.
	 *
	 * @param Ch_Expense_A Charge Account
	 */
	@JsonProperty("Ch_Expense_A")
	public void setCh_Expense_AInput(ForeignEntityInput Ch_Expense_A) {
		this.mCh_Expense_A = Ch_Expense_A;
		if (Ch_Expense_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(Ch_Expense_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCh_Expense_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + Ch_Expense_A.getUUID());
			}
		} else {
			this.setCh_Expense_Acct(0);
		}
	}

	/**
	 * Get Charge Account.
	 *
	 * @return Charge Account
	 */
	@JsonProperty("Ch_Expense_A")
	public ForeignEntityInput Ch_Expense_A() {
		return mCh_Expense_A;
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
							.setParameters(NotInvoicedReceipts_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setNotInvoicedReceipts_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + NotInvoicedReceipts_A.getUUID());
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
	 * Set Product Asset.
	 *
	 * @param P_Asset_A Account for Product Asset (Inventory)
	 */
	@JsonProperty("P_Asset_A")
	public void setP_Asset_AInput(ForeignEntityInput P_Asset_A) {
		this.mP_Asset_A = P_Asset_A;
		if (P_Asset_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(P_Asset_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setP_Asset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + P_Asset_A.getUUID());
			}
		} else {
			this.setP_Asset_Acct(0);
		}
	}

	/**
	 * Get Product Asset.
	 *
	 * @return Account for Product Asset (Inventory)
	 */
	@JsonProperty("P_Asset_A")
	public ForeignEntityInput P_Asset_A() {
		return mP_Asset_A;
	}

	/**
	 * Set Average Cost Variance.
	 *
	 * @param P_AverageCostVariance_A Average Cost Variance
	 */
	@JsonProperty("P_AverageCostVariance_A")
	public void setP_AverageCostVariance_AInput(ForeignEntityInput P_AverageCostVariance_A) {
		this.mP_AverageCostVariance_A = P_AverageCostVariance_A;
		if (P_AverageCostVariance_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(P_AverageCostVariance_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setP_AverageCostVariance_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + P_AverageCostVariance_A.getUUID());
			}
		} else {
			this.setP_AverageCostVariance_Acct(0);
		}
	}

	/**
	 * Get Average Cost Variance.
	 *
	 * @return Average Cost Variance
	 */
	@JsonProperty("P_AverageCostVariance_A")
	public ForeignEntityInput P_AverageCostVariance_A() {
		return mP_AverageCostVariance_A;
	}

	/**
	 * Set Product COGS.
	 *
	 * @param P_COGS_A Account for Cost of Goods Sold
	 */
	@JsonProperty("P_COGS_A")
	public void setP_COGS_AInput(ForeignEntityInput P_COGS_A) {
		this.mP_COGS_A = P_COGS_A;
		if (P_COGS_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(P_COGS_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setP_COGS_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + P_COGS_A.getUUID());
			}
		} else {
			this.setP_COGS_Acct(0);
		}
	}

	/**
	 * Get Product COGS.
	 *
	 * @return Account for Cost of Goods Sold
	 */
	@JsonProperty("P_COGS_A")
	public ForeignEntityInput P_COGS_A() {
		return mP_COGS_A;
	}

	/**
	 * Set Cost Adjustment.
	 *
	 * @param P_CostAdjustment_A Product Cost Adjustment Account
	 */
	@JsonProperty("P_CostAdjustment_A")
	public void setP_CostAdjustment_AInput(ForeignEntityInput P_CostAdjustment_A) {
		this.mP_CostAdjustment_A = P_CostAdjustment_A;
		if (P_CostAdjustment_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(P_CostAdjustment_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setP_CostAdjustment_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + P_CostAdjustment_A.getUUID());
			}
		} else {
			this.setP_CostAdjustment_Acct(0);
		}
	}

	/**
	 * Get Cost Adjustment.
	 *
	 * @return Product Cost Adjustment Account
	 */
	@JsonProperty("P_CostAdjustment_A")
	public ForeignEntityInput P_CostAdjustment_A() {
		return mP_CostAdjustment_A;
	}

	/**
	 * Set Product Expense.
	 *
	 * @param P_Expense_A Account for Product Expense
	 */
	@JsonProperty("P_Expense_A")
	public void setP_Expense_AInput(ForeignEntityInput P_Expense_A) {
		this.mP_Expense_A = P_Expense_A;
		if (P_Expense_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(P_Expense_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setP_Expense_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + P_Expense_A.getUUID());
			}
		} else {
			this.setP_Expense_Acct(0);
		}
	}

	/**
	 * Get Product Expense.
	 *
	 * @return Account for Product Expense
	 */
	@JsonProperty("P_Expense_A")
	public ForeignEntityInput P_Expense_A() {
		return mP_Expense_A;
	}

	/**
	 * Set Inventory Clearing.
	 *
	 * @param P_InventoryClearing_A Product Inventory Clearing Account
	 */
	@JsonProperty("P_InventoryClearing_A")
	public void setP_InventoryClearing_AInput(ForeignEntityInput P_InventoryClearing_A) {
		this.mP_InventoryClearing_A = P_InventoryClearing_A;
		if (P_InventoryClearing_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(P_InventoryClearing_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setP_InventoryClearing_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + P_InventoryClearing_A.getUUID());
			}
		} else {
			this.setP_InventoryClearing_Acct(0);
		}
	}

	/**
	 * Get Inventory Clearing.
	 *
	 * @return Product Inventory Clearing Account
	 */
	@JsonProperty("P_InventoryClearing_A")
	public ForeignEntityInput P_InventoryClearing_A() {
		return mP_InventoryClearing_A;
	}

	/**
	 * Set Invoice Price Variance.
	 *
	 * @param P_InvoicePriceVariance_A Difference between Costs and Invoice Price (IPV)
	 */
	@JsonProperty("P_InvoicePriceVariance_A")
	public void setP_InvoicePriceVariance_AInput(ForeignEntityInput P_InvoicePriceVariance_A) {
		this.mP_InvoicePriceVariance_A = P_InvoicePriceVariance_A;
		if (P_InvoicePriceVariance_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(P_InvoicePriceVariance_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setP_InvoicePriceVariance_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + P_InvoicePriceVariance_A.getUUID());
			}
		} else {
			this.setP_InvoicePriceVariance_Acct(0);
		}
	}

	/**
	 * Get Invoice Price Variance.
	 *
	 * @return Difference between Costs and Invoice Price (IPV)
	 */
	@JsonProperty("P_InvoicePriceVariance_A")
	public ForeignEntityInput P_InvoicePriceVariance_A() {
		return mP_InvoicePriceVariance_A;
	}

	/**
	 * Set Landed Cost Clearing.
	 *
	 * @param P_LandedCostClearing_A Product Landed Cost Clearing Account
	 */
	@JsonProperty("P_LandedCostClearing_A")
	public void setP_LandedCostClearing_AInput(ForeignEntityInput P_LandedCostClearing_A) {
		this.mP_LandedCostClearing_A = P_LandedCostClearing_A;
		if (P_LandedCostClearing_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(P_LandedCostClearing_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setP_LandedCostClearing_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + P_LandedCostClearing_A.getUUID());
			}
		} else {
			this.setP_LandedCostClearing_Acct(0);
		}
	}

	/**
	 * Get Landed Cost Clearing.
	 *
	 * @return Product Landed Cost Clearing Account
	 */
	@JsonProperty("P_LandedCostClearing_A")
	public ForeignEntityInput P_LandedCostClearing_A() {
		return mP_LandedCostClearing_A;
	}

	/**
	 * Set Purchase Price Variance.
	 *
	 * @param P_PurchasePriceVariance_A Difference between Standard Cost and Purchase Price (PPV)
	 */
	@JsonProperty("P_PurchasePriceVariance_A")
	public void setP_PurchasePriceVariance_AInput(ForeignEntityInput P_PurchasePriceVariance_A) {
		this.mP_PurchasePriceVariance_A = P_PurchasePriceVariance_A;
		if (P_PurchasePriceVariance_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(P_PurchasePriceVariance_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setP_PurchasePriceVariance_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + P_PurchasePriceVariance_A.getUUID());
			}
		} else {
			this.setP_PurchasePriceVariance_Acct(0);
		}
	}

	/**
	 * Get Purchase Price Variance.
	 *
	 * @return Difference between Standard Cost and Purchase Price (PPV)
	 */
	@JsonProperty("P_PurchasePriceVariance_A")
	public ForeignEntityInput P_PurchasePriceVariance_A() {
		return mP_PurchasePriceVariance_A;
	}

	/**
	 * Set Rate Variance.
	 *
	 * @param P_RateVariance_A The Rate Variance account is the account used Manufacturing Order
	 */
	@JsonProperty("P_RateVariance_A")
	public void setP_RateVariance_AInput(ForeignEntityInput P_RateVariance_A) {
		this.mP_RateVariance_A = P_RateVariance_A;
		if (P_RateVariance_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(P_RateVariance_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setP_RateVariance_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + P_RateVariance_A.getUUID());
			}
		} else {
			this.setP_RateVariance_Acct(0);
		}
	}

	/**
	 * Get Rate Variance.
	 *
	 * @return The Rate Variance account is the account used Manufacturing Order
	 */
	@JsonProperty("P_RateVariance_A")
	public ForeignEntityInput P_RateVariance_A() {
		return mP_RateVariance_A;
	}

	/**
	 * Set Product Revenue.
	 *
	 * @param P_Revenue_A Account for Product Revenue (Sales Account)
	 */
	@JsonProperty("P_Revenue_A")
	public void setP_Revenue_AInput(ForeignEntityInput P_Revenue_A) {
		this.mP_Revenue_A = P_Revenue_A;
		if (P_Revenue_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(P_Revenue_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setP_Revenue_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + P_Revenue_A.getUUID());
			}
		} else {
			this.setP_Revenue_Acct(0);
		}
	}

	/**
	 * Get Product Revenue.
	 *
	 * @return Account for Product Revenue (Sales Account)
	 */
	@JsonProperty("P_Revenue_A")
	public ForeignEntityInput P_Revenue_A() {
		return mP_Revenue_A;
	}

	/**
	 * Set Trade Discount Granted.
	 *
	 * @param P_TradeDiscountGrant_A Trade Discount Granted Account
	 */
	@JsonProperty("P_TradeDiscountGrant_A")
	public void setP_TradeDiscountGrant_AInput(ForeignEntityInput P_TradeDiscountGrant_A) {
		this.mP_TradeDiscountGrant_A = P_TradeDiscountGrant_A;
		if (P_TradeDiscountGrant_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(P_TradeDiscountGrant_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setP_TradeDiscountGrant_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + P_TradeDiscountGrant_A.getUUID());
			}
		} else {
			this.setP_TradeDiscountGrant_Acct(0);
		}
	}

	/**
	 * Get Trade Discount Granted.
	 *
	 * @return Trade Discount Granted Account
	 */
	@JsonProperty("P_TradeDiscountGrant_A")
	public ForeignEntityInput P_TradeDiscountGrant_A() {
		return mP_TradeDiscountGrant_A;
	}

	/**
	 * Set Trade Discount Received.
	 *
	 * @param P_TradeDiscountRec_A Trade Discount Receivable Account
	 */
	@JsonProperty("P_TradeDiscountRec_A")
	public void setP_TradeDiscountRec_AInput(ForeignEntityInput P_TradeDiscountRec_A) {
		this.mP_TradeDiscountRec_A = P_TradeDiscountRec_A;
		if (P_TradeDiscountRec_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(P_TradeDiscountRec_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setP_TradeDiscountRec_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + P_TradeDiscountRec_A.getUUID());
			}
		} else {
			this.setP_TradeDiscountRec_Acct(0);
		}
	}

	/**
	 * Get Trade Discount Received.
	 *
	 * @return Trade Discount Receivable Account
	 */
	@JsonProperty("P_TradeDiscountRec_A")
	public ForeignEntityInput P_TradeDiscountRec_A() {
		return mP_TradeDiscountRec_A;
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
							.setParameters(PayDiscount_Exp_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPayDiscount_Exp_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + PayDiscount_Exp_A.getUUID());
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
							.setParameters(PayDiscount_Rev_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPayDiscount_Rev_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + PayDiscount_Rev_A.getUUID());
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
	 * Set Project Asset.
	 *
	 * @param PJ_Asset_A Project Asset Account
	 */
	@JsonProperty("PJ_Asset_A")
	public void setPJ_Asset_AInput(ForeignEntityInput PJ_Asset_A) {
		this.mPJ_Asset_A = PJ_Asset_A;
		if (PJ_Asset_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(PJ_Asset_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPJ_Asset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + PJ_Asset_A.getUUID());
			}
		} else {
			this.setPJ_Asset_Acct(0);
		}
	}

	/**
	 * Get Project Asset.
	 *
	 * @return Project Asset Account
	 */
	@JsonProperty("PJ_Asset_A")
	public ForeignEntityInput PJ_Asset_A() {
		return mPJ_Asset_A;
	}

	/**
	 * Set Work In Progress.
	 *
	 * @param PJ_WIP_A Account for Work in Progress
	 */
	@JsonProperty("PJ_WIP_A")
	public void setPJ_WIP_AInput(ForeignEntityInput PJ_WIP_A) {
		this.mPJ_WIP_A = PJ_WIP_A;
		if (PJ_WIP_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(PJ_WIP_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPJ_WIP_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + PJ_WIP_A.getUUID());
			}
		} else {
			this.setPJ_WIP_Acct(0);
		}
	}

	/**
	 * Get Work In Progress.
	 *
	 * @return Account for Work in Progress
	 */
	@JsonProperty("PJ_WIP_A")
	public ForeignEntityInput PJ_WIP_A() {
		return mPJ_WIP_A;
	}

	/**
	 * Set Realized Gain Acct.
	 *
	 * @param RealizedGain_A Realized Gain Account
	 */
	@JsonProperty("RealizedGain_A")
	public void setRealizedGain_AInput(ForeignEntityInput RealizedGain_A) {
		this.mRealizedGain_A = RealizedGain_A;
		if (RealizedGain_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(RealizedGain_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setRealizedGain_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + RealizedGain_A.getUUID());
			}
		} else {
			this.setRealizedGain_Acct(0);
		}
	}

	/**
	 * Get Realized Gain Acct.
	 *
	 * @return Realized Gain Account
	 */
	@JsonProperty("RealizedGain_A")
	public ForeignEntityInput RealizedGain_A() {
		return mRealizedGain_A;
	}

	/**
	 * Set Realized Loss Acct.
	 *
	 * @param RealizedLoss_A Realized Loss Account
	 */
	@JsonProperty("RealizedLoss_A")
	public void setRealizedLoss_AInput(ForeignEntityInput RealizedLoss_A) {
		this.mRealizedLoss_A = RealizedLoss_A;
		if (RealizedLoss_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(RealizedLoss_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setRealizedLoss_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + RealizedLoss_A.getUUID());
			}
		} else {
			this.setRealizedLoss_Acct(0);
		}
	}

	/**
	 * Get Realized Loss Acct.
	 *
	 * @return Realized Loss Account
	 */
	@JsonProperty("RealizedLoss_A")
	public ForeignEntityInput RealizedLoss_A() {
		return mRealizedLoss_A;
	}

	/**
	 * Set Tax Credit.
	 *
	 * @param T_Credit_A Account for Tax you can reclaim
	 */
	@JsonProperty("T_Credit_A")
	public void setT_Credit_AInput(ForeignEntityInput T_Credit_A) {
		this.mT_Credit_A = T_Credit_A;
		if (T_Credit_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(T_Credit_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setT_Credit_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + T_Credit_A.getUUID());
			}
		} else {
			this.setT_Credit_Acct(0);
		}
	}

	/**
	 * Get Tax Credit.
	 *
	 * @return Account for Tax you can reclaim
	 */
	@JsonProperty("T_Credit_A")
	public ForeignEntityInput T_Credit_A() {
		return mT_Credit_A;
	}

	/**
	 * Set Tax Due.
	 *
	 * @param T_Due_A Account for Tax you have to pay
	 */
	@JsonProperty("T_Due_A")
	public void setT_Due_AInput(ForeignEntityInput T_Due_A) {
		this.mT_Due_A = T_Due_A;
		if (T_Due_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(T_Due_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setT_Due_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + T_Due_A.getUUID());
			}
		} else {
			this.setT_Due_Acct(0);
		}
	}

	/**
	 * Get Tax Due.
	 *
	 * @return Account for Tax you have to pay
	 */
	@JsonProperty("T_Due_A")
	public ForeignEntityInput T_Due_A() {
		return mT_Due_A;
	}

	/**
	 * Set Tax Expense.
	 *
	 * @param T_Expense_A Account for paid tax you cannot reclaim
	 */
	@JsonProperty("T_Expense_A")
	public void setT_Expense_AInput(ForeignEntityInput T_Expense_A) {
		this.mT_Expense_A = T_Expense_A;
		if (T_Expense_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(T_Expense_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setT_Expense_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + T_Expense_A.getUUID());
			}
		} else {
			this.setT_Expense_Acct(0);
		}
	}

	/**
	 * Get Tax Expense.
	 *
	 * @return Account for paid tax you cannot reclaim
	 */
	@JsonProperty("T_Expense_A")
	public ForeignEntityInput T_Expense_A() {
		return mT_Expense_A;
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
							.setParameters(UnEarnedRevenue_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setUnEarnedRevenue_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + UnEarnedRevenue_A.getUUID());
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
	 * Set Unrealized Gain Acct.
	 *
	 * @param UnrealizedGain_A Unrealized Gain Account for currency revaluation
	 */
	@JsonProperty("UnrealizedGain_A")
	public void setUnrealizedGain_AInput(ForeignEntityInput UnrealizedGain_A) {
		this.mUnrealizedGain_A = UnrealizedGain_A;
		if (UnrealizedGain_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(UnrealizedGain_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setUnrealizedGain_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + UnrealizedGain_A.getUUID());
			}
		} else {
			this.setUnrealizedGain_Acct(0);
		}
	}

	/**
	 * Get Unrealized Gain Acct.
	 *
	 * @return Unrealized Gain Account for currency revaluation
	 */
	@JsonProperty("UnrealizedGain_A")
	public ForeignEntityInput UnrealizedGain_A() {
		return mUnrealizedGain_A;
	}

	/**
	 * Set Unrealized Loss Acct.
	 *
	 * @param UnrealizedLoss_A Unrealized Loss Account for currency revaluation
	 */
	@JsonProperty("UnrealizedLoss_A")
	public void setUnrealizedLoss_AInput(ForeignEntityInput UnrealizedLoss_A) {
		this.mUnrealizedLoss_A = UnrealizedLoss_A;
		if (UnrealizedLoss_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(UnrealizedLoss_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setUnrealizedLoss_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + UnrealizedLoss_A.getUUID());
			}
		} else {
			this.setUnrealizedLoss_Acct(0);
		}
	}

	/**
	 * Get Unrealized Loss Acct.
	 *
	 * @return Unrealized Loss Account for currency revaluation
	 */
	@JsonProperty("UnrealizedLoss_A")
	public ForeignEntityInput UnrealizedLoss_A() {
		return mUnrealizedLoss_A;
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
							.setParameters(V_Liability_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setV_Liability_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + V_Liability_A.getUUID());
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
							.setParameters(V_Liability_Services_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setV_Liability_Services_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + V_Liability_Services_A.getUUID());
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
							.setParameters(V_Prepayment_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setV_Prepayment_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + V_Prepayment_A.getUUID());
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
	 * Set Warehouse Differences.
	 *
	 * @param W_Differences_A Warehouse Differences Account
	 */
	@JsonProperty("W_Differences_A")
	public void setW_Differences_AInput(ForeignEntityInput W_Differences_A) {
		this.mW_Differences_A = W_Differences_A;
		if (W_Differences_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(W_Differences_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setW_Differences_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + W_Differences_A.getUUID());
			}
		} else {
			this.setW_Differences_Acct(0);
		}
	}

	/**
	 * Get Warehouse Differences.
	 *
	 * @return Warehouse Differences Account
	 */
	@JsonProperty("W_Differences_A")
	public ForeignEntityInput W_Differences_A() {
		return mW_Differences_A;
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
							.setParameters(WriteOff_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setWriteOff_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + WriteOff_A.getUUID());
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
