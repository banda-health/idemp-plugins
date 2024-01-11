package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MProjectTypePhaseInput extends X_C_PhaseInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MProjectTypePhaseInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
