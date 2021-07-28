package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.util.Env;

import java.util.Properties;

@JsonIgnoreProperties(value = {"allocatedAmt", "errorMessage", "creditCards", "creditCardPair", "creditCardExp",
		"currencyISO", "docStatusName", "creditCardName", "docsPostProcess", "c_BankStatementLine_ID", "documentInfo",
		"summary", "processMsg", "doc_User_ID", "c_Activity", "c_BankAccount", "c_BPartner", "c_BP_BankAccount",
		"c_Campaign", "c_CashBook", "c_Charge", "c_ConversionType", "c_Currency", "c_DepositBatch", "c_DocType",
		"c_Invoice", "c_Order", "c_PaymentBatch", "c_PaymentProcessor", "c_POSTenderType", "c_Project", "ref_Payment",
		"reversal", "user1", "user2", "po", "c_DocType_ID"})
public abstract class PaymentMixIn extends MPayment_BH implements POMixIn {
	/**
	 * The JsonCreator must match a superclass constructor to be used instead
	 *
	 * @param ctx     Unused
	 * @param id      Pulled from JSON
	 * @param trxName Unused
	 */
	@JsonCreator
	public PaymentMixIn(@JsonProperty("nonExistentCtx") Properties ctx, @JsonProperty("id") int id,
			@JsonProperty("nonExistentTrxName") String trxName) {
		super(Env.getCtx(), id, null);
	}
}
