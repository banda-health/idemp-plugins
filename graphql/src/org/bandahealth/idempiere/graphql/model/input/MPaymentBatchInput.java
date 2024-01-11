package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPaymentBatchInput extends X_C_PaymentBatchInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPaymentBatchInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
