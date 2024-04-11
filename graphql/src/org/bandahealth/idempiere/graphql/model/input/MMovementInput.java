package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MMovementInput extends X_M_MovementInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_Movement_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MMovementInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
