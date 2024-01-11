package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTestInput extends X_TestInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTestInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
