package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRequestProcessorLogInput extends X_R_RequestProcessorLogInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRequestProcessorLogInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
