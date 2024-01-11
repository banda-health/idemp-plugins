package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInfoWindowAccessInput extends X_AD_InfoWindow_AccessInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MInfoWindowAccessInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
