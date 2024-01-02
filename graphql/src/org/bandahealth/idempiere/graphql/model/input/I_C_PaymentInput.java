package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Payment;

/**
 * Generated Interface for C_Payment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_PaymentInput extends I_C_Payment {

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
	 * Set BH_Visit.
	 *
	 * @param BH_Visit BH_Visit
	 */
	void setBH_VisitInput(I_BH_VisitInput BH_Visit);

	/**
	 * Get BH_Visit.
	 *
	 * @return BH_Visit
	 */
	I_BH_VisitInput BH_Visit();

	/**
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_ActivityInput(I_C_ActivityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	I_C_ActivityInput C_Activity();

	/**
	 * Set C_BankAccount.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	void setC_BankAccountInput(I_C_BankAccountInput C_BankAccount);

	/**
	 * Get C_BankAccount.
	 *
	 * @return Account at the Bank
	 */
	I_C_BankAccountInput C_BankAccount();

	/**
	 * Set C_BP_BankAccount.
	 *
	 * @param C_BP_BankAccount Bank Account of the Business Partner
	 */
	void setC_BP_BankAccountInput(I_C_BP_BankAccountInput C_BP_BankAccount);

	/**
	 * Get C_BP_BankAccount.
	 *
	 * @return Bank Account of the Business Partner
	 */
	I_C_BP_BankAccountInput C_BP_BankAccount();

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
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_CampaignInput(I_C_CampaignInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	I_C_CampaignInput C_Campaign();

	/**
	 * Set C_CashBook.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	void setC_CashBookInput(I_C_CashBookInput C_CashBook);

	/**
	 * Get C_CashBook.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	I_C_CashBookInput C_CashBook();

	/**
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_ChargeInput(I_C_ChargeInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	I_C_ChargeInput C_Charge();

	/**
	 * Set C_ConversionType.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	void setC_ConversionTypeInput(I_C_ConversionTypeInput C_ConversionType);

	/**
	 * Get C_ConversionType.
	 *
	 * @return Currency Conversion Rate Type
	 */
	I_C_ConversionTypeInput C_ConversionType();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput C_Currency();

	/**
	 * Set C_DepositBatch.
	 *
	 * @param C_DepositBatch C_DepositBatch
	 */
	void setC_DepositBatchInput(I_C_DepositBatchInput C_DepositBatch);

	/**
	 * Get C_DepositBatch.
	 *
	 * @return C_DepositBatch
	 */
	I_C_DepositBatchInput C_DepositBatch();

	/**
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocTypeInput(I_C_DocTypeInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	I_C_DocTypeInput C_DocType();

	/**
	 * Set C_Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	void setC_InvoiceInput(I_C_InvoiceInput C_Invoice);

	/**
	 * Get C_Invoice.
	 *
	 * @return Invoice Identifier
	 */
	I_C_InvoiceInput C_Invoice();

	/**
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_OrderInput(I_C_OrderInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	I_C_OrderInput C_Order();

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
	 * Set C_PaymentBatch.
	 *
	 * @param C_PaymentBatch Payment batch for EFT
	 */
	void setC_PaymentBatchInput(I_C_PaymentBatchInput C_PaymentBatch);

	/**
	 * Get C_PaymentBatch.
	 *
	 * @return Payment batch for EFT
	 */
	I_C_PaymentBatchInput C_PaymentBatch();

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
	 * Set C_POSTenderType.
	 *
	 * @param C_POSTenderType C_POSTenderType
	 */
	void setC_POSTenderTypeInput(I_C_POSTenderTypeInput C_POSTenderType);

	/**
	 * Get C_POSTenderType.
	 *
	 * @return C_POSTenderType
	 */
	I_C_POSTenderTypeInput C_POSTenderType();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_ProjectInput(I_C_ProjectInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	I_C_ProjectInput C_Project();

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
	 * Set DocAction.
	 *
	 * @param DocAction The targeted status of the document
	 */
	void setDocActionInput(I_AD_Ref_ListInput DocAction);

	/**
	 * Get DocAction.
	 *
	 * @return The targeted status of the document
	 */
	I_AD_Ref_ListInput DocAction();

	/**
	 * Set DocStatus.
	 *
	 * @param DocStatus The current status of the document
	 */
	void setDocStatusInput(I_AD_Ref_ListInput DocStatus);

	/**
	 * Get DocStatus.
	 *
	 * @return The current status of the document
	 */
	I_AD_Ref_ListInput DocStatus();

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
	 * Set Ref_Payment.
	 *
	 * @param Ref_Payment Ref_Payment
	 */
	void setRef_PaymentInput(I_C_PaymentInput Ref_Payment);

	/**
	 * Get Ref_Payment.
	 *
	 * @return Ref_Payment
	 */
	I_C_PaymentInput Ref_Payment();

	/**
	 * Set Reversal.
	 *
	 * @param Reversal ID of document reversal
	 */
	void setReversalInput(I_C_PaymentInput Reversal);

	/**
	 * Get Reversal.
	 *
	 * @return ID of document reversal
	 */
	I_C_PaymentInput Reversal();

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
	void setUser1Input(I_C_ElementValueInput User1);

	/**
	 * Get User1.
	 *
	 * @return User defined list element #1
	 */
	I_C_ElementValueInput User1();

	/**
	 * Set User2.
	 *
	 * @param User2 User defined list element #2
	 */
	void setUser2Input(I_C_ElementValueInput User2);

	/**
	 * Get User2.
	 *
	 * @return User defined list element #2
	 */
	I_C_ElementValueInput User2();
}
