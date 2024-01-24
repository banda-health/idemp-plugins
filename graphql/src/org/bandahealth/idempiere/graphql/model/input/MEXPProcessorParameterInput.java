package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MEXPProcessorParameterInput extends X_EXP_ProcessorParameterInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The EXP_ProcessorParameter_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MEXPProcessorParameterInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
