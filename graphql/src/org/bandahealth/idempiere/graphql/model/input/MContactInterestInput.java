package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MContactInterestInput extends X_R_ContactInterestInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MContactInterestInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
