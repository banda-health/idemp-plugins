package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_Group_Acct;

import java.sql.ResultSet;

/**
 * Generated Model for C_BP_Group_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
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
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_BP_Group_AcctInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_BP_Group_Acct(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
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
		MAcctSchema foreignEntity;
		if (get_ID() == 0 && C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
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
	public ForeignEntityInput C_AcctSchema() {
		return mC_AcctSchema;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_BP_Group_Acct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MBPGroup_BH foreignEntity;
		if (get_ID() == 0 && C_BP_Group != null &&
				(foreignEntity = new Query(getCtx(), "C_BP_Group", "C_BP_Group_UU=?", get_TrxName())
						.setParameters(C_BP_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BP_Group_ID(foreignEntity.get_ID());
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
		MAccount foreignEntity;
		if (C_Prepayment_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(C_Prepayment_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Prepayment_Acct(foreignEntity.get_ID());
		} else {
			super.setC_Prepayment_Acct(0);
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
		MAccount foreignEntity;
		if (C_Receivable_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(C_Receivable_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Receivable_Acct(foreignEntity.get_ID());
		} else {
			super.setC_Receivable_Acct(0);
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
		MAccount foreignEntity;
		if (C_Receivable_Services_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(C_Receivable_Services_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Receivable_Services_Acct(foreignEntity.get_ID());
		} else {
			super.setC_Receivable_Services_Acct(0);
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
		MAccount foreignEntity;
		if (NotInvoicedReceipts_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(NotInvoicedReceipts_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setNotInvoicedReceipts_Acct(foreignEntity.get_ID());
		} else {
			super.setNotInvoicedReceipts_Acct(0);
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
		MAccount foreignEntity;
		if (PayDiscount_Exp_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(PayDiscount_Exp_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPayDiscount_Exp_Acct(foreignEntity.get_ID());
		} else {
			super.setPayDiscount_Exp_Acct(0);
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
		MAccount foreignEntity;
		if (PayDiscount_Rev_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(PayDiscount_Rev_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPayDiscount_Rev_Acct(foreignEntity.get_ID());
		} else {
			super.setPayDiscount_Rev_Acct(0);
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
		MAccount foreignEntity;
		if (UnEarnedRevenue_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(UnEarnedRevenue_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setUnEarnedRevenue_Acct(foreignEntity.get_ID());
		} else {
			super.setUnEarnedRevenue_Acct(0);
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
		MAccount foreignEntity;
		if (V_Liability_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(V_Liability_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setV_Liability_Acct(foreignEntity.get_ID());
		} else {
			super.setV_Liability_Acct(0);
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
		MAccount foreignEntity;
		if (V_Liability_Services_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(V_Liability_Services_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setV_Liability_Services_Acct(foreignEntity.get_ID());
		} else {
			super.setV_Liability_Services_Acct(0);
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
		MAccount foreignEntity;
		if (V_Prepayment_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(V_Prepayment_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setV_Prepayment_Acct(foreignEntity.get_ID());
		} else {
			super.setV_Prepayment_Acct(0);
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
		MAccount foreignEntity;
		if (WriteOff_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(WriteOff_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setWriteOff_Acct(foreignEntity.get_ID());
		} else {
			super.setWriteOff_Acct(0);
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
