package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInfoWindowInput extends X_AD_InfoWindowInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MInfoWindowInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
