package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MChatTypeInput extends X_CM_ChatTypeInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The CM_ChatType_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MChatTypeInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
