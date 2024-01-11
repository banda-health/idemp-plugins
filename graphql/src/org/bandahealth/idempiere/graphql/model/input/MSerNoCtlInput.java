package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MSerNoCtlInput extends X_M_SerNoCtlInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MSerNoCtlInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
