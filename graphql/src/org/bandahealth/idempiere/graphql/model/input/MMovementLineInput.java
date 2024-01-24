package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MMovementLineInput extends X_M_MovementLineInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_MovementLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MMovementLineInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
