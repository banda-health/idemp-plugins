package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BP_BankAccount;

/**
 * Generated Interface for C_BP_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_BP_BankAccountInput extends I_C_BP_BankAccount {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_User(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput getAD_User();

	/**
	 * Set BankAccountType_RL.
	 *
	 * @param BankAccountType_RL Bank Account Type
	 */
	void setBankAccountType_RL(I_AD_Ref_ListInput BankAccountType_RL);

	/**
	 * Get BankAccountType_RL.
	 *
	 * @return Bank Account Type
	 */
	I_AD_Ref_ListInput getBankAccountType_RL();

	/**
	 * Set BPBankAcctUse_RL.
	 *
	 * @param BPBankAcctUse_RL Business Partner Bank Account usage
	 */
	void setBPBankAcctUse_RL(I_AD_Ref_ListInput BPBankAcctUse_RL);

	/**
	 * Get BPBankAcctUse_RL.
	 *
	 * @return Business Partner Bank Account usage
	 */
	I_AD_Ref_ListInput getBPBankAcctUse_RL();

	/**
	 * Set C_Bank.
	 *
	 * @param C_Bank Bank
	 */
	void setC_Bank(I_C_BankInput C_Bank);

	/**
	 * Get C_Bank.
	 *
	 * @return Bank
	 */
	I_C_BankInput getC_Bank();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartner(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput getC_BPartner();

	/**
	 * Set C_PaymentProcessor.
	 *
	 * @param C_PaymentProcessor Payment processor for electronic payments
	 */
	void setC_PaymentProcessor(I_C_PaymentProcessorInput C_PaymentProcessor);

	/**
	 * Get C_PaymentProcessor.
	 *
	 * @return Payment processor for electronic payments
	 */
	I_C_PaymentProcessorInput getC_PaymentProcessor();

	/**
	 * Set CreditCardType_RL.
	 *
	 * @param CreditCardType_RL Credit Card (Visa, MC, AmEx)
	 */
	void setCreditCardType_RL(I_AD_Ref_ListInput CreditCardType_RL);

	/**
	 * Get CreditCardType_RL.
	 *
	 * @return Credit Card (Visa, MC, AmEx)
	 */
	I_AD_Ref_ListInput getCreditCardType_RL();

	/**
	 * Set R_AvsAddr_RL.
	 *
	 * @param R_AvsAddr_RL This address has been verified
	 */
	void setR_AvsAddr_RL(I_AD_Ref_ListInput R_AvsAddr_RL);

	/**
	 * Get R_AvsAddr_RL.
	 *
	 * @return This address has been verified
	 */
	I_AD_Ref_ListInput getR_AvsAddr_RL();

	/**
	 * Set R_AvsZip_RL.
	 *
	 * @param R_AvsZip_RL The Zip Code has been verified
	 */
	void setR_AvsZip_RL(I_AD_Ref_ListInput R_AvsZip_RL);

	/**
	 * Get R_AvsZip_RL.
	 *
	 * @return The Zip Code has been verified
	 */
	I_AD_Ref_ListInput getR_AvsZip_RL();
}
