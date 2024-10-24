package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_C_PaymentProcessorResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentProcessor;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_PaymentProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PaymentProcessorInput extends MPaymentProcessor implements I_C_PaymentProcessorInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Sequence;
	private ForeignEntityInput mC_BankAccount;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mTrxType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_PaymentProcessor_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_PaymentProcessorInput(@JsonProperty("UU") String UU) {
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
	 * Set Sequence.
	 *
	 * @param AD_Sequence Document Sequence
	 */
	@JsonProperty("AD_Sequence")
	public void setAD_SequenceInput(ForeignEntityInput AD_Sequence) {
		this.mAD_Sequence = AD_Sequence;
		if (AD_Sequence != null) {
			// Since an entity was passed, make sure it's in the DB
			MSequence_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Sequence", "AD_Sequence_UU=?", get_TrxName())
							.setParameters(AD_Sequence.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Sequence_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Sequence with UU " + AD_Sequence.getUU());
			}
		} else {
			this.setAD_Sequence_ID(0);
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

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UU " + C_Currency.getUU());
			}
		} else {
			this.setC_Currency_ID(0);
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
	@JsonProperty("C_PaymentProcessor_ID")
	public void setC_PaymentProcessor_IDFromJson(int C_PaymentProcessor_ID) {
		if (get_ID() == 0) {
			super.setC_PaymentProcessor_ID(C_PaymentProcessor_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_PaymentProcessor_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_PaymentProcessor_UU();
	}

	/**
	 * Set Transaction Type.
	 *
	 * @param TrxType Type of credit card transaction
	 */
	@JsonProperty("TrxType")
	public void setTrxTypeInput(ForeignEntityInput TrxType) {
		this.mTrxType = TrxType;
		if (TrxType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_PaymentProcessorResolver.TRXTYPE_UUIDS_BY_VALUE.containsValue(TrxType.getUU())) {
				throw new AdempiereException("The reference list UU of " + TrxType.getUU() +
						" is not in the list defined for the TrxType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(TrxType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setTrxType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + TrxType.getUU());
			}
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
	public ForeignEntityInput TrxType() {
		return mTrxType;
	}
}
