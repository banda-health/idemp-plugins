package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPaySelectionCheckInput extends X_C_PaySelectionCheckInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPaySelectionCheckInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
