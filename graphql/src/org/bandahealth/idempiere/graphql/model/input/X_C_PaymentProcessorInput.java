package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCurrency;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentProcessor;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_PaymentProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentProcessorInput extends MPaymentProcessor implements I_C_PaymentProcessorInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput TrxType_RL;
	 private I_AD_SequenceInput AD_Sequence;
	 private I_C_BankAccountInput C_BankAccount;
	 private I_C_CurrencyInput C_Currency;

	/**
	 * Standard constructor
	 */
	public X_C_PaymentProcessorInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Sequence.
	 *
	 * @param AD_Sequence Document Sequence
	 */
	public void setAD_Sequence(I_AD_SequenceInput AD_Sequence) {
		this.AD_Sequence = AD_Sequence;
		MSequence_BH foreignEntity;
		if (AD_Sequence != null &&
				(foreignEntity = new Query(getCtx(), MSequence_BH.Table_Name, MSequence_BH.COLUMNNAME_AD_Sequence_UU + "=?", get_TrxName())
						.setParameters(AD_Sequence.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Sequence_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Sequence_ID(0);
		}
	}

	/**
	 * Get Sequence.
	 *
	 * @return Document Sequence
	 */
	public I_AD_SequenceInput getAD_Sequence() {
		return AD_Sequence;
	}

	/**
	 * Set Bank Account.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	public void setC_BankAccount(I_C_BankAccountInput C_BankAccount) {
		this.C_BankAccount = C_BankAccount;
		MBankAccount_BH foreignEntity;
		if (get_ID() == 0 &&C_BankAccount != null &&
				(foreignEntity = new Query(getCtx(), MBankAccount_BH.Table_Name, MBankAccount_BH.COLUMNNAME_C_BankAccount_UU + "=?", get_TrxName())
						.setParameters(C_BankAccount.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BankAccount_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public I_C_BankAccountInput getC_BankAccount() {
		return C_BankAccount;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
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
	 * @param TrxType_RL Type of credit card transaction
	 */
	public void setTrxType_RL(I_AD_Ref_ListInput TrxType_RL) {
		this.TrxType_RL = TrxType_RL;
		MRefList foreignEntity;
		if (TrxType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TrxType_RL.getID())
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
	public I_AD_Ref_ListInput getTrxType_RL() {
		return TrxType_RL;
	}
}
