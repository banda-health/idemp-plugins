package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MShippingTransactionInput extends X_M_ShippingTransactionInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MShippingTransactionInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
