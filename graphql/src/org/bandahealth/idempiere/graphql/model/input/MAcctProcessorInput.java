package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAcctProcessorInput extends X_C_AcctProcessorInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAcctProcessorInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
