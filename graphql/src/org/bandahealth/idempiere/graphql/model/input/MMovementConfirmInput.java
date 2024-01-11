package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MMovementConfirmInput extends X_M_MovementConfirmInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MMovementConfirmInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
