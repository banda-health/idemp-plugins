package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MMovementLineConfirmInput extends X_M_MovementLineConfirmInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MMovementLineConfirmInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
