package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPBankAccount;
import org.compiere.model.MBank;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentProcessor;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_BP_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_BankAccountInput extends MBPBankAccount implements I_C_BP_BankAccountInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mBPBankAcctUse;
	 private I_AD_Ref_ListInput mBankAccountType;
	 private I_AD_Ref_ListInput mCreditCardType;
	 private I_AD_Ref_ListInput mR_AvsAddr;
	 private I_AD_Ref_ListInput mR_AvsZip;
	 private I_AD_UserInput mAD_User;
	 private I_C_BPartnerInput mC_BPartner;
	 private I_C_BankInput mC_Bank;
	 private I_C_PaymentProcessorInput mC_PaymentProcessor;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_BP_BankAccountInput(@JsonProperty("ID") String ID) {
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(I_AD_UserInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		} else {
			super.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public I_AD_UserInput AD_User() {
		return mAD_User;
	}

	/**
	 * Set Bank Account Type.
	 *
	 * @param BankAccountType Bank Account Type
	 */
	@JsonProperty("BankAccountType")
	public void setBankAccountTypeInput(I_AD_Ref_ListInput BankAccountType) {
		this.mBankAccountType = BankAccountType;
		MRefList_BH foreignEntity;
		if (BankAccountType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BankAccountType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBankAccountType(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput BankAccountType() {
		return mBankAccountType;
	}

	/**
	 * Set Account Usage.
	 *
	 * @param BPBankAcctUse Business Partner Bank Account usage
	 */
	@JsonProperty("BPBankAcctUse")
	public void setBPBankAcctUseInput(I_AD_Ref_ListInput BPBankAcctUse) {
		this.mBPBankAcctUse = BPBankAcctUse;
		MRefList_BH foreignEntity;
		if (BPBankAcctUse != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BPBankAcctUse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBPBankAcctUse(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput BPBankAcctUse() {
		return mBPBankAcctUse;
	}

	/**
	 * Set Bank.
	 *
	 * @param C_Bank Bank
	 */
	@JsonProperty("C_Bank")
	public void setC_BankInput(I_C_BankInput C_Bank) {
		this.mC_Bank = C_Bank;
		MBank foreignEntity;
		if (C_Bank != null &&
				(foreignEntity = new Query(getCtx(), MBank.Table_Name, MBank.COLUMNNAME_C_Bank_UU + "=?", get_TrxName())
						.setParameters(C_Bank.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Bank_ID(foreignEntity.get_ID());
		} else {
			super.setC_Bank_ID(0);
		}
	}

	/**
	 * Get Bank.
	 *
	 * @return Bank
	 */
	@JsonProperty("C_Bank")
	public I_C_BankInput C_Bank() {
		return mC_Bank;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_BP_BankAccount_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_BP_BankAccount_UU();
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(I_C_BPartnerInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (get_ID() == 0 &&C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public I_C_BPartnerInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Payment Processor.
	 *
	 * @param C_PaymentProcessor Payment processor for electronic payments
	 */
	@JsonProperty("C_PaymentProcessor")
	public void setC_PaymentProcessorInput(I_C_PaymentProcessorInput C_PaymentProcessor) {
		this.mC_PaymentProcessor = C_PaymentProcessor;
		MPaymentProcessor foreignEntity;
		if (C_PaymentProcessor != null &&
				(foreignEntity = new Query(getCtx(), MPaymentProcessor.Table_Name, MPaymentProcessor.COLUMNNAME_C_PaymentProcessor_UU + "=?", get_TrxName())
						.setParameters(C_PaymentProcessor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_PaymentProcessor_ID(foreignEntity.get_ID());
		} else {
			super.setC_PaymentProcessor_ID(0);
		}
	}

	/**
	 * Get Payment Processor.
	 *
	 * @return Payment processor for electronic payments
	 */
	@JsonProperty("C_PaymentProcessor")
	public I_C_PaymentProcessorInput C_PaymentProcessor() {
		return mC_PaymentProcessor;
	}

	/**
	 * Set Credit Card.
	 *
	 * @param CreditCardType Credit Card (Visa, MC, AmEx)
	 */
	@JsonProperty("CreditCardType")
	public void setCreditCardTypeInput(I_AD_Ref_ListInput CreditCardType) {
		this.mCreditCardType = CreditCardType;
		MRefList_BH foreignEntity;
		if (CreditCardType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CreditCardType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCreditCardType(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput CreditCardType() {
		return mCreditCardType;
	}

	/**
	 * Set Address verified.
	 *
	 * @param R_AvsAddr This address has been verified
	 */
	@JsonProperty("R_AvsAddr")
	public void setR_AvsAddrInput(I_AD_Ref_ListInput R_AvsAddr) {
		this.mR_AvsAddr = R_AvsAddr;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&R_AvsAddr != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(R_AvsAddr.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setR_AvsAddr(foreignEntity.getValue());
		}
	}

	/**
	 * Get Address verified.
	 *
	 * @return This address has been verified
	 */
	@JsonProperty("R_AvsAddr")
	public I_AD_Ref_ListInput R_AvsAddr() {
		return mR_AvsAddr;
	}

	/**
	 * Set Zip verified.
	 *
	 * @param R_AvsZip The Zip Code has been verified
	 */
	@JsonProperty("R_AvsZip")
	public void setR_AvsZipInput(I_AD_Ref_ListInput R_AvsZip) {
		this.mR_AvsZip = R_AvsZip;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&R_AvsZip != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(R_AvsZip.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setR_AvsZip(foreignEntity.getValue());
		}
	}

	/**
	 * Get Zip verified.
	 *
	 * @return The Zip Code has been verified
	 */
	@JsonProperty("R_AvsZip")
	public I_AD_Ref_ListInput R_AvsZip() {
		return mR_AvsZip;
	}
}
