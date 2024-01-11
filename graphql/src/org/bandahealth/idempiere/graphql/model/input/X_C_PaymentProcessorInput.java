package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentProcessor;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_PaymentProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentProcessorInput extends MPaymentProcessor implements I_C_PaymentProcessorInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Sequence;
	private ForeignEntityInput mC_BankAccount;
	private ForeignEntityInput mC_Currency;
	private I_AD_Ref_ListInput mTrxType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_PaymentProcessorInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MPaymentProcessor(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Sequence.
	 *
	 * @param AD_Sequence Document Sequence
	 */
	@JsonProperty("AD_Sequence")
	public void setAD_SequenceInput(ForeignEntityInput AD_Sequence) {
		this.mAD_Sequence = AD_Sequence;
		MSequence_BH foreignEntity;
		if (AD_Sequence != null &&
				(foreignEntity = new Query(getCtx(), "AD_Sequence", "AD_Sequence_UU=?", get_TrxName())
						.setParameters(AD_Sequence.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Sequence_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Sequence_ID(0);
		}
	}

	/**
	 * Get Sequence.
	 *
	 * @return Document Sequence
	 */
	@JsonProperty("AD_Sequence")
	public ForeignEntityInput AD_Sequence() {
		return mAD_Sequence;
	}

	/**
	 * Set Bank Account.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	@JsonProperty("C_BankAccount")
	public void setC_BankAccountInput(ForeignEntityInput C_BankAccount) {
		this.mC_BankAccount = C_BankAccount;
		MBankAccount_BH foreignEntity;
		if (get_ID() == 0 && C_BankAccount != null &&
				(foreignEntity = new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
						.setParameters(C_BankAccount.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BankAccount_ID(foreignEntity.get_ID());
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

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			super.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public ForeignEntityInput C_Currency() {
		return mC_Currency;
	}
	/**
	 * Set Payment Processor.
	 *
	 * @param C_PaymentProcessor_ID Payment processor for electronic payments
	 */

	public void setC_PaymentProcessor_ID(int C_PaymentProcessor_ID) {
		if (get_ID() == 0) {
			super.setC_PaymentProcessor_ID(C_PaymentProcessor_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_PaymentProcessor_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_PaymentProcessor_UU();
	}

	/**
	 * Set Transaction Type.
	 *
	 * @param TrxType Type of credit card transaction
	 */
	@JsonProperty("TrxType")
	public void setTrxTypeInput(I_AD_Ref_ListInput TrxType) {
		this.mTrxType = TrxType;
		MRefList_BH foreignEntity;
		if (TrxType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TrxType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setTrxType(foreignEntity.getValue());
		} else {
			this.setTrxType(null);
		}
	}

	/**
	 * Get Transaction Type.
	 *
	 * @return Type of credit card transaction
	 */
	@JsonProperty("TrxType")
	public I_AD_Ref_ListInput TrxType() {
		return mTrxType;
	}
}
