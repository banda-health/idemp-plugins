package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAcctProcessorLogInput extends X_C_AcctProcessorLogInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAcctProcessorLogInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
