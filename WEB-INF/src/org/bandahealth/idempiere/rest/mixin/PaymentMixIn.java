package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"allocatedAmt", "errorMessage", "creditCards", "creditCardPair", "creditCardExp",
		"currencyISO", "docStatusName", "creditCardName", "docsPostProcess", "c_BankStatementLine_ID", "documentInfo",
		"summary", "processMsg", "doc_User_ID", "c_Activity", "c_BankAccount", "c_BPartner", "c_BP_BankAccount",
		"c_Campaign", "c_CashBook", "c_Charge", "c_ConversionType", "c_Currency", "c_DepositBatch", "c_DocType",
		"c_Invoice", "c_Order", "c_PaymentBatch", "c_PaymentProcessor", "c_POSTenderType", "c_Project", "ref_Payment",
		"reversal", "user1", "user2", "po"})
public abstract class PaymentMixIn extends POMixIn {
}
