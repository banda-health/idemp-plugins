package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MEXPProcessorTypeInput extends X_EXP_Processor_TypeInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The EXP_Processor_Type_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MEXPProcessorTypeInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
