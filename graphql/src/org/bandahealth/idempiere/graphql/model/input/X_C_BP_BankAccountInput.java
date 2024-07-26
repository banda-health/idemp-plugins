package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_C_BP_BankAccountResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPBankAccount;
import org.compiere.model.MBank;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentProcessor;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_BP_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BP_BankAccountInput extends MBPBankAccount implements I_C_BP_BankAccountInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mBPBankAcctUse;
	private ForeignEntityInput mBankAccountType;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Bank;
	private ForeignEntityInput mC_PaymentProcessor;
	private ForeignEntityInput mCreditCardType;
	private ForeignEntityInput mR_AvsAddr;
	private ForeignEntityInput mR_AvsZip;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_BP_BankAccount_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_BP_BankAccountInput(@JsonProperty("UU") String UU) {
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
			}
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}

	/**
	 * Set Bank Account Type.
	 *
	 * @param BankAccountType Bank Account Type
	 */
	@JsonProperty("BankAccountType")
	public void setBankAccountTypeInput(ForeignEntityInput BankAccountType) {
		this.mBankAccountType = BankAccountType;
		if (BankAccountType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_BP_BankAccountResolver.BANKACCOUNTTYPE_UUIDS_BY_VALUE.containsValue(BankAccountType.getUU())) {
				throw new AdempiereException("The reference list UU of " + BankAccountType.getUU() +
						" is not in the list defined for the BankAccountType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BankAccountType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBankAccountType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BankAccountType.getUU());
			}
		} else {
			this.setBankAccountType(null);
		}
	}

	/**
	 * Get Bank Account Type.
	 *
	 * @return Bank Account Type
	 */
	@JsonProperty("BankAccountType")
	public ForeignEntityInput BankAccountType() {
		return mBankAccountType;
	}

	/**
	 * Set Account Usage.
	 *
	 * @param BPBankAcctUse Business Partner Bank Account usage
	 */
	@JsonProperty("BPBankAcctUse")
	public void setBPBankAcctUseInput(ForeignEntityInput BPBankAcctUse) {
		this.mBPBankAcctUse = BPBankAcctUse;
		if (BPBankAcctUse != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_BP_BankAccountResolver.BPBANKACCTUSE_UUIDS_BY_VALUE.containsValue(BPBankAcctUse.getUU())) {
				throw new AdempiereException("The reference list UU of " + BPBankAcctUse.getUU() +
						" is not in the list defined for the BPBankAcctUse column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BPBankAcctUse.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBPBankAcctUse(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BPBankAcctUse.getUU());
			}
		} else {
			this.setBPBankAcctUse(null);
		}
	}

	/**
	 * Get Account Usage.
	 *
	 * @return Business Partner Bank Account usage
	 */
	@JsonProperty("BPBankAcctUse")
	public ForeignEntityInput BPBankAcctUse() {
		return mBPBankAcctUse;
	}

	/**
	 * Set Bank.
	 *
	 * @param C_Bank Bank
	 */
	@JsonProperty("C_Bank")
	public void setC_BankInput(ForeignEntityInput C_Bank) {
		this.mC_Bank = C_Bank;
		if (C_Bank != null) {
			// Since an entity was passed, make sure it's in the DB
			MBank foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Bank", "C_Bank_UU=?", get_TrxName())
							.setParameters(C_Bank.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Bank_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Bank with UU " + C_Bank.getUU());
			}
		} else {
			this.setC_Bank_ID(0);
		}
	}

	/**
	 * Get Bank.
	 *
	 * @return Bank
	 */
	@JsonProperty("C_Bank")
	public ForeignEntityInput C_Bank() {
		return mC_Bank;
	}
	/**
	 * Set Partner Bank Account.
	 *
	 * @param C_BP_BankAccount_ID Bank Account of the Business Partner
	 */
	@JsonProperty("C_BP_BankAccount_ID")
	public void setC_BP_BankAccount_IDFromJson(int C_BP_BankAccount_ID) {
		if (get_ID() == 0) {
			super.setC_BP_BankAccount_ID(C_BP_BankAccount_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_BP_BankAccount_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_BP_BankAccount_UU();
	}

	/**
	 * Set Business Partner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (get_ID() != 0) {
			return;
		}
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Payment Processor.
	 *
	 * @param C_PaymentProcessor Payment processor for electronic payments
	 */
	@JsonProperty("C_PaymentProcessor")
	public void setC_PaymentProcessorInput(ForeignEntityInput C_PaymentProcessor) {
		this.mC_PaymentProcessor = C_PaymentProcessor;
		if (C_PaymentProcessor != null) {
			// Since an entity was passed, make sure it's in the DB
			MPaymentProcessor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_PaymentProcessor", "C_PaymentProcessor_UU=?", get_TrxName())
							.setParameters(C_PaymentProcessor.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_PaymentProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentProcessor with UU " + C_PaymentProcessor.getUU());
			}
		} else {
			this.setC_PaymentProcessor_ID(0);
		}
	}

	/**
	 * Get Payment Processor.
	 *
	 * @return Payment processor for electronic payments
	 */
	@JsonProperty("C_PaymentProcessor")
	public ForeignEntityInput C_PaymentProcessor() {
		return mC_PaymentProcessor;
	}

	/**
	 * Set Credit Card.
	 *
	 * @param CreditCardType Credit Card (Visa, MC, AmEx)
	 */
	@JsonProperty("CreditCardType")
	public void setCreditCardTypeInput(ForeignEntityInput CreditCardType) {
		this.mCreditCardType = CreditCardType;
		if (CreditCardType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_BP_BankAccountResolver.CREDITCARDTYPE_UUIDS_BY_VALUE.containsValue(CreditCardType.getUU())) {
				throw new AdempiereException("The reference list UU of " + CreditCardType.getUU() +
						" is not in the list defined for the CreditCardType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CreditCardType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCreditCardType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + CreditCardType.getUU());
			}
		} else {
			this.setCreditCardType(null);
		}
	}

	/**
	 * Get Credit Card.
	 *
	 * @return Credit Card (Visa, MC, AmEx)
	 */
	@JsonProperty("CreditCardType")
	public ForeignEntityInput CreditCardType() {
		return mCreditCardType;
	}

	/**
	 * Set Address verified.
	 *
	 * @param R_AvsAddr This address has been verified
	 */
	@JsonProperty("R_AvsAddr")
	public void setR_AvsAddrInput(ForeignEntityInput R_AvsAddr) {
		this.mR_AvsAddr = R_AvsAddr;
		if (get_ID() != 0) {
			return;
		}
		if (R_AvsAddr != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_BP_BankAccountResolver.R_AVSADDR_UUIDS_BY_VALUE.containsValue(R_AvsAddr.getUU())) {
				throw new AdempiereException("The reference list UU of " + R_AvsAddr.getUU() +
						" is not in the list defined for the R_AvsAddr column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(R_AvsAddr.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setR_AvsAddr(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + R_AvsAddr.getUU());
			}
		} else {
			this.setR_AvsAddr(null);
		}
	}

	/**
	 * Get Address verified.
	 *
	 * @return This address has been verified
	 */
	@JsonProperty("R_AvsAddr")
	public ForeignEntityInput R_AvsAddr() {
		return mR_AvsAddr;
	}

	/**
	 * Set Zip verified.
	 *
	 * @param R_AvsZip The Zip Code has been verified
	 */
	@JsonProperty("R_AvsZip")
	public void setR_AvsZipInput(ForeignEntityInput R_AvsZip) {
		this.mR_AvsZip = R_AvsZip;
		if (get_ID() != 0) {
			return;
		}
		if (R_AvsZip != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_BP_BankAccountResolver.R_AVSZIP_UUIDS_BY_VALUE.containsValue(R_AvsZip.getUU())) {
				throw new AdempiereException("The reference list UU of " + R_AvsZip.getUU() +
						" is not in the list defined for the R_AvsZip column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(R_AvsZip.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setR_AvsZip(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + R_AvsZip.getUU());
			}
		} else {
			this.setR_AvsZip(null);
		}
	}

	/**
	 * Get Zip verified.
	 *
	 * @return The Zip Code has been verified
	 */
	@JsonProperty("R_AvsZip")
	public ForeignEntityInput R_AvsZip() {
		return mR_AvsZip;
	}
}
