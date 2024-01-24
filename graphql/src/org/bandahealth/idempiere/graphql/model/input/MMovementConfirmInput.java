package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MMovementConfirmInput extends X_M_MovementConfirmInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_MovementConfirm_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MMovementConfirmInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
