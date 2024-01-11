package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInterestAreaInput extends X_R_InterestAreaInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MInterestAreaInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
