package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MResourceInput extends X_S_ResourceInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The S_Resource_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MResourceInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
