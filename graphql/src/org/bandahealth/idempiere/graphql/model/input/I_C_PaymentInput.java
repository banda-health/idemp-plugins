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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set BH_Visit.
	 *
	 * @param BH_Visit BH_Visit
	 */
	void setBH_Visit(I_BH_VisitInput BH_Visit);

	/**
	 * Get BH_Visit.
	 *
	 * @return BH_Visit
	 */
	I_BH_VisitInput getBH_Visit();

	/**
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_Activity(I_C_ActivityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	I_C_ActivityInput getC_Activity();

	/**
	 * Set C_BankAccount.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	void setC_BankAccount(I_C_BankAccountInput C_BankAccount);

	/**
	 * Get C_BankAccount.
	 *
	 * @return Account at the Bank
	 */
	I_C_BankAccountInput getC_BankAccount();

	/**
	 * Set C_BP_BankAccount.
	 *
	 * @param C_BP_BankAccount Bank Account of the Business Partner
	 */
	void setC_BP_BankAccount(I_C_BP_BankAccountInput C_BP_BankAccount);

	/**
	 * Get C_BP_BankAccount.
	 *
	 * @return Bank Account of the Business Partner
	 */
	I_C_BP_BankAccountInput getC_BP_BankAccount();

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
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_Campaign(I_C_CampaignInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	I_C_CampaignInput getC_Campaign();

	/**
	 * Set C_CashBook.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	void setC_CashBook(I_C_CashBookInput C_CashBook);

	/**
	 * Get C_CashBook.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	I_C_CashBookInput getC_CashBook();

	/**
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_Charge(I_C_ChargeInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	I_C_ChargeInput getC_Charge();

	/**
	 * Set C_ConversionType.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	void setC_ConversionType(I_C_ConversionTypeInput C_ConversionType);

	/**
	 * Get C_ConversionType.
	 *
	 * @return Currency Conversion Rate Type
	 */
	I_C_ConversionTypeInput getC_ConversionType();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_Currency(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput getC_Currency();

	/**
	 * Set C_DepositBatch.
	 *
	 * @param C_DepositBatch C_DepositBatch
	 */
	void setC_DepositBatch(I_C_DepositBatchInput C_DepositBatch);

	/**
	 * Get C_DepositBatch.
	 *
	 * @return C_DepositBatch
	 */
	I_C_DepositBatchInput getC_DepositBatch();

	/**
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocType(I_C_DocTypeInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	I_C_DocTypeInput getC_DocType();

	/**
	 * Set C_Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	void setC_Invoice(I_C_InvoiceInput C_Invoice);

	/**
	 * Get C_Invoice.
	 *
	 * @return Invoice Identifier
	 */
	I_C_InvoiceInput getC_Invoice();

	/**
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_Order(I_C_OrderInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	I_C_OrderInput getC_Order();

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
	void setC_PaymentBatch(I_C_PaymentBatchInput C_PaymentBatch);

	/**
	 * Get C_PaymentBatch.
	 *
	 * @return Payment batch for EFT
	 */
	I_C_PaymentBatchInput getC_PaymentBatch();

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
	 * Set C_POSTenderType.
	 *
	 * @param C_POSTenderType C_POSTenderType
	 */
	void setC_POSTenderType(I_C_POSTenderTypeInput C_POSTenderType);

	/**
	 * Get C_POSTenderType.
	 *
	 * @return C_POSTenderType
	 */
	I_C_POSTenderTypeInput getC_POSTenderType();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_Project(I_C_ProjectInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	I_C_ProjectInput getC_Project();

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
	 * Set DocAction_RL.
	 *
	 * @param DocAction_RL The targeted status of the document
	 */
	void setDocAction_RL(I_AD_Ref_ListInput DocAction_RL);

	/**
	 * Get DocAction_RL.
	 *
	 * @return The targeted status of the document
	 */
	I_AD_Ref_ListInput getDocAction_RL();

	/**
	 * Set DocStatus_RL.
	 *
	 * @param DocStatus_RL The current status of the document
	 */
	void setDocStatus_RL(I_AD_Ref_ListInput DocStatus_RL);

	/**
	 * Get DocStatus_RL.
	 *
	 * @return The current status of the document
	 */
	I_AD_Ref_ListInput getDocStatus_RL();

	/**
	 * Set Posted_RL.
	 *
	 * @param Posted_RL Posting status
	 */
	void setPosted_RL(I_AD_Ref_ListInput Posted_RL);

	/**
	 * Get Posted_RL.
	 *
	 * @return Posting status
	 */
	I_AD_Ref_ListInput getPosted_RL();

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

	/**
	 * Set Ref_Payment.
	 *
	 * @param Ref_Payment Ref_Payment
	 */
	void setRef_Payment(I_C_PaymentInput Ref_Payment);

	/**
	 * Get Ref_Payment.
	 *
	 * @return Ref_Payment
	 */
	I_C_PaymentInput getRef_Payment();

	/**
	 * Set Reversal.
	 *
	 * @param Reversal ID of document reversal
	 */
	void setReversal(I_C_PaymentInput Reversal);

	/**
	 * Get Reversal.
	 *
	 * @return ID of document reversal
	 */
	I_C_PaymentInput getReversal();

	/**
	 * Set TenderType_RL.
	 *
	 * @param TenderType_RL Method of Payment
	 */
	void setTenderType_RL(I_AD_Ref_ListInput TenderType_RL);

	/**
	 * Get TenderType_RL.
	 *
	 * @return Method of Payment
	 */
	I_AD_Ref_ListInput getTenderType_RL();

	/**
	 * Set TrxType_RL.
	 *
	 * @param TrxType_RL Type of credit card transaction
	 */
	void setTrxType_RL(I_AD_Ref_ListInput TrxType_RL);

	/**
	 * Get TrxType_RL.
	 *
	 * @return Type of credit card transaction
	 */
	I_AD_Ref_ListInput getTrxType_RL();

	/**
	 * Set User1.
	 *
	 * @param User1 User defined list element #1
	 */
	void setUser1(I_C_ElementValueInput User1);

	/**
	 * Get User1.
	 *
	 * @return User defined list element #1
	 */
	I_C_ElementValueInput getUser1();

	/**
	 * Set User2.
	 *
	 * @param User2 User defined list element #2
	 */
	void setUser2(I_C_ElementValueInput User2);

	/**
	 * Get User2.
	 *
	 * @return User defined list element #2
	 */
	I_C_ElementValueInput getUser2();
}
