package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_PaymentTransaction;

/**
 * Generated Interface for C_PaymentTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_PaymentTransactionInput extends I_C_PaymentTransaction {

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
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_ActivityInput(ForeignEntityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	ForeignEntityInput C_Activity();

	/**
	 * Set C_BankAccount.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	void setC_BankAccountInput(ForeignEntityInput C_BankAccount);

	/**
	 * Get C_BankAccount.
	 *
	 * @return Account at the Bank
	 */
	ForeignEntityInput C_BankAccount();

	/**
	 * Set C_BP_BankAccount.
	 *
	 * @param C_BP_BankAccount Bank Account of the Business Partner
	 */
	void setC_BP_BankAccountInput(ForeignEntityInput C_BP_BankAccount);

	/**
	 * Get C_BP_BankAccount.
	 *
	 * @return Bank Account of the Business Partner
	 */
	ForeignEntityInput C_BP_BankAccount();

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
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_CampaignInput(ForeignEntityInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	ForeignEntityInput C_Campaign();

	/**
	 * Set C_CashBook.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	void setC_CashBookInput(ForeignEntityInput C_CashBook);

	/**
	 * Get C_CashBook.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	ForeignEntityInput C_CashBook();

	/**
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_ChargeInput(ForeignEntityInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	ForeignEntityInput C_Charge();

	/**
	 * Set C_ConversionType.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	void setC_ConversionTypeInput(ForeignEntityInput C_ConversionType);

	/**
	 * Get C_ConversionType.
	 *
	 * @return Currency Conversion Rate Type
	 */
	ForeignEntityInput C_ConversionType();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(ForeignEntityInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	ForeignEntityInput C_Currency();

	/**
	 * Set C_Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	void setC_InvoiceInput(ForeignEntityInput C_Invoice);

	/**
	 * Get C_Invoice.
	 *
	 * @return Invoice Identifier
	 */
	ForeignEntityInput C_Invoice();

	/**
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_OrderInput(ForeignEntityInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	ForeignEntityInput C_Order();

	/**
	 * Set C_Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	void setC_PaymentInput(ForeignEntityInput C_Payment);

	/**
	 * Get C_Payment.
	 *
	 * @return Payment identifier
	 */
	ForeignEntityInput C_Payment();

	/**
	 * Set C_PaymentBatch.
	 *
	 * @param C_PaymentBatch Payment batch for EFT
	 */
	void setC_PaymentBatchInput(ForeignEntityInput C_PaymentBatch);

	/**
	 * Get C_PaymentBatch.
	 *
	 * @return Payment batch for EFT
	 */
	ForeignEntityInput C_PaymentBatch();

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
	 * Set C_POSTenderType.
	 *
	 * @param C_POSTenderType C_POSTenderType
	 */
	void setC_POSTenderTypeInput(ForeignEntityInput C_POSTenderType);

	/**
	 * Get C_POSTenderType.
	 *
	 * @return C_POSTenderType
	 */
	ForeignEntityInput C_POSTenderType();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_ProjectInput(ForeignEntityInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	ForeignEntityInput C_Project();

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

	/**
	 * Set Ref_PaymentTransaction.
	 *
	 * @param Ref_PaymentTransaction Ref_PaymentTransaction
	 */
	void setRef_PaymentTransactionInput(ForeignEntityInput Ref_PaymentTransaction);

	/**
	 * Get Ref_PaymentTransaction.
	 *
	 * @return Ref_PaymentTransaction
	 */
	ForeignEntityInput Ref_PaymentTransaction();

	/**
	 * Set TenderType.
	 *
	 * @param TenderType Method of Payment
	 */
	void setTenderTypeInput(I_AD_Ref_ListInput TenderType);

	/**
	 * Get TenderType.
	 *
	 * @return Method of Payment
	 */
	I_AD_Ref_ListInput TenderType();

	/**
	 * Set TrxType.
	 *
	 * @param TrxType Type of credit card transaction
	 */
	void setTrxTypeInput(I_AD_Ref_ListInput TrxType);

	/**
	 * Get TrxType.
	 *
	 * @return Type of credit card transaction
	 */
	I_AD_Ref_ListInput TrxType();

	/**
	 * Set User1.
	 *
	 * @param User1 User defined list element #1
	 */
	void setUser1Input(ForeignEntityInput User1);

	/**
	 * Get User1.
	 *
	 * @return User defined list element #1
	 */
	ForeignEntityInput User1();

	/**
	 * Set User2.
	 *
	 * @param User2 User defined list element #2
	 */
	void setUser2Input(ForeignEntityInput User2);

	/**
	 * Get User2.
	 *
	 * @return User defined list element #2
	 */
	ForeignEntityInput User2();
}
