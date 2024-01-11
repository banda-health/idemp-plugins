package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MLotCtlInput extends X_M_LotCtlInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MLotCtlInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
