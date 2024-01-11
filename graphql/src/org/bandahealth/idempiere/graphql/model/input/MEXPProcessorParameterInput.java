package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MEXPProcessorParameterInput extends X_EXP_ProcessorParameterInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MEXPProcessorParameterInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
