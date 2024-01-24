package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MStatusInput extends X_R_StatusInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_Status_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MStatusInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
