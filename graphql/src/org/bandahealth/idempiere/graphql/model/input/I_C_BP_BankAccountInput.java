package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BP_BankAccount;

/**
 * Generated Interface for C_BP_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_BP_BankAccountInput extends I_C_BP_BankAccount {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();

	/**
	 * Set BankAccountType.
	 *
	 * @param BankAccountType Bank Account Type
	 */
	void setBankAccountTypeInput(ForeignEntityInput BankAccountType);

	/**
	 * Get BankAccountType.
	 *
	 * @return Bank Account Type
	 */
	ForeignEntityInput BankAccountType();

	/**
	 * Set BPBankAcctUse.
	 *
	 * @param BPBankAcctUse Business Partner Bank Account usage
	 */
	void setBPBankAcctUseInput(ForeignEntityInput BPBankAcctUse);

	/**
	 * Get BPBankAcctUse.
	 *
	 * @return Business Partner Bank Account usage
	 */
	ForeignEntityInput BPBankAcctUse();

	/**
	 * Set C_Bank.
	 *
	 * @param C_Bank Bank
	 */
	void setC_BankInput(ForeignEntityInput C_Bank);

	/**
	 * Get C_Bank.
	 *
	 * @return Bank
	 */
	ForeignEntityInput C_Bank();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set C_PaymentProcessor.
	 *
	 * @param C_PaymentProcessor Payment processor for electronic payments
	 */
	void setC_PaymentProcessorInput(ForeignEntityInput C_PaymentProcessor);

	/**
	 * Get C_PaymentProcessor.
	 *
	 * @return Payment processor for electronic payments
	 */
	ForeignEntityInput C_PaymentProcessor();

	/**
	 * Set CreditCardType.
	 *
	 * @param CreditCardType Credit Card (Visa, MC, AmEx)
	 */
	void setCreditCardTypeInput(ForeignEntityInput CreditCardType);

	/**
	 * Get CreditCardType.
	 *
	 * @return Credit Card (Visa, MC, AmEx)
	 */
	ForeignEntityInput CreditCardType();

	/**
	 * Set R_AvsAddr.
	 *
	 * @param R_AvsAddr This address has been verified
	 */
	void setR_AvsAddrInput(ForeignEntityInput R_AvsAddr);

	/**
	 * Get R_AvsAddr.
	 *
	 * @return This address has been verified
	 */
	ForeignEntityInput R_AvsAddr();

	/**
	 * Set R_AvsZip.
	 *
	 * @param R_AvsZip The Zip Code has been verified
	 */
	void setR_AvsZipInput(ForeignEntityInput R_AvsZip);

	/**
	 * Get R_AvsZip.
	 *
	 * @return The Zip Code has been verified
	 */
	ForeignEntityInput R_AvsZip();
}
