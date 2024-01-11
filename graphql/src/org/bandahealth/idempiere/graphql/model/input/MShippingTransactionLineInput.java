package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MShippingTransactionLineInput extends X_M_ShippingTransactionLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MShippingTransactionLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
