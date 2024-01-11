package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDocTypeCounterInput extends X_C_DocTypeCounterInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDocTypeCounterInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
