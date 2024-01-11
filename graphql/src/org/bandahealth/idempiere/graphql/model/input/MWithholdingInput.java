package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MWithholdingInput extends X_C_WithholdingInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MWithholdingInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
