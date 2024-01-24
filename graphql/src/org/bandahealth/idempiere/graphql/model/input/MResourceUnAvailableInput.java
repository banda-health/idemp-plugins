package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MResourceUnAvailableInput extends X_S_ResourceUnAvailableInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The S_ResourceUnAvailable_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MResourceUnAvailableInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
