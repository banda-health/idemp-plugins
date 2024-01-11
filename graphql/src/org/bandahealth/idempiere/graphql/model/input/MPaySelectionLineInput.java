package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPaySelectionLineInput extends X_C_PaySelectionLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPaySelectionLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
