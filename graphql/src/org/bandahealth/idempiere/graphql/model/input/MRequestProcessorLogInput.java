package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRequestProcessorLogInput extends X_R_RequestProcessorLogInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_RequestProcessorLog_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRequestProcessorLogInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
