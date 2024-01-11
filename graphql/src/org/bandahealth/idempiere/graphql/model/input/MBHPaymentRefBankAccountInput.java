package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHPaymentRefBankAccountInput extends X_BH_PaymentRef_BankAcctInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHPaymentRefBankAccountInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
