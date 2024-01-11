package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MColumnAccessInput extends X_AD_Column_AccessInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MColumnAccessInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
