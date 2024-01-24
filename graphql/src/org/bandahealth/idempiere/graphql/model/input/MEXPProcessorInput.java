package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MEXPProcessorInput extends X_EXP_ProcessorInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The EXP_Processor_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MEXPProcessorInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
