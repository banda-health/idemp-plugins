package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MEXPProcessorTypeInput extends X_EXP_Processor_TypeInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MEXPProcessorTypeInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
