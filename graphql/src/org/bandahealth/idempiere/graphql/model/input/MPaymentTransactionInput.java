package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPaymentTransactionInput extends X_C_PaymentTransactionInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPaymentTransactionInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
