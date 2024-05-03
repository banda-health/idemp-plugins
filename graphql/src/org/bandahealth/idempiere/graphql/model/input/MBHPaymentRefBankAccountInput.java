package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHPaymentRefBankAccountInput extends X_BH_PaymentRef_BankAcctInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_PaymentRef_BankAcct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHPaymentRefBankAccountInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
