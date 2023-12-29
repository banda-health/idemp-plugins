package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPBankAccount;
import org.compiere.model.MBank;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentProcessor;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_BP_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_BankAccountInput extends MBPBankAccount implements I_C_BP_BankAccountInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput BPBankAcctUse_RL;
	 private I_AD_Ref_ListInput BankAccountType_RL;
	 private I_AD_Ref_ListInput CreditCardType_RL;
	 private I_AD_Ref_ListInput R_AvsAddr_RL;
	 private I_AD_Ref_ListInput R_AvsZip_RL;
	 private I_AD_UserInput AD_User;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_BankInput C_Bank;
	 private I_C_PaymentProcessorInput C_PaymentProcessor;

	/**
	 * Standard constructor
	 */
	public X_C_BP_BankAccountInput(String ID) {
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
	}

	/**
	 * Set Bank Account Type.
	 *
	 * @param BankAccountType_RL Bank Account Type
	 */
	public void setBankAccountType_RL(I_AD_Ref_ListInput BankAccountType_RL) {
		this.BankAccountType_RL = BankAccountType_RL;
		MRefList foreignEntity;
		if (BankAccountType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BankAccountType_RL.getID())
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
	public I_AD_Ref_ListInput getBankAccountType_RL() {
		return BankAccountType_RL;
	}

	/**
	 * Set Account Usage.
	 *
	 * @param BPBankAcctUse_RL Business Partner Bank Account usage
	 */
	public void setBPBankAcctUse_RL(I_AD_Ref_ListInput BPBankAcctUse_RL) {
		this.BPBankAcctUse_RL = BPBankAcctUse_RL;
		MRefList foreignEntity;
		if (BPBankAcctUse_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BPBankAcctUse_RL.getID())
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
	public I_AD_Ref_ListInput getBPBankAcctUse_RL() {
		return BPBankAcctUse_RL;
	}

	/**
	 * Set Bank.
	 *
	 * @param C_Bank Bank
	 */
	public void setC_Bank(I_C_BankInput C_Bank) {
		this.C_Bank = C_Bank;
		MBank foreignEntity;
		if (C_Bank != null &&
				(foreignEntity = new Query(getCtx(), MBank.Table_Name, MBank.COLUMNNAME_C_Bank_UU + "=?", get_TrxName())
						.setParameters(C_Bank.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Bank_ID(foreignEntity.get_ID());
		} else {
			this.setC_Bank_ID(0);
		}
	}

	/**
	 * Get Bank.
	 *
	 * @return Bank
	 */
	public I_C_BankInput getC_Bank() {
		return C_Bank;
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
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (get_ID() == 0 &&C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
	}

	/**
	 * Set Payment Processor.
	 *
	 * @param C_PaymentProcessor Payment processor for electronic payments
	 */
	public void setC_PaymentProcessor(I_C_PaymentProcessorInput C_PaymentProcessor) {
		this.C_PaymentProcessor = C_PaymentProcessor;
		MPaymentProcessor foreignEntity;
		if (C_PaymentProcessor != null &&
				(foreignEntity = new Query(getCtx(), MPaymentProcessor.Table_Name, MPaymentProcessor.COLUMNNAME_C_PaymentProcessor_UU + "=?", get_TrxName())
						.setParameters(C_PaymentProcessor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_PaymentProcessor_ID(foreignEntity.get_ID());
		} else {
			this.setC_PaymentProcessor_ID(0);
		}
	}

	/**
	 * Get Payment Processor.
	 *
	 * @return Payment processor for electronic payments
	 */
	public I_C_PaymentProcessorInput getC_PaymentProcessor() {
		return C_PaymentProcessor;
	}

	/**
	 * Set Credit Card.
	 *
	 * @param CreditCardType_RL Credit Card (Visa, MC, AmEx)
	 */
	public void setCreditCardType_RL(I_AD_Ref_ListInput CreditCardType_RL) {
		this.CreditCardType_RL = CreditCardType_RL;
		MRefList foreignEntity;
		if (CreditCardType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CreditCardType_RL.getID())
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
	public I_AD_Ref_ListInput getCreditCardType_RL() {
		return CreditCardType_RL;
	}

	/**
	 * Set Address verified.
	 *
	 * @param R_AvsAddr_RL This address has been verified
	 */
	public void setR_AvsAddr_RL(I_AD_Ref_ListInput R_AvsAddr_RL) {
		this.R_AvsAddr_RL = R_AvsAddr_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&R_AvsAddr_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(R_AvsAddr_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setR_AvsAddr(foreignEntity.getValue());
		}
	}

	/**
	 * Get Address verified.
	 *
	 * @return This address has been verified
	 */
	public I_AD_Ref_ListInput getR_AvsAddr_RL() {
		return R_AvsAddr_RL;
	}

	/**
	 * Set Zip verified.
	 *
	 * @param R_AvsZip_RL The Zip Code has been verified
	 */
	public void setR_AvsZip_RL(I_AD_Ref_ListInput R_AvsZip_RL) {
		this.R_AvsZip_RL = R_AvsZip_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&R_AvsZip_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(R_AvsZip_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setR_AvsZip(foreignEntity.getValue());
		}
	}

	/**
	 * Get Zip verified.
	 *
	 * @return The Zip Code has been verified
	 */
	public I_AD_Ref_ListInput getR_AvsZip_RL() {
		return R_AvsZip_RL;
	}
}
