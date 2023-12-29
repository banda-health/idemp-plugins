package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = {"C_DocType_ID"})
public class MPaymentInput extends X_C_PaymentInput {
	/**
	 * Standard constructor
	 *
	 * @param ID
	 */
	@JsonCreator
	public MPaymentInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
