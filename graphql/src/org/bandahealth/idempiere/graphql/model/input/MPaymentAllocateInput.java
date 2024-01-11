package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPaymentAllocateInput extends X_C_PaymentAllocateInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPaymentAllocateInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
