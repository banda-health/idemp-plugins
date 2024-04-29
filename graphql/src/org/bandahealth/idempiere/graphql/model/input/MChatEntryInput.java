package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MChatEntryInput extends X_CM_ChatEntryInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The CM_ChatEntry_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MChatEntryInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
