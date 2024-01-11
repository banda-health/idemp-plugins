package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHPaymentRefInput extends X_BH_PaymentRefInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHPaymentRefInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
