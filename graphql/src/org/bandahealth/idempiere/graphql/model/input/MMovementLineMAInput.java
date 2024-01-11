package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MMovementLineMAInput extends X_M_MovementLineMAInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MMovementLineMAInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
