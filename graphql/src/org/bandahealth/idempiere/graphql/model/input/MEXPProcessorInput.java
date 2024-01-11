package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MEXPProcessorInput extends X_EXP_ProcessorInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MEXPProcessorInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
