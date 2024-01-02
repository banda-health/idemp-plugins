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
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput AD_User();

	/**
	 * Set BankAccountType.
	 *
	 * @param BankAccountType Bank Account Type
	 */
	void setBankAccountTypeInput(I_AD_Ref_ListInput BankAccountType);

	/**
	 * Get BankAccountType.
	 *
	 * @return Bank Account Type
	 */
	I_AD_Ref_ListInput BankAccountType();

	/**
	 * Set BPBankAcctUse.
	 *
	 * @param BPBankAcctUse Business Partner Bank Account usage
	 */
	void setBPBankAcctUseInput(I_AD_Ref_ListInput BPBankAcctUse);

	/**
	 * Get BPBankAcctUse.
	 *
	 * @return Business Partner Bank Account usage
	 */
	I_AD_Ref_ListInput BPBankAcctUse();

	/**
	 * Set C_Bank.
	 *
	 * @param C_Bank Bank
	 */
	void setC_BankInput(I_C_BankInput C_Bank);

	/**
	 * Get C_Bank.
	 *
	 * @return Bank
	 */
	I_C_BankInput C_Bank();

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
	void setC_BPartnerInput(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput C_BPartner();

	/**
	 * Set C_PaymentProcessor.
	 *
	 * @param C_PaymentProcessor Payment processor for electronic payments
	 */
	void setC_PaymentProcessorInput(I_C_PaymentProcessorInput C_PaymentProcessor);

	/**
	 * Get C_PaymentProcessor.
	 *
	 * @return Payment processor for electronic payments
	 */
	I_C_PaymentProcessorInput C_PaymentProcessor();

	/**
	 * Set CreditCardType.
	 *
	 * @param CreditCardType Credit Card (Visa, MC, AmEx)
	 */
	void setCreditCardTypeInput(I_AD_Ref_ListInput CreditCardType);

	/**
	 * Get CreditCardType.
	 *
	 * @return Credit Card (Visa, MC, AmEx)
	 */
	I_AD_Ref_ListInput CreditCardType();

	/**
	 * Set R_AvsAddr.
	 *
	 * @param R_AvsAddr This address has been verified
	 */
	void setR_AvsAddrInput(I_AD_Ref_ListInput R_AvsAddr);

	/**
	 * Get R_AvsAddr.
	 *
	 * @return This address has been verified
	 */
	I_AD_Ref_ListInput R_AvsAddr();

	/**
	 * Set R_AvsZip.
	 *
	 * @param R_AvsZip The Zip Code has been verified
	 */
	void setR_AvsZipInput(I_AD_Ref_ListInput R_AvsZip);

	/**
	 * Get R_AvsZip.
	 *
	 * @return The Zip Code has been verified
	 */
	I_AD_Ref_ListInput R_AvsZip();
}
