package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MResourceUnAvailableInput extends X_S_ResourceUnAvailableInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MResourceUnAvailableInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
