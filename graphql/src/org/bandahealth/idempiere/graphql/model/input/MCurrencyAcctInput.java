package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MCurrencyAcctInput extends X_C_Currency_AcctInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MCurrencyAcctInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
