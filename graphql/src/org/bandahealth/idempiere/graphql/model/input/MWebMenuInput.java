package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MWebMenuInput extends X_U_WebMenuInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MWebMenuInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
